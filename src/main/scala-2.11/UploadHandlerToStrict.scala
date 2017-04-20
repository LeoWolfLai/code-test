/**
  * Created by leo on 2016/7/21.
  */
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{RequestContext, RouteResult, Directive, Route}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import scala.concurrent.Future
import scala.concurrent.duration._

object UploadHandlerToStrict extends App {

	implicit val system = ActorSystem()
	implicit val materializer = ActorMaterializer()
	implicit val ec = system.dispatcher

	def toStrict(timeout: FiniteDuration): Directive[Unit] = {
		def toStrict0(inner: Unit ⇒ Route): Route = {
			val result: RequestContext ⇒ Future[RouteResult] = c ⇒ {
				// call entity.toStrict (returns a future)
				c.request.entity.toStrict(timeout).flatMap { strict ⇒
					// modify the context with the strictified entity
					val c1 = c.withRequest(c.request.withEntity(strict))
					// call the inner route with the modified context
					inner()(c1)
				}
			}
			result
		}
		Directive[Unit](toStrict0)
	}

	val route: Route = {
		(path("resize") & post) {
			toStrict(1.second) {
				formFields('json.as[String]) { json =>
					uploadedFile("image") {
						case (meta, file) => {
							complete {
								// do something with file, sizes, rotate ...
								s"$meta $file"
							}
						}
					}
				}
			}
		}
	} ~ getFromResourceDirectory("web")

	val bindingFuture = Http().bindAndHandle(route, "localhost", 12345)

	System.in.read()
	system.shutdown()
	system.awaitTermination()
}

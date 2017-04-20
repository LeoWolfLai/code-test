import java.net.URL
import java.util
import java.util.UUID

import org.joda.time.{DateTimeZone, _}
import org.joda.time.DateTime
import spray.json._

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex
import java.util.Locale
import java.util.Currency

val stickeruid:UUID = UUID.randomUUID()

val stickeruid2:UUID = UUID.randomUUID()

val test:Long = 12346546

val testdate1 = UUID.fromString("0e671f30-fc84-11e5-a756-f535519d4774")
val testdate2 = UUID.fromString("baee9d60-fc88-11e5-a756-f535519d4774")
val testdate3 = UUID.fromString("1975fc70-fc89-11e5-a756-f535519d4774")
val testdate4 = UUID.fromString("f177cbe0-fc88-11e5-a756-f535519d4774")
val rest = testdate4.toString.concat("_001.stk")

val time1 = testdate1.timestamp()
val time2 = testdate2.timestamp()
val time3 = testdate3.timestamp()
val time4 = testdate4.timestamp()
val time5 = DateTime.now()
val time6 = LocalDateTime.now()

var abc = List(time1,time2,time3,time4).sortWith(_ > _)

val dd = new DateTime((time3-0x01b21dd213814000L)/10000)
val dd2 = new DateTime((time4-0x01b21dd213814000L)/10000)

println(dd.isAfter(dd2.plusMinutes(2)))

abc :+ (time4+1)

val bcd = List("132", "654", 3 , 10.78, "we are")

val Pattern = "(.*\\()(.*)(\\))".r
val avaurl = "CallLog(NoAnswer,2016-09-23T08:48:19.334Z)"
val file = "file/123/png"
avaurl match{
	case Pattern(some,calllog,paren) =>
		println("calllog is " + calllog)
}

file.split("/").foreach(x => println(x))
val listtest = List(7, 3, 9, 6)
val listtest2 = List("123","321","456","654")
val test123 = for( (filter, url) <- (listtest zip listtest2)) yield true
val list3 = listtest2 :+ "789"
val lista:List[String] = List.empty
val listb = lista :+ "111"

listtest2.slice(0,10)

def testf :(String, String, String)= {
	("test1", "test2", "test3")
}

val Pattern2 = "(.*)(\\-)(.*)(\\_)(.*)".r
val tarstr = "ar-Latn_AE"
val nottar = "file/123/png"
tarstr match{
	case Pattern2(lan, dash , script ,underline, country) =>
		println("lan is:" + lan, "dash is:" + dash,"script is:" + script
			,"underline is:" + underline, "country is: " + country)
	case _ => println("not a tar")
}

System.getProperty("java.library.path", "")

/*file.length
println(file.substring(2,11))

val avatar = Map(("123",456))

println(avatar)*/

val str:String = "en-all"
val locate:Locale = Locale.forLanguageTag(str)
val locate2 = new Locale.Builder().setLanguage("pt").setRegion("PT").build()
println("locate2 is :"+locate2.toString)
val script = locate2.getScript

script match {
	case "" => println("script is empty!")
		case _ => println("script else!")
}

//if(script.isEmpty){println("script is empty!")}
val script2 = locate2.getCountry
val script3 = locate2.getLanguage
println("script is :" + script)
val re = locate2.getDisplayLanguage()
locate2 match{
	case Locale.CHINA => println("CHINA")
		case _ => println("else!")
}

val cur = Currency.getInstance(locate2)
cur.getSymbol
cur.toString

val testtest = locate.getCountry
val testtest2 = locate.getLanguage

val strr = "123"
val sett:Option[Set[(Locale, Int)]] = Some(Set((Locale.TAIWAN, 123), (Locale.TAIWAN, 123), (Locale.US, 789)))
val map1:Map[Any, Int] = sett match{
	case Some(set) => set.toMap
	case None => Set(("YOYO", 123), ("YOYO", 123), ("KK", 789)).toMap
}

val maptest = Map((strr,456))
maptest(strr)

sealed case class CallLog(state: String, time: DateTime)
object CallLog {
	def unapply(values: Map[String,String]) :Option[List[CallLog]] = try{
		val keys = values.keys.toList
		Some(keys.map(key => CallLog(key, DateTime.parse(values(key)))))
	} catch{
		case ex: Exception => None
	}
}
final case class CallHistory(log:CallLog, peer: UUID) {

}

val call = List(CallLog("Calling", dd), CallLog("NoAnswer", dd2))
val callmap:Map[String, String] = Map(call map{calllog => (calllog.state, calllog.time.toString())} : _*)
val callmap2: Map[String, String] = call.map(c => c.state -> c.time.toString)(collection.breakOut)
val calllist:List[CallHistory] = call.map(c => CallHistory(c , UUID.randomUUID()))

val CallLog(log) = callmap
3.compare(1)

val hex = Integer.toHexString(11)
"000111".concat(hex).takeRight(4)
//val hex2 = "%06x".format(11)
val n:Long = 999





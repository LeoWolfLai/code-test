package codility

/**
	* Created by leo on 2017/4/19.
	*/
import scala.collection.mutable.Queue

object matrix {

	def matrix(array: Array[Array[Int]]):Int = {

		println("width = " + array(0).length)
		println("long = " + array.length)


		var regions = array(0).length * array.length
		println("regions is " + regions)

		val matrix = Array.ofDim[Int](array.length, array(0).length)

		def traverse(q: Queue[(Int, Int)], array: Array[Array[Int]], boolArray: Array[Array[Int]]): Unit = {
			val (x, y) = q.dequeue()
			boolArray(x)(y) = 1

			println("x is:" + x + ", y is:" + y)

			if (x + 1 < array.length && boolArray(x + 1)(y) != 1 && array(x + 1)(y) == array(x)(y)) {
				regions -= 1
				q.enqueue((x + 1, y))
			}
			if (x - 1 >= 0 && boolArray(x - 1)(y) != 1 && array(x - 1)(y) == array(x)(y)) {
				regions -= 1
				q.enqueue((x - 1, y))
			}
			if (y + 1 < array(0).length && boolArray(x)(y + 1) != 1 && array(x)(y + 1) == array(x)(y)) {
				regions -= 1
				q.enqueue((x, y + 1))
			}
			if (y - 1 >= 0 && boolArray(x)(y - 1) != 1 && array(x)(y - 1) == array(x)(y)) {
				regions -= 1
				q.enqueue((x, y - 1))
			}

			if (q.nonEmpty)
				traverse(q, array, boolArray)
		}

		for (i <- array(0).indices; j <- array.indices) {
			if (matrix(i)(j) == 0) {
				val queue = Queue((i, j))
				traverse(queue, array, matrix)
			}
		}
		regions
	}
}

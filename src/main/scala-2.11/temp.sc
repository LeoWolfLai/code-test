import scala.collection.JavaConverters._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
	def solution(a: Array[Int]): Int = {
		// write your code in Scala 2.12

		def _equilibrium(
			                currentIndex: Int,
			                sumLeft: Long,
			                sumRight: Long,
			                listLeft: List[Int]): Int = {

			if (sumLeft == sumRight)
				currentIndex
			else
				listLeft match {
					case current :: next :: tail=>
						_equilibrium(currentIndex + 1, sumLeft + current, sumRight - next, next :: tail)
					case current :: Nil if sumLeft == 0 =>
						currentIndex + 1
					case _ =>
						-1
				}
		}
		if (a.isEmpty)
			-1
		else
			_equilibrium(0, 0, a.drop(1).map(_.toLong).sum, a.toList)
	}
}
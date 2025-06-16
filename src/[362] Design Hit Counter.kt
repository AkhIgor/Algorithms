import java.util.*

fun main() {
    val counter = HitCounter()

    println(counter.hit(2_000))
    println(counter.hit(4_000))
    println(counter.hit(8_000))
    println(counter.hit(8_500))
    println(counter.hit(8_501))
    println(counter.hit(10_501))
    println(counter.hit(16_501))
}

//class HitCounter {
//
//    private val hits = LinkedList<Int>()
//
//    /**
//     * Record a hit with given timestamp.
//     */
//    fun hit(timestamp: Int): Int {
//        hits.add(timestamp)
//
//        while (hits.isNotEmpty() && hits.first <= timestamp - 5000) {
//            hits.removeFirst()
//        }
//
//        return hits.size
//    }
//}

// MINE
class HitCounter {

    val hitTimes = LinkedList<Int>()

    fun hit(time: Int): Int {
        hitTimes.add(time)

        var index = hitTimes.size - 1
        while (index >= 0 && time - 5_000 < hitTimes[index]) {
            index--
        }
        val result =  hitTimes.size - 1 - index

        for (i in 0..<index) {
            hitTimes.removeFirst()
        }

        return result
    }
}
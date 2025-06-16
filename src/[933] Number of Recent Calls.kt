import java.util.LinkedList

fun main() {
    val counter = RecentCounter()

    println(counter.ping(1))
    println(counter.ping(100))
}

class RecentCounter() {
    private val requests = LinkedList<Int>() // Queue to store timestamps

    fun ping(t: Int): Int {
        // Add the new request's timestamp at the end of queue
        requests.addLast(t)

        // Remove all old timestamps that are older than t - 3000 ms
        while (!requests.isEmpty() && requests.peekFirst() < t - 3000) {
            requests.removeFirst()
        }

        // Return the number of recent pings
        return requests.size
    }
}

// MINE
//class RecentCounter() {
//
//    private val calls = IntArray(10)
//    private var callCounter = -1
//
//    fun ping(t: Int): Int {
//        callCounter++
//        calls[callCounter] = t
//
//        var i = callCounter
//        var limitExceed = false
//        while (i >= 0 && !limitExceed) {
//            if (calls[i] < t - 3_000) {
//                limitExceed = true
//            }
//            i--
//        }
//        for (j in i+1..callCounter) {
//            calls[j-i] = calls[j]
//        }
//        return if (limitExceed) {
//            callCounter - i + 1
//        } else callCounter + 1
//    }
//}
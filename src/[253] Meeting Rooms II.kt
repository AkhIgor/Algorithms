fun main() {
    println(minMeetingRooms(arrayOf(
        intArrayOf(0, 40),
        intArrayOf(5, 10),
        intArrayOf(15, 20),
        intArrayOf(21, 22)
    )))
}

private fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val starts = intervals.map { it.first() }.sorted()
    val ends = intervals.map { it.last() }.sorted()

    var roomsNeeded = 0
    var maxRooms = 0
    var startPointer = 0
    var endPointer = 0

    while (startPointer < starts.size) {
        if (starts[startPointer] < ends[endPointer]) {
            roomsNeeded++
            startPointer++
        } else {
            roomsNeeded--
            endPointer++
        }
        maxRooms = maxOf(maxRooms, roomsNeeded)
    }

    return maxRooms
}

// MAIN
//private fun minMeetingRooms(intervals: Array<IntArray>): Int {
//    intervals.sortBy { it.first() }
//
//    var counter = 0
//    var currInterval = intervals[0]
//
//    for (interval in intervals) {
//        if (currInterval.last() >= interval.first() ) {
//            counter++
//            currInterval = interval
//        }
//    }
//
//    return counter
//}
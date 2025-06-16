fun main() {
    println(maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)))

    println(maxDistToClosest(intArrayOf(1, 0, 0, 0)))
    println(maxDistToClosest(intArrayOf(0, 0, 0, 1)))
    println(maxDistToClosest(intArrayOf(1, 0, 0, 1)))
    println(maxDistToClosest(intArrayOf(0, 1)))

    println(maxDistToClosest(intArrayOf(0, 0, 0, 1)))
    println(maxDistToClosest(intArrayOf(1, 0, 0, 0, 0, 0, 1)))
}

fun maxDistToClosest(seats: IntArray): Int {
    var lastPersonPosition = -1
    var result = 0

    for (i in seats.indices) {
        if (seats[i] == 1) {
            if (lastPersonPosition == -1) {
                // Первый человек, смотрим дальность от начала ряда
                result = i
            } else {
                // Средний случай: находим середину между людьми
                result = maxOf(result, (i - lastPersonPosition) / 2)
            }
            lastPersonPosition = i
        }
    }

    // Последний блок пустых мест: максимальная дистанция от последнего занятого места до конца ряда
    result = maxOf(result, seats.size - 1 - lastPersonPosition)

    return result
}

// MINE
//private fun maxDistToClosest(seats: IntArray): Int {
//    var right = 0 // 4
//    var left = 0 // 1
//
//    var maxDistanceRow = 0
//
//    while (right < seats.size) {
//        if (seats[right] == 0) {
//            right++
//        } else {
//            if (left == 0 && seats[left] == 0) {
//                maxDistanceRow = maxOf(right - left, maxDistanceRow) // 0
//            }
//            while (left< right && seats[left] == 1) {
//                left++
//            }
//
//            val freeSeatsCount = right - left
//            if(freeSeatsCount % 2 == 1) {
//                maxDistanceRow = maxOf((freeSeatsCount / 2) + 1, maxDistanceRow)
//            } else {
//                maxDistanceRow = maxOf((freeSeatsCount + 1) / 2, maxDistanceRow)
//            }
//
//            left = right
//            right++
//        }
//
//        if (right == seats.size - 1 && seats[right] == 0) {
//            maxDistanceRow = maxOf(right - left, maxDistanceRow) // 0
//        }
//    }
//
//    return maxDistanceRow
//}
/**
 * 356. Line Reflection
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * Example 1:
 *
 * Input: [[1,1],[-1,1]]
 * Output: true
 * Example 2:
 *
 * Input: [[1,1],[-1,-1]]
 * Output: false
 *
 *
 * Difficulty: Medium
 */

fun main() {
    println(
        isReflectedLine(
            listOf(
                Pair(1, 1),
                Pair(-1, 1)
            )
        )
    )

    println(
        isReflectedLine(
            listOf(
                Pair(1, 1),
                Pair(-1, -1)
            )
        )
    )

    println(
        isReflectedLine(
            listOf(
                Pair(0, 0),
                Pair(1, 0),
                Pair(2, 0),
            )
        )
    )
}


private fun isReflectedLine(points: List<Pair<Int, Int>>): Boolean {
    val pointsSet = points.toSet()

    var min = points.first().first
    var max = points.first().first

    pointsSet.forEach { point ->
        if (point.first < min) {
            min = point.first
        }
        if (point.first > max) {
            max = point.first
        }
    }

    val m = (max + min)/2
    var result = true

    pointsSet.forEach { point ->
        if (!pointsSet.contains(Pair(2*m - point.first, point.second))) {
            result = false
            return@forEach
        }
    }

    return result
}


// MINE
//private fun isReflectedLine(points: List<Pair<Int, Int>>): Boolean {
//    var firstIndex = 0
//    var secondIndex = points.size - 1
//
//    var mirroredLine = -1
//    var result = false
//
//    while (firstIndex != secondIndex) {
//        val diff = points[secondIndex].first - points[firstIndex].first
//
//        if (points[secondIndex].second == points[firstIndex].second && (mirroredLine == -1 || (diff != mirroredLine))) {
//            mirroredLine = diff
//            result = true
//        } else {
//            result = false
//            break
//        }
//
//        firstIndex++
//        if (firstIndex == secondIndex) break
//        secondIndex--
//    }
//
//    return result
//}
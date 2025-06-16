fun main() {
    println(
        merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ).map { it.toList() }
            .toList()
    )
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    // Отсортируем интервалы по первому элементу (началу интервала)
    intervals.sortBy { it[0] }

    val mergedIntervals = mutableListOf<IntArray>()
    var currentInterval = intervals[0]

    for (interval in intervals) {
        if (interval[0] <= currentInterval[1]) {
            // Объединяем текущий интервал с предыдущими
            currentInterval[1] = maxOf(interval[1], currentInterval[1])
        } else {
            // Новый интервал не пересекается, добавляем предыдущий и переходим дальше
            mergedIntervals.add(currentInterval.clone())
            currentInterval = interval
        }
    }

    // Добавляем последний объединённый интервал
    mergedIntervals.add(currentInterval)

    return mergedIntervals.toTypedArray()
}

// MINE
//private fun merge(intervals: Array<IntArray>): Array<IntArray> {
//    val result = mutableListOf<IntArray>()
//    var start = 0
//    var end = 0
//
//    while (start < intervals.size) {
//        while (end < intervals.size - 1 && intervals[end + 1].first() <= intervals[start].last()) {
//            end++
//        }
//
//        result.add(intArrayOf(intervals[start].first(), intervals[end].last()))
////        val min = minOf(intervals[start].first(), intervals[end].first())
////        val max = maxOf(intervals[start].last(), intervals[end].last())
////
////        result.add(intArrayOf(min, max))
//
//        end++
//        start = end
//    }
//
//    return result.toTypedArray()
//}
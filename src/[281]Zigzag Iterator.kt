import java.util.*

fun main() {
    val iterator1 = ZigZagIterator(listOf(1, 2), listOf(3, 4, 5, 6))

    val iterator2 = ZigZagIterator(listOf(1), listOf())

    val iterator3 = ZigZagIterator(listOf(), listOf(1))

    val iterator4 = ZigZagIterator(listOf(1, 2, 3), listOf(4, 5, 6, 7))

    println("1:")
    while (iterator1.hasNext()) {
        print("${iterator1.next()} ,")
    }
    println()

    println("2:")
    while (iterator2.hasNext()) {
        print("${iterator2.next()} ,")
    }
    println()

    println("3:")
    while (iterator3.hasNext()) {
        print("${iterator3.next()} ,")
    }
    println()

    println("4:")
    while (iterator4.hasNext()) {
        print("${iterator4.next()} ,")
    }
}

class ZigZagIterator(
    vararg lists: List<Int>,
) {

    val iteratorQueue = ArrayDeque<ListIterator<Int>>()

    init {
        lists.forEach {
            if (it.listIterator().hasNext()) {
                iteratorQueue.offer(it.listIterator())
            }
        }
    }

    fun hasNext(): Boolean {
        return iteratorQueue.isNotEmpty()
    }

    fun next(): Int {
        val listIterator = iteratorQueue.pop()
        if (listIterator.hasNext()) {
            iteratorQueue.offer(listIterator)
        }
        val next = listIterator.next()
        return next
    }
}

// MINE
//class ZigZagIterator(
//    val v1: List<Int>,
//    val v2: List<Int>
//) {
//    val totalSize = v1.size + v2.size
//
//    var pointer1 = 0
//    var pointer2 = 0
//
//    var i = 0
//
//    fun hasNext(): Boolean {
//        return i < totalSize
//    }
//
//    fun next(): Int {
//        i++
//        return when {
//            (pointer1 == pointer2) -> {
//                if (pointer1 < v1.size) {
//                    val next = v1[pointer1]
//                    pointer1++
//                    next
//                } else {
//                    val next = v2[pointer2]
//                    pointer2++
//                    next
//                }
//            }
//
//            else -> {
//                if (pointer2 < v2.size) {
//                    val next = v2[pointer2]
//                    pointer2++
//                    next
//                } else {
//                    val next = v1[pointer1]
//                    pointer2++
//                    next
//                }
//            }
//        }
//    }
//}
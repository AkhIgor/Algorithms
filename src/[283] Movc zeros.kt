fun main() {
    var array = IntArray(20)

    for (i in 0 ..4) { // [2,2,2,2,0]
        array.set(i, 2)
    }
    array.set(5, 0)
    moveZeroes(array)
}


fun moveZeroes(nums: IntArray): Unit {
    var insertPos = 0 // Указатель на позицию, куда будем вставлять ненулевые элементы

    // Проходим по массиву и перемещаем ненулевые элементы в начало
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[insertPos] = nums[i]
            insertPos++
        }
    }

    // Заполняем оставшиеся позиции нулями
    while (insertPos < nums.size) {
        nums[insertPos] = 0
        insertPos++
    }

    println(nums.joinToString(", "))
}

// MINE
//private fun moveZeroes(nums: IntArray): Unit {
//    var i = 0
//
//    var buffer: Int
//
//    while (i < nums.size - 1) {
//        if (nums[i] == 0) {
//            var j = i
//            while (j < nums.size - 1 && nums[j] == 0) {
//                j++
//            }
//
//            if (nums[j] != 0) {
//                buffer = nums[i]
//                nums[i] = nums[j]
//                nums[j] = buffer
//            }
//        }
//        i++
//    }
//
//    println(nums.joinToString(", "))
//}
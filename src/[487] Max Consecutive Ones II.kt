fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0)))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var left = 0
    var zeroCount = 0
    var maxLength = 0

    for ((right, num) in nums.withIndex()) {
        if (num == 0) {
            zeroCount += 1
        }

        // Пока количество нулей превышает разрешенное значение (1),
        // двигаем левую границу окна
        while (zeroCount > 1) {
            if (nums[left++] == 0) {
                zeroCount -= 1
            }
        }

        // Вычисляем длину текущего окна и сохраняем максимум
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}

// MINE
//private fun findMaxConsecutiveOnes(nums: IntArray): Int {
//    var left = 0
//    var right = 0
//
//    var hasZero = false
//
//    var maxConsecutive = 0
//
//    while (right < nums.size) {
//        if (nums[right] == 0) {
//            if (hasZero) {
//                maxConsecutive = maxOf(right - left, maxConsecutive)
//                while (left < right && hasZero) {
//                    if (nums[left] == 0) {
//                        hasZero = false
//                    }
//                    left++
//                }
//            } else {
//                hasZero = true
//            }
//        }
//
//        right++
//    }
//
//    return maxConsecutive
//}
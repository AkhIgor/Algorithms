/**
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <=
 */

fun main() {
    println(subarraySum(intArrayOf(1, 2, 3), 3))
    println(subarraySum(intArrayOf(1, 2, 3, 9), 3))

    println(subarraySum(intArrayOf(1, 2, 2, 3), 3))
    println(subarraySum(intArrayOf(1, 2, 1, 3, 2, 3), 3))
}

//private fun subarraySum(nums: IntArray, k: Int): Int {
//    val map = mutableSetOf<Int>()
//
//    var count = 0
//    for (num in nums) {
//        val diff = k - num
//
//        if (map.contains(num) || num == k) {
//            count++
//        }
//        map.add(diff)
//    }
//
//    return count
//}


fun subarraySum(nums: IntArray, k: Int): Int {
    val count = mutableMapOf<Int, Int>() // map для хранения количества раз встреченной суммы
    count[0] = 1 // начальная сумма равна нулю встречается один раз

    var cumulativeSum = 0 // текущая кумулятивная сумма
    var result = 0 // итоговое количество подмассивов

    for (num in nums) {
        cumulativeSum += num // добавляем текущий элемент к общей сумме

        // проверяем, существует ли разница между текущей суммой и искомым значением k
        result += count.getOrDefault(cumulativeSum - k, 0)

        // обновляем карту счётчика текущих сумм
        count[cumulativeSum] = count.getOrDefault(cumulativeSum, 0) + 1
    }

    return result
}

// MINE
//private fun subarraySum(nums: IntArray, k: Int): Int {
//    if(nums.isEmpty()) return 0
//
//    var subarrayCount = 0
//
//    var left = 0; var right = 0
//
//    var currentSum = 0
//
//    while (left < nums.size) {
//        while (currentSum < k && right < nums.size) {
//            currentSum += nums[right]
//            println("currentSum = $currentSum")
//            right++
//        }
////        if (right == nums.size && currentSum < k) return 0
//
//        if (currentSum == k) {
//            subarrayCount++
//            println("subarrayCount = $subarrayCount")
//        }
//
//        currentSum -= nums[left]
//        left++
//    }
//
//    return subarrayCount
//}
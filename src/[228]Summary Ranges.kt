/**
 * 228. Summary Ranges
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */

fun main() {
    println(summaryRanges(listOf(0, 1, 2, 4, 5, 7)))
    println(summaryRanges(listOf(0, 2, 3, 4, 6, 8, 9)))
}

private fun summaryRanges(nums: List<Int>): List<String> {
    if (nums.isEmpty()) return emptyList()
    val result = mutableListOf<String>()

    var left = 0

    for (right in 0..nums.size - 2) {
        if (nums[right + 1] == nums[right] + 1) {
            // cool!
        } else {
            if (left == right) result.add(nums[right].toString())
            else result.add("${nums[left]}->${nums[right]}")

            left = right + 1
        }
    }

    if (left == nums.size - 1) result.add(nums[nums.size - 1].toString())
    else result.add("${nums[left]}->${nums[nums.size - 1]}")

    return result
}

//private fun summaryRanges(nums: List<Int>): List<String> {
//    val result = mutableListOf<String>()
//
//    var start = 0
//    var end = 0
//    while (end <= nums.size - 1) {
//        if (end + 1 < nums.size && nums[end] + 1 == nums[end + 1]) {
////            cool!
//        } else {
//            if (start == end) {
//                result.add(nums[start].toString())
//            } else {
//                result.add("${nums[start]} -> ${nums[end]}")
//            }
//            start = end + 1
//        }
//        end++
//    }
//
//    return result
//}

// MINE
//private fun summaryRanges(nums: List<Int>): List<String> {
//    val result = mutableListOf<String>()
//
//    var start = 0 // 1
//    var end = 0 // 2
//
//    while (start < nums.size) { // (nums.size) = 6
//        while (end < nums.size - 1 && nums[end+1] == nums[end] + 1) {
//            end++
//        }
//
//        if (end < nums.size - 1) {
//            if (end == start) {
//                result.add(nums[start].toString())
//            } else {
//                val range = "${nums[start]} -> ${nums[end]}"
//                result.add(range)
//            }
//        } else {
//            if (start >= nums.size -1) {
//                result.add(nums[nums.size - 1].toString())
//            } else {
//                val range = "${nums[start]} -> ${nums[nums.size - 1]}"
//                result.add(range)
//            }
//        }
//
//        end++
//        start = end
//    }
//
//    return result
//}
/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

fun main() {
    println(longestSubarray(listOf(1, 1, 0, 1)))
    println(longestSubarray(listOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
    println(longestSubarray(listOf(1, 1, 1)))
    println(longestSubarray(listOf(1, 0, 0, 0, 0, 1, 1, 0)))
    println(longestSubarray(listOf(0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1)))
}

private fun longestSubarray(nums: List<Int>): Int {
    var right = 0
    var left = 0

    var hasZero = false
    var length = 0

    while (right < nums.size) {
        if (nums[right] == 1) {
            right++
        } else {
            if (hasZero) {
                length = maxOf(right - left - 1, length)

                while (left < right && hasZero) {
                    if (nums[left] == 0) {
                        hasZero = false
                    }
                    left++
                }
            } else {
                length = maxOf(right - left - 1, length)
                hasZero = true
                right++
            }
        }
    }
    length = maxOf(right - left -1, length)

    return length
}


//private fun longestSubarray(nums: List<Int>): Int {
//    var zeroCount = 0
//    var longestWindow = 0
//    var left = 0
//
//    for (right in 0 ..<nums.size) {
//        if(nums[right] == 0) {
//            zeroCount++
//        }
//        while(zeroCount > 1) {
//            if(nums[left] == 0) {
//                zeroCount--
//            }
//            left++
//        }
//
//        longestWindow = max(longestWindow, right - left)
//    }
//
//    return longestWindow
//}

// MINE
//private fun longestSubarray(nums: List<Int>): Int {
//    val subarray = mutableListOf<Int>()
//
//    var isFirst = true
//    var hasZero = true
//
//    nums.forEachIndexed { index, number ->
//        if (number == 1) {
//            hasZero = false
//            if (isFirst) {
//                isFirst = false
//                subarray.add(index) // Первый индекс единицы
//            }
//        } else if (number == 0) {
//            isFirst = true
//            if (!hasZero) {
//                hasZero = true
//                subarray.add(index-1)
//            }
//        }
//    }
//    subarray.add(nums.size - 1)
//
//    var maxLenght = 0
//
//    if(subarray.size > 2) {
//        for (i in 0..<subarray.size - 3 step 2) {
//            val firstLen = subarray[i+1] - subarray[i] + 1
//            val secondLen = subarray[i+3] - subarray[i+2] + 1
//
//            if(subarray[i+2] - subarray[i+1] < 3) {
//                val length = firstLen + secondLen
//                if (length > maxLenght) {
//                    maxLenght = length
//                }
//            } else {
//                val length = maxOf(firstLen, secondLen)
//                if (length > maxLenght) {
//                    maxLenght = length
//                }
//            }
//        }
//    } else {
//        maxLenght = subarray.last() - subarray.first() + 1
//    }
//
//    return maxLenght
//}
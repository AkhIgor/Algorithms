fun main() {
    println(twoSum(nums = intArrayOf(2, 7, 11, 15), 9)?.toList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray? {
    val numsMap = hashMapOf<Int, Int>() // value, index

    nums.forEachIndexed { index, number ->
        if (numsMap.contains(target - number)) {
            val firstIndex = numsMap[target - number]!!
            return intArrayOf(firstIndex, index)
        } else {
            numsMap[number] = index
        }
    }

    return null
}
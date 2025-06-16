import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    val charSet = mutableSetOf<Char>()

    var right = 0
    var left = 0

    var maxDiff = 0

    while (right < s.length) {
        if (charSet.contains(s[right])) {
            maxDiff = max(right - left, maxDiff)
            charSet.remove(s[left])
            left++
        } else {
            charSet.add(s[right])
            right++
        }
    }
    maxDiff = max(right - left, maxDiff)
    return maxDiff
}
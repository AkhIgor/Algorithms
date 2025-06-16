
fun main() {
    println(isPalindrome("abcba"))
}

fun isPalindrome(text: String): Boolean {
    var left = 0
    var right = text.length-1

    while(left < right) {
        while (left < right && !text[left].isLetterOrDigit()) {
            left++
        }

        while (right > left && !text[right].isLetterOrDigit()) {
            right --
        }

        if(text[left].lowercaseChar() != text[right].lowercaseChar()) return false

        left++
        right--
    }

    return true
}
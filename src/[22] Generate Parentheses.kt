fun main() {
    println(generateParenthesis(3).toString())
}

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    fun backtrack(currentString: String, openCount: Int, closeCount: Int) {
        if (closeCount == 3) {
            result.add(currentString)
            return
        }

        if (openCount < n) {
            backtrack(currentString + '(', openCount + 1, closeCount)
        }

        if (closeCount < openCount) {
            backtrack(currentString + ')', openCount, closeCount + 1)
        }
    }

    backtrack("", 0, 0)
    return result
}

// MINE
//private fun generateParenthesis(n: Int): List<String> {
//    val result = mutableListOf<String>()
//
//    recursive(n, n, result)
//
//    return result
//}
//
//private fun recursive(left: Int, right: Int, result: MutableList<String>) {
//    if (left > 0 && right > 0) {
//        val buffer = StringBuilder()
//        for (i in 0..right) {
//            for (i in 0..(right-left)) {
//                buffer.append("(")
//            }
//            buffer.append(")")
//        }
//        result.add(buffer.toString())
//
//        val medium = (left + right) / 2
//        recursive(left-1, medium, result)
//    } else return
//}
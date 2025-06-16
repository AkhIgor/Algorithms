import java.util.*

fun main() {
    println(isValid("()[]{}"))

    println(isValid("()[]{"))
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    stack.push(s[0])

    var i = 1

    while (i < s.length) {
        val char = s[i]

        when (char) {
            '(', '{', '[' -> {
                stack.push(char)
            }

            ')' -> {
                val prevPerenthnesse = stack.safePop()
                if (prevPerenthnesse != '(') return false
            }

            '}' -> {
                val prevPerenthnesse = stack.safePop()
                if (prevPerenthnesse != '{') return false
            }

            ']' -> {
                val prevPerenthnesse = stack.safePop()
                if (prevPerenthnesse != '[') return false
            }
        }
        i++
    }

    return stack.isEmpty()
}

private fun Stack<Char>.safePop(): Char? {
    return try {
        pop()
    } catch (_: EmptyStackException) {
        null
    }
}
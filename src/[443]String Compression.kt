fun main() {
    println(compress(listOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
    println(compress(listOf('a')))
    println(compress(listOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')))
}

// MINE
private fun compress(chars: List<Char>): Int {
    val compressedString = StringBuilder()
    var count = 1
    var char = chars[0]
    for (i in 1..<chars.size) {
        if (char == chars[i]) {
            count++
        } else {
            if (count == 1) {
                compressedString.append(char.toString())
            } else {
                compressedString.append("$char$count")
            }

            char = chars[i]
        }
    }
    if (count == 1) {
        compressedString.append(char.toString())
    } else {
        compressedString.append("$char$count")
    }

    return compressedString.length
}

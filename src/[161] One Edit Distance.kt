fun main() {
    println(isOneEditDistance("car", "cat"))
    println(isOneEditDistance("car", "csr"))
    println(isOneEditDistance("AB", "ABC"))
    println(isOneEditDistance("1203", "1213"))

    println(isOneEditDistance("car", "edr"))
    println(isOneEditDistance("car", "asdasdas"))
    println(isOneEditDistance("car", "a"))
    println(isOneEditDistance("car", "aqw"))
}

private fun isOneEditDistance(string1: String, string2: String): Boolean {
    var isEditMade = false
    var i = 0
    var j = 0

    while (i <= string1.length - 1 && j <= string2.length - 1) {
        if (string1[i] != string2[j]) {
            if (isEditMade) {
                return false
            } else {
                if (string1.length > i + 1 && string1[i + 1] == string2[j]) { // need to remove char fron string 1
                    isEditMade = true
                    i++
                } else if (string2.length > j + 1 && string2[j + 1] == string1[i]) { // need to add char to string 1
                    isEditMade = true
                    j++
                } else { // need to change char in string 1
                    isEditMade = true
                    i++
                    j++
                }
            }
        } else {
            i++
            j++
        }
    }

    return if (i > j) {
        val diff = i - j
        if (diff > 1) false
        else if (diff == 1) !isEditMade
        else true
    } else {
        val diff = j - i
        if (diff > 1) false
        else if (diff == 1) !isEditMade
        else true
    }
}
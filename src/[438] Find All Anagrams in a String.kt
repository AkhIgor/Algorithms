fun main() {
    println(findAnagrams(s = "abccba", p = "abc"))
}

fun findAnagrams(s: String, p: String): List<Int> {
    if (s.isBlank() || p.isBlank() || s.length < p.length) return listOf()

    val result = mutableListOf<Int>()
    val need = IntArray(26) // Таблица для символов строки p
    val have = IntArray(26) // Таблица для текущей части строки s

    // Заполнение таблицы needed символомами из p
    p.forEach { ch -> need[ch - 'a']++ }

    var matches = 0
    var l = 0 // Левая граница окна

    // Скользящий окном по строке s
    for (r in s.indices) {
        val rCh = s[r] - 'a'
        if (need[rCh] > 0) {
            have[rCh]++
            if (have[rCh] <= need[rCh]) matches++
        }

        // Окно достигло нужной ширины
        if (r >= p.length) {
            val lCh = s[l++] - 'a'
            if (need[lCh] > 0) {
                if (have[lCh] <= need[lCh]) matches-- // Проверка на уменьшение совпадений
                have[lCh]--                 // Удаляем символ из окна
            }
        }

        // Нашли полную анаграмму
        if (matches == p.length)
            result.add(l)
    }

    return result
}

// MINE
//private fun findAnagrams(s: String, p: String): List<Int> {
//    if (s.isBlank() || p.isBlank()) return emptyList()
//
//    val charSet = mutableMapOf<Char, Int>()
//
//    val indexes = mutableListOf<Int>()
//
//    var startIndex: Int
//    var charIndex = 0
//    var setChanged = false
//    p.forEach { c ->
//        charSet.compute(c) { key, value ->
//            value?.let { value + 1 } ?: 1
//        }
//    }
//
//    while (charIndex < s.length) {
//        startIndex = charIndex
//        while (startIndex < s.length && !charSet.isEmpty() && charSet.contains(s[startIndex])) {
//            setChanged = true
//            var charCount = charSet.get(s[startIndex])
//
//            if(charCount != null && charCount > 1) {
//                charSet.set(s[startIndex], charCount-1)
//            } else {
//                charSet.remove(s[startIndex])
//            }
//
//            startIndex++
//        }
//        if (charSet.isEmpty()) {
//            indexes.add(charIndex)
//        }
//        if (setChanged) {
//            setChanged = false
//            charSet.clear()
//
//            p.forEach { c ->
//                charSet.compute(c) { key, value ->
//                    value?.let { value + 1 } ?: 1
//                }
//            }
//        }
//        charIndex++
//    }
//
//    return indexes
//}
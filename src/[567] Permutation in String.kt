fun main() {
    println(checkInclusion("hello", "ooolleooolleh"))
}

private  fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false // Сразу исключаем случаи, когда длина s1 больше длины s2

    val charCountS1 = IntArray(26)
    val windowCharCount = IntArray(26)

    for (i in s1.indices) { // Заполняем начальную частоту символов в s1
        charCountS1[s1[i] - 'a']++
        windowCharCount[s2[i] - 'a']++ // Формируем первое окно в s2
    }

    // Проверяем первую позицию окна
    if (charCountS1.contentEquals(windowCharCount)) return true

    // Начинаем сдвигать окно по всей строке s2
    for (right in s1.length until s2.length) {
        val leftIndex = right - s1.length

        // Обновляем окно: добавляем новый символ справа и удаляем старый слева
        windowCharCount[s2[right] - 'a']++
        windowCharCount[s2[leftIndex] - 'a']--

        // Проверяем новое состояние окна
        if (charCountS1.contentEquals(windowCharCount)) return true
    }

    return false
}

// MINE
//private fun checkInclusion(s1: String, s2: String): Boolean {
//    val map = hashMapOf<Char, Int>()
//    var length = s1.length
//
//    s1.forEach { char ->
//        putData(map, char)
//    }
//
//    var buffMap = HashMap<Char, Int>(map)
//
//    var left = 0
//    var right = 0
//
//    while (right < s2.length) {
//        if (map.contains(s2[right])) {
//            val currValue = map.get(s2[right])!!
//            if (currValue > 0) {
//                val newValue = currValue - 1
//                buffMap.set(s2[right], newValue)
//                right++
//            } else {
//                putData(buffMap, s2[left])
////                buffMap.set(s2[right], 0)
//                left++
//            }
//        } else {
//            right++
//            left = right
//            buffMap = HashMap<Char, Int>(map)
//        }
//
//    }
//
//    return buffMap.values.find { it != 0 } == null
//}
//
//private fun putData(map: MutableMap<Char, Int>, char: Char) {
//    map.compute(char) { char, value ->
//        value?.let {
//            value + 1
//        } ?: 1
//    }
//}


import java.util.*
import kotlin.collections.toList

fun main() {
    println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))

    println(groupAnagrams(arrayOf("")))
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val ans = mutableMapOf<String?, MutableList<String>>()

    for (s in strs) {
        val chars: CharArray = s.toCharArray()
        Arrays.sort(chars)
        val key = String(chars)
        if (!ans.containsKey(key)) {
            ans.put(key, ArrayList<String>())
        }
        ans[key]!!.add(s)
    }

    return ans.values.map { it.toList() }.toList()
}

//private fun groupAnagrams(strs: Array<String>): List<List<String>> {
//    val result = mutableMapOf<Set<Char>, List<String>>()
//
//    strs.forEach { str ->
//        val set = mutableSetOf<Char>()
//        str.forEach { set.add(it)}
//
//        if(result.contains(set)) {
//            result.compute(set, { key, value ->
//                value?.toMutableList()?.apply {
//                    add(str)
//                }?.toList()
//            })
//        } else {
//            result[set] = listOf(str)
//        }
//    }
//
//    return result.values.toList()
//}
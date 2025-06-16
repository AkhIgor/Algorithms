fun main() {
    LRUCache(2).apply {
        put(1, 1)
        put(2, 2)
        println(get(1))
        put(3, 3)
        println(get(2))
        put(4, 4)
        println(get(1))
        println(get(3))
        println(get(4))
    }
}

internal class Node(var key: Int, var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
}


internal class LRUCache(private val cap: Int) {
    private val cache: MutableMap<Int?, Node> = HashMap<Int?, Node>()
    private val oldest: Node = Node(0, 0)
    private val latest: Node = Node(0, 0)

    init {
        this.oldest.next = this.latest
        this.latest.prev = this.oldest
    }

    fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val node: Node = cache.get(key)!!
            remove(node)
            insert(node)
            return node.`val`
        }
        return -1
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev!!.next = next
        next!!.prev = prev
    }

    private fun insert(node: Node) {
        val prev = latest.prev
        val next = latest
        next.prev = node
        prev!!.next = node
        node.next = next
        node.prev = prev
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)!!)
        }
        val newNode = Node(key, value)
        cache.put(key, newNode)
        insert(newNode)

        if (cache.size > cap) {
            val lru = oldest.next
            remove(lru!!)
            cache.remove(lru.key)
        }
    }
}

// MINE
//class LRUCache(val capacity: Int) {
//
//    private val hashMap = HashMap<Int, Int>(capacity)
//    private val values = IntArray(capacity) { -1 }
//    private var currPutIndex = 0
//
//    fun get(key: Int): Int {
//        return hashMap.remove(key)?.let { index ->
//            val value = values[index]
//            values[index] = -1
//            value
//        } ?: -1
//    }
//
//    fun put(key: Int, value: Int) {
//        hashMap[key]?.let { index ->
//            values[index] = value
//        } ?: run {
//            values[currPutIndex] = value
//            hashMap[key] = currPutIndex
//            if (currPutIndex == capacity - 1) {
//                currPutIndex = 0
//            } else {
//                currPutIndex++
//            }
//        }
//    }
//}
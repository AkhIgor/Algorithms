fun main() {
    val listNode_1 = ListNode(1)
    val listNode_2 = ListNode(2)
    val listNode_3 = ListNode(3)
    val listNode_4 = ListNode(4)
    val listNode_5 = ListNode(5)
    listNode_1.next = listNode_2
    listNode_2.next = listNode_3
    listNode_3.next = listNode_4
    listNode_4.next = listNode_5
    println((listNode_1).toMyString())
    println(reverseList(listNode_1)?.toMyString())
}

private fun reverseList(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head

    // Рекурсивно разворачиваем остальную часть списка
    val newHead = reverseList(head.next)

    newHead?.next = head
    // Переворачиваем связь: следующая голова указывает на старую голову
    head.next!!.next = head

    // Старый головной узел теперь становится последним,
    // следовательно, сбрасываем его ссылку на следующий узел
    head.next = null

    return newHead
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString()
    }

    fun toMyString(): String {
        val result = StringBuilder()
        var current: ListNode? = this
        while (current != null) {
            result.append("[${current.`val`}] -> ")
            current = current.next
        }
        return result.toString()
    }
}
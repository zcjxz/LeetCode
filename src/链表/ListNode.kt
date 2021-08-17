package 链表

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 传入一个数组，创建一个链表
 */
fun createListNode(array: IntArray): ListNode {
    val head = ListNode(array[0])
    var current = head
    for (i in 1 until array.size){
        val next = ListNode(array[i])
        current.next = next
        current = next
    }
    return head
}

/**
 * 打印链表
 */
fun printListNode(listNode: ListNode?){
    if (listNode==null){
        print("null")
        return
    }
    print("${listNode.`val`}、")
    var next = listNode.next
    while (next!=null){
        print("${next.`val`}、")
        next = next.next
    }
}
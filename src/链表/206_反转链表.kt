package 链表

fun reverseList(head: ListNode?): ListNode? {
    // 头部
    var pre: ListNode? = null
    var current = head
    while (current != null) {
        // 保存下一个结点
        val next = current.next
        // 链接结点
        current.next = pre
        // 重新指向头部
        pre = current
        // 操作结点往后移
        current = next
    }
    return pre
}

fun main() {

}
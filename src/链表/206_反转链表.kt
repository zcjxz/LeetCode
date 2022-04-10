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

/**
 * 双指针迭代法
 */
fun reverseListT2(head: ListNode?): ListNode? {
    head?.next?:return head
    var pre:ListNode? = null
    var cur = head
    while (cur!=null){
        val next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
    return pre
}

/**
 * 递归
 */
fun reverseListT2_2(head: ListNode?): ListNode? {
    head?.next?:return head
    val pre = reverseListT2_2(head.next)
    head.next?.next = head
    head.next = null
    return pre
}

fun main() {

}
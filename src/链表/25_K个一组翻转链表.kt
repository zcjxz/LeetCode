package 链表

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    head ?: return null
    var start = head
    var count = 0
    while (start != null && count<=k) {
        count++
        val pre = start
        start = start.next
        if (count == k) {
            pre.next = reverseKGroup(start, k)
            return reverseGroup(head,pre.next)
        }
    }
    return head
}

fun reverseGroup(head: ListNode?, last: ListNode?): ListNode? {
    head ?: return head
    var p = last
    var c: ListNode? = head
    while (c != null && c != last) {
        val next = c.next
        c.next = p
        p = c
        c = next
    }
    return p
}

fun main() {
    val result = reverseKGroup(createListNode(intArrayOf(1, 2, 3, 4,5,6)), 3)
    printListNode(result)
}
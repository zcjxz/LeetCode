package 链表

/**
 * 迭代的解法
 * 使用 temp、node1、node2 三个指针对 node1、node2 调换位置，然后再向前移动两位，调换下一组
 */
fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next==null) return head
    val fakeHead = ListNode(0)
    fakeHead.next = head
    var temp = fakeHead
    while (temp.next!=null && temp.next!!.next!=null){
        val node1 = temp.next
        val node2 = node1!!.next
        temp.next = node2
        node1.next = node2!!.next
        node2.next = node1
        temp = temp.next!!.next!!
    }
    return fakeHead.next
}

/**
 * 递归的解法
 * 每次只把 第一个 跟 第二个 结点互换。
 */
fun swapPairs1(head: ListNode?): ListNode? {
    if(head?.next == null) return head
    val newHead = head.next
    head.next = swapPairs1(newHead!!.next)  // 注意这里要传 newHead 的 next 相当于 head.next.next，这个才是后面链表的指针
    newHead.next = head // next 用完之后记得重置为 head
    return newHead
}


fun main() {
    printListNode(swapPairs(createListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))))
}
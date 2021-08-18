package 链表

/**
 * 自己写的版本，后面补充 递归 、 迭代 的版本
 * 自己建一个指示器，间隔一个进行交换
 */
fun swapPairs(head: ListNode?): ListNode? {
    if (head == null) return null
    var pre = head
    var i = 0
    var current = head.next
    val fakeHead = ListNode(0)
    fakeHead.next = current
    while (current?.next != null) {
        i++
        if (i % 2 != 0) {
            // 进行交换
            pre!!.next = current.next
            current.next = pre
            current = pre.next
        }else {
            // 不需要交换的时候，指针往前移动
            current = current.next
            // 保存下一个 pre 的 next 指针
            val temp = pre!!.next
            // 提前把上一个结点 next 改为下次要交换的下个结点，否则中间的结点会丢失
            // 比如没有把 1 的 next 改为 4，就会导致 4 这个结点丢失，因为 3 的 next 会指向 5
            pre.next = current
            pre = temp
        }

    }
    return fakeHead.next
}



fun main() {
    printListNode(swapPairs(createListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))))
}
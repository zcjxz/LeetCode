package 链表

fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    val set = mutableSetOf<ListNode>()
    var temp = head
    while (temp != null) {
        if (set.contains(temp)) {
            return temp
        }
        set.add(temp)
        temp = temp.next
    }
    return null
}

fun main() {

}
package 链表


fun hasCycle(head: ListNode?): Boolean {
    if (head?.next==null) return false
    val set = mutableSetOf<ListNode>()
    var temp = head
    while (temp!=null){
        if (set.contains(temp)){
            return true
        }
        set.add(temp)
        temp = temp.next
    }
    return false
}

/**
 * 快慢指针的解法
 * 快指针每步走 2 个结点，慢指针每步走 1 个结点
 */
fun hasCycle1(head: ListNode?): Boolean {
    if (head?.next == null) return false
    // 快慢指针的起点不同，由于下面判断的条件是 slow != fast 如果起点相同，就要进行额外的处理
    // 其实我们可以在 head 前面多加一个结点，这样走了一步之后， slow 就是 head ，fast 就是 head.next
    var slow = head
    var fast = head.next
    while (slow!=fast){
        if (fast?.next == null){
            return false
        }
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return true
}

fun main() {

}
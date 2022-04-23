package 链表

/**
 * 迭代解法
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    list1?:return list2
    list2?:return list1
    var n1 = list1
    var n2 = list2
    val f = ListNode(-1)
    var c = f
    while (n1!=null && n2 != null){
        if (n1.`val`<=n2.`val`){
            c.next = n1
            n1 = n1.next
        }else{
            c.next = n2
            n2 = n2.next
        }
        c = c.next!!
    }
    if (n1 == null){
        c.next = n2
    }else{
        c.next = n1
    }
    return f.next
}

/**
 * 递归的写法
 */
fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    list1?:return list2
    list2?:return list1
    return if (list1.`val`<=list2.`val`){
        list1.next = mergeTwoLists2(list1.next,list2)
        list1
    }else{
        list2.next = mergeTwoLists2(list1,list2.next)
        list2
    }
}

fun main() {
    val list1 = createListNode(intArrayOf(1, 2, 4))
    val list2 = createListNode(intArrayOf(1, 3, 4))
    printListNode(mergeTwoLists2(list1, list2))
}

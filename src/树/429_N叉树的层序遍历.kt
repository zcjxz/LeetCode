package 树

import java.util.LinkedList

// 迭代
fun levelOrder(root: Node?): List<List<Int>> {
    root?:return emptyList()
    val result = mutableListOf<List<Int>>()
    result.add(mutableListOf(root.`val`))
    var children = root.children
    var subChildren = mutableListOf<Node>()
    while (children.isNotEmpty()){
        val childrenVal = mutableListOf<Int>()
        children.forEach {
            it?.let {
                childrenVal.add(it.`val`)
                subChildren.addAll(it.children.filterNotNull())
            }
        }
        result.add(childrenVal)
        children = subChildren
        subChildren= mutableListOf()
    }
    return result
}

fun levelOrder2(root: Node?): List<List<Int>> {
    root?:return emptyList()
    val result = mutableListOf<List<Int>>()
    val list = LinkedList<Node?>()
    list.add(null)
    list.add(root)
    while (list.size>0){
        val temp = mutableListOf<Int>()
        var pop = list.pop()
        while (pop!=null){
            temp.add(pop.`val`)
            pop.children.filterNotNull().forEach {
                list.addFirst(it)
            }
            pop = list.pop()
        }
        list.addFirst(null)
        result.add(temp)
    }
    return result
}

fun main() {
    val root = Node(1).apply {
        children = mutableListOf(
            Node(3).apply {
                children= mutableListOf(Node(5),Node(6))
            },
            Node(2),
            Node(4)
        )
    }
    levelOrder(root).forEach {
        print("[")
        it.forEach{item -> print("$item、")}
        println("]")
    }
}

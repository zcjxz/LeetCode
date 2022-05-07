package 树

import java.util.*

fun inorderTraversal(root: TreeNode?): List<Int> {

    fun inorder(root: TreeNode?,list:MutableList<Int>){
        root?:return
        inorder(root.left,list)
        list.add(root.`val`)
        inorder(root.right,list)
    }

    val result = mutableListOf<Int>()
    inorder(root, result)
    return result
}

/**
 * 迭代的解法，模拟了调用栈
 */
fun inorderTraversal2(root:TreeNode?): List<Int> {
    root?:return emptyList()
    val result = mutableListOf<Int>()
    val stack = LinkedList<TreeNode>()
    var index = root
    while (index!=null || stack.isNotEmpty()){
        while (index!=null){
            stack.push(index)
            index = index.left
        }
        index = stack.pop()
        result.add(index.`val`)
        index = index.right
    }
    return result
}

fun main() {
    inorderTraversal(createTreeNode(mutableListOf(1,null,2,3))).forEach {
        print("$it、")
    }
}
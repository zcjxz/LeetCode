package 树

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

fun main() {
    inorderTraversal(createTreeNode(mutableListOf(1,null,2,3))).forEach {
        print("$it、")
    }
}
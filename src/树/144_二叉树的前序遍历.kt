package 树

fun preorderTraversal(root: TreeNode?): List<Int> {

    fun preorderTraversal(root: TreeNode?,result:MutableList<Int>){
        root?:return
        result.add(root.`val`)
        preorderTraversal(root.left,result)
        preorderTraversal(root.right,result)
    }

    val result = mutableListOf<Int>()
    preorderTraversal(root,result)
    return result
}

fun main() {
    preorderTraversal(createTreeNode(mutableListOf(1,null,2,3))).forEach {
        print("$it、")
    }
}
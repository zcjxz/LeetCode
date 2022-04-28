package 树

class TreeNode(var `val`:Int) {
    var left:TreeNode?=null
    var right:TreeNode?=null
}

fun createTreeNode(l:MutableList<Int?>):TreeNode?{
    if (l.size==0) return null
    val first = l[0]
    if (first==null){
        l.removeAt(0)
        return null
    }
    val root =TreeNode(first)
    l.removeAt(0)
    root.left = createTreeNode(l)
    root.right = createTreeNode(l)

    return root;
}
package 树


fun preorder(root: Node?): List<Int> {
    fun preorder(root: Node?,result:MutableList<Int>){
        root?:return
        result.add(root.`val`)
        root.children.forEach {
            preorder(it,result)
        }
    }

    val result = mutableListOf<Int>()
    preorder(root,result)
    return result
}


fun main() {

}
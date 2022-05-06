package 树

fun postorder(root: Node?): List<Int> {

    fun postorder(root: Node?,result:MutableList<Int>){
        root?:return
        root.children.forEach {
            postorder(it,result)
        }
        result.add(root.`val`)
    }

    val result = mutableListOf<Int>()
    postorder(root,result)
    return result
}

fun main() {

}
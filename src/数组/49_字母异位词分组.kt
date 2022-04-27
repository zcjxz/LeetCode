package 数组

/**
 * 这道题是在 242 题目的基础上衍生出来的题目。
 * 242 有两种解法，对应这道题其实也有两种解法，这里就只用排序的解法
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val map = mutableMapOf<String,MutableList<String>>()
    strs.forEach {
        val s = it.toCharArray().apply { sort() }
        val k = String(s)
        if (map.containsKey(k)){
            map[k]?.add(it)
        }else{
            map[k] = mutableListOf<String>().apply {
                add(it)
            }
        }
    }
    val result = mutableListOf<MutableList<String>>()
    map.forEach{
        result.add(it.value)
    }
    return result
}

fun main() {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
        print("[")
        it.forEach{
            print("$it、")
        }
        println("]")
    }
}


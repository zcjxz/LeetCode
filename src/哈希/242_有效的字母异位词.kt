package 哈希

/**
 * 哈希
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s.length!=t.length) return false
    val map = mutableMapOf<Char,Int>()
    s.forEach {
        if (map.containsKey(it)){
            map[it] = map[it]!! +1
        }else{
            map[it] = 1
        }
    }
    t.forEach {
        if (map.containsKey(it)){
            map[it] = map[it]!! -1
            if (map[it]!!<=0){
                map.remove(it)
            }
        }else{
            return false
        }
    }
    return map.isEmpty()
}

/**
 * 排序
 */
fun isAnagram2(s: String, t: String): Boolean {
    if (s.length!=t.length) return false
    val s2Array = s.toCharArray()
    s2Array.sort()
    val t2Array = t.toCharArray()
    t2Array.sort()
    return s2Array.contentEquals(t2Array)
}

fun main() {
    println(isAnagram2("rat","tar"))
}
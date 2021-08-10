

/**
 * 我这里是直接先做一次拷贝，然后再进行 map 查找，也就是会遍历两次，其实可以不用这样
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    nums.forEachIndexed{
        index, i ->
        map[i] = index
    }
    nums.forEachIndexed { index, i ->
        val dp =target-i
        if (map.containsKey(dp) && map[dp]!=index){
            return intArrayOf(index,map[dp]!!)
        }
    }
    return intArrayOf()
}

/**
 * 这种做法是减少了一遍循环
 */
fun twoSum1(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    nums.forEachIndexed { index, i ->
        val dp = target-i
        if (map.containsKey(dp) && map[dp]!=index){
            return intArrayOf(index,map[dp]!!)
        }
        map[i] = index
    }
    return intArrayOf()
}


fun main() {
    twoSum1(intArrayOf(3,3),6).forEach { print("$it、") }
}
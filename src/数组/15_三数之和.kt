package 数组

/**
 * 先排序，然后开始遍历数组。
 * 遍历的时候，右边采用双指针的方法，筛选出符合条件的另外两个数，也就是三数之和等于 0 。
 *
 * 其实这道的难点是如何去重。
 * 如果我们不进行排序，要进行查找和去重是非常麻烦的，时间复杂度很高。
 * 排序之后，我们可以使用双指针来快速查找到满足条件的另外两个元素，
 * 而且由于排过序，所以相同的两个数是挨在一起，也能更方便进行去重。
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    var i = 0
    nums.sort()
    val result = mutableListOf<MutableList<Int>>()
    while (i < nums.size-2) {
        // 去重
        if (i>0 && nums[i] == nums[i-1]){
            i++
            continue
        }
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            // 注意去重不能写在这里，会导致有相同的元素无法计入结果
//            if (l>1 && nums[l] == nums[l-1]){
//                l++
//                continue
//            }
            val dp = nums[l] + nums[r] + nums[i]
            when {
                dp == 0 -> {
                    result.add(mutableListOf(nums[i],nums[l],nums[r]))
                    // 查找到一组之后，要去除到后面相同的元素，防止又被后面重复算进结果
                    while (l<r && nums[l] == nums[l+1]){
                        l++
                    }
                    while (l<r && nums[r] == nums[r-1]){
                        r--
                    }
                    l++
                    r--
                }
                dp > 0 -> {
                    // 由于排过序，所以整体偏大的话，就把右指针往左边偏移，使整体变小
                    r--
                }
                else -> {
                    // 同理，左指针往右偏移，使整体变大
                    l++
                }
            }
        }
        i++

    }
    return result
}

fun threeSumT2(nums: IntArray): List<List<Int>> {
    if (nums.size<3) return emptyList()
    val result = mutableListOf<List<Int>>()
    nums.sort()
    var i =0
    while (i<nums.size-2){
        // 去重
        while (i>0 && nums[i] == nums[i-1]){
            i++
            // 记得这里要用 continue ，防止有三个以上相同的数，只去重了第二个的情况
            continue
        }
        var l = i+1
        var r = nums.size-1
        while (l<r) {
            val dp = nums[i] + nums[l] + nums[r]
            when{
                dp==0->{
                    result.add(mutableListOf(nums[i],nums[l],nums[r]))
                    while (l<r && nums[l]==nums[l+1]) l++
                    while (l<r && nums[r]==nums[r-1]) r--
                    l++
                    r--
                }
                dp<0 ->{
                    l++
                }
                dp>0 ->{
                    r--
                }
            }
        }
        i++
    }
    return result
}

fun main() {
//    threeSumT2(intArrayOf(-1, 0, 1, 2, -1, -4))
//    threeSum(intArrayOf(0,0,0))
    threeSumT2(intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6))
}
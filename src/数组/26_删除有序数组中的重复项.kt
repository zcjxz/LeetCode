package 数组

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var s = 0
    var p = 1
    while (p<nums.size){
        if (nums[p]!=nums[s]){
            nums[++s] = nums[p]
        }
        p++
    }
    return s+1
}

fun main() {
    val nums = intArrayOf(1,1,2,2,2,3,4)
    println(removeDuplicates(nums))
    nums.forEach {
        print("$it、")
    }
}
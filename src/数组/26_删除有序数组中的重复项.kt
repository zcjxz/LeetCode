package 数组

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    var j = 1
    while (j<nums.size){
        if (nums[i]!=nums[j]){
            nums[++i] = nums[j]
        }
        j++
    }
    return ++i
}

fun main() {
    val nums = intArrayOf(1,1,2,2,2,3,4)
    println(removeDuplicates(nums))
    nums.forEach {
        print("$it、")
    }
}
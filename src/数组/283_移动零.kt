package 数组

/**
 * 双指针
 * left 指针指向处理完成的数据尾端，right 指针指向待处理的数据头部
 * right 遇到不为 0 的元素，就跟 left 指针替换。
 * ---------------------------------------------
 * 我一开始的解法都是，想着怎么标记第一个零的位置，然后再进行替换，替换完成之后再找第一个零的位置，
 * 其实换种思路，我们只要把非零的元素都排到前面就可以了。
 */
fun moveZeroes(nums: IntArray): Unit {
    var left = 0
    var right = 0
    while (right<nums.size){
        if (nums[right]!=0){
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
        }
        right++
    }
    nums.forEach { print("$it. ") }
}

fun main() {
    moveZeroes(intArrayOf(1,0,3,0,0,52))
}
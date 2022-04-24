package 数组

fun rotate(nums: IntArray, k: Int): Unit {
    val m = k % nums.size
    val temp = IntArray(m)
    System.arraycopy(nums,nums.size-m,temp,0,m)
    for(i in nums.size-1 downTo m){
        nums[i] = nums[i-m]
    }
    System.arraycopy(temp,0,nums,0,temp.size)
}

fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7,8)
    rotate(nums,3)
    nums.forEach {
        print("$it、")
    }
}
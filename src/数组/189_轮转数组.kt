package 数组

/**
 * 标准的解法
 */
fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    val temp = IntArray(n)
    for (i in 0 until n){
        temp[(i+k)%n] = nums[i]
    }
    System.arraycopy(temp,0,nums,0,n)
}

/**
 * 自己写的解法，这个思路是，临时的数组只是存放一下要被覆盖的数据，
 * 等原数组把后面的数据覆盖到前面之后，再把临时数组里面的值覆盖到后面，
 * 比上面标准的解法，少拷贝了 [数组大小 - (k%数组大小）] 个数据
 */
fun rotateMy(nums: IntArray, k: Int): Unit {
    val m = k % nums.size
    val temp = IntArray(m)
    System.arraycopy(nums,nums.size-m,temp,0,m)
    for(i in nums.size-1 downTo m){
        nums[i] = nums[i-m]
    }
    System.arraycopy(temp,0,nums,0,temp.size)
}

/**
 * 也是自己想出来的解法，但是一开始写不出来，一直有 bug，看了官方的 【环形替换】解法，原来是一样的
 */
fun rotateMy2(nums: IntArray, k: Int): Unit {
    val m = k%nums.size
    var c = nums[0]
    var p = m
    var t = nums[p]
    var count = 0
    // todo 这里还不完整，回到原来的位置之后，需要跳到下一个，需要另一个循环来做
    while (count <nums.size){
        t = nums[p]
        nums[p] = c
        c = t
        p = (p+m)%nums.size
        count++
    }
}

/* 还有个翻转数组的解法 */

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    rotateMy2(nums, 2)
    nums.forEach {
        print("$it、")
    }
}
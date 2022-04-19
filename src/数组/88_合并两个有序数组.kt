package 数组

/**
 * 双指针
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = 0
    var j = 0
    var z = 0
    val result = IntArray(nums1.size)
    while (i<m && j<n){
        if (nums1[i]<=nums2[j]){
            result[z] = nums1[i]
            i++
        }else{
            result[z] = nums2[j]
            j++
        }
        z++
    }
    if (i==m){
        nums2.copyInto(result,z,j,n)
    }else{
        nums1.copyInto(result,z,i,m)
    }
    result.copyInto(nums1)
}

/**
 * 倒序合并，这样不用中间变量来存储，和最后的拷贝操作
 */
fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m-1
    var j = n-1
    var z = nums1.size-1
    while (z>=0 && i>=0 && j>=0){
        if (nums1[i]>nums2[j]){
            nums1[z] = nums1[i]
            i--
        }else{
            nums1[z] = nums2[j]
            j--
        }
        z--
    }
    if (j>=0){
        for (x in 0..j){
            nums1[x] = nums2[x]
        }
    }
}

/**
 * 倒序合并的 简洁写法
 */
fun merge3(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = m - 1
    var p2 = n - 1
    var tail = m + n - 1

    while (tail >= 0) {
        nums1[tail--] = when {
            p1 == -1 -> nums2[p2--]
            p2 == -1 -> nums1[p1--]
            nums1[p1] > nums2[p2] -> nums1[p1--]
            else -> nums2[p2--]
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    val nums2 = intArrayOf(2,5,6)
    merge2(nums1,3,nums2,3)
    nums1.forEach {
        print("$it、")
    }
}
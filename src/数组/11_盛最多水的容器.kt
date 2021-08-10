
/**
 * 双指针解法
 * 从头和尾分别设置一个指针，哪一个指针的数值比较小，就往另一个指针移动，直到两个指针相邻，其中最大值就是最大的面积。
 * 理论依据是，以小边为基准移动指针的矩形一定小于现在矩形的面积。因为小的一边会限制矩形一边的长度，移动大边的指针，只会让横轴变更短。
 * 所以舍弃掉这个边的后续可能性，因为现在就是这个边为矩形的最大面积的了。
 */
fun maxArea(height: IntArray): Int {
    if (height.size<2) return 0
    var l = 0
    var r = height.size-1
    var ans = 0
    while (l<r){
        val area = Math.min(height[l], height[r]) * (r - l)
        if (area>ans){
            ans = area
        }
        if (height[l]<=height[r]){
            l++
        }else{
            r--
        }
    }
    return ans
}

fun main() {
    print(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

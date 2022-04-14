package 栈

import java.util.Stack

fun largestRectangleArea(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    // 由于 Kotlin 中入参 无法改变，只能 copy 多一份
    val copy = IntArray(heights.size+2)
    heights.copyInto(copy,1)
    // 放置哨兵
    copy[0] = 0
    copy[copy.size-1] = 0
    // 提前放置哨兵，在 while 循环中可以不用判空
    stack.push(0)
    var max = 0
    for (i in copy.indices){
        // 注意这里要循环弹出来
        while (copy[stack.peek()]>copy[i]){
            val height = copy[stack.pop()]
            // 宽度 = 当前元素 - 弹出后栈顶的元素 -1
            max = Math.max(max,(i - stack.peek() -1)*height)
        }
        stack.push(i)
    }
    return max
    return maxSize
}

fun main() {
    print(largestRectangleArea(intArrayOf(2, 1,2)))
}
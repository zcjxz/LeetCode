package 堆

import java.util.PriorityQueue
import kotlin.math.min

/**
 * 堆的解法，通过取出堆上最小的数，然后分别乘上 最小的丑数 。
 * 还是用了 Set 来过滤重复的数值
 */
fun nthUglyNumber(n: Int): Int {
    val uglyArray = intArrayOf(2,3,5)
    val heap = PriorityQueue<Long>()
    val set = HashSet<Long>()
    set.add(1)
    heap.add(1)
    for (i in 0 until n){
        val ugly = heap.poll()
        if (i==n-1){
            return ugly.toInt()
        }
        uglyArray.forEach {
            val next = ugly*it
            if (set.add(next)){
                heap.offer(next)
            }
        }
    }
    return 0
}

/**
 * 动态规划，其实我也看不太懂，那个证明的过程。。。。
 */
fun nthUglyNumber2(n: Int): Int {
    val dp = IntArray(n+1).apply {
        this[2] = 1
    }
    var p2 = 1
    var p3 = 1
    var p5 = 1
    for (i in 2 .. n){
        val num2 = dp[p2]*2
        val num3 = dp[p3]*3
        val num5 = dp[p5]*5
        dp[i] = min(min(num2,num3),num5)
        when(dp[i]){
            num2 -> p2++
            num3 -> p3++
            num5 -> p5++
        }
    }
    return dp[n]
}
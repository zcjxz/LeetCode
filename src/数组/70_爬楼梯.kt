package 数组
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 记忆化搜索 数学 动态规划
// 👍 1795 👎 0

/**
 * 这种解法能够解出答案，但是由于每一个都会重新计算，会有很多重复的计算，这里需要优化，否则提交 LeetCode 的时候会超时
 */
fun climbStairs(n: Int): Int {
    if (n == 1 || n == 0) {
        return 1
    }
    return climbStairs(n - 1) + climbStairs(n - 2)
}

/**
 * 优化之后的速度，啪的一下，很快啊，就算完了。
 * 这里其实用的就是 动态规划 ，有状态转移转移表dp，和 递推公式 dp[i] = dp[i-1] + dp[i-2]
 */
fun climbStairs1(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n){
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[n]
}

/**
 * 滚动数组 解法
 * 这个是之前在 LeetCode 上看到的另一种解法，主要是在上面的基础上，优化了空间复杂度，但是多了元素的拷贝的操作，增加了时间复杂度
 * 优化的方向是，根据 dp[i] = dp[i-1] + dp[i-2] 这个递推公式只用到了前面两项的内容，所以直接用一个短数组来滚动就可以了。
 */
fun climbStairs2(n: Int): Int {
    if (n == 1 || n == 0) return 1
    val dp = IntArray(3)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n){
        dp[2] = dp[0] + dp[1]
        dp[0] = dp[1]
        dp[1] = dp[2]
    }
    return  dp[2]
}

fun climbStairsT2(n: Int): Int {
    val dp = IntArray(3)
    dp.fill(1)
    for (i in 2 .. n){
        dp[2] = dp[0] + dp[1]
        dp[0] = dp[1]
        dp[1] = dp[2]
    }
    return dp[2]
}

fun main() {
    println(climbStairs2(45))
}
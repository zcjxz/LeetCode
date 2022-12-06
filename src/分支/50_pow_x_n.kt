package 分支

/**
 * https://leetcode.cn/problems/powx-n/
 */
fun myPow(x: Double, n: Int): Double {
    fun pow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n == 1) return x
        val pow = pow(x, n / 2)
        return if (n % 2 == 0) {
            pow * pow
        } else {
            pow * pow * x
        }
    }

    return if (n > 0) {
        pow(x, n)
    } else {
        1 / pow(x, Math.abs(n))
    }
}

fun main() {
    println(myPow(3.00, 10))
}
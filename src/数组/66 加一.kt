package 数组

fun plusOne(digits: IntArray): IntArray {
    for(i in digits.indices.reversed()){
        digits[i] = ++digits[i] % 10
        // 如果不为 零 ，不需要进位，直接返回
        if(digits[i] != 0) return digits
    }
    // 如果都遍历完，说明到最后了还需要进位，则加多一位，第一位为1.
    // 这种情况就是 9、99、999 的情况
    return IntArray(digits.size+1).also{it[0]=1}
}


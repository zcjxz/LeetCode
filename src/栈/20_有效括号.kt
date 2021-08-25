package 栈

import java.util.*

fun isValid(s: String): Boolean {
    if (s.length%2==1){
        return false
    }
    val pairs = mutableMapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    val stack = Stack<Char>()
    for (i in s){
        if (pairs.containsKey(i)){
            if (stack.isEmpty() || stack.pop()!= pairs[i]){
                return false
            }
        }else{
            stack.push(i)
        }
    }
    return stack.isEmpty()
}
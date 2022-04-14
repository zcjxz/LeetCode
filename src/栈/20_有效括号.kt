package 栈

import java.util.*

fun isValid(s: String): Boolean {
    if (s.length%2!=0) return false
    val map = mutableMapOf(')' to '(','}' to '{',']' to '[')
    val stack = LinkedList<Char>()
    s.forEach {
        if (map[it]==null){
            stack.push(it)
        }else{
            if (stack.size==0 || stack.pop()!=map[it]){
                return false
            }
        }
    }
    return stack.size==0
}

fun main() {
    print(isValid("){"))
}
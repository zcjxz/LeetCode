package 栈

import java.util.*

class MinStack() {

    private val mainStack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(x: Int) {
        mainStack.push(x)
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x)
        }
    }

    fun pop() {
        if (mainStack.peek() == minStack.peek()) {
            minStack.pop()
        }
        mainStack.pop()
    }

    fun top(): Int {
        return mainStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}
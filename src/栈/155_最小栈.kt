package 栈

import java.util.*

class MinStack() {

    private val mainStack = LinkedList<Int>()
    private val minStack = LinkedList<Int>()

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
package 堆

import java.util.PriorityQueue

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    arr.apply {  }
    return arr.run {
        sort()
        arr.copyOf(k)
    }
}

fun getLeastNumbers2(arr: IntArray, k: Int): IntArray {
    if (arr.size<k){return arr}
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    priorityQueue.addAll(arr.take(k))
    for (i in k until arr.size){
        priorityQueue.offer(arr[i])
        priorityQueue.poll()
    }
    val result = IntArray(k)
    for (i in 0 until k){
        result[i] = priorityQueue.poll()
    }
    return result
}


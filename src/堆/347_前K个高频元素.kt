package 堆

import java.util.*
import kotlin.Comparator

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val heap = PriorityQueue(Comparator<Map.Entry<Int, Int>> { o1, o2 ->
        o1.value - o2.value
    })
    val map = mutableMapOf<Int,Int>()
    nums.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    map.forEach{
        if (heap.size<k){
            heap.offer(it)
        }else{
            val top = heap.peek()
            if (top.value<it.value){
                heap.poll()
                heap.offer(it)
            }
        }
    }
    return heap.map { it.key }.toIntArray()
}

/* 还有一种是快排的做法 */

fun main() {
    topKFrequent(intArrayOf(4,4,3,3,2,3),2).forEach {
        print("$it、")
    }
}
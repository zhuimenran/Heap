package com.txb.queue;

import com.txb.maxheap.util.MaxHeap;

/**
 * 优先队列出队时等级最高的出队，而最大堆的root为最大值
 * 用最大堆实现优先队列，比较容易实现，最大堆是用数组实现的。最重要的是上浮与下沉操作
 * @author 13125
 *
 * @param <E>
 */
public class PriorityQueue <E extends Comparable<E>> implements Queue<E>{

	private MaxHeap<E> heap;
	
	public PriorityQueue() {
		heap = new MaxHeap<>();
	}
	
	//入队
	@Override
	public void enqueue(E e) {
		heap.add(e);
	}
	@Override
	public int getSize() {
		
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		
		return heap.isEmpty();
	}

	
//出队
	@Override
	public E dequeue() {
		return heap.extractMax();
	}

	//最大值
	@Override
	public E getFront() {
		
		return heap.findMax();
	}

	

}

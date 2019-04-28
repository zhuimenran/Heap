package com.txb.queue;

import com.txb.maxheap.util.MaxHeap;

/**
 * 用最大堆实现优先队列
 * @author 13125
 *
 * @param <E>
 */
public class PriorityQueue <E extends Comparable<E>> implements Queue<E>{

	private MaxHeap<E> heap;
	
	public PriorityQueue() {
		heap = new MaxHeap<>();
	}
	
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

	

	@Override
	public E dequeue() {
		return heap.extractMax();
	}

	@Override
	public E getFront() {
		
		return heap.findMax();
	}

	

}

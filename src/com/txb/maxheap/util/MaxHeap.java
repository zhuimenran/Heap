package com.txb.maxheap.util;
/**
 * 用数组实现最大堆
 * @author 13125
 *
 */
public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;
	
	public MaxHeap(int capacity) {
		data = new Array<E>(capacity);
	}
	
	public MaxHeap() {
		data = new Array<E>();
	}
	
	//heapify,将任意数组组成堆的形状
	public MaxHeap(E []list) {
		data = new Array<E>(list);//将数组装入堆数组中
		//将从倒数第一个非叶子节点到第一个节点进行下沉操作
		for(int i = parent(list.length-1); i >=0; i--) {
			siftDown(i);
		}
	}
	
	//得到数量
	public int size() {
		return data.getSize();
	}
	
	//都得到容量
	public int  getCapacity() {
		return data.getCapacity();
	}
	
	//判断是否为空
	public boolean isEmpty() {
		return data.getSize() ==0;
	}
	
	//replace,取出最大元素，放入新元素//logn
	public E replace(E e) {
		//将最大元素替换为新元素
		E ret = findMax();
		data.set(0, e);
		
		siftDown(0);
		return ret;
	}
	
	
	
	
	//返回完全二叉树的数组表示中，所给索引所表示的元素的父节点的索引
	private int parent(int index) {
		if(index==0) {
			throw new IllegalArgumentException("没有父亲节点");
		}
		return (index-1)/2;
	}
	
	//返回完全二叉树的数组表示中，所给索引所表示的元素的左孩子节点的索引
		private int leftChild(int index) {
			
			return index*2+1;
		}
		
		//返回完全二叉树的数组表示中，所给索引所表示的元素的右孩子节点的索引
		private int rightChild(int index) {
					
			return index*2+2;
		}
		
		//添加元素
		public void add(E e) {
			data.addLast(e);
			
			//维护堆的性质
			siftUp(data.getSize()-1);//上浮元素的索引
		}
		
		//上浮节点
		private void siftUp(int k) {
			while(k>0 && data.get(parent(k)).compareTo(data.get(k))<0) {
				data.swap(k,parent(k));
				k = parent(k);
			}
		}
		
		//取出元素(最大元素）
		public E extractMax() {
			E ret = findMax();
			data.swap(0, data.getSize()-1);
			data.removeLast();
			siftDown(0);
			return ret;
		}
		
		//下沉节点
		private void siftDown(int k) {
			
			while(leftChild(k)<data.getSize()) {
				int j = leftChild(k);//此时j为左右节点的最大值
				if(j+1 < data.getSize()&& data.get(j+1).compareTo(data.get(j))>0) {
					j = rightChild(k);
				}
				
				if(data.get(k).compareTo(data.get(j))>0) {
					break;//没有违反堆的性质
				}
				data.swap(k,j);
				k = j;//继续下沉
			}
		}
		
		//看堆中的最大元素
		public E findMax() {
			if(data.getSize() == 0) {
				throw new IllegalArgumentException("weik");
			}
			return data.get(0);
		}
}

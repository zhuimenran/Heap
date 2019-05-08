package com.txb.maxheap.util;
/**
 * 用数组实现最大堆
// * 堆（数据结构）：堆可以被看成是一棵树，如：堆排序；
//
//　　栈（数据结构）：一种先进后出的数据结构
//http://blog.csdn.net/genios/article/details/8157031
//
//最大堆和最小堆是二叉堆的两种形式。
//
//最大堆：根结点的键值是所有堆结点键值中最大者，且每个结点的值都比其孩子的值大。
//
//最小堆：根结点的键值是所有堆结点键值中最小者，且每个结点的值都比其孩子的值小。
// * @author 13125
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
	
//	生成最大堆：最大堆通常都是一棵完全二叉树，因此我们使用数组的形式来存储最大堆的值，从1号单元开始存储，
	//因此父结点跟子结点的关系就是两倍的关系。
//
//	即：heap[father * 2] = heap[leftChild];  heap[father * 2 + 1] = heap[rightChild];
//
//	 
//
//	最大堆的初始化
//
//	在生成最大堆时，我们可以采取一次次遍历整棵树找到最大的结点放到相应的位置中。
//
//	但是这种方法有个不好的地方，就是每个结点都要重复比较多次。
//
//	所以我们可以换一种思考的顺序，从下往上进行比较。先找到最后一个有子结点的结点，先让他的两
	//个子结点进行比较，找到大的值
	//再和父结点的值进行比较。如果父结点的
//	值小，则子结点和父结点进行交换，交换之后再往下比较。然后一步步递归上去，知道所在结点的位置是0号位置跳出。这样就可以有效地减少比较所用到的时间。
	
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
		
		//上浮节点，节点比父节点的值大，就上浮（只要子节点大于父节点，交换之后就能保证父节点大于子节点
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

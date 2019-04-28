package com.txb.queue;

public interface Queue<E> {
		public int getSize();
		
		public boolean  isEmpty();
		
		
		
		public E dequeue();
		
		public E  getFront();

		public void enqueue(E e);

		
}

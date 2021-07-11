package com.datastructure.heap;

public class MaxPriorityQueue1 {
	private Integer[] heap;
	int len;

	MaxPriorityQueue1(int size) {
		heap = new Integer[size+1];
		len = 0;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public int size() {
		return len;
	}
	public void insert(int x){
		if(len == heap.length-1){
			resize(2*heap.length);
		}
		len++;
		heap[len] = x;
		heapify(len);
	}

	private void heapify(int k) {
		while(k > 1 && heap[k/2] < heap[k]){
			int tmp = heap[k/2];
			heap[k/2] = heap[k];
			heap[k] = tmp;
			k = k/2;
		}
		
	}

	private void resize(int n) {
		Integer [] arr = new Integer[n];
		for(int i=0; i<heap.length;i++){
			arr[i] = heap[i];
		}
		heap = arr;
	}
	private void printMaxHeap(){
		for(int i=1; i<=len; i++){
			System.out.print(heap[i] +" ");
		}
	}
	public static void main(String[] args) {
		MaxPriorityQueue1 queue = new MaxPriorityQueue1(4);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(9);
		queue.insert(8);
		queue.insert(7);
		System.out.println(queue.size());
		queue.printMaxHeap();
	}

}

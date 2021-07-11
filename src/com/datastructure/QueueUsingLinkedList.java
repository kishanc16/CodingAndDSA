package com.datastructure;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
	private static Node rear;
	private static Node front;
	private static int length;
	
	static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public QueueUsingLinkedList() {
		rear = null;
		front = null;
		length = 0;
	}
	public int length(){
		return length;
	}
	public boolean isEmpty(){
		return length == 0;
	}
	
	public void enqueue(int data){
		Node newNode = new Node(data);
		if(isEmpty()){
			front = newNode;
		}else{
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}
	public void display(){
		Node temp = front;
		if(!isEmpty()){
			while(temp != rear){
				System.out.print(temp.data +" -->");
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
	}
	public int dequeue(){
		
		if(isEmpty()){
			throw new NoSuchElementException("Queue is Empty");
		}
		int temp= front.data;
		front = front.next;
		if(front == null)
			rear = null;
		length--;
		
		return temp;
	}
	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(7);
		queue.display();
		System.out.println("Enqueue Element : "+queue.dequeue());
		System.out.println("Enqueue Element : "+queue.dequeue());
		System.out.println("Enqueue Element : "+queue.dequeue());
		
		
		queue.display();
		
	}

}

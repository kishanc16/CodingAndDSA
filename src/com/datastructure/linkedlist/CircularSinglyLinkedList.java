package com.datastructure.linkedlist;

public class CircularSinglyLinkedList {
	private static Node last;
	private static int length;
	static class Node{
		Node next ;
		int data ;
		
		Node(int data){
			this.next = null;
			this.data = data;
		}
	}
	public CircularSinglyLinkedList() {
		last = null;
		length = 0;
	}
	public int length(){
		return length;
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public void circularList(){
		Node a = new Node(3);
		Node b = new Node(5);
		Node c = new Node(7);
		Node d = new Node(9);
		Node e = new Node(11);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = a;
		last = e;
		
		
	}
	public void showListNode()
	{
		Node first = last.next;
		while(first != last)
		{
			System.out.print(first.data+" ");
			first = first.next;
		}
		System.out.println(first.data);
	}
	public void insertAtBegining(int data ){
		Node newNode = new Node(data);
		if(last == null){
			last = newNode;
		}else{		
			newNode.next = last.next;
		}
		last.next = newNode;
		length++;
	}
	public void insertAtLast(int data){
		Node newNode = new Node(data);
		if(last == null){
			last = newNode;
		}else{
			newNode.next = last.next;
		}
		last.next = newNode; 
		last = last.next;
		length++;
	}
	public static void main(String[] args) {
		CircularSinglyLinkedList circular = new CircularSinglyLinkedList();
		//circular.circularList();
		//circular.showListNode();
		circular.insertAtLast(13);
		circular.insertAtLast(15);
		circular.showListNode();
		circular.insertAtBegining(21);
		circular.insertAtBegining(1);
		circular.showListNode();
		
		
		
	}

}

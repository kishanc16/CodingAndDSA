package com.datastructure.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

	private static Node head;
	private static Node tail; 
	private static int length;
	 static class Node{
		 Node prev;
		 Node next;
		 int data;
		 
		 Node(int data){
			 this.data = data;
		 }
	 }
	 public DoublyLinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	 public int length()
	 {
		 return length;
	 }
	 public boolean isEmpty(){
		 return length == 0;
	 }
	 public void insertAtLast(int data){
		 Node newNode = new Node(data);
		 if(isEmpty()){
			 head = newNode;
		 }else{
		 tail.next = newNode;
		 newNode.prev = tail;
		 }		 
		 tail = newNode;
		 length++;
		 
	 }
	 public void insertAtFirst(int data){
		 Node newNode = new Node(data);
		 
		 if(isEmpty()){
			 tail = newNode;
		 }else{
			 head.prev = newNode; 
		 }
		 newNode.next = head;
		 head = newNode;
		 length++;
	 }
	 public void displayForward(){
		 if(isEmpty())
			 return;
		 Node curr = head;
		 while(curr != null){
			 System.out.print(curr.data+"-->");
			 curr = curr.next;
		 }
		 System.out.println("null");		 
	 }
	 public void displayBackward(){
		 if(isEmpty())
			 return;
		 Node last = tail;
		 while(last != null){
			 System.out.print(last.data +"-->");
			 last = last.prev;
		 }
		 System.out.println("null");
	 }
	 public int deleteLast(){
		 if(isEmpty())
			 throw new NoSuchElementException("*** List is Empty ***");
		 Node temp = tail;
		 if(tail == head)
		 {
			 head = null;
		 }else{
			 tail.prev.next = null;
		 }
		 tail = tail.prev;
		 temp.prev = null;
		 length--;
		 return temp.data;
	 }
	 public int deleteFirst(){
		 if(isEmpty())
			 throw new NoSuchElementException("*** List is Empty ***");
		 Node temp = head;
		 if(head == tail){
			 tail = null;
		 }else{
			 head.next.prev = null;
		 }
		 head = head.next;
		 temp.next = null;
		 length--;
		 return temp.data;
	 }
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
//		list.insertAtLast(3);
//		list.insertAtLast(5);
//		list.insertAtLast(7);
		list.insertAtLast(9);
		list.insertAtLast(11);
		
		list.displayForward();
		list.displayBackward();
		
		System.out.println("Last Element : "+list.deleteLast());
		System.out.println("First Element : "+list.deleteFirst());
		list.insertAtFirst(21);
		list.insertAtFirst(22);
		list.displayForward();
		list.displayBackward();

	}

}

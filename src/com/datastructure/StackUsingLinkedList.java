package com.datastructure;

public class StackUsingLinkedList {
	
	private static Node top;
	private static int length;
	static class Node{
		private Node next;
		private int data;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public int length(){
		return length;
	}
	public boolean isEmpty(){
		return length == 0;
	}
	public void push(int data){
		Node newNode = new Node(data);				
		newNode.next = top;
		top = newNode;
		length++;	
	}
	public void displayNode(){
		if (top == null)
			return;
		Node curr  = top ;
		System.out.println("Top->");
		while(curr.next != null){
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.println(curr.data+"-->null");
	}
	public int pop(){
		int temp = top.data;
		top = top.next;
		length--;
		
		return temp;
	}

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
//		stack.push(8);
//		stack.push(5);
//		stack.push(3);
		
		
		stack.displayNode();
		System.out.println("Pop Element: "+stack.pop());
		stack.displayNode();
		
	}

}

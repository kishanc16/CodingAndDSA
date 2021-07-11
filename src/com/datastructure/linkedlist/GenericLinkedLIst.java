package com.datastructure.linkedlist;

public class GenericLinkedLIst<T> {
	
	private ListNode<T> head;
	public GenericLinkedLIst() {
		head = null;
	}
	private static class ListNode<T>{
		private T data;
		private ListNode<T> next;
		
		ListNode(T data){
			this.data = data;
			this.next = null;
		}
	}
	public void insertNodeAtLast(T data) {
		if(head == null){
			head = new ListNode<>(data);
		}else{
			ListNode<T> temp = new ListNode<>(data);
			ListNode<T> curr = head;
			while(curr.next != null)
				curr = curr.next;
			curr.next =  temp;
		}
	}
	public void insertNodeAtFirst(T data) {
		if(head == null){
			head = new ListNode<>(data);
		}else{
			ListNode<T> temp = new ListNode<>(data);
			temp.next = head;
			head = temp;
		}
	}
	
	public void displayNode() {
		if(head == null)
			return;
		ListNode<T> curr = head;
		while(curr.next != null){
			System.out.print(curr.data +"-->");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	public ListNode<T> reverseNode() {
		ListNode<T> curr = head;
		ListNode<T> prev = null;
		ListNode<T> currNext = null;
		while(curr != null){
			currNext = curr;
			curr = curr.next;
			currNext.next = prev;
			prev = currNext;
		}
		return prev;
	}
	private ListNode<T> findMiddleNode() {
		if(head == null)
			return null;
		ListNode<T> fast = head;
		ListNode<T> slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;			
		}
		return slow;
	}
	
	private ListNode<T> deleteNodeAtPosition(int position) {
		if(position == 1){
			ListNode<T> temp = head;
			head = temp.next;
			temp.next = null;
			return temp;
		}else{
		ListNode<T> prev = head; 
		int count = 1;
		while(count < position-1){
			prev = prev.next;
			count++;
		}
		ListNode<T> curr = prev.next;
		prev.next = curr.next;
		curr.next = null;
		return curr;
		}
	}
	private void sortedLinkedList() {
		if(head == null)
			return;
		ListNode<T> curr = head;
		
		while(curr != null){
			
			ListNode<T> second = curr.next;
			while(second != null)
			{
				if((int)curr.data > (int)second.data)
				{
					T temp = curr.data;
					curr.data = second.data;
					second.data = temp;
				}
				second = second.next;
			}
			curr = curr.next;
		}
		
	}
	private void createLoop() {
		ListNode<T> curr = head;
		ListNode<T>temp = head.next.next.next;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = temp;
	}
	private void findLoopAndRemove() {
		ListNode<T> fast = head;
		ListNode<T> slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				System.out.println("Find loop at Node : "+ slow.data);
				removeLoop(slow);
			}
		}
		
	}
	
	private void removeLoop(ListNode<T> slow) {
		ListNode<T> temp1 = head;
		ListNode<T> temp2 = null;
		while(true){
			temp2 = slow;
			while(temp2.next != slow && temp2.next !=temp1 ){
				temp2 = temp2.next;
			}
			if(temp2.next == temp1){
				break;
			}
			temp1 = temp1.next;
		}	
		temp2.next = null;
	}
	public static void main(String[] args) {
		GenericLinkedLIst<Integer> singlyLinkedList = new GenericLinkedLIst<>();
		singlyLinkedList.insertNodeAtLast(4);
		singlyLinkedList.insertNodeAtLast(5);
		singlyLinkedList.insertNodeAtLast(5);
		singlyLinkedList.insertNodeAtLast(8);
		singlyLinkedList.insertNodeAtLast(9);
		singlyLinkedList.insertNodeAtFirst(11);
		singlyLinkedList.insertNodeAtFirst(13);
		singlyLinkedList.displayNode();
		
		singlyLinkedList.createLoop();		
		singlyLinkedList.findLoopAndRemove();
		singlyLinkedList.displayNode();
		
		
//		ListNode<Integer> middleNode = singlyLinkedList.findMiddleNode();
//		System.out.println("Middle Element : "+middleNode.data);
//		
//		singlyLinkedList.sortedLinkedList();
//		singlyLinkedList.displayNode();
//		
//		ListNode<Integer> deletedNode = singlyLinkedList.deleteNodeAtPosition(1);
//		System.out.println("Deleted Element : "+deletedNode.data);
//		
//		ListNode<Integer> middleNode1 = singlyLinkedList.findMiddleNode();
//		System.out.println("Middle Element : "+middleNode1.data);
//		
//		singlyLinkedList.head = singlyLinkedList.reverseNode();
//		singlyLinkedList.displayNode();
		
		GenericLinkedLIst<Character> characterLinkedList = new GenericLinkedLIst<>();
		characterLinkedList.insertNodeAtLast('A');
		characterLinkedList.insertNodeAtLast('B');
		characterLinkedList.insertNodeAtLast('R');
		characterLinkedList.insertNodeAtLast('S');
		
		characterLinkedList.displayNode();
		characterLinkedList.head = characterLinkedList.reverseNode();
		characterLinkedList.displayNode();
 	}
	
	
}

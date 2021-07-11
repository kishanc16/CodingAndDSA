package com.datastructure.linkedlist;

public class LinkedList {
	
	private ListNode head;
	 
	private static class ListNode {
		private int data;
		private ListNode next;
 
		ListNode(int data) {
			this.data = data;
		}
	}
	public void insertElement(int data)
	{
		ListNode temp = new ListNode(data);
		ListNode curr = head;
		if(curr == null)
		{
			head = temp;
		}else{
			while(curr.next !=  null)
			{
				curr = curr.next;
			}
			curr.next = temp;
			}
	}
	public void display(ListNode head)
	{
		ListNode temp = head;
		if(head == null)
			return;
		while(temp.next != null)
		{
			System.out.print(temp.data+"--> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	public void reverseListRecursion(ListNode head,ListNode t){
		
		if(head != null){
			reverseListRecursion(head.next,head);
			head.next = t;
			return;
		}else{
			this.head = t;
			return;
		}
	}
	public void reverseListIterate(ListNode head)
	{
		if (head == null) return;
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode currNext =null;
		while (curr != null)
		{
			currNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = currNext;			
		}
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertElement(3);
		list.insertElement(5);
		list.insertElement(9);
		list.insertElement(2);
		list.display(list.head);
		list.reverseListRecursion(list.head,null);
		list.display(list.head);
		list.reverseListIterate(list.head);
		list.display(list.head);
		
	}

}

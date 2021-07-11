package com.datastructure.linkedlist;

import java.util.*;

class FirstUnique {

	static class ListNode {
		private int data;
		ListNode next;
		ListNode prev;

		ListNode() {

		}
	}

	Map<Integer, ListNode> map;
	ListNode head;
	ListNode tail;

	public void addNode(ListNode node) {
		if (head.next == tail) {
			head.next = node;
			tail.prev = node;
			node.next = tail;
			node.prev = head;
		} else {
			ListNode tailPrev = tail.prev;
			tail.prev = node;
			tailPrev.next = node;
			node.prev = tailPrev;
			node.next = tail;
		}

	}

	public void removeNode(ListNode node) {
		//System.out.println("remove called "+ node.data );
		ListNode next = node.next;
		ListNode prev = node.prev;
		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;
	}

	public FirstUnique(int[] nums) {
		map = new HashMap<Integer, ListNode>();
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.prev = head;
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
	}

	public int showFirstUnique() {
		if(head.next==tail){
            return -1;
        }else{
            return head.next.data;
        }
	}

	public void add(int value) {

		if (map.containsKey(value)) {
			ListNode node = map.get(value);
			if(node != null){
				map.put(value, null);
				removeNode(node);
			}

		} else {
			ListNode newNode = new ListNode();
			newNode.data = value;
			map.put(value, newNode);
			addNode(newNode);
		}
	}

	public static void main(String ar[]) {
		int nums[] = {7,7,7 };
		FirstUnique obj = new FirstUnique(nums);
		int param1 = obj.showFirstUnique();
		System.out.println(param1);
		obj.add(7);
		
		System.out.println(obj.showFirstUnique());
		obj.add(3);
		obj.add(3);
		obj.add(7);
		System.out.println(obj.showFirstUnique());
		obj.add(5);
		System.out.println(obj.showFirstUnique());		
		
	}
}

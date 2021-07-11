package com.datastructure.linkedlist;
import java.util.*;

class LRUCache {
	
	static class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    final Node head = new Node();
    final Node tail = new Node();
    private int capacity;
    private Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodeMap.get(key) != null) {
            Node node = nodeMap.get(key);
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node();
            node.key = key; node.val = value;
            nodeMap.put(key, node);
            add(node);
        }
    }
    
    public void add(Node node) {
        if (head.next == tail) {
            head.next = node;
            tail.prev = node;
            node.next = tail;
            node.prev = head;
        } else {
            Node headNext = head.next;
            head.next = node;
            headNext.prev = node;
            node.prev = head;
            node.next = headNext;
        }
    }
    
    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    public static void main(String ar[])
    {
    	LRUCache cache  = new LRUCache(2);
    	cache.put(3, 8);
    	cache.put(2, 2);
    	System.out.println(cache.get(3));
    	cache.put(7, 5);
    	System.out.println(cache.get(3));
    	
    }
}

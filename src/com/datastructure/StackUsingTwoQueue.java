package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
	Queue<Integer> queue1;
	Queue<Integer> queue2;
	public StackUsingTwoQueue() {
		queue1 = new LinkedList<>();
		queue2 = new LinkedList<>();
	}
	public void push(int i){
		if(queue1.size()==0)
			queue1.add(i);
		else{
			int sizeOfQueue1 = queue1.size();
			
			for(int j=0 ; j<sizeOfQueue1 ; j++)
				queue2.add(queue1.remove());
			
			queue1.add(i);
			
			for(int k=0 ; k<sizeOfQueue1 ; k++)
				queue1.add(queue2.remove());
		}
	}
 
	public int pop(){
		if(queue1.size()==0){
			System.out.println("Empty");
		}
		return queue1.remove();
	}

	public static void main(String[] args) {
		
		StackUsingTwoQueue stack = new StackUsingTwoQueue();
		stack.push(3);
		stack.push(7);
		stack.push(9);
		stack.push(70);
		stack.push(50);
		stack.push(90);
		stack.push(110);
		System.out.println(stack.queue1);
		System.out.println(stack.queue2);
		System.out.println(stack.pop());
		
	}

}
 
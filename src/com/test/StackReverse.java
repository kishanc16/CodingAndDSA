package com.test;

import java.util.Stack;

public class StackReverse {
	
	static Stack<Integer> stack;
	
	StackReverse()
	{
		stack  = new Stack<>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackReverse st = new StackReverse();
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(9);
		stack.push(11);
		
		System.out.println(stack);
		st.reverseStack();
		System.out.println(stack);
		
	}
	private void reverseStack() {
		// TODO Auto-generated method stub
	
		if(stack.size()>  0)
		{
			int x = stack.peek();
			stack.pop();
			
			reverseStack();
			
			pushToBottom(x);
			System.out.println(x);	
		}
	}
	private void pushToBottom(int x) {
		// TODO Auto-generated method stub
		if(stack.size() == 0){
			stack.push(x);
		}else{
			int y = stack.pop();
			pushToBottom(x);
			
			stack.push(y);
		}
	}
}

package com.datastructure;

import java.util.Stack;

public class TestCase {
	private static TreeNode root;
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
		}
	}
	public TestCase() {
		root = null;
	}
	public void createTree(){
		root = new TreeNode(9);
		TreeNode first = new TreeNode(5);
		TreeNode second = new TreeNode(8);
		TreeNode third = new TreeNode(6);
		TreeNode fourth = new TreeNode(11);
		TreeNode fifth = new TreeNode(13);
		
		root.left = first;
		root.right = fourth;
		first.left = third;
		first.right = second;
		fourth.right = fifth;
	}
	public void inOrderRecursive(TreeNode root){
		if(root == null)
			return ;
		inOrderRecursive(root.left);
		System.out.print(root.data+" ");
		inOrderRecursive(root.right);
	}
	public void inOrderIterative(TreeNode root){
		if(root == null)
			return;
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || temp != null){
			if(temp != null){
				stack.push(temp);
				temp = temp.left;
			}else{
				temp = stack.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
	}
	public void preOrderRecursive(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		
	}
	public void preOrderIterative(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.print(temp.data+" ");				
			
			if(temp.right != null){
				stack.push(temp.right);
			}
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	public void postOrderRecursive(TreeNode root){
		if(root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data+" ");
		 
	}
	public void postOrderIterative(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		Stack<Integer> st = new Stack<>();
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			st.push(temp.data);				
			
			if(temp.left != null){
				stack.push(temp.left);
			}
			if(temp.right != null)
				stack.push(temp.right);
		}
		
		while(!st.isEmpty()){
			System.out.print(st.pop()+" ");
		}
		
	}
	public boolean isBST(TreeNode root,TreeNode left,TreeNode right){
		if(root == null)
			return true;
		
		if(left != null && root.data <= left.data)
			return false;
		
		if(right != null && root.data >= right.data)
			return false;
		
		return (isBST(root.left,left,root) && isBST(root.right,root,right));
	}
	public static void main(String[] args) {
		TestCase tree = new TestCase();
		tree.createTree();
		
		tree.inOrderRecursive(root);
		System.out.println();
		tree.inOrderIterative(root);
//		tree.preOrderRecursive(root);
//		System.out.println();
//		tree.preOrderIterative(root);
//		tree.postOrderRecursive(root);
//		System.out.println();
//		tree.postOrderIterative(root);
		System.out.println(tree.isBST(root,null,null));

	}

}

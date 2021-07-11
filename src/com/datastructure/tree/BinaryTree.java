package com.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	TreeNode root=null;
	static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data)
		{
			this.data = data;
		}
	}
	public void createBinaryTree()
	{
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left  = sixth;
		third.right = seventh;
	}
	
	public void preOrderRecursive(TreeNode root)
	{
		//root->left->right
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	public void preOrderIterative(TreeNode root)
	{
		//root->left->right
		if(root == null)
		{
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode temp = stack.pop();
			System.out.print(temp.data+" ");
			if(temp.right != null)
			{
				stack.push(temp.right);
			}
			if(temp.left != null)
			{
				stack.push(temp.left);
			}
		}
	}
	public void inOrderRecursive(TreeNode root)
	{
		//left->root->right
		if(root == null)
			return ;
		inOrderRecursive(root.left);
		System.out.print(root.data+ " ");
		inOrderRecursive(root.right);
	}
	public void inOrderIterative(TreeNode root)
	{
		//left->root->right
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while(!stack.isEmpty() || temp != null)
		{
			if(temp != null)
			{
				stack.push(temp);
				temp = temp.left;
			}else{
				temp = stack.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
	}
	public void postOrderRecursive(TreeNode root)
	{
		//left->right->root
		if(root  == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data+" ");
	}
	public void postOrderIterative(TreeNode root)
	{
		if(root  == null)
			return;
		  Stack<TreeNode> stack = new Stack<>();
		  stack.push(root);
		  TreeNode temp = root;
		  Stack<Integer> st = new Stack<>();
		  while(!stack.isEmpty())
		  {
			  temp = stack.pop();
			  st.push(temp.data);
			   if(temp.left != null)
			    {
				  stack.push(temp.left);
				}
			   if(temp.right != null)
				  {
					  stack.push(temp.right);
				  }
				  
		 }
		  while(!st.isEmpty())
		  {
			  System.out.print(st.pop()+" ");
		  }
	 }
	public void levelOrderTraversal(TreeNode root)
	{
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
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
		
		BinaryTree bt  = new BinaryTree();
		bt.createBinaryTree();
		System.out.println("Recursive preOrder: ");
		bt.preOrderRecursive(bt.root);
		System.out.println("\nIterative preOrder: ");
		bt.preOrderIterative(bt.root);
		System.out.println("\nRecursive inOrder: ");
		bt.inOrderRecursive(bt.root);
		System.out.println("\nIterative inOrder: ");
		bt.inOrderIterative(bt.root);
		System.out.println("\nRecursive postOrder: ");
		bt.postOrderRecursive(bt.root);
		System.out.println("\nIterative postOrder: ");
		bt.postOrderIterative(bt.root);
		System.out.println("\nLevel Order Traversal: ");
		bt.levelOrderTraversal(bt.root);
		
		System.out.println("Is Tree BST : "+ bt.isBST(bt.root, null, null));
		}
}
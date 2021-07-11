package com.datastructure.tree;
import java.util.*;

import com.datastructure.tree.BinaryTree.TreeNode;

public class ListFromRootToLeef {
	BinaryTree.TreeNode root;
	static List<List<Integer>> result = new ArrayList<>();
	
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
	public void inOrderRecursive(TreeNode root){
		//left->root->right
		if(root == null)
			return ;
		inOrderRecursive(root.left);
		System.out.print(root.data+ " ");
		inOrderRecursive(root.right);
	}
	private static List<List<Integer>> findRootToLeaf(TreeNode root, List<Integer> list) {

		if(root.left == null && root.right == null){
			result.add(list);
		}
		
		list.add(root.data);
		if(root.left != null)
			findRootToLeaf(root.left,new ArrayList<>(list));
		
		if(root.right != null)
			findRootToLeaf(root.right,new ArrayList<>(list));
		
		return result;
	}

	public static void main(String[] args) {
		ListFromRootToLeef tree = new ListFromRootToLeef();
		tree.createBinaryTree();
		//tree.inOrderRecursive(tree.root);
				
		List<List<Integer>> result = findRootToLeaf(tree.root,new ArrayList<>());
		System.out.println(result);
	}
	
	
}

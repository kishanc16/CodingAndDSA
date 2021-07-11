package com.datastructure.tree;
import java.util.*;

import com.datastructure.tree.BinaryTree.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree bt  = new BinaryTree();
		bt.createBinaryTree();
		List<List<Integer>> list = levelOrder(bt.root);
		List<Double> averageList = AverageInLevelInBT(bt.root);
		System.out.println(list);
		System.out.println(averageList);
	}

	private static List<Double> AverageInLevelInBT(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			double sum = 0;
			for(int i=0; i<size; i++){
				TreeNode tmp = queue.poll();
				sum +=tmp.data;
				if(tmp.left != null)
					queue.add(tmp.left);
				if(tmp.right != null)
					queue.add(tmp.right);
			}
			result.add((sum/size));
		}
		
		return result;
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer>list = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode tmp = queue.poll();
				list.add(tmp.data);
				if(tmp.left != null)
					queue.add(tmp.left);
				if(tmp.right != null)
					queue.add(tmp.right);
			}
			result.add(list);
		}
		return result;
	}

}

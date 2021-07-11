package com.dynamicprogramming;

import java.util.*;

public class MergeInterval {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(5);
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<>();
		l4.add(9);
		l4.add(10);
		ArrayList<Integer> l5 = new ArrayList<>();
		l5.add(12);
		l5.add(16);

		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);

		ArrayList<Integer> result = new ArrayList<>();
		result.add(3);
		result.add(6);
		System.out.println(list);
		list = mergeInterval(list, result);
		System.out.println(list);

	}

	private static ArrayList<ArrayList<Integer>> mergeInterval(ArrayList<ArrayList<Integer>> list,
			ArrayList<Integer> result) {
		ArrayList<Integer> newList = new ArrayList<>();
		ArrayList<Integer> newList1 = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i).get(0));
			newList.add(list.get(i).get(1));
		}

		int first = 0;
		boolean flag = true;

		for (int i = 0; i < newList.size(); i++) {
			if (newList.get(i) < result.get(0) || newList.get(i) > result.get(1)) {
				newList1.add(newList.get(i));
			} else {
				if (flag)
					first = i;
				flag = false;
			}
		}

		if (newList1.size() % 2 != 0)
			newList1.add(first, result.get(1));
		list.clear();
		for (int i = 0; i < newList1.size(); i += 2) {
			ArrayList<Integer> l1 = new ArrayList<>();
			l1.add(newList1.get(i));
			l1.add(newList1.get(i + 1));
			list.add(l1);
		}

		return list;
	}

}

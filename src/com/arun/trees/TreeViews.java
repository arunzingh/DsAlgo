package com.arun.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeViews {
	
	void printSpiral(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.add(root);
		
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				TreeNode n = s1.pop();
				System.out.print(n.data + " ");
				if (n.right != null) s2.add(n.right);
				if (n.left != null) s2.add(n.left);
				
			}
			
			while (!s2.isEmpty()) {
				TreeNode n = s2.pop();
				System.out.print(n.data + " ");
				if (n.left != null) s1.add(n.left);
				if (n.right != null) s1.add(n.right);
				
			}
		}
	}
	
	void leftView(TreeNode root) {
		int[] maxLevel = {0};
		leftViewUtil(root, 1, maxLevel);
	}
	
	void leftViewUtil(TreeNode root, int level, int[] maxLevel) {
		
		if (root == null) return;
		
		if (maxLevel[0] < level) {
			System.out.print(root.data + " ");
			maxLevel[0] = level;
		}
		
		leftViewUtil(root.left, level + 1, maxLevel);
		leftViewUtil(root.right, level + 1, maxLevel);

	}
	
	
//	void bottomView(TreeNode root) {
//		Queue<TreeNode> q = new ConcurrentLinkedQueue<TreeNode>();
//		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//		root.hd = 0;
//		q.add(root);
//		
//		while (!q.isEmpty()) {
//			TreeNode n = q.poll();
//			map.put(n.hd, n.data);
//			
//			if (n.left != null) {
//				n.left.hd = n.hd - 1;
//				q.add(n.left);
//			}
//			
//			if (n.right != null) {
//				n.right.hd = n.hd + 1;
//				q.add(n.right);
//			}
//		}
//		
//		Set<Entry<Integer, Integer>> keyset = map.entrySet();
//		Iterator<Entry<Integer, Integer>> it = keyset.iterator();
//		
//		while (it.hasNext()) {
//			Entry<Integer, Integer> data = it.next();
//			System.out.print(data.getValue() + " ");
//		}
//		
//	}
	
	// Arun
	void bottomView(TreeNode root) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		bottomViewUtil(root, 0, map);
		
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			System.out.print(entry.getValue() + " ");
		}
	}
	
	void bottomViewUtil(TreeNode root, int hd, Map<Integer, Integer> map) {
		if (root == null) return;
		
		map.put(hd, root.data);
		
		bottomViewUtil(root.left, hd - 1, map);
		bottomViewUtil(root.right, hd + 1, map);
	}
	
	void topView(TreeNode root) {
		Queue<TreeNode> q = new ConcurrentLinkedQueue<TreeNode>();
		
		int hd = 0;
		root.hd = hd;
		q.add(root);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		while (!q.isEmpty()) {
			
			TreeNode n = q.poll();
			
			if (!map.containsKey(n.hd)) {
				map.put(n.hd, n.data);
				System.out.print(n.data +  " ");
			}
			
			if (n.left != null) {
				n.left.hd = n.hd-1;
				q.add(n.left);
			}
			
			if (n.right != null) {
				n.right.hd = n.hd+1;
				q.add(n.right);
			}
		}
		
	}
	// This is incorrect
	// top view has to be level order traversal
	
	void topView1(TreeNode root) {
		if (root == null) return;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		topViewUtil(root, map, 0);
		
		Iterator<Integer> iterator = map.keySet().iterator();
		
		while (iterator.hasNext()) {
			int key = iterator.next();
			System.out.print(map.get(key) + " ");
		}
	}
	
	
	
	private void topViewUtil(TreeNode root, Map<Integer, Integer> map, int hd) {
		if (root == null) return;
		
		if (!map.containsKey(hd)) {
			map.put(hd, root.data);
		}

		topViewUtil(root.left, map, hd-1);
		topViewUtil(root.right, map, hd+1);
		

	}

	int getLeftLeavesSum(TreeNode root) {
		int[] sum = {0};
		
		getLeftLeavesSumUtil(root, sum);
		
		return sum[0];
	}
	
	void getLeftLeavesSumUtil(TreeNode root, int[] sum) {
		if (root == null) return;
		
		if (isLeaf(root.left)) {
				sum[0] += root.left.data;
		}
		getLeftLeavesSumUtil(root.left, sum);
		getLeftLeavesSumUtil(root.right, sum);
	}
	
	
	boolean isLeaf(TreeNode node) {
		if (node == null) return false;
		
		if (node.left == null && node.right == null)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);

		TreeNode c3 = new TreeNode(5);
		c3.left = new TreeNode(7);
		c3.right = new TreeNode(8);

		c1.left = new TreeNode(4);
		c1.right = c3;

		root.left = c1;
		root.right = c2;

		c2.right = new TreeNode(6);

		TreeNode n1 = new TreeNode(9);
		n1.left = new TreeNode(10);
		n1.right = new TreeNode(11);
		n1.left.left = new TreeNode(12);
		n1.left.right = new TreeNode(13);

		c2.right.right = n1;
		
		BTreePrinter.printNode(root);
		
		TreeViews views = new TreeViews();
		System.out.println("TopView");
		views.topView(root);
		
		System.out.println("TopView-arun");
		views.topView1(root);
		
//		System.out.println("BottomView");
//		views.bottomView(root);
		
		System.out.println("BottomView-arun");
		views.bottomView(root);
		
		System.out.println("LeftView");
		views.leftView(root);
		
		System.out.println("Spiral");
		views.printSpiral(root);
		
		System.out.println("leftLeaves=" + views.getLeftLeavesSum(root));
	}
}

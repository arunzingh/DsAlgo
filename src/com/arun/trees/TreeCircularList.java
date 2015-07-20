package com.arun.trees;


public class TreeCircularList {
	
	
	TreeNode convertToList(TreeNode root) {
		
		if (root == null) return null;
//		System.out.println("root = " + root.data);
		TreeNode leftList = convertToList(root.left);
		TreeNode rightList = convertToList(root.right);
		
		root.left = root;
		root.right = root;
		System.out.println("root = " + root.data );
		leftList = append(leftList, root);
		leftList = append(leftList, rightList);
		
		return leftList;
	}
	
	TreeNode append(TreeNode a, TreeNode b) {
		 if (a != null) {
			 System.out.println("a = " + a.data);
		 } else {
			 System.out.println("a is null");
		 }
		 
		 if (b != null) {
			 System.out.println("b = " + b.data);
		 } else {
			 System.out.println("b is null");
		 }

		if (a == null) return b;
		if (b == null) return a;
		
		System.out.println("appending " + a.data + " with " + b.data);
		
		TreeNode aLast = a.left;
		TreeNode bLast = b.left;
		
		join(aLast, b);
		join(bLast, a);
		
		return a;
	}
	
	void join(TreeNode a, TreeNode b){
		System.out.println("joining " + a.data + " with " + b.data);
		a.right = b;
		b.left = a;
	}
	
	
	int getLeafNodesCount(TreeNode root) {
		if (root == null) return 0;
		
		if (root.left == null && root.right == null) return 1;
		
		return getLeafNodesCount(root.left) + getLeafNodesCount(root.right);
		
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		
		TreeCircularList list = new TreeCircularList();
		
//		TreeNode result = list.convertToList(root);
//		printList(result);
		
		System.out.println(list.getLeafNodesCount(root));
	}
	
	public static void printList(TreeNode head) {
		TreeNode curr = head;
		while (curr != null) {
			System.out.print(curr.data);
			curr = curr.right;
			if (curr != null)
				System.out.print(" -> ");
			
			if (curr == head) break;
		}
		System.out.println("");
	}
	
}

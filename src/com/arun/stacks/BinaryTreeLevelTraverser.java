package com.arun.stacks;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.arun.trees.TreeNode;

public class BinaryTreeLevelTraverser {
	
	Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
	int count = 0;
	void doLevelTraversing(TreeNode head) {
		queue.add(head);
		
		count = queue.size();
		while (!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
			System.out.print(node.data + " ");

			if (--count == 0) {
				System.out.println("");
				count = queue.size();
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode n314 = new TreeNode(314);
		TreeNode n6 = new TreeNode(6);
		TreeNode n271 = new TreeNode(271);
		TreeNode n28 = new TreeNode(28);
		TreeNode n0 = new TreeNode(0);
		TreeNode n561 = new TreeNode(561);
		TreeNode n3 = new TreeNode(3);
		TreeNode n17 = new TreeNode(17);
		TreeNode n6a = new TreeNode(6);
		TreeNode n2 = new TreeNode(2);
		TreeNode n271a = new TreeNode(271);
		TreeNode n28a = new TreeNode(28);
		TreeNode n1 = new TreeNode(1);
		TreeNode n257 = new TreeNode(257);
		TreeNode n401 = new TreeNode(401);
		TreeNode n641 = new TreeNode(641);
		
		n314.left = n6;
		n314.right = n6a;
		n6.left = n271;
		n6.right = n561;
		n271.left = n28;
		n271.right = n0;
		n561.right = n3;
		n3.left = n17;
		n6a.left = n2;
		n6a.right = n271a;
		n2.right = n1;
		n271a.right = n28a;
		n1.left = n401;
		n1.right = n257;
		n401.right = n641;
		
		new BinaryTreeLevelTraverser().doLevelTraversing(n314);
	}
}

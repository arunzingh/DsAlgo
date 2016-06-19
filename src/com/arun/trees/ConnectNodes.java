package com.arun.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodes {
	private static void linkNodesAtSameLevelWithExtraSpace(TreeNode rootNode) {
		if (rootNode == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode); // Adding Level 1 in Queue
		queue.add(null);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node != null) {
				node.next = queue.peek(); // setting nextRight to head of Queue.

				if (node.left != null) // adding entries in Queue for Next Level
					queue.add(node.left);

				if (node.right != null) // adding entries in Queue for Next
										
					queue.add(node.right);

			} else {

				// checking if queue head is null, if it is null then this is
				// end of all levels
				// and if queue head is not null then this is end of level and
				// adding null to indicate end of level.
				if (queue.peek() != null)
					queue.add(null);
			}
		}
	}
}

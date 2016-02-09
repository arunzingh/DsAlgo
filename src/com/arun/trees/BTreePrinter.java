package com.arun.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

	public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
		int maxLevel = BTreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(
			List<TreeNode<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
		for (TreeNode<T> node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i
							+ 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(node.left),
				BTreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode<Integer>(1);

		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);

		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.right = new TreeNode<Integer>(7);

		root.left.left.left = new TreeNode<Integer>(8);
		root.left.left.right = new TreeNode<Integer>(9);
		root.left.right.left = new TreeNode<Integer>(10);
		root.left.right.right = new TreeNode<Integer>(11);
		root.right.left.left = new TreeNode<Integer>(12);
		root.right.left.right = new TreeNode<Integer>(13);
		root.right.right.left = new TreeNode<Integer>(14);
		root.right.right.right = new TreeNode<Integer>(15);

		root.left.left.left.left = new TreeNode<Integer>(16);
		root.left.left.left.right = new TreeNode<Integer>(17);
		root.left.left.right.left = new TreeNode<Integer>(18);
		root.left.left.right.right = new TreeNode<Integer>(19);
		root.left.right.left.left = new TreeNode<Integer>(20);
		root.left.right.left.right = new TreeNode<Integer>(21);
		root.left.right.right.left = new TreeNode<Integer>(22);
		root.left.right.right.right = new TreeNode<Integer>(23);
		root.right.left.left.left = new TreeNode<Integer>(24);
		root.right.left.left.right = new TreeNode<Integer>(25);
		root.right.left.right.left = new TreeNode<Integer>(26);
		root.right.left.right.right = new TreeNode<Integer>(27);
		root.right.right.left.left = new TreeNode<Integer>(28);
		root.right.right.left.right = new TreeNode<Integer>(29);
		root.right.right.right.left = new TreeNode<Integer>(30);
		root.right.right.right.right = new TreeNode<Integer>(31);
		
		printNode(root);
	}

}
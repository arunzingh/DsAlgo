package com.arun.trees;

public class LowestCommonAncestor {
	
	TreeNode findLca(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) return null;
		
		if (root == n1 || root == n2) {
			return root;
		} 
		
		TreeNode leftLca = findLca(root.left, n1, n2);
		TreeNode rightLca = findLca(root.right, n1, n2);
		
		if (leftLca != null && rightLca != null) {
			return root;
		}
		
		return leftLca != null ? leftLca : rightLca;
	}
	
	boolean findNode(TreeNode root, TreeNode n) {
		if (root == null) return false;
		
		if (root == n || findNode(root.left, n) || findNode(root.right, n))
			return true;
		
		return false;
	}
	
	TreeNode findLca1(TreeNode root, TreeNode n1, TreeNode n2) {
		boolean[] found = {false, false};
		
		TreeNode result = findLcaUtil(root, n1, n2, found);
		
		if ((found[0] && found[1])
				|| (found[0] && findNode(result, n2))
				||  (found[1] && findNode(result, n1)))
			return result;
		
		return null;
		
	}
	
	TreeNode findLcaUtil(TreeNode root, TreeNode n1, TreeNode n2, boolean[] found) {
		
		if (root == null) return null;
		if (root == n1) {
			found[0] = true;
			return root;
		} else if (root == n2) {
			found[1] = true;
			return root;
		}
		
		TreeNode leftLca = findLcaUtil(root.left, n1, n2, found);
		TreeNode rightLca = findLcaUtil(root.right, n1, n2, found);
		
		if (leftLca != null && rightLca != null) {
			found[0] = true;
			found[1] = true;
			return root;
		}
		
		
		return leftLca != null ? leftLca : rightLca;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		root.left = c1;
		root.right = c2;
		c1.left = new TreeNode(4);
		c1.right = new TreeNode(5);
		c2.left = new TreeNode(6);
		c2.right = new TreeNode(7);
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		System.out.println(lca.findLca1(root, c1.left, c1.right).data);
		System.out.println(lca.findLca1(root, c1.left, c2.left).data);
		System.out.println(lca.findLca1(root, c2, c1.left).data);
		System.out.println(lca.findLca1(root, c1, c1.left).data);
		System.out.println(lca.findLca1(root, c1, new TreeNode(11)).data);

	}
}

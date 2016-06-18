package com.arun.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoComplete {
	
	// Ternarary 
	TstNode root;

	public void add(List<String> listWords) {
		for (String w : listWords) {
			root = addUtil(root, w, 0);
		}
	}

	private TstNode addUtil(TstNode root, String w, int index) {
		char c = w.charAt(index);

		if (root == null) {
			root = new TstNode(c);
		}

		if (c < root.c) {
			root.left = addUtil(root.left, w, index);
		} else if (c > root.c) {
			root.right = addUtil(root.right, w, index);
		} else if (index < w.length()-1) {
			root.middle = addUtil(root.middle, w, index + 1);
		} else {
			root.isEnd = true;
		}
		return root;
	}
	
	private List<String> getSuggestionWords(TstNode root, String w, int index) {
		
		List<String> listSuggestions = new ArrayList<String>();
		
		TstNode n = getNode(root, w, index);
		
		getNextWordListUtil(n.middle, w, listSuggestions);
		
		return listSuggestions;
		
	}

	private void getNextWordListUtil(TstNode n, String prefix, List<String> listSuggestions) {
		if (n == null) return;
		
		if (n.isEnd) {
			listSuggestions.add(prefix + n.c);
		}
		
		getNextWordListUtil(n.left, prefix, listSuggestions);
		getNextWordListUtil(n.right, prefix, listSuggestions);
		getNextWordListUtil(n.middle, prefix + n.c, listSuggestions);
	}

	private TstNode getNode(TstNode root, String w, int index) {
		if (root == null)
			return null;

		char c = w.charAt(index);

		if (c < root.c) {
			return getNode(root.left, w, index);
		} else if (c > root.c) {
			return getNode(root.right, w, index);
		} else if (index < w.length()-1) {
			return getNode(root.middle, w, index + 1);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		List<String> dict = Arrays.asList(new String[] { "the", "a", "there",
				"answer", "any", "by", "bye", "their" });
		AutoComplete ac = new AutoComplete();

		ac.add(dict);
		
		TstNode n = ac.getNode(ac.root, "the", 0);
		boolean res = n == null ? false : true;
		System.out.println("the is present in tst: " + res);
		
		n = ac.getNode(ac.root, "these", 0);
		res = n == null ? false : true;
		System.out.println("these is present in tst: " + res);
		
		n = ac.getNode(ac.root, "their", 0);
		res = n == null ? false : true;
		System.out.println("their is present in tst: " + res);
		
		n = ac.getNode(ac.root, "thaw", 0);
		res = n == null ? false : true;
		System.out.println("thaw is present in tst: " + res);
		
		List<String> resList = ac.getSuggestionWords(ac.root, "b", 0);
		System.out.println(resList.toString());
	}
}

class TstNode {

	char c;
	boolean isEnd = false;

	TstNode left;
	TstNode middle;
	TstNode right;

	public TstNode(char ch) {
		this.c = ch;
	}
}
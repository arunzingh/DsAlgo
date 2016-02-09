package com.arun.strings;
 
public class SubstringSearch {
 
	public void doBoyerMooreSearch(String pattern, String text) {
 
		int M = pattern.length();
		int N = text.length();
 
		char[] arrPat = pattern.toCharArray();
		char[] arrText = text.toCharArray();
 
		int[] badchar = badCharHeuristic(arrPat);
 
		int s = 0; // s is shift of the pattern with respect to text
 
		while (s <= (N - M)) {
 
			// start checking from the right most of pattern
			int j = M - 1;
 
			// Keep reducing index j of pattern while characters of pattern and
			// text are matching at this shift s
			while (j >= 0 && arrPat[j] == arrText[s + j])
				j--;
 
			// If the pattern is present at current shift, then index j
			// will become -1 after the above loop
 
			if (j < 0) {
				// match
				System.out.println("pattern occurs at index " + s);
 
				// Shift the pattern so that the next character in text
				// aligns with the last occurrence of it in pattern.
				// The condition s+m < n is necessary for the case when
				// pattern occurs at the end of text
				s += (s + M < N) ? M - badchar[arrText[s + M]] : 1;
 
			} else {
 
				// Shift the pattern so that the bad character in text
				// aligns with the last occurrence of it in pattern. The
				// max function is used to make sure that we get a positive
				// shift. We may get a negative shift if the last occurrence
				// of bad character in pattern is on the right side of the
				// current character.
				s += Math.max(1, j - badchar[arrText[s + j]]);
			}
 
		}
	}
 
	private int[] badCharHeuristic(char[] arrPat) {
 
		int[] badchar = new int[256];
 
		// Initialize all occurrences as -1
		for (int i = 0; i < badchar.length; i++) {
			badchar[i] = -1;
		}
 
		// Fill the actual value of last occurrence of a character
		for (int i = 0; i < arrPat.length; i++) {
			badchar[arrPat[i]] = i;
		}
 
		return badchar;
	}
 
	public void doRabinKarpSearch(String pattern, String text) {
		final int PRIME = 101;
 
		char[] arrPat = pattern.toCharArray();
		char[] arrText = text.toCharArray();
 
		int M = arrPat.length;
		int N = arrText.length;
		long hashPat = 0;
		long currHash = 0;
 
		for (int i = 0; i < M; i++) {
			hashPat += arrPat[i] * Math.pow(PRIME, i);
			currHash += arrText[i] * Math.pow(PRIME, i);
		}
 
		int start = 0;
 
		for (int i = 1; i <= N - M; i++) {
 
			if (hashPat == currHash) {
				for (int j = 0; j < M; j++) {
					if (arrText[i + j - 1] != arrPat[j])
						break;
					if (j == M - 1) {
						System.out.println("Pattern found at index " + (i - 1));
					}
				}
			}
 
			currHash -= arrText[start];
			start++;
			currHash /= PRIME;
			currHash += arrText[i + M - 1] * Math.pow(PRIME, M - 1);
		}
 
	}
 
	public void doKmpSearch(String pattern, String text) {
		int[] lps = computeLps(pattern);
		char[] arrText = text.toCharArray();
		char[] arrPat = pattern.toCharArray();
 
		// pointer for pattern array
		int j = 0;
 
		// pointer for text array
		int i = 0;
 
		while (i < text.length()) {
			if (arrText[i] == arrPat[j]) {
				i++;
				j++;
				if (j == pattern.length()) {
					System.out.println("Found pattern at index " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}
 
	/**
	 * lps indicates longest proper prefix which is also suffix.
	 * 
	 * @param pattern
	 * @return
	 */
	public int[] computeLps(String pattern) {
 
		int[] lps = new int[pattern.length()];
		char[] arrPattern = pattern.toCharArray();
 
		lps[0] = 0;
 
		int i = 1;
		int j = 0;
 
		while (i < pattern.length()) {
			if (arrPattern[i] == arrPattern[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					j = 0;
					i++;
				}
			}
		}
		return lps;
	}
 
	public static void main(String[] args) {
		String pattern = "abcdabca";
		String pattern1 = "acacabacacabacacac";
 
		SubstringSearch s = new SubstringSearch();
		// int[] lps = s.computeLps(pattern);
		// System.out.println(Arrays.toString(lps));
		// System.out.println("#1");
		// s.doKmpSearch("ABABCABAB", "ABABDABACDABABCABAB");
		// System.out.println("#2");
		// s.doKmpSearch("TEST", "THIS IS A TEST TEXT");
		// System.out.println("#3");
		// s.doKmpSearch("AABA", "AABAACAADAABAAABAA");
 
		// s.doRabinKarpSearch("GEEK", "GEEKS FOR GEEKS");
 
		s.doBoyerMooreSearch("GEEK", "GEEKS FOR GEEKS");
 
	}
}
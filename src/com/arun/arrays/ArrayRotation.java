package com.arun.arrays;

import java.util.Arrays;

public class ArrayRotation {

	void rotate(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			rotateByOne(a);
		}
	}

	void rotateByOne(int[] a) {
		int temp = a[a.length - 1];

		for (int i = a.length - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = temp;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		new ArrayRotation().rotate(a, 2);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void rotateLeftByBlockSwap(int[] arr, int d) {
		rotateLeftByBlockSwapUtil(arr, 0, arr.length, d, arr.length - d);
	}

	public static void rotateLeftByBlockSwapUtil(int[] arr, int start, int end, int m, int n) {
		System.out.println(Arrays.toString(arr) + " #" + start + " #" + end
				+ " #" + m + " #" + n);

		if (m == n) {
			blockSwap(arr, start, end - m, n);
			return;
		}
		if (m < n) {
			blockSwap(arr, start, end - m, m);
			rotateLeftByBlockSwapUtil(arr, start, end - m, m, n - m);
		} else {
			blockSwap(arr, start, end - n, n);
			rotateLeftByBlockSwapUtil(arr, start + n, end, m - n, n);
		}
	}

	private static void blockSwap(int[] arr, int l, int r, int size) {
		for (int i = 0; i < size; i++) {
			swap(arr, l + i, r + i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

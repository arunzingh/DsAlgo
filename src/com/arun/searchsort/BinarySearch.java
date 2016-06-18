package com.arun.searchsort;

public class BinarySearch {
	int doBinarySearch(int[] a, int left, int right, int x) {
		
		if (left <= right) {
		
			int mid = left + (right - left) /2;
			
			if (a[mid] == x) {
				return mid;
			} 
			
			if (a[mid] > x) {
				return doBinarySearch(a, left, mid - 1, x);
			} else {
				return doBinarySearch(a, mid + 1, right, x);
			}
		}
		
		return -1;
	}
	
	int doBinarySearchIterative(int[] a, int num) {
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			
			int mid = left + (right - left) /2;
			
			if (a[mid] == num)
				return mid;
			
			if (a[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	int firstOccurrence(int[] a, int left, int right, int x) {
//		System.out.println("left=" + left + " right=" + right);
		if (left <= right) {
			
			int mid = (left + right) / 2;
//			System.out.println("mid=" + mid + " a[mid]=" + a[mid] + " a[mid-1]=" + a[mid-1]);

			if ((mid == 0 || a[mid] > a[mid-1]) && a[mid] == x)
				return mid;
			
			if (a[mid] >= x) 
				return firstOccurrence(a, left, mid-1, x);
			else 
				return firstOccurrence(a, mid+1, right, x);
			
		}
		
		
		return -1;
	}
	
	int lastOccurrence(int[] a, int left, int right, int x) {
		if (left <= right) {
			
			int mid = (left + right) / 2;
			
			if ((mid == a.length -1 || a[mid] < a[mid+1]) && a[mid] == x)
				return mid;
			
			
			if (a[mid] <= x) 
				return lastOccurrence(a, mid+1, right, x);
			else
				return lastOccurrence(a, left, mid-1, x);
		}
		
		return -1;
	}
	
	int ceil(int[] a, int left, int right, int x) {
		if (left <= right) {
			
			if (a[left] >= x)
				return a[left];
			
			
			if (a[right] < x) 
				return -1;
			
			int mid = (left + right) / 2;
			
			if (a[mid] == x) 
				return x;
			else if (a[mid] < x) {
				if (mid+1 <= right && a[mid+1] >= x)
					return a[mid+1];
				else
					return ceil(a, mid+1, right, x);
			} else {
				if (mid-1 >= left && a[mid-1] < x )
					return a[mid];
				else
					return ceil(a, left, mid-1, x);
			}
		}
		
		return -1;
	}
	
	
	public int findSmallestMissing(int[] a, int left, int right) {
		
		if (left > right) return right + 1;
		
		if (left != a[left]) return left;
			
		int mid = (left + right) /2;
		
		
		
		if (a[mid] > mid) {
			if (mid-1 >= left && a[mid-1] == mid-1) {
				return mid;
			} else {
				return findSmallestMissing(a, left, mid-1);
			}
		} else {
			if (mid+1 <= right && a[mid+1] > mid+1) {
				return mid+1;
			} else {
				return findSmallestMissing(a, mid+1, right);
			}
		}
			
	}
	
	
	/**
	 * Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1} 
	 * Output: 500
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public int findMaximumElement(int[] a, int left, int right) {
		
		// only one element
		if (left == right)
			return a[left];
		
		
		// two elements
		if (left+1 == right){
			if (a[left] > a[right])
				return a[left];
			else 
				return a[right];
		}
				
		System.out.println("left=" + left + " right=" + right);
		
		int mid = (left + right) / 2;
		
		// Since we need three elements to decide whether 
		// mid is the maximum element, need to specifically handle the cases
		// when there is one or two elements
		if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
			return a[mid];
		} 
		
		
		if (a[mid] > a[mid-1]) {
			return findMaximumElement(a, mid+1, right);
		} else {
			return findMaximumElement(a, left, mid-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] a = {1, 40, 10};
		
		
		BinarySearch b = new BinarySearch();
		
//		System.out.println(new BinarySearch().doBinarySearch(a, 0, a.length - 1, 10));
//		System.out.println(new BinarySearch().doBinarySearch(a, 0, a.length - 1, 4));
		
//		System.out.println("first index=" +b.lastOccurrence(a, 0, a.length-1, 0));
		
//		System.out.println("ceil=" +b.ceil(a, 0, a.length-1, 5));
		
//		System.out.println("missing=" +b.findSmallestMissing(a, 0, a.length-1));
		
		System.out.println("maximum=" +b.findMaximumElement(a, 0, a.length-1));


	}
}

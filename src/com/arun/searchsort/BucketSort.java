package com.arun.searchsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	void doBucketSorting(int[] a) {
		
		
		int min = a[0];
		int max = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if (min > a[i])
				min = a[i];
			
			if (max < a[i])
				max = a[i];
		}
		
		System.out.println("max=" + max + " min=" + min);
		int[] buckets = new int[(max-min+1)];
		
		for (int i = 0; i < a.length; i++) {
			buckets[(a[i]-min)]++;     
		}
		
		
		for (int i = 0; i < buckets.length; i++) {
			System.out.print(buckets[i] + " ");
		}
		System.out.println("");
		
		int i = 0;                                  
	    for( int b = 0; b < buckets.length; b++ )    // "Empty" buckets
	      for( int j = 0; j < buckets[b]; j++ )      // back into array
	        a[i++] = b+min;                     // by creating one per count
	}
	
	/**
	 * Java version to support float data types
	 * @param array
	 */
	void doBucketSorting1(float[] a) {
		if (a == null || a.length <= 1) 
			return; //trivially sorted
		
		float max = a[0];
		float min = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) min = a[i];
			if (a[i] > max) max = a[i];
		}
		
		double interval = (max - min + 1) / 10;
		
		List<Float> buckets[] = new ArrayList[10]; 
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Float>();
		}
		
	    for (int i = 0; i < a.length; i++) { //partition the input array
            buckets[(int)((a[i] - min)/interval)].add(a[i]);
        }
	    
	    int pointer = 0;
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]); //mergeSort
            for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets
                a[pointer] = buckets[i].get(j);
                pointer++;
            }
        }
		
	}
	
	public static void main(String[] args) {
		int[] a = {1, 5, 9, 5, 8, 10};
		float arr[] = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
		}
		
		new BucketSort().doBucketSorting(a);
		
		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
		}
		new BucketSort().doBucketSorting1(arr);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}

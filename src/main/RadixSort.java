package main;

import java.util.Arrays;

public class RadixSort {
	
	private int[] a, b;
	private int[] buckets;
	private static final int base = 1<<16; 
	private int N;
	public void sort(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		N = A.length;
		this.a = A;
		b = new int[N];
		buckets = new int[base];
		radixsort(0,N - 1);
	}
	
	private void radixsort(int left,int right) {
		for(int k = 0;k < 2;k++) {
			Arrays.fill(buckets,0);
			for(int i = left;i <= right;i++) {
				buckets[a[i]>>(k*16) & (base - 1)]++;
				b[i] = a[i];
			}
			
			for(int i = 1;i < base;i++) {
				buckets[i] += buckets[i - 1];
			}
			
			for(int i = right;i >= left;i--) {
				a[--buckets[b[i]>>(k*16) & (base - 1)]] = b[i];
			}
		}	
	}

}

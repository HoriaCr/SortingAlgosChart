package main;

public class Mergesort {
	private int[] A;
	private int[] B;
	private int N;
	
	public void sort(int[] values) {
		if(values == null || values.length < 2) {
			return;
		}
		this.A = values;
		N = values.length;
		B = new int[N];
		mergesort(0,N - 1);
	}
	
	private void mergesort(int l, int r) {
	    int m = (l + r) >> 1, i, j, k;
	    if (l == r) return;
	    
	    mergesort(l, m);
	    mergesort(m + 1, r);
	    
	    for (i = l, j = m + 1, k = l; i <= m || j <= r; ) {
	    	  if (j > r || (i <= m && A[i] < A[j]))
	              B[k++] = A[i++];
	          else
	              B[k++] = A[j++];
	    }
	    
	    for (k = l; k <= r; k++) {
	    	A[k] = B[k];
	    }
	}
	
}
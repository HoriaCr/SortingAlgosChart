package main;

public class Heapsort {
	private int[] a;
	private int n;
	private int left;
	private int right;
	private int largest;

	private void buildheap(int[] a) {
		n = a.length - 1;
		for (int i = n >> 1 ; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	private void maxheap(int[] a, int i) {
		left = i<<1;
		right = (i<<1) + 1;
		if (left <= n && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n && a[right] > a[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			exchange(i, largest);
			maxheap(a, largest);
		}
	}

	private void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private void heapsort() {
		buildheap(a);
		
		for (int i = n; i > 0; i--) {
			exchange(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
	}

	public void sort(int[] values) {
		if(values == null || values.length < 2) {
			return;
		}
		
		this.a = values;
		heapsort();
	}

}

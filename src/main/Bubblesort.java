package main;

public class Bubblesort {
	private int[] values;
	private int N;
	public void sort(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		N = A.length;
		this.values = A;
		bubblesort(0,N - 1);
		
	}
	
	private void bubblesort(int left,int right) {
		boolean isSorted = false;
		do {
			isSorted = true;
			for(int i = left + 1;i <= right;i++) {
				if (values[i] < values[i - 1]) {
					int temp = values[i];
					values[i] = values[i - 1];
					values[i - 1] = temp;
					isSorted = false;
				}
			}
			
		} while (isSorted == false);
	}
	
}

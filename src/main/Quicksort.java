package main;

public class Quicksort {
	private int []numbers;
	private int N;
	public void sort(int[] values) {
		if(values == null || values.length < 2) {
			return;
		}
		N = values.length;
		this.numbers = values;
		quicksort(0,N - 1);
	}
	
	private void quicksort(int left,int right) {
		int i = left;
		int j = right;
		int pivot = numbers[(left + right)>>1];
		
		while (i <= j) {
			while (numbers[i] < pivot) i++;
			while (numbers[j] > pivot) j--;
			
			if(i <= j) {
				int aux = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = aux;
				i++;
				j--;
			}
		}
		
		if (left < j) {
			quicksort(left,j);
		}
		if (i < right) {
			quicksort(i,right);
		}
	}

}

package unitTests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import main.Quicksort;

import org.junit.Test;

public class QuicksortTest {

	private int[] values;
	private int N;
	
	@Test
	public void test() {
		N = 1000;
		values = new int[N];
		Random generator = new Random();
		Quicksort sorter = new Quicksort();
		
		for(int i = 0;i < N;i++) {
			values[i] = generator.nextInt(10000000);
		}
		
		int[] sortedValues = values;
		Arrays.sort(sortedValues);
		sorter.sort(values);
		assertEquals(sortedValues,values);
		assertEquals(true,isOrdered(values));
	}
	
	public boolean isOrdered(int[] A) {
		for(int i = 1;i < A.length;i++) {
			if (A[i] < A[i - 1]) {
				return false;
			}
		}
		return true;
	}

}

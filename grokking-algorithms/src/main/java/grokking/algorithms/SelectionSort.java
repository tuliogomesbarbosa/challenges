package grokking.algorithms;

import java.util.Arrays;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = arr[smallestIndex];
			arr[smallestIndex] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		var arr = new int[]{35, 3, 50, 2};
		ss.selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
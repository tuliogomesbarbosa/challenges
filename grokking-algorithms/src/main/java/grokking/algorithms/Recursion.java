package grokking.algorithms;

import java.util.Arrays;

public class Recursion {

	private static void countDown(int n) {
		if (n <= 0) {
			return;
		}
		System.out.printf("%s%n ", n);
		countDown(n - 1);
	}

	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static int sum(int[] arr) {
		if (arr.length == 0) return 0;
		return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
	}

	private static int count(int[] arr) {
		if (arr.length == 0) return 0;
		return 1 + count(Arrays.copyOfRange(arr, 1, arr.length));
	}

	private static int max(int[] arr) {
		if (arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		return max(arr[0], max(Arrays.copyOfRange(arr, 1, arr.length)));
	}

	private static int max(int a, int b) {
		return Math.max(a, b);
	}

	private static int[] binarySearch(int[] arr) {
		return new int[]{};
	}

	public static void main(String[] args) {
		countDown(3);
		System.out.println(factorial(3));
		System.out.println(sum(new int[]{2, 4, 6}));
		System.out.println(count(new int[]{2, 4, 6, 8, 10}));
		System.out.println(max(new int[]{50, 3, 10, 70, 4}));
	}
}
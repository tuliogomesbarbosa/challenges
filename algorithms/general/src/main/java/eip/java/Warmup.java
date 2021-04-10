package eip.java;

import java.util.HashSet;
import java.util.Set;

public class Warmup {

	private static int[][] transpose(int[][] arr) {
		var transposed = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				transposed[i][j] = arr[j][i];
			}
		}
		return transposed;
	}

	/**
	 * Arrays: Write a program that tests if a 2D square array is symmetric about the diagonal
	 * from (0,0) to (n-1,n-1).
	 */
	public static boolean isSymmetric(int[][] arr) {
		int[][] transposed = transpose(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != transposed[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static String primitiveTypes(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				sb.append("FizzBuzz ");
			} else if (i % 3 == 0) {
				sb.append("Fizz ");
			} else if (i % 5 == 0) {
				sb.append("Buzz ");
			}
		}
		return sb.toString();
	}

	public static boolean findValues(int[] arr, int x) {
		Set<Integer> values = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && values.contains(x / arr[i])) {
				return true;
			}
			values.add(arr[i]);
		}
		return false;
	}

	public static String longestSubstringSingleCharacter(String s) {
		String longestSubstring = "";
		// char[] sArr = s.toCharArray();
		String longestSoFar = "" + s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				longestSoFar = longestSoFar + s.charAt(i);
			} else {
				longestSoFar = "" + s.charAt(i);
			}
			if (longestSoFar.length() > longestSubstring.length()) {
				longestSubstring = longestSoFar;
			}
		}
		return longestSubstring;
	}

	public static void main(String[] args) {
		System.out.println(isSymmetric(new int[][]{{1, 2, 3}, {2, 1, 4}, {3, 4, 3}}));
		System.out.println(isSymmetric(new int[][]{{3, 5, 8}, {3, 4, 7}, {8, 5, 3}}));
		System.out.println(primitiveTypes(15));
		System.out.println(findValues(new int[]{5, 3, 2}, 10));
		System.out.println(longestSubstringSingleCharacter("abcdddddeff"));
	}
}

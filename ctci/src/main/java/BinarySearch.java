import java.util.Arrays;

public class BinarySearch {

	// O(log n) -> log 1024 = 10 steps
	public static int search(int target, int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(1, new int[]{1, 2, 3, 4, 5, 6}));
		int[] nonSortedArr = new int[]{4, 7, 134, 123, 100, 2, 5, 7, 1000, 99, 1}; // 1, 2, 4, 5, 7, 7, 99, 100, 123, 134, 100
		Arrays.sort(nonSortedArr);
		System.out.println(search(100, nonSortedArr));
	}
}
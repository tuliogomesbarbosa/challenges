package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
	/**
	 * [[1,3], [2,6], [8,10], [15,18]] -> [[1,6], [8,10], [15,18]]
	 * [[1,4], [4,5]] -> [1,5]
	 */
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // O(n log n)
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}};
		Arrays.stream(merge(intervals1)).forEach(interval -> System.out.printf("%s-%s\n", interval[0], interval[1]));
		int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
		Arrays.stream(merge(intervals2)).forEach(interval -> System.out.printf("%s-%s\n", interval[0], interval[1]));
	}

}

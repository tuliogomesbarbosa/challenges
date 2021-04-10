package fuckingalgorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BackTrackingPermutations {
	static List<List<Integer>> res = new LinkedList<>();

	static List<List<Integer>> permute(int[] nums) {
		Deque<Integer> track = new LinkedList<>();
		backtrack(nums, track);
		return res;
	}

	/**
	 * Path: recorded in track
	 * Selection List: those elements in nums that do not exist in track
	 * End Condition: all elements in nums appear in track
	 * <p>
	 * We made a few changes here: instead of explicitly recording the "selection List", we use nums and track to deduce the current selection list:
	 */
	static void backtrack(int[] nums, Deque<Integer> track) {
		// trigger the End Condition
		if (track.size() == nums.length) {
			res.add(new LinkedList(track));
			return;
		}

		for (int num : nums) {
			// exclude illegal selections
			if (track.contains(num))
				continue;
			// select
			track.add(num);
			// enter the next level decision tree
			backtrack(nums, track);
			// deselect
			track.removeLast();
		}
	}

	public static void main(String[] args) {
		// PATH = [1,2,3] ; SELECTION_LIST = []
		permute(new int[]{1, 2, 3});
	}

}

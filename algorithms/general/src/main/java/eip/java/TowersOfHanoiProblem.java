package eip.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem 16.1
 */
public class TowersOfHanoiProblem {
	private static final int NUM_PEGS = 3;


	public static Deque<Integer> compute(int numRings) {
		List<Deque<Integer>> pegs = new ArrayList<>();
		for (int i = 0; i < NUM_PEGS; i++) {
			pegs.add(new LinkedList<>());
		}
		for (int i = numRings; i >= 1; i--) {
			pegs.get(0).addFirst(i);
		}
		doCompute(pegs, numRings, 0, 1, 2);
		return pegs.get(1);
	}

	public static void doCompute(List<Deque<Integer>> pegs, int numRings, int fromPeg, int toPeg, int usePeg) {
		if (numRings > 0) {
			doCompute(pegs, numRings - 1, fromPeg, usePeg, toPeg);
			pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
			System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
			doCompute(pegs, numRings -1, usePeg, toPeg, fromPeg);
		}
	}

	public static void doComputeWithoutRecursion() {

	}

	public static void main(String[] args) {
		compute(5).forEach(System.out::println);
	}
}
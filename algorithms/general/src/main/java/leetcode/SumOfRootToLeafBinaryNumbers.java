package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfRootToLeafBinaryNumbers {
	public static int recursiveSum(TreeNode root) {
		return preOrder(root, 0);
	}

	private static int preOrder(TreeNode root, int curNumber) {
		if (root != null) {
			curNumber = (curNumber << 1) | root.val;
			if (root.left == null && root.right == null) {
				return curNumber;
			}
			return preOrder(root.left, curNumber) + preOrder(root.right, curNumber);
		}
		return 0;
	}

	public static int stackSum(TreeNode root) {
		if(root == null) return 0;
		int rootToLeafSum = 0;
		Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
		stack.push(new Pair<>(root, 0));
		while (!stack.isEmpty()) {
			var pair = stack.pop();
			var node = pair.key;
			int curNumber = (pair.value << 1) | node.val;
			if (node.left == null && node.right == null) {
				rootToLeafSum += curNumber;
			} else {
				stack.push(new Pair<>(node.left, curNumber));
				stack.push(new Pair<>(node.right, curNumber));
			}
		}
		return rootToLeafSum;
	}

	public static void main(String[] args) {
		var treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(0);
		treeNode.right = new TreeNode(1);
		treeNode.left.left = new TreeNode(0);
		treeNode.left.right = new TreeNode(1);
		treeNode.right.left = new TreeNode(0);
		treeNode.right.right = new TreeNode(1);
		System.out.println(SumOfRootToLeafBinaryNumbers.recursiveSum(treeNode));
		System.out.println(SumOfRootToLeafBinaryNumbers.stackSum(treeNode));
	}

	public static class Pair<K, V> {
		K key;
		V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}


	}
}

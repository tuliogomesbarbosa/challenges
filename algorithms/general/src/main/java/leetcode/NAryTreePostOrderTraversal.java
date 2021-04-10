package leetcode;

import java.util.List;

public class NAryTreePostOrderTraversal {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<Integer> postorder(Node root) {
		return null;
	}

	public static void main(String[] args) {

	}
}
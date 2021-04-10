package ctci;

public class BinaryTreeHeight {

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

		public Node add(Node root, int val) {
			if (root == null) {
				return new Node(val);
			} else {
				Node cur;
				if (val <= root.val) {
					cur = add(root.left, val);
					root.left = cur;
				} else {
					cur = add(root.right, val);
					root.right = cur;
				}
				return root;
			}
		}

		@Override
		public String toString() {
			return "Node{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
		}
	}

	/**
	 * static Node lca(Node root,int v1,int v2)
	 * {
	 *     //Decide if you have to call rekursively
	 *     //Samller than both
	 *     if(root.data < v1 && root.data < v2){
	 *         return lca(root.right,v1,v2);
	 *     }
	 *     //Bigger than both
	 *     if(root.data > v1 && root.data > v2){
	 *         return lca(root.left,v1,v2);
	 *     }
	 *
	 *     //Else solution already found
	 *     return root;
	 * }
	 */

	public static int height(Node root) {
		if(root == null) return -1;
		int leftHeight = 1 + height(root.left);
		int rightHeight = 1 + height(root.right);
		return Math.max(leftHeight, rightHeight);
	}

	public static Node min(Node root) {
		if(root.left == null) return root;
		return min(root.left);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.add(root, 2);
		root.add(root, 6);
		root.add(root, 1);
		root.add(root, 3);
		root.add(root, 5);
		root.add(root, 7);
		System.out.println(height(root));
		System.out.println(min(root));

	}

}

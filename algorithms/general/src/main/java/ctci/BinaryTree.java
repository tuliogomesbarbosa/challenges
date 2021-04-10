package ctci;

public class BinaryTree {

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			visit(root);
			inOrder(root.right);
		}
	}

	public void preOrder(Node root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(Node root) {
		if (root != null) {
			preOrder(root.left);
			preOrder(root.right);
			visit(root);
		}
	}

	public void invert(Node root) {
		if (root != null) {
			Node tmp = root.right;
			root.right = root.left;
			root.left = tmp;
			if (root.left != null) {
				invert(root.left);
			}
			if (root.right != null) {
				invert(root.right);
			}
		}
	}

	private void visit(Node node) {
		System.out.printf("%s->", node.val);
	}

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(4);
		root.right = new Node(10);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.right.right = new Node(20);

		BinaryTree btree = new BinaryTree();
		btree.inOrder(root);
		System.out.println();
		btree.preOrder(root);
		System.out.println();
		btree.postOrder(root);
	}
}
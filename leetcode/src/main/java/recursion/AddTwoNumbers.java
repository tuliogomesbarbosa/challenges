package recursion;

public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		void add(int n) {
			ListNode newNode = new ListNode(n);
			ListNode current = this;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		static void prettyPrint(ListNode head) {
			if (head == null) {
				System.out.println();
				return;
			}
			System.out.printf("%s->", head.val);
			prettyPrint(head.next);
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return traverse(l1, l2, 0);
	}

	ListNode traverse(ListNode l1, ListNode l2, int carriedForward) {
		int l1Val = 0;
		int l2Val = 0;
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			l2Val = l2.val;
		} else if (l2 == null) {
			l1Val = l1.val;
		} else {
			l1Val = l1.val;
			l2Val = l2.val;
		}
		int sum = l1Val + l2Val + carriedForward;
		int normalized = sum % 10;
		carriedForward = sum / 10;
		ListNode ln = new ListNode(normalized);
		var next = traverse(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carriedForward);
		if (next == null && carriedForward > 0) {
			ln.next = new ListNode(carriedForward);
		} else {
			ln.next = next;
		}
		return ln;
	}

	public static void main(String[] args) {
		var addTwoNumbers = new AddTwoNumbers();
/*		var l1 = new ListNode(2);
		l1.add(4);
		l1.add(9);
		var l2 = new ListNode(5);
		l2.add(6);
		l2.add(4);
		l2.add(9);*/

/*		var l1 = new ListNode(2);
		l1.add(4);
		l1.add(3);
		var l2 = new ListNode(5);
		l2.add(6);
		l2.add(4);*/

/*		var l1 = new ListNode(9);
		l1.add(9);
		l1.add(9);
		l1.add(9);
		l1.add(9);
		l1.add(9);
		l1.add(9);
		var l2 = new ListNode(9);
		l2.add(9);
		l2.add(9);
		l2.add(9);*/

		var l1 =  new ListNode(0);
		var l2 = new ListNode(0);

		ListNode.prettyPrint(l1);
		ListNode.prettyPrint(l2);
		ListNode.prettyPrint(addTwoNumbers.addTwoNumbers(l1, l2));
	}

}

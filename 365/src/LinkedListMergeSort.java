import java.util.List;

public class LinkedListMergeSort {

    public static void main(String[] args) {
        var node = LinkedList.createLinkedList(List.of(29, 23, 82, 11, 4, 3, 21));
        System.out.print("Original: ");
        LinkedList.display(node);

        System.out.print("After merge: ");
        var merged = mergeSort(node);
        LinkedList.display(merged);
    }

    public static LinkedList.LinkedListNode mergeSort(LinkedList.LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var firstSecond = new LinkedList.Pair<LinkedList.LinkedListNode, LinkedList.LinkedListNode>(null, null);

        splitInHalf(head, firstSecond);

        var left = mergeSort(firstSecond.first);
        var right = mergeSort(firstSecond.second);

        return mergeSortedLists(left, right);
    }

    private static void splitInHalf(LinkedList.LinkedListNode head, LinkedList.Pair<LinkedList.LinkedListNode, LinkedList.LinkedListNode> pair) {
        if (head.next == null) {
            pair.first = head;
            return;
        }

        LinkedList.LinkedListNode slow = head, fast = head.next;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        pair.first = head;
        pair.second = slow.next;
        // break links
        slow.next = null;
    }

    private static LinkedList.LinkedListNode mergeSortedLists(LinkedList.LinkedListNode left, LinkedList.LinkedListNode right) {
        LinkedList.display(left);
        LinkedList.display(right);

        LinkedList.LinkedListNode merged = null, curr1 = left, curr2 = right;

        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                merged = LinkedList.insertAtTail(merged, curr1.data);
                curr1 = curr1.next;
            } else {
                merged = LinkedList.insertAtTail(merged, curr2.data);
                curr2 = curr2.next;
            }
        }

        // merge remaining
        while (curr1 != null) {
            merged = LinkedList.insertAtTail(merged, curr1.data);
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            merged = LinkedList.insertAtTail(merged, curr2.data);
            curr2 = curr2.next;
        }

        return merged;
    }

    private static LinkedList.LinkedListNode mergeSortedLists2(LinkedList.LinkedListNode left, LinkedList.LinkedListNode right) {
        // TODO merge sorted lists in place without help of insertAtTail
        return null;
    }
}

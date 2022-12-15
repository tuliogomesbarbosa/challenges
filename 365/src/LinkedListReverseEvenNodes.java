import java.util.List;

public class LinkedListReverseEvenNodes {

    public static void main(String[] args) {
        var node = LinkedList.createLinkedList(List.of(7, 14, 21, 28, 9));
        System.out.print("Original: ");
        LinkedList.display(node);

        System.out.print("After reverse: ");
        var reversed = reverseEvenNodes(node);
        LinkedList.display(reversed);
    }

    private static LinkedList.LinkedListNode reverseEvenNodes(LinkedList.LinkedListNode head) {
        // extract even nodes to different list, reverse this list and insert them again in the original list

        if (head == null || head.next == null) {
            return head;
        }

        LinkedList.LinkedListNode curr = head;
        LinkedList.LinkedListNode evenList = null;


        while (curr != null && curr.next != null) {
            LinkedList.LinkedListNode even = curr.next;
            curr.next = even.next;
            // reverse even on the fly by pushing even at the head of evenList
            even.next = evenList;
            evenList = even;

            curr = curr.next;
        }

        LinkedList.display(head);
        LinkedList.display(evenList);

        // apply event into head

        return mergeAlternating(head, evenList);
    }

    private static LinkedList.LinkedListNode mergeAlternating(LinkedList.LinkedListNode head, LinkedList.LinkedListNode evenList) {
        if (head == null) {
            return evenList;
        }

        if (evenList == null) {
            return head;
        }

        LinkedList.LinkedListNode merged = head;

        while (head != null && evenList != null) {
            LinkedList.LinkedListNode tmp = evenList;
            evenList = evenList.next;

            tmp.next = head.next;

            head.next = tmp;
            head = tmp.next;
        }

        return merged;
    }
}

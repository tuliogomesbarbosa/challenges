import java.util.List;

public class RotateLinkedList {

    public static void main(String[] args) {
        var node = LinkedList.createLinkedList(List.of(1, 2, 3, 4, 5));
        System.out.print("Original: ");
        LinkedList.display(node);

        System.out.print("After rotation: ");
        var rotated = rotateList(node, 2);
        LinkedList.display(rotated);
    }

    public static LinkedList.LinkedListNode rotateList(LinkedList.LinkedListNode head, int n) {
        if(head == null || head.next == null) return head;

        LinkedList.LinkedListNode curr = head;

        while (n > 0) {
            LinkedList.LinkedListNode prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            curr.next = head;
            head = curr;
            n--;
        }

        return head;
    }
}

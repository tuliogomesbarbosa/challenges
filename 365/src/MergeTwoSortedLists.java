import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        var l1 = LinkedList.createLinkedList(List.of(1,2,4));
        var l2 = LinkedList.createLinkedList(List.of(1,3,4,5,6,7));

        System.out.print("After merge: ");
        var merged = mergeTwoLists(l1, l2);
        LinkedList.display(merged);
    }

    public static LinkedList.LinkedListNode mergeTwoLists(LinkedList.LinkedListNode list1, LinkedList.LinkedListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        LinkedList.LinkedListNode head = new LinkedList.LinkedListNode(-1);
        LinkedList.LinkedListNode curr = head;

        while(list1 != null && list2 != null) {
            if(list1.data <= list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 != null) {
            curr.next = list1;
        }

        if(list2 != null) {
            curr.next = list2;
        }


        return head.next;
    }

}

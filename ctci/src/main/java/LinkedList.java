import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LinkedList {
    
    public static class LinkedListNode {
        public int key;
        public int data;
        public LinkedListNode next;
        public LinkedListNode arbitraryPointer;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public LinkedListNode(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public LinkedListNode(int data, LinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitraryPointer) {
            this.data = data;
            this.next = next;
            this.arbitraryPointer = arbitraryPointer;
        }
    }

    public static class Pair<X, Y> {
        public X first;
        public Y second;

        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }

    }

    public static LinkedListNode insertAtHead(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = head;
        return newNode;
    }

    public static LinkedListNode insertAtTail(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            return newNode;
        }
        LinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static LinkedListNode createLinkedList(ArrayList<Integer> lst) {
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for (Integer x : lst) {
            LinkedListNode newNode = new LinkedListNode(x);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    public static LinkedListNode createLinkedList(int[] arr) {
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for (int i = 0; i < arr.length; ++i) {
            LinkedListNode newNode = new LinkedListNode(arr[i]);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    public static LinkedListNode createRandomList(int length) {
        LinkedListNode listHead = null;
        Random generator = new Random();
        for (int i = 0; i < length; ++i) {
            listHead = insertAtHead(listHead, generator.nextInt(100));
        }
        return listHead;
    }

    public static void display(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.printf("%d", temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.printf(", ");
            }
        }
        System.out.println();
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        //no need to reverse if head is
        //null or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode reversedList = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return reversedList;
    }

    public static LinkedListNode removeDuplicates(LinkedListNode head) {
        //TODO: Write - Your - Code
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> visited = new HashSet<>();
        LinkedListNode tmp = head;
        LinkedListNode prev = null;

        while (tmp != null) {
            if (visited.contains(tmp.data)) {
                prev.next = tmp.next;
            } else {
                visited.add(tmp.data);
            }

            prev = tmp;
            tmp = tmp.next;
        }

        return head;
    }

    public static LinkedListNode deleteNode(LinkedListNode head, int key) {
        //TODO: Write - Your - Code

        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public static LinkedListNode sort(LinkedListNode head) {
        // 29 -> 23 -> 82 -> 11
        // 29 -> 23 -> 82 -> 25

        LinkedListNode sorted = null;
        LinkedListNode unsorted = head;

        while (unsorted != null) {
            LinkedListNode tmp = unsorted.next;

            if (sorted == null || unsorted.data <= sorted.data) {
                unsorted.next = sorted;
                sorted = unsorted;
                unsorted = tmp;
                continue;
            }

            LinkedListNode curr = sorted;

            while (curr.next != null && unsorted.data > curr.next.data) {
                curr = curr.next;
            }

            unsorted.next = curr.next;
            curr.next = unsorted;

            unsorted = tmp;
        }

        return sorted;
    }

    public static LinkedListNode sortedInsert(LinkedListNode head, LinkedListNode node) {

        if (node == null) {
            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedListNode curr = head;

        while (curr.next != null && (curr.next.data < node.data)) {

            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static LinkedListNode insertionSort(LinkedListNode head) {

        LinkedListNode sorted = null;
        LinkedListNode curr = head;

        while (curr != null) {

            LinkedListNode temp = curr.next;

            sorted = sortedInsert(sorted, curr);

            curr = temp;
        }

        return sorted;
    }

    static LinkedListNode swapNthNode(LinkedListNode head, int n) {
        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while(n > 1) {
            prev = curr;
            curr = curr.next;
            n--;
        }

        // 7  14 21 28 35 42
        // 28 14 21 7  35 42
        // curr = 28, prev = 21

        // prev = 21 -> 7 -> 14 -> 21 -> 7 ... | curr = 28 -> 35 -> 42 | head = 7 -> 14 -> 21 -> 7 -> 14 ...
        prev.next = head;
        // tmp = 7 -> 14 -> 21 ->
        LinkedListNode tmp = head.next;
        head.next = curr.next;
        curr.next = tmp;

        return curr;
    }

    public static void main(String[] args) {
        LinkedListNode listHead = null;
        int[] arr = {7, 14, 21, 28};
        listHead = LinkedList.createLinkedList(arr);

        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = reverse(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);

        arr = new int[]{4, 7, 4, 9, 7, 11, 4};

        listHead = LinkedList.createLinkedList(arr);
        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = removeDuplicates(listHead);
        System.out.print("After Remove Duplicates: ");
        LinkedList.display(listHead);

        arr = new int[]{20, 14, 36, 11, 72, 41};

        listHead = LinkedList.createLinkedList(arr);
        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = deleteNode(listHead, 72);
        System.out.print("After Delete: ");
        LinkedList.display(listHead);

        arr = new int[]{29, 23, 82, 25};

        listHead = LinkedList.createLinkedList(arr);
        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = sort(listHead);
        System.out.print("After Sort: ");
        LinkedList.display(listHead);

        arr = new int[]{7, 14, 21, 28, 35, 42};

        listHead = LinkedList.createLinkedList(arr);
        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = swapNthNode(listHead, 4);
        System.out.print("After Swap: ");
        LinkedList.display(listHead);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static LinkedListNode createLinkedList(List<Integer> lst) {
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
}

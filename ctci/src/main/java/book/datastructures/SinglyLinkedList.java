package book.datastructures;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Space complexity O(N)
// A Singly Linked List
public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    // private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
    }

    public void insert(Collection<T> c) {
        for (T value : c) {
            insertAtTail(value);
        }
    }

    // Time : O(1)
    // Space: O(1)
    public void insertAtHead(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = this.head;
        head = newNode;
        size++;
    }

    // Time : O(N)
    // Space: O(1) ?
    public void insertAtTail(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head == null) {
            this.head = newNode;
            size++;
            return;
        }

        Node<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = newNode;
        size++;
    }

    // Time:  O(N)
    // Space: O(1) ?
    public T remove(T value) {
        if (this.head == null) return null;

        Node<T> tmp = this.head;

        if (tmp.value == value) {
            this.head = tmp.next;
            size--;
            return value;
        }

        while (tmp.next != null) {
            if (tmp.next.value == value) {
                tmp.next = tmp.next.next;
                size--;
                return value;
            }

            tmp = tmp.next;
        }

        return null;
    }

    // Without tail, time complexity is O(N)
    public T removeLast() {
        if (this.head == null) return null;
        if (this.head.next == null) {
            T deletedValue = this.head.value;
            this.head = null;
            size--;
            return deletedValue;
        }

        Node<T> curr = this.head;
        Node<T> prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        T deletedValue = curr.value;
        prev.next = null;
        size--;

        return deletedValue;
    }

    public T getNth(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(String.format("list size is %d, provided index is %d", size, index));

        Node<T> curr = this.head;
        int counter = 0;
        while (curr != null) {
            if (counter == index) return curr.value;
            counter++;
            curr = curr.next;
        }

        return null;
    }

    public T deleteNth(int index) {
        return null;
    }

    //
    public void reverse() {

    }

    public void removeDups() {
        if (head == null || head.next == null) return;
        // 1 -> 2 -> 1 -> 5
        Set<T> occurrences = new HashSet<>();
        Node<T> curr = head;
        Node<T> prev = null;

        while (curr != null) {
            if (occurrences.contains(curr.value)) {
                prev.next = curr.next;
                size--;
            } else {
                occurrences.add(curr.value);
                prev = curr;
            }

            curr = curr.next;
        }
    }

    public T returnKthToLastWithSize(int n) {
        if (n > size()) return null;

        Node<T> curr = head;
        int kth = this.size - n;

        while (curr.next != null) {
            if (kth == 0) break;
            else {
                curr = curr.next;
                kth--;
            }
        }

        return curr.value;
    }

    public T returnKthToLast(int n) {
        Node<T> curr = this.head;
        Node<T> runner = this.head;

        while (runner != null && n > 0) {
            runner = runner.next;
            n--;
        }

        if (n > 0) throw new IndexOutOfBoundsException();

        while (runner != null) {
            runner = runner.next;
            curr = curr.next;
        }

        return curr.value;
    }

    // only have access to input Node, not to head.
    // solution: overwrite the current node with next.
    public boolean deleteMiddleNode(Node<T> node) {
        if (node == null || node.next == null) return false;

        Node<T> next = node.next;
        node.value = next.value;
        node.next = next.next;

        return true;
    }

    public Node<T> partition(T n) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node<T> curr = this.head;
        Node<T> left = null, right = null;

        // split

        while (curr != null) {
            if (curr.value.compareTo(n) < 0) {
                if (left == null) {
                    left = new Node<>(curr.value);
                } else {
                    Node<T> currLeft = left;

                    while (currLeft.next != null) {
                        currLeft = currLeft.next;
                    }

                    currLeft.next = new Node<>(curr.value);
                }
            } else {
                if (right == null) {
                    right = new Node<>(curr.value);
                } else {
                    Node<T> currRight = right;

                    while (currRight.next != null) {
                        currRight = currRight.next;
                    }

                    currRight.next = new Node<>(curr.value);
                }
            }

            curr = curr.next;
        }

        // make right's head point to left's tail.next
        Node<T> currLeft = left;
        while (currLeft.next != null) {
            currLeft = currLeft.next;
        }

        currLeft.next = right;

        return left;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.head == null) return "{}";

        StringBuilder sb = new StringBuilder();

        Node<T> tmp = this.head;
        while (tmp != null) {
            sb.append(tmp.value).append("\t");
            tmp = tmp.next;
        }

        sb.append("\n");

        return sb.toString();
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtTail(30);

        System.out.println("Remove");

        System.out.println(sll);
        System.out.println(sll.remove(20));
        System.out.println("size: " + sll.size());
        System.out.println(sll);
        System.out.println(sll.remove(30));
        System.out.println("size: " + sll.size());
        System.out.println(sll);
        System.out.println(sll.remove(10));
        System.out.println("size: " + sll.size());
        System.out.println(sll);
        System.out.println(sll.remove(20));
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("Insert");

        sll.insertAtTail(40);
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        sll.insertAtHead(50);
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        sll.insertAtHead(60);
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("RemoveLast");

        System.out.println(sll.removeLast());
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("---");

        System.out.println(sll.removeLast());
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("---");

        System.out.println(sll.removeLast());
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("---");

        System.out.println(sll.removeLast());
        System.out.println("size: " + sll.size());
        System.out.println(sll);

        System.out.println("GetNth");

        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtTail(30);
        sll.insertAtTail(40);
        sll.insertAtTail(50);

        System.out.println(sll.getNth(0));
        System.out.println(sll.getNth(1));
        System.out.println(sll.getNth(4));
        System.out.println(sll.getNth(5));
    }
}
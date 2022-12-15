package book.chapter2;

import book.datastructures.SinglyLinkedList;

import java.util.List;

// Implement an algorithm to find the kth to last element of a singly linked list.
public class ReturnKthToLast {

    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        // list.insert(List.of(1, 1, 2, 3, 4, 5));
        list.insert(List.of(1, 1, 2, 3, 4, 5, 6));
        // list.insert(List.of(1, 1, 2, 3, 4, 5, 6, 7));
        // 1, 1, 2, 3, 4, 5             = s = 6, n = 3 => s - n = 3 =>
        // 1, 1, 2, 3, 4, 5, 6          = s = 7, n = 3 => s - n = 4 =>
        // 1, 1, 2, 3, 4, 5, 6, 7       = s = 8, n = 3 => s - n = 5 =>
        System.out.println("KthToLast: " + list.returnKthToLast(3));
    }
}

package book.chapter2;

import book.datastructures.SinglyLinkedList;

import java.util.List;

// Write code to remove duplicates from an unsorted linked list.
public class RemoveDups {
    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.insert(List.of(1, 1, 1, 1, 2));

        list.removeDups();
        System.out.printf("List after deletion: %s", list);
        System.out.println(list.size());
    }
}
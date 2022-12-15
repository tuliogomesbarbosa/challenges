package book.chapter2;

import book.datastructures.SinglyLinkedList;

import java.util.List;

public class Partition {
    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.insert(List.of(3, 5, 8, 5, 10, 2, 1));

        System.out.println(list.partition(5));

        // list.insert(List.of(1, 1, 2, 3, 4, 5, 6));
    }
}
package book.datastructures;

import java.util.EmptyStackException;

public class StackWithLinkedList<T> {

    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "StackNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private StackNode<T> top;

    public T peek() {
        if (this.top == null) throw new EmptyStackException();

        return this.top.data;
    }

    public T pop() {
        if (this.top == null) throw new EmptyStackException();

        T item = this.top.data;
        this.top = this.top.next;

        return item;
    }

    public void push(T elem) {
        StackNode<T> item = new StackNode<>(elem);
        item.next = top;
        top = item;
    }

    @Override
    public String toString() {
        return "StackWithLinkedList{" +
                "top=" + top +
                '}';
    }

    public static void main(String[] args) {
        StackWithLinkedList<Integer> sll = new StackWithLinkedList<>();
        sll.push(1);
        sll.push(2);
        sll.push(3);
        sll.push(4);
        sll.push(5);

        System.out.println(sll);

        sll.pop();
        sll.pop();
        sll.pop();

        System.out.println(sll);
    }
}
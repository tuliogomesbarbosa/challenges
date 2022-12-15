package book.datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {

    private static class QueueNode<T> {
        private final T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private QueueNode<T> start;
    private QueueNode<T> end;

    public void add(T elem) {
        QueueNode<T> item = new QueueNode<>(elem);

        if (this.end != null) {
            this.end.next = item;
        }

        this.end = item;

        if (this.start == null) {
            this.start = this.end;
        }

    }

    public T remove() {
        if (this.start == null) throw new NoSuchElementException();

        T item = this.start.data;
        this.start = this.start.next;
        if (this.start == null) {
            this.end = null;
        }
        return item;
    }

    public T peek() {
        if (this.start == null) throw new NoSuchElementException();

        return this.start.data;
    }

    public boolean isEmpty() {
        return this.start == null;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);

        queue.remove();
        queue.remove();

        System.out.println(queue);

        queue.remove();
        queue.remove();
        queue.remove();

        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
}
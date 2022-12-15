package book.datastructures;

import java.util.*;

public class SimpleStack {

    private final Deque<Integer> min;

    private final int[] elements;
    private int top;
    private final int capacity;

    public SimpleStack(int size) {
        this.capacity = size;
        this.elements = new int[size];
        this.top = -1;
        this.min = new ArrayDeque<>();
    }

    public int peek() {
        return this.elements[top];
    }

    public int pop() {
        int popped = this.elements[top--];
        if(!min.isEmpty() && min.peek() == popped) min.pop();
        return popped;
    }

    public void push(int elem) {
        if(size() >= capacity) throw new RuntimeException("Stack is full");

        this.elements[++top] = elem;

        if (min.isEmpty() || min.peek() > elem) {
            min.push(elem);
        }
    }

    public int size() {
        return top + 1;
    }

    // O(1)
    public int min() {
        if (min.isEmpty()) throw new EmptyStackException();
        return  this.min.peek();
    }

    @Override
    public String toString() {
        return "SimpleStack{" +
                "elements=" + Arrays.toString(elements) +
                ", top=" + top +
                '}';
    }

    public static void main(String[] args) {
        var ss = new SimpleStack(5);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);

        System.out.println(ss);
        System.out.printf("size %s\n", ss.size());

        assert ss.size() == 5;

        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());

        System.out.println(ss);
        System.out.printf("size %s\n", ss.size());

        assert ss.size() == 0;

        ss.push(10);
        ss.peek();

        System.out.println(ss);
        System.out.printf("size %s\n", ss.size());

        assert ss.size() == 1;

        ss.pop();

        ss.push(5);
        System.out.printf("min %d\n", ss.min());
        ss.push(6);
        System.out.printf("min %d\n", ss.min());
        ss.push(3);
        System.out.printf("min %d\n", ss.min());

        assert ss.min() == 3;

        ss.push(7);
        System.out.printf("min %d\n", ss.min());
        ss.pop();
        System.out.printf("min %d\n", ss.min());
        ss.pop();
        System.out.printf("min %d\n", ss.min());

        assert ss.min() == 5;
    }
}

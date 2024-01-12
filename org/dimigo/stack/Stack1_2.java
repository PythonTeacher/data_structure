package org.dimigo.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

// 스택 구현 (ArrayList)
interface IStack2<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}

class MyStack2<T> implements IStack2<T> {
    private ArrayList<T> stack;
    private int top;

    public MyStack2() {
        this.top = -1;
        this.stack = new ArrayList();
    }

    @Override
    public void push(T item) {
        ++top;
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.remove(top--);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.get(top);
    }

    @Override
    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }
}

public class Stack1_2 {
    public static void main(String[] args) {
        IStack2 s = new MyStack2();
        System.out.println(s.isEmpty());
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

package org.dimigo.stack;

import java.util.EmptyStackException;
import java.util.Stack;

// 스택 구현 (배열)
interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
/*
class MyStack {
    private char[] stack;
    private int top;
    private int size;

    public MyStack(int size) {
        this.top = -1;
        this.size = size;
        this.stack = new char[size];
    }

    public void push(char item) {
        if (isFull()) throw new RuntimeException("Stack is Full");
        stack[++top] = item;
    }

    public char pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    public boolean isFull() {
        return (top == size - 1) ? true : false;
    }
}
*/

class MyStack<T> {
    private T[] stack;
    private int top;
    private int size;

    public MyStack(int size) {
        this.top = -1;
        this.size = size;
        this.stack = (T[]) new Object[size];
    }

    public void push(T item) {
        if (isFull()) throw new RuntimeException("Stack is Full");
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
}

public class Stack1_1 {
    public static void main2(String[] args) {
        Stack s = new Stack();
        System.out.println(s.isEmpty());    // true
        s.push('A');
        s.push(10);
        s.push("hello");
        System.out.println(s);
        System.out.println(s.isEmpty());    // false
        System.out.println(s.peek());       // C
        System.out.println(s.pop());        // C
        System.out.println(s.pop());        // B
        System.out.println(s.pop());        // A
        System.out.println(s.pop());        // EmptyStackException 발생
    }

    public static void main(String[] args) {
        MyStack s = new MyStack(5);
//        MyStack<Integer> s = new MyStack(5);
        System.out.println(s.isEmpty());
        s.push('A');
        s.push("B");
        s.push(10);
        //s.push("D");
        System.out.println(s.isEmpty());
        System.out.println(s.peek()); // 10
        System.out.println(s.pop());  // 10
        System.out.println(s.pop());  // B
        System.out.println(s.pop());  // A
        //System.out.println(s.pop());
    }
}

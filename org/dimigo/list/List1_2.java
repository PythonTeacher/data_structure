package org.dimigo.list;

import java.util.EmptyStackException;

// LinkedList로 Stack 구현하기
class MyLinkedListStack<T> {
    public Node<T> top;
    public int size;

    /*public MyLinkedListStack() {
        this.top = null;
        this.size = 0;
    }*/

    public void push(T item) {
        Node<T> newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        else {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

}

public class List1_2 {
    public static void main(String[] args) {
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

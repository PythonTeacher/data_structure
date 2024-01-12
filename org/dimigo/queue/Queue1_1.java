package org.dimigo.queue;

import java.util.LinkedList;
import java.util.Queue;

// 선형큐 구현 (배열)
interface IQueue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

class MyLinearQueue<T> implements IQueue<T> {
    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public MyLinearQueue(int size) {
        front = rear = -1;
        this.size = size;
        this.queue = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) throw new RuntimeException("Queue is Full");
        queue[++rear] = item;    // 다음 rear 포인터가 가리키는 위치에 데이터 추가
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[++front];
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[front+1];
    }

    @Override
    public boolean isEmpty() {
        return front == rear ? true : false;
    }

    @Override
    public boolean isFull() {
        return (rear == size - 1) ? true : false;
    }
}

class MyQueue<T> {
    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public MyQueue(int size) {
        front = rear = -1;
        this.size = size;
        this.queue = (T[]) new Object[size];
    }

    public void enqueue(T item) {
        if (isFull()) throw new RuntimeException("Queue is Full");
        queue[++rear] = item;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[++front];
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[front+1];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == size - 1;
    }
}

public class Queue1_1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList();
        queue.offer("사과"); queue.offer("배");
        System.out.println(queue.peek());    // 사과
        System.out.println(queue.poll());     // 사과
        System.out.println(queue.poll());     // 사과

//        Queue<String> queue = new LinkedList();
//        queue.offer("A");
//        queue.offer("B");
//        queue.offer("C");
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());       // null
//        System.out.println(queue.remove());     // NoSuchElementException 발생
    }

    public static void main2(String[] args) {
        MyQueue<String> queue = new MyQueue(3);
        queue.enqueue("사과");
        queue.enqueue("배");
        queue.enqueue("포도");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

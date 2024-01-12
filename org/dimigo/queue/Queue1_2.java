package org.dimigo.queue;

import java.util.ArrayList;

// 선형큐 구현(ArrayList)
interface IQueue2<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
}

class MyQueueArrayList<T> implements IQueue2<T> {
    private int front;
    private int rear;
    private ArrayList<T> queue;

    public MyQueueArrayList() {
        front = rear = -1;
        this.queue = new ArrayList();
    }

    @Override
    public void enqueue(T item) {
        ++rear;
        queue.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        // 큐에서 삭제할 데이터 반환
        return queue.get(++front);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue.get(front+1);
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }
}

class MyQueue2<T> {
    private int front;
    private int rear;
    private ArrayList<T> queue;

    public MyQueue2() {
        front = rear = -1;
        this.queue = new ArrayList();
    }

    public void enqueue(T item) {
        ++rear;
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        // 큐에서 삭제할 데이터 반환
        return queue.get(++front);
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue.get(front+1);
    }

    public boolean isEmpty() {
        return front == rear;
    }
}

public class Queue1_2 {
    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
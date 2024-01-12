package org.dimigo.queue;

// 원형큐 구현
interface IQueue3<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

class MyQueue3<T> implements IQueue3<T> {
    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public MyQueue3(int size) {
        front = rear = 0;
        this.size = size;
        this.queue = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) throw new RuntimeException("Queue is Full");
        //rear = (rear + 1) % size;
        //queue[rear] = item;
        queue[rear = (rear + 1) % size] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        // 큐에서 삭제할 데이터 반환
        //front = (front + 1) % size;
        //return queue[front];
        return queue[front = (front + 1) % size];
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[(front + 1) % size];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}

class MyQueue4<T> {
    private int front;
    private int rear;
    private int size;
    private T[] queue;

    public MyQueue4(int size) {
        front = rear = 0;
        this.size = size;
        this.queue = (T[]) new Object[size];
    }

    public void enqueue(T item) {
        if (isFull()) throw new RuntimeException("Queue is Full");
        //rear = (rear + 1) % size;
        //queue[rear] = item;
        // queue[rear = (rear + 1) % size] = item;
        // queue[++rear % n] = item;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        //front = (front + 1) % size;
        //return queue[front];
        // return queue[front = (front + 1) % size];
        return queue[++front % size];
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[(front + 1) % size];
    }

    public boolean isEmpty() {
        return front == rear ;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}


public class Queue1_3 {
    public static void main(String[] args) {
        MyQueue4<String> queue = new MyQueue4(4);
        queue.enqueue("사과");
        queue.enqueue("배");
        queue.enqueue("딸기");
        System.out.println(queue.peek());       // 사과
        System.out.println(queue.dequeue());    // 사과
        System.out.println(queue.dequeue());    // 배
        System.out.println(queue.dequeue());    // 딸기
        System.out.println(queue.dequeue());    // Queue is Empty
    }
}

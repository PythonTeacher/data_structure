package org.dimigo.list;

// LinkedList로 Queue 구현하기
class MyLinkedListQueue<T> {
    public Node<T> front;
    public Node<T> rear;
    public int size;

    /*public MyLinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }*/

    public void enQueue(T item) {
        Node<T> newNode = new Node(item);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T deQueue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        else {
            T data = front.data;
            front = front.next;
            if (front == null) rear = null;
            size--;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        else {
            return front.data;
        }
    }

    public boolean isEmpty() {
        return front == null;
        //return rear == null;
    }

}

public class List1_3 {
    public static void main(String[] args) {
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.peek());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}

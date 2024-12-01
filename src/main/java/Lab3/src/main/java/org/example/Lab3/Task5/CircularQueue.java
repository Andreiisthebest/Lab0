package org.example.Lab3.Task5;

public class CircularQueue<T> implements Queue<T> {
    private final T[] queue;
    private int front;
    private int rear;
    private final int size;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        this.size = size;
        this.queue = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = element;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T element = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return element;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        do {
            System.out.println(queue[i]);
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
    }
}

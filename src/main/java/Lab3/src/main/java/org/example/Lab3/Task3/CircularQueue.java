package org.example.Lab3.Task3;

public class CircularQueue<T> implements Queue<T> {
    Object cars[] = new Object[size];
    private int front;
    private int rear;
    private static final int size = 5;

    public CircularQueue() {
        front = -1;
        rear = -1;
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
        cars[rear] = element;
        System.out.println("Inserted: " + element);
    }

    @Override
    public Object dequeue() {
        Object car = cars[front];

        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        System.out.println("\n"+ cars[front] + " entered the station\n_________________________");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return car;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Elements in queue:");
        int i = front;
        do {
            System.out.println(cars[i]);
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
    }
}
package org.example.Lab3.Task1;

public class CarQueue implements Queue {
    public int size;
    public Object[] elements;
    public int maxSize;
    public int front;
    public int rear;

    public CarQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[this.maxSize];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }


        rear = (rear + 1) % maxSize;
        elements[rear] = item;
        size++;
        System.out.println("Item added: " + item + " at index " + rear);
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Object dequeuedElement = elements[front];
        elements[front] = null;
        front = (front + 1) % maxSize;
        size--;
        System.out.println("Item dequeued: " + dequeuedElement);
    }

    @Override
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % maxSize;
            System.out.print(elements[index] + " (" + index + ") ");
        }
        System.out.println();
    }

    @Override
    public void isRefueling() {
        System.out.println("Item is being processed.");
    }

    @Override
    public void wasRefueled() {
        System.out.println("Item was processed.");
    }
}

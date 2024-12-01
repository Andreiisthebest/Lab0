package org.example.Lab3.Task1;

public class CircularQueue<T> implements Queue {
    public int size;
    public Object[] elements;
    public int maxSize;
    public int front;
    public int rear;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new Object[this.maxSize];
        size = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (isEmpty()) {

                front = 0;
                rear = 0;
                elements[rear] = item;
            } else {

                rear = (rear + 1) % elements.length;
                elements[rear] = item;
            }
            size++;
            System.out.println("Item added: " + item + " at index " + rear);
        }
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Object dequeuedElement = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            if (size == 0) {
                front = -1;
                rear = -1;
            }
            System.out.println("Item dequeued: " + dequeuedElement);
        }
    }

    @Override
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % elements.length;
                System.out.print(elements[index] + " (" + index + ") ");
            }
            System.out.println();
        }
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

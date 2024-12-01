package org.example.Lab3.Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearQueueStressTests {

    @Test
    void testEnqueueSpecialSymbols() {
        CarQueue queue = new CarQueue(3);

        queue.enqueue("🚗");
        queue.enqueue("特斯拉");
        queue.enqueue("Über");

        assertTrue(queue.isFull(), "Queue should be full after enqueuing three elements.");
        assertEquals(3, queue.size, "Queue size should be 3.");
        assertEquals("🚗", queue.elements[0], "Element at index 0 should be '🚗'.");
        assertEquals("特斯拉", queue.elements[1], "Element at index 1 should be '特斯拉'.");
        assertEquals("Über", queue.elements[2], "Element at index 2 should be 'Über'.");
    }

    @Test
    void testEnqueueDequeueSequence() {
        CarQueue queue = new CarQueue(3);

        queue.enqueue("Toyota");
        queue.enqueue("Honda");
        queue.enqueue("Ford");

        assertEquals(3, queue.size, "Queue size should be 3 after enqueuing three elements.");
        assertTrue(queue.isFull(), "Queue should be full.");

        queue.dequeue();

        assertEquals(2, queue.size, "Queue size should be 2 after one dequeue.");
        assertFalse(queue.isFull(), "Queue should not be full after one dequeue.");


        assertNull(queue.elements[0], "Index 0 should be empty after dequeuing 'Toyota'.");
        assertEquals("Honda", queue.elements[1], "Element at index 1 should be 'Honda'.");
        assertEquals("Ford", queue.elements[2], "Element at index 2 should be 'Ford'.");
    }

    @Test
    void testQueueCapacityLimit() {
        CarQueue queue = new CarQueue(3);

        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.enqueue("Car3");


        queue.enqueue("Car4");

        assertEquals(3, queue.size, "Queue size should remain 3 after attempting to enqueue a fourth element.");
        assertTrue(queue.isFull(), "Queue should remain full and not accept the fourth element.");


        assertEquals("Car1", queue.elements[0], "First element should still be 'Car1'.");
        assertEquals("Car2", queue.elements[1], "Second element should still be 'Car2'.");
        assertEquals("Car3", queue.elements[2], "Third element should still be 'Car3'.");
    }

    @Test
    void testAlternatingEnqueueDequeue() {
        CarQueue queue = new CarQueue(3);

        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.dequeue();
        queue.enqueue("Car3");

        assertEquals(2, queue.size, "Queue size should be 2 after alternating enqueue and dequeue.");
        assertFalse(queue.isFull(), "Queue should not be full.");


        assertNull(queue.elements[0], "Index 0 should be empty after dequeuing 'Car1'.");
        assertEquals("Car2", queue.elements[1], "Element at index 1 should be 'Car2'.");
        assertEquals("Car3", queue.elements[2], "Element at index 2 should be 'Car3'.");
    }
}

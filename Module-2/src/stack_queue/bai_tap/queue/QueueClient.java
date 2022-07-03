package stack_queue.bai_tap.queue;

public class QueueClient {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.displayQueue();

    }
}

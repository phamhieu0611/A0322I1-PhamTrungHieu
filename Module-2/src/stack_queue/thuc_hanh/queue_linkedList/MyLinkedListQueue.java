package stack_queue.thuc_hanh.queue_linkedList;

public class MyLinkedListQueue {
            private stack_queue.thuc_hanh.queue_linkedList.Node head;
            private stack_queue.thuc_hanh.queue_linkedList.Node tail;

            public MyLinkedListQueue() {
                this.head = null;
                this.tail = null;
            }

            public void enqueue(int key){
                stack_queue.thuc_hanh.queue_linkedList.Node temp = new stack_queue.thuc_hanh.queue_linkedList.Node(key);
                if (this.tail == null){
                    this.head = this.tail = temp;
                    return;
                }
                this.tail.next = temp;
                this.tail = temp;
            }

            public stack_queue.thuc_hanh.queue_linkedList.Node dequeue(){
                if (this.head == null)
                    return null;
                stack_queue.thuc_hanh.queue_linkedList.Node temp = this.head;
                this.head = this.head.next;
                if (this.head == null)
                    this.tail = null;
                return temp;
            }
        }

    class Node {
        public int key;
        public stack_queue.thuc_hanh.queue_linkedList.Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

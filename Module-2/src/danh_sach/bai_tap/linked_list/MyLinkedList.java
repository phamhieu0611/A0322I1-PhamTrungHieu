package danh_sach.bai_tap.linked_list;

public class MyLinkedList {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList(Object data){
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    public void add(int index, Object data){
        Node temp = head;
        Node holder;

        for (int i = 0; i < index-1; i++){
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            temp = temp.next;
        }temp.next = new Node(data);
        numNodes++;
    }

    public void remove(int index){
        Node temp = head;
        Node holder = null;
        if (index == 0){
            holder = temp.next;
            head = holder;
            numNodes--;
        }else if (index == numNodes){
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }temp.next = null;
            numNodes--;
        }else{
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }holder = temp.next.next;
            temp.next = holder;
            numNodes--;
        }
    }
    public void removeObject(Object element){
        Node temp = head;
        Node holder = null;

        for (int i = 0; i < numNodes; i++){
            if (head.getData().equals(element)){
                holder = temp.next;
                break;
            }if (temp.next.getData().equals(element)){
                holder = temp.next.next;
                break;
            }temp = temp.next;
        }if (temp.equals(head)){
            head = holder;
            numNodes--;
        }else if (holder == null){
            temp.next = null;
            numNodes--;
        }else {
            temp.next = holder;
            numNodes--;
        }
    }
    public int size(){
        return numNodes+1;
    }
    public boolean contains(Object data){
        Node temp = head;
        boolean check = false;
        for (int i = 0; i < numNodes; i++){
            if (temp.getData().equals(data)){
                check = true;
                break;
            }temp = temp.next;
        }return check;
    }
    public int indexOf(Object data){
        Node temp = head;
        int position = -1;
        for (int i = 0; i <= numNodes; i++){
            if (temp.getData().equals(data)){
                position = i;
                break;
            }temp = temp.next;
        }return position;
    }
    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }return temp;
    }
    public Object getFirst(){
        return head.getData();
    }
    public Object getLast(){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            temp = temp.next;
        }return temp.getData();
    }
    public void clear(){
        head = null;
    }
    public MyLinkedList clone(){
        return this;
    }
    public void ensureCapacity(int minCapacity){
        numNodes = minCapacity;
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }
}

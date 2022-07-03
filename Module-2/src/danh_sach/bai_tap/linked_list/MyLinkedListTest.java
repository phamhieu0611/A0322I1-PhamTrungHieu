package danh_sach.bai_tap.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(5);
        ll.addFirst(6);
        ll.printList();
        ll.addFirst(7);
        ll.addFirst(10);
        ll.printList();
        ll.add(2, 20);
        ll.remove(3);
        ll.printList();
    }
}

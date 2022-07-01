package danh_sach.bai_tap.my_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    private void ensurecapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element){
        if (size == elements.length){
            ensurecapa();
            for (int i = elements.length-1; i > index; i--){
                elements[i] = elements[i-1];
            }
        }elements[index] = element;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index > elements.length){
            throw new IndexOutOfBoundsException("Không có trong mảng.");
        }for (int i = index; i < elements.length; i++){
            elements[i] = elements[i+1];
        }elements[elements.length-1] = null;
        size--;
    }

    public int size(){
        return size;
    }

    public MyList<E> clone(){
        return this;
    }

    public boolean contains(E o){
       boolean check = true;
       for (Object varible: elements){
           if (varible != o){
               check = false;
           }
       }return check;
    }

    public int indexOf(E o){
        int position = 0;
        for (int i = 0; i < size; i++){
            if (elements[i].equals(0)){
                position = 1;
            }
        }return position;
    }

    public void ensureCapacity(int minCapacity){
        elements = Arrays.copyOf(elements, minCapacity);
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
    }

    public E get(int index){
        if (index > elements.length || index < 0){
            throw new IndexOutOfBoundsException("Không có trong mảng.");
        }return (E) elements[index];
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}

package 큐단순연결리스트;

import java.util.NoSuchElementException;

public class ListQueue <E extends Comparable<E>>{
    private Node<E> front, rear;
    private int size;

    public ListQueue() {
        front = rear = null;
        size =  0;
    }

    public int size() {return size;}
    public boolean isEmpty() {return size==0;}
    public void add(E newItem) {
        Node newNode = new Node(newItem, null);

        if(isEmpty()) front = newNode;
        else rear.setNext(newNode);

        rear = newNode;
        size++;
    }
    public E remove(){
        if(isEmpty())
            throw new NoSuchElementException();

        E frontItem = front.getItem();
        front = front.getNext();

        size--;
        if(isEmpty()) rear = null;

        return frontItem;
    }

    public void print() {
        if (isEmpty()) System.out.println("큐가 empty임");
        else {
            Node tempNode = this.front;
            for (int i = 0; i < size(); i++) {
                System.out.print(tempNode.getItem()+"\t");
                tempNode = tempNode.getNext();
            }
            System.out.println();
        }
    }


}

package 후위표기법;// 자료구조 과제 #3 (60200216 김현빈)

import java.util.EmptyStackException;

public class ListStack<E extends Comparable<E>> {
    private Node<E> top;
    private int size;

    public ListStack(){
        top = null;
        size = 0;
    }


    // peek, push, pop
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E peek() { // 스택의 top item을 리턴
        if(isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    public void push(E newItem){
        // 새로운 노드
        Node newNode = new Node(newItem, top);
        // top을 추가된 노드로 변경
        top = newNode;
        size++;
    }

    public E pop(){
        if (isEmpty()) throw new EmptyStackException();

        E topItem = top.getItem();
        top = top.getNext();
        size--;

        return topItem;
    }
    public void print(){
        if( isEmpty() ) System.out.println("스택이 비어있음.");
        else{
            for(Node p = top; p != null; p=p.getNext()){
                System.out.print(p.getItem()+"\t");
            }
            System.out.println();
        }
    }
}


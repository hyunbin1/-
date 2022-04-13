package 큐배열;

import java.util.NoSuchElementException;

public class ArrayQueue <E>{
    private E[] q;
    private int front, rear, size;

    public ArrayQueue(){
        q = (E[]) new Object[2];
        front = rear = size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {return size==0;}
    private void resize(int newSize) {
        Object[] t = new Object[newSize];

        for(int i=1, j=front+1; i< size+1; i++, j++){
            t[i] = q[j%q.length];
        }

        front = 0;
        rear = size;

        q = (E[]) t;
    }

    public void add(E newItem){
        if((rear+1)%q.length == front) // 배열이 full인 경우
            resize(2*q.length);

        rear = (rear+1) % q.length;
        q[rear] = newItem; // 새항목 삽입
        size++;
    }

    public E remove() {
        if(isEmpty()) throw new NoSuchElementException();

        front = (front+1) % q.length; // 삭제될 시 프론트의 새로운 위치.
        E item = q[front]; // return을 위해서 따로 만들어 준 것

        q[front] = null; // 실제 q리스트에서 front의 내용을 빼주는 과정
        size--;

        if(size > 0  && size == q.length/4) // 빈 배열 크기가 너무 클 경우 줄이기
            resize(q.length/2);

        return item;
    }

    public void print(){
        if( isEmpty() ) System.out.println("스택이 비어있음.");
        else{
            System.out.print("항목수: "+size+"/ ");
            for(int i=0; i<q.length; i++ ){
                System.out.print(q[i]+ "\t ");
            }
            System.out.println();
        }
    }

}

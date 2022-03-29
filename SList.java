// 자료구조 과제 #2 (60200216 김현빈)

import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {

    protected Node head; // 연결리스트 첫 노드 
    private int size;

    public SList() { // 연결리스트 생성자
        head = null;
        size = 0;
    }


    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public int search(E target){
        Node p = head;

        for(int k = 0; k < size; k++){
            if(target == p.getItem()) 
                return k;
            p = p.getNext(); // 노드 클레스 안에 있는 메서드

        }
        return -1; // 탐색 실패
    }

    public void insertFront(E newItem){
        head = new Node(newItem, head);
        size++;
    }
    public void insertAfter(E newItem, Node p){
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }
    public void deleteFront(){
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }
    public void deleteAfter(Node p){
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }
    public void print(){
        for(Node p=head; p != null; p=p.getNext()){
            System.out.print(p.getItem()+"\t");
        }
        System.out.println();
    }

    public void mergedLists(Node p1, Node p2) {
        Node mergedList = new Node(null, null);

        while (p1 != null && p2 != null) {
            // p1과 p2 비교 후 작은 수를 처리
            if (p1.getItem().compareTo(p2.getItem()) <= 0) {
                mergedList.setNext(p1);
                p1 = p1.getNext();
            } else {
                mergedList.setNext(p2);
                p2 = p2.getNext();
            }
            mergedList = mergedList.getNext();
        }
        // 비교 후 하나 남은 노드 처리
        if(p1 != null) mergedList.setNext(p1);
        else if(p2 != null) mergedList.setNext(p2);
    }

    public void splitList(Node p, int k, SList l1, SList l2){

        System.out.println("k="+k+"을 기준으로 두 개의 리스트로 분리:");

    }



}

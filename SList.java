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

    // public void mergedLists(Node p1, Node p2){
    //     if(p1 == null || p2 == null) throw new NoSuchElementException();
    //     head = new Node(p1.getItem(), p1.getNext());

    //     }        
    // }
    


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





}

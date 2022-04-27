package 큐단순연결리스트;// 자료구조 과제 #3 (60200216 김현빈)

public class Node<E extends Comparable<E>>{ // 제네릭 타입 안에서 extends는 상속의 의미가 아니다. Comparable을 상속이 아니라 제너릭 타입에 대해서 구체화한타입니다.
    // 모든 타입이 허용되었지만, comparable로 인해서 서로 비교가능한 타입만 넣을 수 있음을 의미한다. 
    // public class Node <E extends Number<E>>{ // 숫자 타입만 가능

    private E item; // 정수, 실수 등 여러 타입이 가능하기 때문에 제네릭 타입으로 선언
    private Node<E> next; // 다음 노드 값

    // 생성자
    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    // get, set 메소드
    public E getItem() {return item;}
    public Node<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}    
    public void setNext(Node<E> newNext) {next = newNext;}
}

//자료구조 과제 #6(60200216 김현빈)
package 이진탐색트리;

import java.util.LinkedList;
import java.util.Queue;

// 이진탐색트리 클래스
public class BST <Key extends Comparable<Key>, Value> {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public BST(Key newId, Value newName) {
        root = new Node(newId, newName);
    }

    //Method: get, put(삽입), min, deleteMin, delete(임의의 키값)

    // k값을 갖는 노드를 탐색 & value 리턴
    public Value get(Key k) {
        return get(root, k);
    }

    // n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 탐색 & value 리턴
    public Value get(Node n, Key k) {
        if (n == null) return null;

        int t = n.getKey().compareTo(k);

        // 찾는 값이 k이고 t가 기준 값이다.
        if (t > 0) { // 왼쪽 서브트리 탐색
            return get(n.getLeft(), k);
        } else if (t < 0) {
            return get(n.getRight(), k);
        } else // t와 key가 같은 경우
            return (Value) n.getValue();
    }


    // key, value 가지는 새 노드 생성 & 부모와 연결
    // 이미 k존재할 경우 value 갱신
    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    public Node put(Node n, Key k, Value v){
        if(n==null) return new Node(k, v); // 기존 노드가 없을 경우 새로 생성

        int t = n.getKey().compareTo(k);

        if(t>0){
            n.setLeft(put(n.getLeft(), k, v));
        }
        else if(t<0){
            n.setRight(put(n.getRight(), k, v));
        }
        else{
            n.setValue(v);
        }

        return n;
    }
    
    // 최소값 찾기 - 왼쪽 자식 노드를 따라 내려가다 null을 만났을 때, null의 부모 노드가 가진 key를 리턴한다.
    public Key min() {
        if(root == null){
            return null;
        }

        return (Key) min(root).getKey(); // 노드를 같은 매개변수 min을 호출힌다.
    }

    private Node min(Node n){
        if(n.getLeft() == null) return n;

        return min(n.getLeft());
    }

    public void deleteMin(){
        if( root == null ){
            System.out.println("empty 트리");
        }
        root = deleteMin(root);
    }

    public Node deleteMin(Node n){
        if(n.getLeft() == null)
            return n.getRight(); // 조상이 오른쪽 자식 참조하도록 하면 저절로 삭제됨

        // 왼쪽 자식이 있을 경우
        n.setLeft(deleteMin(n.getLeft()));
        // 질문? 양쪽 자식 모두다 null일 경우?
       return n;
    }

    public void deleteMax(){
        if(root == null){
            System.out.println("empty 트리");
        }
        root = deleteMax(root);
    }

    public Node deleteMax(Node n){
        if(n.getRight() == null) return n.getLeft();

        n.setRight(deleteMax(n.getRight()));

        return n;
    }


    
    public void delete(Key k){
        root = delete(root, k);
    }

    public Node delete(Node n, Key k){ // k는 타겟 아이디이다.
        if(n==null){ return null;}

        int t = n.getKey().compareTo(k); // 가져온 노드의 키보다 타겟 키가 큰지 작은지 판별

        // 타겟 노드를 찾는 과정
        if(t>0){ //타겟가 현재 노드보다 작다면
            n.setLeft(delete(n.getLeft(), k));
        }
        else if(t<0){ //타겟가 현재 노드보다 크다면
            n.setRight(delete(n.getRight(), k));
        }

        // 타겟을 찾았을 경우(같을 경우)
        else{
            if(n.getRight() == null) // case0. 자식 노드가 없거나, case1. 왼쪽에만 노드만 있는 경우
                return n.getLeft();
            if(n.getLeft() == null ) // case1. 오른쪽에만 노드가 있는 경우
                return n.getRight();

            // 삭제될 노드를 담아준다.
            Node target = n;
            // 삭제될 노드를 대신하여 조상 노드와 연결될 자식 노드를 찾아서 n이 가리키게 함.
            // 대신할 노드는 삭제될 노드의 오른쪽 자손 중에서 가장 작은 자손이 된다. - 이진트리 구조를 유지하기 위해서
            n = min(target.getRight()); // n은 대체된 오른쪽에서 가장 작은 자손이 된다.
            n.setRight( deleteMin(target.getRight()));
            n.setLeft(target.getLeft());

        }
        return n;

    }


    public int height() {
        return height(root) + 1;
    }

    private int height(Node n){
        if(n==null) return -1;
        return 1+Math.max(height(n.getLeft()), height(n.getRight()));
    }

    public void print(Node root){
        System.out.printf("\ninorder:\n");
        inorder(root);
        System.out.printf("\npreorder:\n");
        preorder(root);
        System.out.printf("\nlevel order:\n");
        levelorder(root);

    }

    // 전위 순회
    public void preorder(Node n){
        if( n != null){
            System.out.print(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    //중위 순회
    public void inorder(Node n){
        if( n != null){
            inorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorder(n.getRight());
        }
    }

    // 레벨 순회
    public void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        Node t;

        q.add(root);
        while(!q.isEmpty()){
            t = q.remove();
            System.out.print(t.getKey() + " ");

            if(t.getLeft() != null)
                q.add(t.getLeft());
            if(t.getRight() != null)
                q.add(t.getRight());
        }
    }


}

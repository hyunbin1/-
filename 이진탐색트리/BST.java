package 이진탐색트리;
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
    
    // 최소값 찾기

    
    
    



}

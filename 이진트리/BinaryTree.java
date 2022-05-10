// 자료구조 과제 #5(60200216 김현빈)
package 이진트리;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    public BinaryTree() {root = null;}

    public Node getRoot(){return root;}
    public void setRoot(Node newRoot) {root = newRoot;}

    public boolean isEmpty(){return root == null;}

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
    // 후위 순회
    public void postorder(Node n){
        if( n != null){
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey() + " ");
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

    // 트리 노드 수 - 후위순회를 사용하여 자식부터 검사
    public int size(Node n){
        if(n==null){
            return 0;
        }
        else{
            return(1+size(n.getLeft()) + size(n.getRight() ));
        }
    }

    // 트리 높이 구하기
    public int height(Node n){
        if(n==null){
            return 0;
        }
        else{
            return (1+Math.max(height(n.getLeft()), height(n.getRight())));
        }
    }

    public static boolean isEqual(Node n, Node m){
        if(n == null || m == null){
            return n == m;
        }
        if(n.getKey().compareTo(m.getKey()) != 0){
            return false;
        }

        return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
    }

//
//    public static Node copy(Node root) {
//        if( root == null)
//            return null;
//
//        Node newNode = new Node(root.getKey(), null, null);
//        newNode.setRight(copy(root.getRight()));
//        newNode.setLeft(copy(root.getLeft()));
//
//        return newNode;
//    }
//
    // 교수님 코드
    public Node copy (Node n){
        Node left, right;

        if(n==null) { return null;}
        else{
            left = copy(n.getLeft());
            right = copy(n.getRight());
            return new Node(n.getKey(), left, right);
        }
    }
}

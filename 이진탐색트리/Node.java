//자료구조 과제 #6(60200216 김현빈)
package 이진탐색트리;

public class Node <Key extends Comparable<Key>, Value>{
    private Key id;
    private Value name;
    private Node left, right;

    public Node(Key newId, Value newName){
        id = newId;
        name = newName;
        left = right = null;
    }

    public Key getKey() {
        return id;
    }

    public void setKey(Key newId) {
        id = newId;
    }

    public Value getValue() {
        return name;
    }

    public void setValue(Value newName) {
        name = newName;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node newLeft) {
        left = newLeft;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node newRight) {
        right = newRight;
    }
}

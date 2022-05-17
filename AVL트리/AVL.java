package AVL트리;

public class AVL <Key extends Comparable<Key>, Value> {
    public Node root;

    private Node rotateRight (Node n) {
        Node x = n.left;
        n.left = x.right;
        x.right = n;

        //높이 갱신
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node n){
        Node x = n.right;
        n.right = x.left;
        x.left = n;

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    public void put(Key k, Value v) {root = put(root, k, v) ;}

    private Node put(Node n, Key k, Value v) {
        if(n==null) return new Node(k,v,1);

        int t = k.compareTo((Key) n.id);
        if( t < 0 ) n.left = put(n.left, k, v);
        else if( t > 0 ) n.right = put(n.right, k, v);
        else{
            n.name = v;
            return n;
        }
        // 본인의 높이 계산하기.
        n.height = tallerHeight(height(n.left), height(n.right) + 1);
        // 불균형 처리하기
        return balance(n);
    }

    //불균형 처리함수
    private Node balance(Node n){
        if( bf(n) > 1){
            if(bf(n.left )< 0) { // LR회전
                n.left = rotateLeft(n.left);
            }
            // LL 회전
            n = rotateRight(n);
        }
        else if(bf(n) < -1){
            if(bf(n.right )> 0) {
                // RL 회전
                n.right = rotateRight(n.right);
            }
            // RR 회전
            n = rotateLeft(n);
        }
        return n;
    }

    // 왼쪽 서브트리에서 오른쪽 서브트리 높이를 뺀다.
    // 왼쪽이 더 높을 경우 +, 오른쪽이 더 높을 경우는 -이다.
    // 같을 경우 0
    private int bf(Node n){ // bf = balance fact - 왼쪽 서브트리 높이 - 오른쪽 서브트리
        return height(n.left) - height(n.right);
    }


    public int height(Node n){
        if(n==null) return 0;
        return n.height;
    }

    private int tallerHeight( int x, int y ){
        if(x>y) return x;
        else return y;
    }
}

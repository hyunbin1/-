// 자료구조 과제 #9(60200216 김현빈)
package 해시테이블;

public class Chaining <K, V> {
    private int M = 13;
    private Node[] a = new Node[M];
    private int conflict = 0;

    public static class Node {
        private Object key;
        private Object data;
        private Node next;

        public Node(Object newkey, Object newdata, Node ref){
            key = newkey;
            data = newdata;
            next = ref;
        }
        public Object getKey() {return key;}

        public Object getData() {
            return data;
        }
    }
    private int hash(K key) { // 해시코드
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public V get(K key){
        int i = hash(key);
        for (Node x = a[i]; x != null; x=x.next){
            if(key.equals(x.key)) return (V) x.data;
        }
        return null;
    }

    private void put(K key, V data){
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next){
            if(key.equals(x.key)) {
                x.data = data;
                return;
            }
        }
        a[i] = new Node(key, data, a[i]);
    }
    public static void main(String[] args) {
        Chaining t = new Chaining<>();

        t.put(71, "71");
        t.put(23, "23");
        t.put(73, "73");
        t.put(49, "49");
        t.put(54, "54");
        t.put(89, "89");
        t.put(39, "39");

        System.out.println("충돌 횟수: " + t.conflict);
//        System.out.println("탐색 결과");
//        System.out.println("50의 data = "+t.get(50));
//        System.out.println("63의 data = "+t.get(63));
//        System.out.println("37의 data = "+t.get(37));
//        System.out.println("22의 data = "+t.get(2));
        System.out.println();

        System.out.println("해시 테이블");
        for(int i=0; i < t.M; ++i) {
            System.out.print(String.format("%2d", i));
            Node x = t.a[i];
            while(x != null){
                System.out.print("-->["+x.getKey()+", "+ x.getData()+"]");
                x = x.next;
            }
            System.out.println();
        }
//
//        for(int i=0; i < t.M; ++i) {
//            System.out.print("\t" + t.a[i]);
//        }
//        System.out.println();
    }
}

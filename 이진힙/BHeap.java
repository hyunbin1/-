//자료구조 과제 #8(60200216)
package 이진힙;

public class BHeap <Key extends Comparable<Key>, Value> {
    private Entry[] a;
    private int N;
    public BHeap(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }

    public int size() {
        return N;
    }
    private Boolean greater(int i, int j) {
        return a[j].getKey().compareTo(a[i].getKey()) < 0;
    }
    private void swap(int i, int j) {
        Entry temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void createHeap() {
        for(int i = N/2; i > 0; i--) {
            downHeap(i);
        }
    }
    public void downHeap(int i) {
        while(2*i <= N) { // 회귀아니고 반복하는 거임., // 2i = 왼쪽자식이 있는지 보는거임. 있으면 검사, 없으면 while 문 중단
            int k = 2*i; // 왼쪽 자식 설정
            if(k < N && greater(k, k+1) ) k++; // 오른쪽 자식도 있는지 확인
            if(!greater(i,k)) break;
            swap(i,k);
            i=k;
        }
    }

    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey, newValue); // 삽입할 노드
        a[++N] = temp; // 배열의 제일 마지막에 저장한다.
        upheap(N); // upheap을 하면서 알맞는 위치를 탐색한다.
    }
    private void upheap(int j){
        while( j>1 && greater(j/2, j)) { // 루트가 아닌 j 중 j/2값이 j 보다 크다면(힙속성이 잘못되어있는것 ) - 수정해야할 부분이니까
            swap(j/2, j);
            j = j/2;
        }
    }
    public Entry deleteMin(){
        Entry min = a[1]; // 부모자식관계 확실하게 하기 위해 0인덱스는 빈칸으로 두고 1을 루트로 시작한다.
        swap(1, N--);
        a[N+1] = null;
        downHeap(1);
        return min;
    }
    public void print() {
        for (int i = 1; i < N+1; i++) {
            System.out.printf("["+a[i].getKey()+"]");
        }

        System.out.println();
        System.out.printf("힙 크기 = " + size() + "\n\n");
    }
}

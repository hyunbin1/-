// 자료구조 과제 #9(60200216 김현빈)
package 해시테이블;

public class QuadraticProbing <K,V> {
    private int M = 11; // 테이블 크기
    private int N = 0; //항목 수 N
    private K[] a = (K[]) new Object[M]; // 테이블 작성
    private V[] d = (V[]) new Object[M]; // value 저장
    private int conflict = 0;
    private int hash(K key) { // 해시코드
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V data) { // 삽입메서드
        int initialPosition = hash(key);
        int i = initialPosition;
        int j = 1;

        do{
            if(a[i] == null) { // 테이블이 비어있다면 key와 value 모두 매핑(초기화)해준다
                a[i] = key;
                d[i] = data;
                N++;
                return;
            }

            if(a[i].equals(key)) { // 이미 같은 key가 있다면 데이터만 갱신한다.
                d[i] = data;
                return;
            }
            conflict++; // 충돌횟수 추가
            System.out.println("충돌 시 입력 값: "+key);
            i = (initialPosition + j++);
        } while(N < M); // 현재 u가 초기위치와 같게 되면 루프 종료
    }

    public V get(K key) { // 탐색 메서드
        int initialPosition = hash(key); // 입력받은 키의 해쉬값을 받아 처음으로 탐색할 인덱스 위치를 찾는다.
        int i = initialPosition;
        int j = 1;
        while(a[i] != null){
            if(a[i].equals(key)) return d[i];
            i = (initialPosition + (j++)*(j++)) % M; // j를 한개씩 늘리면서 탐색
        }
        return null; // 탐색 실패
    }

    public static void main(String[] args) {
        QuadraticProbing t = new QuadraticProbing<>();

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
            System.out.printf("\t%2d", i);
        }
        System.out.println();

        for(int i=0; i < t.M; ++i) {
            System.out.print("\t" + t.a[i]);
        }
        System.out.println();
    }
}

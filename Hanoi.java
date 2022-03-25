// 자료구조 과제 #1 60200216 김현빈
import java.util.Scanner;

public class Hanoi {

    static int count = 0; // 이동횟수
    public static StringBuilder sb = new StringBuilder();


    // from에 꽂혀있는 num개의 원반을 by를 거쳐 to로 이동한다.
    public static void moveDisk(int diskNumber, char start, char by, char end) {
        ++count;
        if(diskNumber == 1) { // 원판 개수 1개일 경우
            System.out.println("원판 "+ diskNumber +"을 " + start + "에서 " + end + "로 이동");
        } else {
            moveDisk(diskNumber-1, start, end, by);
            System.out.println("원판 "+ diskNumber +"을 " + start + "에서 " + end + "로 이동");
            moveDisk(diskNumber-1, by, start, end);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int diskNumber = sc.nextInt(); // 원판 개수
        int diskNumber3 = 3; // 원판 3개일 경우
        int diskNumber4 = 4; // 원판 4개일 경우
        System.out.println("원판이 "+diskNumber3+"개인 경우");
        System.out.println("(원반 이름: 크기가 작은-큰 순서 1-2-3"+"\n");
        moveDisk(diskNumber3, 'A', 'B', 'C');
        System.out.println("\n"+"원판이 "+diskNumber4+"개인 경우");
        System.out.println("(원반 이름: 크기가 작은-큰 순서 1-2-3"+"\n");
        moveDisk(diskNumber4, 'A', 'B', 'C');
        System.out.println(sb);
    }
}
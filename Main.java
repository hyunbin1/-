// 자료구조 과제 #2 (60200216 김현빈)
public class Main {
	public static void main(String[] args) {


		ArrList<String> s = new ArrList<>();

		s.insertLast("apple"); s.print();
		s.insertLast("orange"); s.print();
		s.insertLast("cherry"); s.print();
		s.insertLast("peer"); s.print();
		s.insert("grape", 1); s.print();
		s.insert("lemon", 4); s.print();
		s.insertLast("kiwi"); s.print();

		s.delete(4); s.print();
		s.delete(0); s.print();
		s.delete(0); s.print();
		s.delete(3); s.print();
		s.delete(0); s.print();

		System.out.println("1번째 항목은 " + s.peek(1) + "이다.");
		System.out.println();



		SList<Integer> sortedList1 = new SList<Integer>();
		SList<Integer> sortedList2 = new SList<Integer>();

		// sortedList1 초기화
		System.out.print("Sorted List 1: ");
		sortedList1.insertFront(50);
		sortedList1.insertFront(40);
		sortedList1.insertFront(30);
		sortedList1.insertFront(20);
		sortedList1.insertFront(10);
		sortedList1.print();

		// sortedList2 초기화
		System.out.print("Sorted List 2: ");
		sortedList2.insertFront(55);
		sortedList2.insertFront(37);
		sortedList2.insertFront(35);
		sortedList2.insertFront(18);
		sortedList2.insertFront(15);
		sortedList2.print();

		// Merged List [연습문제 2.17]
		System.out.print("Merged List:   ");
		sortedList1.mergedLists(sortedList1.head, sortedList2.head);
		sortedList1.print();

		// Separation based on K
		SList<Integer> singleList = new SList<>();
		int k = 20;
		singleList.insertFront(45);
		singleList.insertFront(17);
		singleList.insertFront(20);
		singleList.insertFront(50);
		singleList.insertFront(57);
		singleList.insertFront(35);
		singleList.insertFront(10);
		singleList.insertFront(15);
		singleList.insertFront(90);
		singleList.insertFront(10);
		SList<Integer> list1 = new SList<>();
		SList<Integer> list2 = new SList<>();
		System.out.println("--------------------");
		System.out.println();


		System.out.print("Single List: "); singleList.print();
		System.out.println("k="+k+"을 기준으로 두 개의 리스트로 분리:");
		singleList.splitList(singleList.head, k, list1, list2);
		System.out.print("List 1(<= 20): "); singleList.print();
		System.out.print("List 2(>20):   ");list2.print();
		System.out.println();
	}
}

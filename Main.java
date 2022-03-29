// 자료구조 과제 #2 (60200216 김현빈)
public class Main {
	public static void main(String[] args) {

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
		
		// Merged List 
		System.out.print("Merged List:   ");
		sortedList1.mergedLists(sortedList1.head, sortedList2.head);
		sortedList1.print();
		}
}

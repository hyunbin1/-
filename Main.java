
public class Main {
	public static void main(String[] args) {

		SList<Integer> sortedList1 = new SList<Integer>();
		SList<Integer> sortedList2 = new SList<Integer>();
		SList<Integer> mergedList = new SList<Integer>();
		
		// sortedList1 초기화
		System.out.print("Sorted List 1: ");
		sortedList1.insertFront(20);
		sortedList1.insertFront(10);
		sortedList1.insertAfter(30, sortedList1.head.getNext());
		sortedList1.insertAfter(40, sortedList1.head.getNext());
		sortedList1.insertAfter(50, sortedList1.head.getNext());
		sortedList1.print();		
		
		// sortedList2 초기화
		System.out.print("Sorted List 2: ");
		sortedList2.insertFront(18);
		sortedList2.insertFront(15);
		sortedList2.insertAfter(35, sortedList2.head.getNext());
		sortedList2.insertAfter(37, sortedList2.head.getNext());
		sortedList2.insertAfter(55, sortedList2.head.getNext());
		sortedList2.print();		
		
		// Merged List 
		System.out.print("Merged List:   ");
		int mergedListSize = sortedList1.size()+sortedList2.size();
		while(mergedListSize < 0){
			mergedListSize--;
			if(sortedList1.compareTo(sortedList2)) {

			}

		}
		System.out.print(sortedList1.head.getNext().getItem());

		


	}

}

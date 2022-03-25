public class MyString {
	private char[] content;   // 실제 내용을 담을 배열 변수
	
	// immutable은 생성자 이외에는 내용물을 설정하는 방법이 없다.
	public MyString() {
		// 길이가 0 인 배열을 할당.
		this.content = new char[0];

	}
	public MyString(char[] carray) {
		this.content = carray;

	}
	public MyString(String s) {
		this.content = s.toCharArray();

	}
	public int length() {
		int contentLength = content.length;
		return contentLength;
	}

	public String toString() {
		// String 클래스의 생성자 중 적당한 것을 찾아서 활용
		// 이 함수가 있어야 println을 사용할 수 있다.
		String stringContent = "";
		for(int i = 0; i <stringContent.length(); i++){
			stringContent += content[i];
		}


		return stringContent;
	}
//
//	public boolean equals(String s) {
//
//	}
//	public boolean equals(MyString s) {
//
//	}
//	public char charAt(int n) throws IndexOutOfBoundsException{
//		// 특정 위치의 char 를 둘려주는 함수
//	}
//	public static MyString add(MyString a, MyString b) {
//
//	}
//	public int indexOf(char c) {
//		// 문자열에서 문자 c의 위치를 알려준다. 없으면 -1
//	}
//	public int indexOf(String s) {
//		// s 가 포함되어 있는 경우 위치를 돌려준다.
//		// 없으면 -1
//		// 아래의 보조 함수 isSubstr을 사용하면 편리하다.
//		// 그러면 여기서는 반복문만 돌리면 된다.
//	}
//
//	public boolean isSubstr(int index, String s) {
//		// content의 특정 위치부터가 s와 같은지 판별하는 함수
//
//	}
//
//	public MyString substring(int begin, int end) {
//		// 스트링의 일부를 추출해서 MyString으로 만들어 주는 함수.
//
//
//
//	}
}

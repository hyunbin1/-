// 자료구조 과제 #3 (60200216 김현빈)
public class Main {
	public static void main(String[] args) {
		String str1 = "{{(){()}}}";
		String str2 = "{{(){()})()}";
		isBracketSet(str1);
		isBracketSet(str2);


	}

	public static void isBracketSet(String str){
		ListStack<String> stack = new ListStack<>();
		boolean isSet = true;
		for(int i =0; i<str.length(); i++){

			if(str.charAt(i)=='{'){
				stack.push("{");
			}

			else if(str.charAt(i)=='('){
				stack.push("(");
				if(str.charAt(i+1)==')'){
					stack.pop();
					i++;
				}else{
					System.out.println(i+1+"번 째 문자 "+str.charAt(i)+"에서 짝이 맞지 않는다. ");
					isSet = false;
				}
			}

			else if(str.charAt(i)== '}'){
				if(stack.peek()=="{"){
					stack.pop();
				}
			}
			else{
				System.out.println(i+1+"번 째 문자 "+str.charAt(i)+"에서 짝이 맞지 않는다. ");
				isSet = false;
			}
		}
		if(isSet==true)
			System.out.println("괄호 짝이 맞다");
	}


}

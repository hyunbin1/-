package 후위표기법;
// 자료구조 과제 #4(60200216 김현빈)

public class Main {
    public static void main(String[] args) {
        String input1 = "A-B+C/D";
        String input2 = "A/B-C*D";
        String input3 = "A-B*C+D/E-F";
        String input4 = "(A-B)*C-(D/(E+F))";

        test(input1);
        test(input2);
        test(input3);
        test(input4);
    }

    public static void test(String str) {
        ListStack<Character> stack = new ListStack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch(ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)){ // 스택이 비어있지 않고 우선순위 보다 현재가 더 높음
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;

                default:
                    sb.append(ch);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    public static int priority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;

        }
        return -1;
    }



}

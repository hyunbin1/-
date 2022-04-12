package 후위표기법;

public class Main {
    public static void main(String[] args) {
        String input1 = "A-B+C/D";
        String input2 = "A/B-C*D";
        String input3 = "A-B*C+D/E-F";
        String input4 = "(A-B)*C-(D/(E+F))";

        test(input1);
    }

    public static void test(String str) {
        ListStack<String> stack = new ListStack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch(ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(String.valueOf(ch))){
                        stack.pop();
                    }
                    stack.push(String.valueOf(ch));
                    break;
                case '(':
                    stack.push(String.valueOf(ch));
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != "("){
                        stack.pop();
                    }
                    stack.pop();
                default:
                    stack.push(String.valueOf(ch));

            }
            while(!stack.isEmpty()){
                stack.pop();
            }
            stack.print();


        }
    }

    public static int priority(String operator) {
        if (operator == "(" || operator == ")") {
            return 0;
        } else if (operator == "+" || operator == "-") {
            return 1;
        } else if (operator == "*" || operator == "/") {
            return 2;

        }
        return -1;
    }



}

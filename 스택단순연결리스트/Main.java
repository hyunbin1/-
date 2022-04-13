package 스택단순연결리스트;

import 스택배열.ArrayStack;

public class Main {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();

        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        stack.print();

        System.out.println(stack.peek());
        stack.push("pear");
        stack.print();

        stack.pop();
        stack.print();

        System.out.println(stack.peek());
        stack.push("grape");
        stack.print();


    }
}

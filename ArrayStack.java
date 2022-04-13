import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E s[];
    private int top;

    public ArrayStack(){
        s = (E[]) new Object[1]; // 초기 크기가 1인 배열 생성
        top = -1; // 빈배열임을 의미
    }
    public boolean isEmpty() {
        return top == -1; // top이 -1일경우 빈배열임
    }
    public int size(){
        return top+1;
    }
    public void resize(int newSize){
        Object[] t = new Object[newSize];

        for (int i =0; i<size(); i++){
            t[i] = s[i];
        }

        s= (E[]) t;
    }

    //peek, push, pop
    public E peek(){
        if(isEmpty()) throw new EmptyStackException();
        return s[top]; // 가장 위에 있는 스택 아이템을 리턴
    }

    public void push(E newItem){
        if(size() == s.length){
            resize(2*s.length);
        }
        s[++top] = newItem; // top에는 이미 아이템이 있으니까 1증가 시킨후에 새로운 아이템을 넣는다.
    }

    public E pop() {
        if(isEmpty()) throw new EmptyStackException();

        E item = s[top];
        s[top--] = null; // top을 null로 만들어 준 후에 top을 하나 감소시킨다.

        if(size() > 0 && size()==s.length/4)
            resize(s.length/2);

        return item;
    }

    public void print(){
        if(isEmpty()) System.out.print("스택이 비어있음.");
        else{
            for (int i =0; i<size(); i++){
                System.out.println(s[i]+"\t ");
            }
        }
        System.out.println();
    }
}





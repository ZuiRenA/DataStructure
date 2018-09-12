package JavaPractice.Stack;

public class stack {
    public static void main(String[] args){
        StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.println(value);
        }
    }

}

class StackX{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int s){
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long l){
        stackArray[++top] = l;
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }

}

package JavaPractice.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class postfix {
    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while (true){
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();

            if (input.equals("")){
                break;
            }

            ParsePost aParse = new ParsePost(input);
            output = aParse.doParse();

            System.out.println("Evaluates to: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

class StackXFive{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackXFive(int i){
        maxSize = i;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j){
        stackArray[++top] = j;
    }

    public int pop(){
        return stackArray[top--];
    }

    public int peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize);
    }

    public int size(){
        return top + 1;
    }

    public int peekN(int n){
        return stackArray[n];
    }

    public void diaplayStack(String s){
        System.out.print(s);
        System.out.print("Stack(bottom --> top):");

        for (int j = 0; j < size(); j++){
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println();
    }
}

class ParsePost{
    private StackXFive theStack;
    private String input;

    public ParsePost(String s){
        input = s;
    }

    public int doParse(){
        theStack = new StackXFive(20);
        char ch;
        int i;
        int num1,num2,interAns;

        for (i = 0; i < input.length(); i++){
            ch = input.charAt(i);
            theStack.diaplayStack("" + ch +" ");
            if (ch >= '0' && ch <= '9'){
                theStack.push(ch - '0');
            }else {
                num2 = theStack.pop();
                num1 = theStack.pop();

                switch (ch){
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                        break;
                }

                theStack.push(interAns);
            }
        }

        interAns = theStack.pop();
        return interAns;
    }
}

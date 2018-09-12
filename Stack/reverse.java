package JavaPractice.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverse {
    public static void main(String[] args) throws IOException {
        String input,output;

        while (true){
            System.out.print("Enter a word: ");
            System.out.flush();
            input = getString();

            if (input.equals("")){
                break;
            }

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();

            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

class StackXT{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackXT(int s){
        maxSize = s;
        stackArray = new char[s];
        top = -1;
    }

    public void push(char c){
        stackArray[++top] = c;
    }

    public char pop(){
        return stackArray[top--];
    }

    public char peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }
}

class Reverser{
    private String input;
    private String output;

    public Reverser(String s){
        input = s;
    }

    public String doRev(){
        int stackSize = input.length();
        StackXT theStack = new StackXT(stackSize);

        for (int i = 0; i < stackSize; i++){
            char ch = input.charAt(i);
            theStack.push(ch);
        }

        output = "";
        while (!theStack.isEmpty()){
            char ch = theStack.pop();
            output = output + ch;
        }

        return output;
    }
}

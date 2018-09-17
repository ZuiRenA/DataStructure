package JavaPractice.Recursion;

import java.io.IOException;
import java.util.Scanner;

public class stackTriangle2 {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;

    public static class StackX{
        private int maxSize;
        private int[] stackArray;
        private int top;

        StackX(int s){
            maxSize = s;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int p){
            stackArray[++ top] = p;
        }

        public int pop(){
            return stackArray[top --];
        }

        public int peek(){
            return stackArray[top];
        }

        public boolean isEmpty(){
            return (top == -1);
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.print("请输入一个数字:");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    public static int getInt() throws IOException {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("请重新输入数字");
            Scanner inputAgain = new Scanner(System.in);

            if (inputAgain.hasNextInt()){
                input = inputAgain;
            }
        }

        int num = input.nextInt();
        return num;
    }

    public static void stackTriangle(){
        theStack = new StackX(10000);
        theAnswer = 0;


        while (theNumber > 0){
            theStack.push(theNumber);
            -- theNumber;
        }

        while (!theStack.isEmpty()){
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }
}

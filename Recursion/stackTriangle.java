package JavaPractice.Recursion;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.util.Scanner;

public class stackTriangle {
    static int theNumber;
    static int theAnswer;
    static StackXX theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) throws IOException {
        System.out.print("请输入一个数字 ");
        theNumber = getInt();
        recTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    private static void recTriangle() {
        theStack = new StackXX(10000);
        codePart = 1;
        while (step() == false){

        }
    }

    private static boolean step() {
        switch (codePart){
            case 1:
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = theStack.peek();

                if (theseParams.n == 1){
                    theAnswer = 1;
                    codePart = 5;
                }else {
                    codePart = 3;
                }

                break;
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2;
                break;
            case 4:
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress;
                theStack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }

    public static class Params{
        public int n;
        public int returnAddress;

        public Params(int nn, int ra){
            n = nn;
            returnAddress = ra;
        }
    }

    public static class StackXX{
        private int maxSize;
        private Params[] stackArray;
        private int top;

        public StackXX(int s){
            maxSize = s;
            stackArray = new Params[maxSize];
            top = -1;
        }

        public void push(Params p){
            stackArray[++ top] = p;
        }

        public Params pop(){
            return stackArray[top --];
        }

        public Params peek() {
            return stackArray[top];
        }
    }

    private static int getInt() throws IOException{
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("请重新输入数字:");
            Scanner inputAgain = new Scanner(System.in);

            if (inputAgain.hasNextInt()){
                input = inputAgain;
            }
        }

        int num = input.nextInt();
        return num;
    }
}
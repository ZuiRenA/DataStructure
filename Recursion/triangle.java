package JavaPractice.Recursion;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class triangle {
    static int theNumner;

    public static void main(String[] args) throws IOException {
        System.out.print("输入一个数字: ");
        int num = getInt();
        int theAnswer = triangle(num);
        System.out.println("Triangele = " + theAnswer);
    }

    public static int triangle(int n){
        if (n == 1){
            return 1;
        }else {
            return (n + triangle(n-1));
        }
    }

    public static int getInt(){
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()){
            System.out.print("请重新输入: ");
            Scanner inputAgain = new Scanner(System.in);

            if (inputAgain.hasNextInt()){
                input = inputAgain;
            }
        }

        int num = input.nextInt();
        return num;
    }
}

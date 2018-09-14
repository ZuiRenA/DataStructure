package JavaPractice.Recursion;

import java.io.IOException;
import java.util.Scanner;

public class anagram {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("请输入一个单词: ");
        String word = getString();
        size = word.length();
        count = 0;

        for (int i = 0; i < size; i++){
            arrChar[i] = word.charAt(i);
        }

        doAnagram(size);
    }

    private static void doAnagram(int newSize) {
        
        if (newSize == 1){
            return;
        }

        for (int i = 0; i < newSize; i++){
            doAnagram(newSize - 1);
            
            if (newSize == 2){
                displayWord();
            }
            
            rotate(newSize);
        }
    }

    private static void rotate(int newSize) {
        int i;
        int position = size - newSize;
        char temp = arrChar[position];

        for (i = position + 1; i < size; i++){
            arrChar[i-1] = arrChar[i];
        }

        arrChar[i-1] = temp;
    }

    private static void displayWord() {
        int a = count/10;

        switch (a){
            case 1:
                System.out.print(" ");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.print(" ");
        }

        System.out.print(++count + " ");

        for (int i = 0; i < size; i++){
            System.out.print(arrChar[i]);
        }

        System.out.print("   ");
        System.out.flush();

        if (count%6 == 0){
            System.out.println("");
        }
    }

    public static String getString() throws IOException {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        return str;
    }

}

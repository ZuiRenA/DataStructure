package JavaPractice.heap;

import java.util.Scanner;

public class heapSort {
    static class Node{
        private int iData;

        public Node(int key){ iData = key;}

        public int getKey(){return iData;}
    }
    
    static class Heap{
        private Node[] heapArray;
        private int maxSize;
        private int currentSize;
        
        public Heap(int max){
            maxSize = max;
            heapArray = new Node[maxSize];
            currentSize = 0;
        }
        
        public Node remove(){
            Node root = heapArray[0];
            heapArray[0] = heapArray[--currentSize];
            trickleDown(0);
            return root;
        }

        private void trickleDown(int index) {
            int largerChild;
            Node top = heapArray[index];

            while (index < currentSize / 2){
                int leftChild = 2 * index + 1;
                int rightChild = leftChild + 1;

                if (rightChild < currentSize &&
                        heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                    largerChild = rightChild;
                else
                    largerChild = leftChild;

                if (top.getKey() >= heapArray[largerChild].getKey())
                    break;

                heapArray[index] = heapArray[largerChild];
                index = largerChild;
            }
        }

        public void displayHeap(){
            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0;
            String dots = "..................................";
            System.out.println(dots + dots);

            while (currentSize > 0){
                if (column == 0){
                    for (int i = 0; i < nBlanks; i++){
                        System.out.print(' ');
                    }
                }

                System.out.print(heapArray[j].getKey());

                if (++j == currentSize)
                    break;

                if (++column == itemsPerRow){
                    nBlanks /= 2;
                    itemsPerRow *= 2;
                    column = 0;
                    System.out.println();
                }else {
                    for (int i = 0; i < nBlanks * 2 - 2; i++){
                        System.out.print(' ');
                    }
                }
            }

            System.out.println("\n" + dots + dots);
        }

        public void displayArray(){
            for (int i = 0; i < maxSize; i++){
                System.out.print(heapArray[i] + " ");
            }

            System.out.println();
        }

        public void insertAt(int index, Node newNode){
            heapArray[index] = newNode;
        }

        public void incrementSize(){currentSize++;}
    }

    public static void main(String[] args){
        int size, j;
        System.out.print("输入items数量: ");
        size = getInt();
        Heap theHeap = new Heap(size);

        for (j = 0; j < size; j++){
            int n = (int)(java.lang.Math.random() * 100);
            Node newNode = new Node(n);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }

        System.out.print("Random: ");
        theHeap.displayArray();

        for (j = size / 2 - 1; j >= 0; j--)
            theHeap.trickleDown(j);

        System.out.print("Heap:  ");
        theHeap.displayArray();
        theHeap.displayHeap();

        for (j = size - 1; j >= 0; j--){
            Node biggestNode = theHeap.remove();
            theHeap.insertAt(j, biggestNode);
        }

        System.out.println("Sorted: ");
        theHeap.displayArray();
    }


    public static String getString(){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        return s;
    }

    public static char getChar(){
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt(){
        String s = getString();
        return Integer.parseInt(s);
    }
    

}

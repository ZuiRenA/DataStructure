package JavaPractice.heap;

import java.util.Scanner;

public class heap {
    static class Node{
        private int iData;

        Node(int key){
            iData = key;
        }

        public int getKey(){
            return iData;
        }

        public void setKey(int id){
            iData = id;
        }
    }

    static class Heap{
        private Node[] heapArray;
        private int maxSize;
        private int currentSize;

        public Heap(int max){
            maxSize = max;
            currentSize = 0;
            heapArray = new Node[maxSize];
        }

        public boolean isEmpty(){
            return (currentSize == 0);
        }

        public boolean insert(int key){
            if (currentSize == maxSize)
                return false;
            Node newNode = new Node(key);
            heapArray[currentSize] = newNode;
            trickleUp(currentSize++);
            return true;
        }

        private void trickleUp(int index) {
            int parent = (index - 1) / 2;
            Node bottom = heapArray[index];

            while (index > 0 &&
                    heapArray[parent].getKey() < bottom.getKey()){
                heapArray[index] = heapArray[parent];
                index = parent;
                parent = (parent - 1) / 2;
            }

            heapArray[index] = bottom;
        }

        public Node remove(){
            Node root = heapArray[0];
            heapArray[0] = heapArray[--currentSize];
            trickDown(0);
            return root;
        }

        private void trickDown(int index) {
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
            heapArray[index] = top;
        }

        public boolean change(int index, int newValue){

            if (index < 0 || index >= currentSize)
                return false;

            int oldValue = heapArray[index].getKey();
            heapArray[index].setKey(newValue);

            if (oldValue < newValue)
                trickleUp(index);
            else
                trickDown(index);

            return true;
        }

        public void displayHeap(){
            System.out.print("heapArray: ");

            for (int i = 0; i < currentSize; i++){
                if (heapArray[i] != null)
                    System.out.print(heapArray[i].getKey() + " ");
                else
                    System.out.print("-- ");
            }

            System.out.println();

            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0;
            String dots = "...........................";
            System.out.println(dots + dots);

            while (currentSize > 0){
                for (int a = 0; a < nBlanks; a++){
                    System.out.print(' ');
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
                    for (int b = 0; b < nBlanks * 2 - 2; b++){
                        System.out.print(' ');
                    }
                }

                System.out.println("\n" + dots + dots);
            }
        }
    }

    public static void main(String[] args){
        int value, value2;
        Heap theHeap = new Heap(31);
        boolean success;

        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        while (true){
            System.out.print("Enter first letter of show, insert, remove, change: ");
            int choice = getChar();
            switch (choice){
                case 's':
                    theHeap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    success = theHeap.insert(value);

                    if (!success)
                        System.out.println("插入失败");
                    break;
                case 'r':
                    if (!theHeap.isEmpty())
                        theHeap.remove();
                    else
                        System.out.println("删除失败，已为空");
                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    value = getInt();
                    System.out.print("Enter new key: ");
                    value2 = getInt();
                    success = theHeap.change(value, value2);

                    if (!success)
                        System.out.println("换位失败");
                    break;

                default:
                    System.out.println("请重试");
            }
        }
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

package JavaPractice.hash;

import java.util.Scanner;

public class hashChain {

    static class Link{
        private int iData;
        public Link next;

        public Link(int id){
            iData = id;
        }

        public int getKey(){
            return iData;
        }

        public void displayLink(){
            System.out.print(iData + " ");
        }
    }

    static class SortedList{
        private Link first;

        public void SortedList(){
            first = null;
        }

        public void insert(Link theLink){
            int key = theLink.getKey();
            Link previous = null;
            Link current = first;

            while ((current != null) && (key > current.getKey())){
                previous = current;
                current = current.next;
            }

            if (previous == null)
                first = theLink;
            else
                previous.next = theLink;

            theLink.next = current;
        }

        public void delete(int key){
            Link previous = null;
            Link current = first;

            while ((current != null) && (key != current.getKey())){
                previous = current;
                current = current.next;
            }

            if (previous == null)
                first = first.next;
            else
                previous.next = current.next;
        }

        public Link find(int key){
            Link current = first;

            while ((current != null) && (key <= current.getKey())){
                if (current.getKey() == key)
                    return current;

                current = current.next;
            }
            return null;
        }

        public void displayList(){
            System.out.print("List (first --> last): ");
            Link current = first;

            while (current != null){
                current.displayLink();
                current = current.next;
            }

            System.out.println("");
        }
    }

    static class HashTable{
        private SortedList[] hashArray;
        private int arraySize;

        HashTable(int size){
            arraySize = size;
            hashArray = new SortedList[arraySize];

            for (int i = 0; i < arraySize; i++){
                hashArray[i] = new SortedList();
            }
        }

        public void displayTable(){
            for (int i = 0; i < arraySize; i++){
                System.out.print(i + ".");
                hashArray[i].displayList();
            }
        }

        public int hashFunc(int key){
            return key % arraySize;
        }

        public void insert(Link theLink){
            int key = theLink.getKey();
            int hashVal = hashFunc(key);
            hashArray[hashVal].insert(theLink);
        }

        public void delete(int key){
            int hashVal = hashFunc(key);
            hashArray[hashVal].delete(key);
        }

        public Link find(int key){
            int hashVal = hashFunc(key);
            Link theLink = hashArray[hashVal].find(key);
            return theLink;
        }
    }

    public static void main(String[] args){
        Link aDataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTable theHashTable = new HashTable(size);

        for (int i = 0; i < n; i++){
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }

        while (true){
            System.out.println("Enter first letter of show, insert, delete, or find: ");
            char choice = getChar();

            switch (choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);

                    if (aDataItem != null)
                        System.out.println("Found" + aKey);
                    else
                        System.out.println("Can't find " + aKey);

                    break;
                default:
                    System.out.println("Invalid entry");

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

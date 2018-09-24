package JavaPractice.hash;

import java.util.Scanner;

public class hashDouble {

    static class DataItem{
        private int iData;

        public DataItem(int id){
            iData = id;
        }

        public int getkey(){return iData;}
    }

    static class HashTable{
        private DataItem[] hashArray;
        private int arraySize;
        private DataItem nonItem;

        HashTable(int size){
            arraySize = size;
            hashArray = new DataItem[arraySize];
            nonItem = new DataItem(-1);
        }

        public void displayTable(){
            System.out.print("Table: ");

            for (int i = 0; i < arraySize; i++){
                if (hashArray[i] != null)
                    System.out.print(hashArray[i].getkey() + " ");
                else
                    System.out.print("**");
            }

            System.out.println();
        }

        public int hashFunc1(int key){
            return key % arraySize;
        }

        public int hashFunc2(int key){
            return 5 - key & 5;
        }

        public void insert(int key, DataItem item){
            int hashVal = hashFunc1(key);
            int stepSize = hashFunc2(key);

            while ((hashArray[hashVal] != null) &&
                    (hashArray[hashVal].getkey() != -1)){

                hashVal += stepSize;
                hashVal %= arraySize;
            }

            hashArray[hashVal] = item;
        }

        public DataItem delete(int key){
            int hashVal = hashFunc1(key);
            int stepSize = hashFunc2(key);

            while (hashArray[hashVal] != null){
                if (hashArray[hashVal].getkey() == key){
                    DataItem temp = hashArray[hashVal];
                    hashArray[hashVal] = nonItem;
                    return temp;
                }

                hashVal += stepSize;
                hashVal %= arraySize;
            }

            return null;
        }

        public DataItem find(int key){
            int hashVal = hashFunc1(key);
            int stepSize = hashFunc2(key);

            while (hashArray[hashVal] != null){
                if (hashArray[hashVal].getkey() == key)
                    return hashArray[hashVal];

                hashVal += stepSize;
                hashVal %= arraySize;
            }

            return null;
        }
    }

    public static void main(String[] args){
        hash.DataItem aDataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        hash.HashTable theHashTable = new hash.HashTable(size);

        for (int i = 0; i < n; i++){
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new hash.DataItem(aKey);
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
                    aDataItem = new hash.DataItem(aKey);
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

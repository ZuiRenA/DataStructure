package JavaPractice.AdvancedSorting;

public class quickSort {

    public static class ArrayIns{
        private int[] theArray;
        private int nElems;

        public ArrayIns(int max){
            theArray = new int[max];
            nElems = 0;
        }

        public void insert(int value){
            theArray[nElems] = value;
            nElems ++;
        }

        public void display(){
            System.out.print("A = ");

            for (int i = 0; i < nElems; i++){
                System.out.print(theArray[i] + " ");
            }
            System.out.println();
        }

        public void quickSort(int[] array,int left, int right){
            if (left < right) {
                int base = array[right];
                int temp;
                int leftPtr = left, rightPtr = right;
                do {
                    while ((array[leftPtr] < base) && (leftPtr < right))
                        leftPtr++;

                    while ((array[rightPtr] > base) && (rightPtr > left))
                        rightPtr--;

                    if (leftPtr <= rightPtr) {
                        temp = array[leftPtr];
                        array[leftPtr] = array[rightPtr];
                        array[rightPtr] = temp;
                        leftPtr++;
                        rightPtr--;
                    }

                } while (leftPtr <= rightPtr);
                if (left < rightPtr)
                    quickSort(array, left, rightPtr);
                if (right > leftPtr)
                    quickSort(array, leftPtr, right);
            }
        }

        public void quickSortCall(){
            quickSort(theArray, 0, nElems - 1);
        }

    }

    public static void main(String[] args){
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);

        for (int i = 0; i < maxSize; i++){
            int n = (int)(java.lang.Math.random() * 99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSortCall();
        arr.display();
    }


}

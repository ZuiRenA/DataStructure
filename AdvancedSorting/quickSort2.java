package JavaPractice.AdvancedSorting;

public class quickSort2 {

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
            for (int i = 0; i < nElems; i++){
                System.out.print(theArray[i] + " ");
            }

            System.out.println();
        }

        public void quickSort(){
            recQuickSort(theArray, 0, nElems - 1);
        }

        private void recQuickSort(int[] array,int left, int right) {
            if (left < right){
                int pivot = medianOfThree(left,right);
                int leftPtr = left, rightPtr = right;

                do {
                    while ((array[leftPtr] < pivot) && (leftPtr < right)){
                        leftPtr ++;
                    }

                    while ((array[rightPtr] > pivot) && (rightPtr > left)){
                        rightPtr --;
                    }

                    if (leftPtr <= rightPtr){
                        swap(leftPtr,rightPtr);
                        leftPtr ++;
                        rightPtr --;
                    }
                }while (leftPtr <= rightPtr);

                if (left < rightPtr)
                    recQuickSort(array, left, rightPtr);
                if (right > leftPtr)
                    recQuickSort(array, leftPtr, right);
            }
        }

        private int medianOfThree(int left, int right) {
            int center = (left + right) / 2;
            
            if (theArray[left] > theArray[right]) {
                swap(left, center);
            }

            if (theArray[center] > theArray[right]){
                swap(center, right);
            }

            swap(center,right - 1);
            return theArray[right-1];
        }

        private void swap(int num1, int num2) {
            int temp = theArray[num1];
            theArray[num1] = theArray[num2];
            theArray[num2] = temp;
        }

    }

    public static void main(String[] args){
        int maxSize = 16;
        ArrayIns arr = new ArrayIns(maxSize);

        for (int i = 0; i < maxSize; i++){
            int n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}

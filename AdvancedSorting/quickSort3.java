package JavaPractice.AdvancedSorting;

public class quickSort3 {

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
            recQuickSort(0, nElems - 1);
        }

        private void recQuickSort( int left, int right) {
            int size = right - left + 1;

            if (left < right){
                if (size >= 10){
                    int pivot = medianOfThree(left, right);
                    int leftPtr = left, rightPtr = right;

                    do {

                        while ((theArray[leftPtr] < pivot) && (leftPtr < right)){
                            leftPtr ++;
                        }

                        while ((theArray[rightPtr] > pivot) && (rightPtr > left)) {
                            rightPtr --;
                        }

                        if (leftPtr <= rightPtr){
                            swap(leftPtr,rightPtr);
                            leftPtr ++;
                            rightPtr --;
                        }

                    }while (leftPtr <= rightPtr);

                    if (left < rightPtr){
                        recQuickSort(left,rightPtr);
                    }

                    if (right > leftPtr){
                        recQuickSort(right,leftPtr);
                    }

                }else {
                    insertionSort(left, right);
                }
            }
        }

        private void insertionSort(int left, int right){
            int in, out;

            for (out = left + 1; out < right; out++){
                int temp = theArray[out];
                in = out;

                while ((in > left) && (theArray[in-1] > temp)){
                    theArray[in] = theArray[in-1];
                    -- in;
                }

                theArray[in] = temp;
            }
        }

        private int medianOfThree(int left,int right){
            int center = (left + right) / 2;

            if (theArray[left] > theArray[center]){
                swap(left,center);
            }

            if (theArray[left] > theArray[right]){
                swap(left,right);
            }

            if (theArray[center] > theArray[right]){
                swap(center,right);
            }

            swap(center, right - 1);
            return theArray[right - 1];
        }

        private void swap(int left, int right){
            int temp = theArray[left];
            theArray[left] = theArray[right];
            theArray[right] = temp;
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

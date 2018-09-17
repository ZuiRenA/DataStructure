package JavaPractice.Recursion;

public class mergeSort {

    public static class DArray{
        private long[] theArray;
        private int nElems;

        public DArray(int max){
            theArray = new long[max];
            nElems = 0;
        }

        public void insert(long value){
            theArray[nElems] = value;
            nElems ++;
        }

        public void display(){
            for (int i = 0; i < nElems; i++){
                System.out.print(theArray[i] + " ");
            }

            System.out.println();
        }

        public void mergeSort(){
            long[] workSpace = new long[nElems];
            recMergeSort(workSpace,0,nElems - 1);
        }

        public void recMergeSort(long[] workSpace, int lowerBound, int upperBound){

            if (lowerBound == upperBound){
                return;
            }else {
                int mid = (lowerBound + upperBound) / 2;

                recMergeSort(workSpace, lowerBound, mid);
                recMergeSort(workSpace, mid + 1, upperBound);

                merge(workSpace, lowerBound , mid + 1, upperBound);
            }
        }

        public void merge(long[] workSpace, int lowPtr,
                          int highPtr, int upperBound){
            int i = 0;
            int lowerBound = lowPtr;
            int mid = highPtr - 1;
            int n = upperBound - lowerBound + 1;

            while (lowPtr <= mid && highPtr <= upperBound){

                if (theArray[lowPtr] < theArray[highPtr]){
                    workSpace[i ++] = theArray[lowPtr ++];
                }else {
                    workSpace[i ++] = theArray[highPtr ++];
                }
            }

            while (lowPtr <= mid){
                workSpace[i ++] = theArray[lowPtr ++];
            }

            while (highPtr <= upperBound){
                workSpace[i ++] = theArray[highPtr ++];
            }

            for (i = 0; i < n; i++){
                theArray[lowerBound + i] = workSpace[i];
            }
        }
    }

    public static void main(String[] args){
        int maxSize = 100;
        DArray arr = new DArray(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display();

        arr.mergeSort();
        System.out.print("使用递归进行归并排序: ");
        arr.display();
    }
}

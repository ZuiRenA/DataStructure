package JavaPractice.SimpleSorts;

public class insertSort {
    public static void main(String[] args){
        int maxSize = 10000;
        ArrayIns arr = new ArrayIns(maxSize);
        /*
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);

        arr.display();

        System.out.println("进行插入排序");

        arr.insertionSort();
        arr.display();
        */
        /*
        for (int i = 0; i < maxSize; i++){
            long n = (long)(java.lang.Math.random()*(maxSize - 1));
            arr.insert(n);
        }

        arr.insertionSort();
        */
        
    }
}

class ArrayIns{
    private long[] a;
    private int nElems;

    public ArrayIns(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems ++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort(){
        int in,out;

        for (out = 1; out < nElems; out++){
            long temp = a[out];
            in = out;

            while (in > 0 && a[in-1] >= temp){
                a[in] = a[in-1];
                -- in;
            }
            a[in] = temp;
        }
    }

    public int median(){
        int middleNumber = 0;
        
        return middleNumber;
    }
}

package JavaPractice.SimpleSorts;

class ArrayBub{
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
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
        System.out.println("");
    }

    public void bubbleSort(){
        int outRight,in;

        for (outRight = nElems - 1; outRight > 1; outRight --){
            for (in = 0; in < outRight; in++){
                if (a[in] > a[in + 1]){
                    swap(in,in + 1);
                }
            }
        }

    }

    public void bubbleSortLeft(){
        int outRight = nElems - 1;
        int outLeft = 0;
        int in;

        for (;outRight > outLeft; outRight --, outLeft++){
            for (in = outLeft + 1; in < outRight; in++){
                if (a[in] > a[in+1]){
                    swap(in,in + 1);
                }
            }

            for (in = outRight - 1; in > outLeft; in--){
                if (a[in] > a[in-1]){
                    swap(in,in - 1);
                }
            }
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

public class bubbleSort{
    public static void main(String[] args) {
        int maxSize = 10000;
        /*
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(11);
        arr.insert(88);
        arr.insert(99);
        arr.insert(44);
        arr.insert(33);
        arr.insert(55);
        arr.insert(22);
        arr.insert(00);
        arr.insert(66);
        arr.display();

        System.out.println("进行冒泡排序");
        arr.bubbleSort();
        arr.display();
        */
        ArrayBub array = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++){
            long n = (long) (java.lang.Math.random()*(maxSize - 1));
            array.insert(n);
        }

        array.bubbleSort();
    }
}


package JavaPractice.ArrayPractice;

import org.mvel2.ast.Or;

import java.util.Random;

class OrdArray{
    private long[] a;
    private int nElems;

    public OrdArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true){
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey){
                return curIn;
            }else if (lowerBound > upperBound){
                return nElems;
            }else{
                if (a[curIn] < searchKey){
                    lowerBound = curIn + 1;
                }else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value){
        int i;
        for(i = 0;i < nElems;i++){
            //find where it goes
            if(a[i] > value){//line search
                break;
            }
        }
        for(int k = nElems;k > i;k--){
            //move bigger ones up
            a[k] = a[k-1];
        }
        a[i] = value;
        nElems++;
    }

    public void insert1(long value){
       int lowerBound = 0;
       int upperBound = nElems - 1;
       int curIn;

       while (true){
           curIn = (lowerBound + upperBound) / 2;
           if (lowerBound > upperBound){
               break;
           }
           if (a[curIn] == value){
               break;
           }else if (a[curIn] < value){
               if (curIn == nElems - 1){
                    curIn = curIn + 1;
                    break;
               }else if (a[curIn+1] >= value){
                   curIn = curIn + 1;
                   break;
               }else {
                   lowerBound = curIn - 1;
               }
           }else {
               if (curIn == 0){
                   break;
               }else if (a[curIn - 1] < value){
                   break;
               }else {
                   upperBound = curIn + 1;
               }

           }
       }

       for (int i = nElems; i > curIn; i--){
           a[i] = a[i-1];
       }
       a[curIn] = value;
       nElems ++;
    }

    public boolean delete(long value){
        int i = find(value);
        if (i == nElems){
            return false;
        }else {
            for (int j = i;j < nElems; j++){
                a[j] = a[j+1];
            }
            nElems --;
            return true;
        }
        /*
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true){
            curIn = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound){
                return false;
            }
            if (a[curIn] == value){
                break;
            }else if (a[curIn] < value){
                lowerBound = curIn + 1;
            }else{
                upperBound = curIn - 1;
            }
        }

        for (int i = nElems; i < curIn; i++){
            a[i] = a[i+1];
        }
        nElems --;
        return true;
        */
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public OrdArray merge(OrdArray ordArray){
        OrdArray dist = new OrdArray(this.nElems + ordArray.nElems);
        int index = 0;

        for (int i = 0; i < ordArray.size(); i++){
            dist.insert(ordArray.a[i]);
        }

        for (int i = 0; i < this.size(); i++){
            dist.insert(this.a[i]);
        }

        nElems = ordArray.nElems + this.nElems;
        return dist;

    }

}

class OrderedApp{
    public static void main(String[] args){
        Random random = new Random(100);
        int maxSize = 100;
        OrdArray array1 = new OrdArray(maxSize);
        OrdArray array2 = new OrdArray(maxSize);

        array1.insert(77);
        array1.insert(99);
        array1.insert(44);
        array1.insert(55);
        array1.insert(22);
        array1.insert(88);
        array1.insert(11);
        array1.insert(00);
        array1.insert(66);
        array1.insert(33);

        array2.insert(random.nextInt(20));
        array2.insert(random.nextInt(50));

        array2.display();

        System.out.println("合并2个数组");
        OrdArray array3 = array1.merge(array2);
        array3.display();

        /*
        int searchKey = 33;
        if (array1.find(searchKey) != array1.size()){
            System.out.println("Found " + searchKey);
        }else {
            System.out.println("Can't find " + searchKey);
        }

        array1.delete(22);
        array1.display();

        array1.delete(00);
        array1.delete(55);
        array1.delete(99);

        array1.display();
        */
    }
}
package JavaPractice.ArrayPractice;

class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey){
        int i;
        for (i = 0; i < nElems; i++){
            if (a[i] == searchKey){
                break;
            }
        }
        if (i == nElems){
            return false;
        }else {
            return true;
        }
    }

    public void insert(long value){
        a[nElems] = value;
        nElems ++;
    }

    public boolean delete(long value){
        int i;
        for (i = 0; i < nElems; i++){
            if (value == a[i]){
                break;
            }
        }
        if (i == nElems){
            return false;
        }else {
            for (int k = i; k < nElems; k++){
                a[k] = a[k+1];
            }
            nElems --;
            return true;
        }

    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public long getMax(){
        long max = -1;
        for (int i = 0; i < nElems; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public long removeMax(){
        long max = -1;
        int index = 0;
        for (int i = 0; i < nElems; i++){
            if (a[i] > max){
                max = a[i];
                index = i;
            }
        }
        if (index != -1){
            for (int i = index + 1; i < nElems; i++){
                a[i] = a[i+1];
            }
            nElems --;
        }
        return max;
    }

    public void noDup(){
        int NULL = -1;
        int order = 0;

        for (int j = 0; j < nElems; j++){
            for (int i = j + 1; i < nElems; i++){
                if (a[j] != NULL && a[j] == a[i]){
                    a[i] = NULL;
                }
            }
        }

        for (int temp = 0; temp < nElems; temp++){
            if (a[temp] != NULL){
                if (temp > order){
                    a[order] = a[temp];
                }
                order ++;
            }
        }

        nElems = order;
    }

}

class HighArrayApp{
    public static void main(String[] args){
        int maxSize = 100;
        HighArray array1 = new HighArray(maxSize);

        array1.insert(00);
        array1.insert(11);
        array1.insert(22);
        array1.insert(33);
        array1.insert(44);
        array1.insert(55);
        array1.insert(66);
        array1.insert(77);
        array1.insert(88);
        array1.insert(99);
        array1.insert(99);
        array1.insert(99);

        array1.display();

        System.out.println("删除重复数");
        array1.noDup();
        array1.display();

        /*
        int searchKey = 35;
        if (array1.find(searchKey)){
            System.out.println("Found " + searchKey);
        }else {
            System.out.println("Con't find " + searchKey);
        }

        array1.delete(00);
        array1.delete(55);
        array1.delete(99);

        array1.display();
        */


        long max = array1.getMax();
        System.out.println("Found max is " + max);

        HighArray array2 = new HighArray(maxSize);
        int i = 0;
        max = array1.removeMax();
        while (max != -1){
            array2.insert(max);
            max = array1.removeMax();
        }
        System.out.println("逆序排列");
        array2.display();

    }
}

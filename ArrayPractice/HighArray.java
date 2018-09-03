package JavaPractice.ArrayPractice;
/*
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
}

class HighArrayApp{
    public static void main(String[] args){
        int maxSize = 100;
        HighArray array = new HighArray(maxSize);

        array.insert(00);
        array.insert(11);
        array.insert(22);
        array.insert(33);
        array.insert(44);
        array.insert(55);
        array.insert(66);
        array.insert(77);
        array.insert(88);
        array.insert(99);

        array.display();

        int searchKey = 35;
        if (array.find(searchKey)){
            System.out.println("Found " + searchKey);
        }else {
            System.out.println("Con't find " + searchKey);
        }

        array.delete(00);
        array.delete(55);
        array.delete(99);

        array.display();
    }
}
*/
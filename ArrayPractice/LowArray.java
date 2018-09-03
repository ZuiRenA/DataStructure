package JavaPractice.ArrayPractice;
//数组封装进LowArray
class LowArray {
    private long[] a;
    public LowArray(int size){
        a = new long[size];
    }
    public void setElem(int index, long value){
        a[index] = value;
    }
    public long getElem(int index){
        return a[index];
    }
}
class LowArrayApp{
    public static void main(String[] args){
        LowArray array;
        array = new LowArray(100);
        int nElems = 0;
        int i;
        array.setElem(0,00);
        array.setElem(1,11);
        array.setElem(2,22);
        array.setElem(3,33);
        array.setElem(4,44);
        array.setElem(5,55);
        array.setElem(6,66);
        array.setElem(7,77);
        array.setElem(8,88);
        array.setElem(9,99);
        nElems = 10;

        for (i = 0; i < nElems; i++){
            System.out.print(array.getElem(i) + " ");
        }
        System.out.println();

        int searchKey = 26;
        for (i = 0; i < nElems; i++){
            if (array.getElem(i) == searchKey){
                break;
            }
        }
        if (i == nElems){
            System.out.println("Can't find " + searchKey);
        }else {
            System.out.println("Found " + searchKey);
        }

        for (i = 0; i < nElems; i++){
            if (array.getElem(i) == 55){
                break;
            }
        }
        for (int k = i; k < nElems; k++){
            array.setElem(k,array.getElem(k+1));
        }
        nElems--;

        for (i = 0; i < nElems; i++){
            System.out.print(array.getElem(i) + " ");
        }
        System.out.println();

    }
}
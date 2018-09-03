package JavaPractice.ArrayPractice;

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
        for (i = 0; i < nElems; i++){
            if (a[i] > value){
                break;
            }
        }
        for (int k = nElems; k > i; k--){
            a[k] = a[k-1];
        }
        a[i] = value;
        nElems ++;
    }

    public boolean delete(long value){
        int i = find(value);
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

class OrderedApp{
    public static void main(String[] args){
        int maxSize = 100;
        OrdArray array = new OrdArray(maxSize);

        array.insert(77);
        array.insert(99);
        array.insert(44);
        array.insert(55);
        array.insert(22);
        array.insert(88);
        array.insert(11);
        array.insert(00);
        array.insert(66);
        array.insert(33);

        int searchKey = 33;
        if (array.find(searchKey) != array.size()){
            System.out.println("Found " + searchKey);
        }else {
            System.out.println("Can't find " + searchKey);
        }

        array.display();

        array.delete(00);
        array.delete(55);
        array.delete(99);

        array.display();
    }
}
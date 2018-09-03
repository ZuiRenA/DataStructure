package JavaPractice.ArrayPractice;

public class Array {
    public static void main(String[] args){
        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int i;
        long searchKey = 0;
        arr[0] = 00;
        arr[1] = 11;
        arr[2] = 22;
        arr[3] = 33;
        arr[4] = 44;
        arr[5] = 55;
        arr[6] = 66;
        arr[7] = 77;
        arr[8] = 88;
        arr[9] = 99;
        nElems = 10;
        //----------------------------------
        for (i = 0; i < nElems; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //----------------------------------
        searchKey = 66;
        for (i = 0; i < nElems; i++){
            if (arr[i] == searchKey){
                break;
            }
        }
        if (i == nElems){
            System.out.println("Can't find " + searchKey);
        }else {
            System.out.println("Found " + searchKey);
        }
        //----------------------------------
        searchKey = 55;
        for (i = 0; i < nElems; i++){
            if (arr[i] == searchKey){
                break;
            }
        }
        for (int k = i; k < nElems; k++){
            arr[k] = arr[k + 1];
        }
        nElems --;
        //----------------------------------
        for (i = 0; i < nElems; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

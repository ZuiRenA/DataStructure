package JavaPractice.LinkList;

public class listInsertionSort {
    public static class Link{
        public long dData;
        public Link next;

        public Link(long dd){
            dData = dd;
        }
    }

    public static class SortedList{
        public Link first;

        public SortedList(){
            first = null;
        }

        public SortedList(Link[] linkArr){
            first = null;

            for (int i = 0; i < linkArr.length; i++){
                insert(linkArr[i]);
            }
        }

        public void insert(Link k){
            Link previous = null;
            Link current = first;

            while (current != null && k.dData > current.dData){
                previous = current;
                current = current.next;
            }

            if (previous == null){
                first = k;
            }else {
                previous.next = k;
            }

            k.next = current;
        }

        public Link remove(){
            Link temp = first;
            first = first.next;
            return temp;
        }
    }

    public static void main(String[] args){
        int size = 10;
        Link[] linkArray = new Link[size];

        for (int i = 0; i < size; i++){
            int n = (int)(java.lang.Math.random()*99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }

        System.out.print("Unsorted array: ");

        for (int i= 0; i < size; i++){
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println();

        SortedList theSortedList = new SortedList(linkArray);

        for (int i = 0; i < size; i++){
            linkArray[i] = theSortedList.remove();
        }

        System.out.print("Sorted Array: ");

        for (int i = 0; i < size; i++){
            System.out.print(linkArray[i].dData + " ");
        }
    }
}

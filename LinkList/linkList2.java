package JavaPractice.LinkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class linkList2 {

    public static class Link2{
        public int iData;
        public double dData;
        public Link2 next;

        public Link2(int id, double dd){
            iData = id;
            dData = dd;
        }

        public void displayLink(){
            System.out.println("{" + iData + ", " + dData + "}");
        }
    }

    public static class LinkList2{
        private Link2 first;

        public LinkList2() {
            first = null;
        }

        public void insertFirst(int id, double dd){
            Link2 newLink = new Link2(id,dd);
            newLink.next = first;
            first = newLink;
        }

        public Link2 find(int key) {
            Link2 current = first;

            while (current.iData != key) {

                if (current.next != null) {
                    return null;
                } else {
                    current = current.next;
                }

            }

            return current;
        }

        public Link2 delete(int key) {
            Link2 current = first;
            Link2 previous = first;

            while (current.iData != key) {

                if (current.next != null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;

                }
            }

            if (current == first){
                first = first.next;
            }else {
                previous.next = current.next;
            }

            return current;
        }

        public void displayList(){
            System.out.print("List (first --> last): ");
            Link2 current = first;

            while (current != null){
                current.displayLink();
                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        LinkList2 theList = new LinkList2();

        theList.insertFirst(22,2.99);
        theList.insertFirst(44,4.99);
        theList.insertFirst(66,6.99);
        theList.insertFirst(88,8.99);

        theList.displayList();

        Link2 f = theList.find(getKey());
        if (f != null){
            System.out.println("Fount link with key" + f.iData);
        }else {
            System.out.println("Can't find link");
        }

        Link2 d = theList.delete(getKey2());
        if (d != null){
            System.out.println("Deleted link with key" + d.iData);
        }else {
            System.out.println("Can't find link");
        }

        theList.displayList();
    }

    public static int getKey() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int key1 = br.read();
        return key1;
    }

    public static int getKey2() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int key2 = br.read();
        return key2;
    }

}
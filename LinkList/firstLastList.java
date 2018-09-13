package JavaPractice.LinkList;

public class firstLastList {
    public static void main(String[] args){
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}

class Link3{
    public long dData;
    public Link3 next;

    public Link3(long d){
        dData = d;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}

class FirstLastList{
    private Link3 first;
    private Link3 last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(long dd){
        Link3 newLink = new Link3(dd);

        if (isEmpty()){
            last = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd){
        Link3 newLink = new Link3(dd);

        if (isEmpty()){
            first = newLink;
        }else {
            last.next = newLink;
        }

        last = newLink;
    }

    public long deleteFirst(){
        long temp = first.dData;

        if (first.next != null){
            last = null;
        }

        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.print("List(first --> last): ");

        Link3 current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");

    }
}
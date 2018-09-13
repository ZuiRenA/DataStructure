package JavaPractice.LinkList;

public class linkQueue {
    public static class Link5{
        public long dData;
        public Link5 next;

        public Link5(long dd){
            dData = dd;
        }

        public void displayLink(){
            System.out.print(dData + " ");
        }

    }

    public static class LinkList5{
        private Link5 first;
        private Link5 last;

        public LinkList5(){
            first = null;
            last = null;
        }

        public boolean isEmpty(){
            return (first == null);
        }

        public void insertLast(long dd){
            Link5 newLink = new Link5(dd);

            if (isEmpty()){
                first = newLink;
            }else {
                last.next = newLink;
            }

            last = newLink;
        }

        public long deleteFirst(){
            long temp = first.dData;

            if (first.next == null){
                last = null;
            }

            first = first.next;
            return temp;
        }

        public void displayList(){
            Link5 current = first;

            while (current != null){
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }

    public static class LinkQueue{
        private  LinkList5 theList;

        public LinkQueue(){
            theList = new LinkList5();
        }

        public boolean isEmpty(){
            return theList.isEmpty();
        }

        public void insert(long dd){
            theList.insertLast(dd);
        }

        public long remove(){
            return theList.deleteFirst();
        }

        public void displayQueue(){
            System.out.print("Queue (front --> rear):");
            theList.displayList();
        }
    }
    public static void main(String[] args){
        LinkQueue theQueue = new LinkQueue();

        theQueue.insert(20);
        theQueue.insert(40);

        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);

        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();
    }
}


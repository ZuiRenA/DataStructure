package JavaPractice.LinkList;

public class linkStack {

    public static class Link4{
        public long dData;
        public Link4 next;

        public Link4(long dd){
            dData = dd;
        }

        public void displayLink(){
            System.out.println(dData + " ");
        }
    }

    public static class LinkList4{
        private Link4 first;

        public LinkList4(){
            first = null;
        }

        public boolean isEmpty(){
            return (first == null);
        }

        public void insertFirst(long dd){
            Link4 newLink = new Link4(dd);
            newLink.next = first;
            first = newLink;
        }

        public long deleteFirst(){
            Link4 temp = first;
            first = first.next;
            return temp.dData;
        }

        public void displayList(){
            Link4 current = first;

            while (current != null){
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }

    public static class LinkStack{
        private LinkList4 theList;

        public LinkStack(){
            theList = new LinkList4();
        }

        public void push(long j){
            theList.insertFirst(j);
        }

        public long pop(){
            return theList.deleteFirst();
        }

        public boolean isEmpty(){
            return theList.isEmpty();
        }

        public void displayStack(){
            System.out.print("Stack (top --> bottom)");
            theList.displayList();
        }
    }

    public static void main(String[] args){
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }

}



package JavaPractice.Stack;

public class queue {
    public static void main(String[] args){
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while (!theQueue.isEmpty()){
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }
}

class Queue{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public Queue(int i){
        maxSize = i;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long l){
        if (rear == maxSize - 1){
            rear = -1;
        }

        queArray[++rear] = l;
    }

    public long remove(){
        long temp = queArray[front++];
        if (front == maxSize){
            front = 0;
        }

        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (rear + 1 == front || (front + maxSize == rear));
    }

    public boolean isFull(){
        return (rear + 2 == front || (front + maxSize-2== rear));
    }

    public int size(){
        if (rear >= front){
            return  rear - front + 1;
        }else {
            return (maxSize - front) + (rear + 1);
        }
    }
}
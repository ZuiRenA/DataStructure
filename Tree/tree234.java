package JavaPractice.Tree;

import java.util.Scanner;

public class tree234 {

    public static class DataItem {
        public int dData;

        public DataItem(int dd){
            dData = dd;
        }

        public void displayItem(){
            System.out.print("/" + dData);
        }
    }

    public static class Node{
        private static final int ORDER = 4;
        private int numItems;
        private Node parent;
        private Node childArray[] = new Node[ORDER];
        private DataItem itemArray[] = new DataItem[ORDER - 1];

        public void connectChild(int childNum, Node child){
            childArray[childNum] = child;
            if (child != null){
                child.parent = this;
            }
        }

        public Node disconnectChild(int childNum){
            Node tempNode = childArray[childNum];
            childArray[childNum] = null;
            return tempNode;
        }

        public Node getChild(int childNum){
            return childArray[childNum];
        }

        public Node getParent(){
            return parent;
        }

        public boolean isLeaf(){
            return (childArray[0] == null);
        }

        public int getNumItems(){
            return numItems;
        }

        public DataItem getItem(int index){
            return itemArray[index];
        }

        public boolean isFull(){
            return (numItems == ORDER - 1);
        }

        public int findItem(long key){
            for (int i = 0; i < ORDER - 1; i++){

                if (itemArray[i] == null)
                    break;
                else if (itemArray[i].dData == key)
                    return i;
            }

            return -1;
        }

        public int insertItem(DataItem newItem){
            numItems ++;
            int newKey = newItem.dData;

            for (int i = ORDER - 2; i > 0; i--){

                if (itemArray[i] == null)
                    continue;
                else {
                    int itsKey = itemArray[i].dData;

                    if (newKey < itsKey)
                        itemArray[i+1] = itemArray[i];
                    else {
                        itemArray[i+1] = newItem;
                        return i + 1;
                    }
                }
            }

            itemArray[0] = newItem;
            return 0;
        }

        public DataItem removeItem(){
            DataItem temp = itemArray[numItems-1];
            itemArray[numItems-1] = null;
            numItems --;
            return temp;
        }

        public void displayNode(){
            for (int i = 0; i < numItems; i++){
                itemArray[i].displayItem();
            }
            System.out.println("/");
        }

    }




    public static class Tree234{
        private Node root = new Node();

        public int find(int key){
            Node curNode = root;
            int childNumber;

            while (true){

                if ((childNumber = curNode.findItem(key)) != -1)
                    return childNumber;
                else if (curNode.isLeaf())
                    return -1;
                else
                    curNode = getNextChild(curNode, key);
            }
        }

        public void insert(int dValue){
            Node curNode = root;
            DataItem tempItem = new DataItem(dValue);

            while (true){

                if (curNode.isFull()){
                    split(curNode);
                    curNode = curNode.getParent();
                    curNode = getNextChild(curNode, dValue);
                }else if (curNode.isLeaf())
                    break;
                else
                    curNode = getNextChild(curNode, dValue);
            }

            curNode.insertItem(tempItem);
        }

        private void split(Node thisNode) {
            DataItem itemB, itemC;
            Node parent, child2, child3;
            int itemIndex;

            itemC = thisNode.removeItem();
            itemB = thisNode.removeItem();
            child2 = thisNode.disconnectChild(2);
            child3 = thisNode.disconnectChild(3);
            Node newRight = new Node();

            if (thisNode == root){
                root = new Node();
                parent = root;
                root.connectChild(0, thisNode);
            }else
                parent = thisNode.getParent();

            itemIndex = parent.insertItem(itemB);
            int n = parent.getNumItems();

            for (int i = n - 1; i > itemIndex; i--){
                Node temp = parent.disconnectChild(i);
                parent.connectChild(i +1, temp);
            }

            parent.connectChild(itemIndex + 1, newRight);
            newRight.insertItem(itemC);
            newRight.connectChild(0, child2);
            newRight.connectChild(1, child3);
        }

        private Node getNextChild(Node theNode, int theValue) {
            int i;
            int numItems = theNode.getNumItems();

            for (i = 0; i < numItems; i++){

                if (theValue < theNode.getItem(i).dData)
                    return theNode.getChild(i);
            }

            return theNode.getChild(i);
        }
        
        public void displayTree(){
            recDisplayTree(root, 0, 0);
        }

        private void recDisplayTree(Node thisNode, int level, int childNumber) {
            System.out.print("level = " + level + " child = " + childNumber);
            thisNode.displayNode();

            int numberItems = thisNode.getNumItems();
            for (int i = 0; i < numberItems; i++){
                Node nextNode = thisNode.getChild(i);

                if (nextNode != null)
                    recDisplayTree(nextNode, level + 1, i);
                else
                    return;
            }
        }
    }

    public static void main(String[] args){
        int value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true){
            System.out.print("Enter first letter of show, insert or find: ");
            char choice = getChar();

            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1)
                        System.out.println("Found " +found);
                    else
                        System.out.println("Can't find " + found);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString(){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        return s;
    }

    public static char getChar() {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt(){
        String s = getString();
        return Integer.parseInt(s);
    }
}

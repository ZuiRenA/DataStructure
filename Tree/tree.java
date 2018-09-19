package JavaPractice.Tree;


import java.io.IOException;
import java.util.Scanner;

import static JavaPractice.LinkList.interIterator.getChar;

public class tree {

    public static class Node{
        public int iData;
        public double dData;
        public Node leftChild;
        public Node rightChild;

        public void displayNode(){
            System.out.println("{" + iData + ", " + dData + "}");
        }

    }


    public static class Tree{
        private Node root;

        public Tree(){
            root = null;
        }

        public Node find(int key){
            Node current = root;

            while (current.iData != key){

                if (key < current.iData){
                    current = current.leftChild;
                }else {
                    current = current.rightChild;
                }

                if (current == null){
                    return null;
                }
            }

            return current;
        }

        public void insert(int id, double dd){
            Node newNode = new Node();
            newNode.iData = id;
            newNode.dData = dd;

            if (root == null){
                root = newNode;
            }else {
                Node current = root;
                Node parent;

                while (true){
                    parent = current;

                    if (id < current.iData){
                        current = current.leftChild;

                        if (current == null){
                            parent.leftChild = newNode;
                            return;
                        }
                    }else {
                        current = current.rightChild;

                        if (current == null){
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }
        }

        public boolean delete(int key){
            Node current = root;
            Node parent = root;
            boolean isLeftChild = true;

            while (current.iData != key){
                parent = current;

                if (key < current.iData){
                    isLeftChild = true;
                    current = current.leftChild;
                }else {
                    isLeftChild = false;
                    current = current.rightChild;
                }

                if (current == null){
                    return false;
                }
            }

            if ((current.leftChild == null) && (current.rightChild == null)) {

                if (current == root)
                    root = null;
                else if (isLeftChild)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;

            }else if (current.rightChild == null){

                if (current == root)
                    root = current.leftChild;
                else if (isLeftChild)
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;

            }else if (current.leftChild == null){

                if (current == root)
                    root = current.rightChild;
                else if (isLeftChild)
                    parent.leftChild = current.rightChild;
                else
                    parent.rightChild = current.rightChild;

            }else {
                Node successor = getSuccessor(current);

                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.leftChild = successor;
                else
                    parent.rightChild = successor;

                successor.leftChild = current.leftChild;
            }

            return true;
        }

        private Node getSuccessor(Node delNode){
            Node sucessorParent = delNode;
            Node sucessor = delNode;
            Node current = delNode.rightChild;

            while (current != null){
                sucessorParent = sucessor;
                sucessor = current;
                current = current.leftChild;
            }

            if (sucessor != delNode.rightChild){
                sucessorParent.leftChild = sucessor.rightChild;
                sucessor.rightChild = delNode.rightChild;
            }

            return sucessor;
        }

        public void traverse(int traverseType){
            switch (traverseType){

                case 1:
                    System.out.print("\nPreorder traversal: ");
                    preOrder(root);
                    break;
                case 2:
                    System.out.print("\nInorder traversal: ");
                    preOrder(root);
                    break;
                case 3:
                    System.out.print("\nPostorder traversal: ");
                    break;
            }
            System.out.println();
        }

        private void preOrder(Node loaclRoot) {
            if (loaclRoot != null){
                System.out.print(loaclRoot.iData + " ");
                preOrder(loaclRoot.leftChild);
                preOrder(loaclRoot.rightChild);
            }
        }

        private void inOrder(Node loaclRoot){
                if (loaclRoot != null){
                    preOrder(loaclRoot.leftChild);
                    preOrder(loaclRoot.rightChild);
                    System.out.print(loaclRoot.iData + " ");
                }
        }

        public void displayTree(){
            Stack globalStack = new Stack();
            globalStack.push(root);
            int nBlanks = 32;
            boolean isRowEmpty = false;

            while (!isRowEmpty){
                Stack localStack = new Stack();
                isRowEmpty = true;

                for (int i = 0; i < nBlanks; i++)
                    System.out.print(' ');

                while (!globalStack.isEmpty()) {
                    Node temp = globalStack.pop();

                    if (temp != null) {
                        System.out.print(temp.iData);
                        localStack.push(temp.leftChild);
                        localStack.push(temp.rightChild);
                    }

                    if (temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }

                    for (int i = 0; i < nBlanks*2 - 2; i ++)
                        System.out.print(' ');
                }

                System.out.println();
                nBlanks /= 2;
                while (!localStack.isEmpty())
                    globalStack.push(localStack.pop());
            }

        }

        public static class Stack{
            private int[] StackiData;
            private double[] StackdData;
            private int top;
            public Stack(){
                top = -1;
            }

            public void push(Node value) {
                StackiData[++top] = value.iData;
                StackdData[++top] = value.dData;
            }

            public Node pop(){
                Node node = new Node();
                node.iData = StackiData[top--];
                node.dData = StackdData[top--];
                return node;
            }

            public boolean isEmpty(){
                return (top == -1);
            }

            public Node peek(){
                Node node = new Node();
                node.iData = StackiData[top];
                node.dData = StackdData[top];
                return node;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);

        while (true){
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();

            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.println("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);

                    if (found != null){
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }else {
                        System.out.print("Could not find ");
                        System.out.print(value + '\n');
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);

                    if (didDelete){
                        System.out.print("Deleted " + value + "\n");
                    }else {
                        System.out.print("Could not delete ");
                        System.out.print(value + "\n");
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1,2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    public static String getString() throws IOException {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

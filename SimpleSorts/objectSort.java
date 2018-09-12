package JavaPractice.SimpleSorts;

public class objectSort {
    public static void main(String[] args){
        int maxSize = 100;
        ArrayInOb arr = new ArrayInOb(maxSize);

        arr.insert("Evans","Patty",24);
        arr.insert("Smith","Doc",59);
        arr.insert("Smith","Lorraine",37);
        arr.insert("Yee","Tom",43);
        arr.insert("Hashimto","Sato",21);
        arr.insert("Stimson","Henry",29);
        arr.insert("Velasquez0","Jose",72);

        System.out.println("Before sorting: ");
        arr.display();

        arr.insertionSort();

        System.out.println("After sorting:");
        arr.display();
    }
}

class Person{
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a){
        lastName = last;
        firstName = first;
        age = a;
    }

    public void displayPerson(){
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(",Age: " + age);
    }

    public String getLastName(){
        return lastName;
    }

}

class ArrayInOb{
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max){
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age){
        a[nElems] = new Person(lastName,firstName,age);
        nElems ++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            a[i].displayPerson();
        }
        System.out.println();
    }

    public void insertionSort(){
        int in,out;

        for (out = 1; out < nElems; out++){
            Person temp = a[out];
            in = out;

            while (in > 0 && a[in-1].getLastName().compareTo(temp.getLastName()) > 0){
                a[in] = a[in-1];
                -- in;
            }
            a[in] = temp;
        }
    }
}
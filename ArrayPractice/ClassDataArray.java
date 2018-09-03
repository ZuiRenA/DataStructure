package JavaPractice.ArrayPractice;

public class ClassDataArray {
    private Person[] a;
    private int nElems;

    public  ClassDataArray(int max){
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchName){
        int i;
        for (i = 0; i < nElems; i++){
            if (a[i].getLast().equals(searchName)){
                break;
            }
        }
        if (i == nElems){
            return null;
        }else {
            return a[i];
        }
    }

    public void insert(String last, String first, int age){
        a[nElems] = new Person(last,first,age);
        nElems ++;
    }

    public boolean delete(String searchName){
        int i;
        for (i = 0; i < nElems; i++){
            if (a[i].getLast().equals(searchName)){
                break;
            }
        }
        if (i == nElems){
            return false;
        }else {
            for (int k = i; k < nElems; k++){
                a[k] = a[k+1];
            }
            nElems --;
            return true;
        }
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            a[i].displayPerson();
        }
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
        System.out.print("Last name " + lastName);
        System.out.print(", first name " + firstName);
        System.out.println(", age " + age);
    }

    public String getLast(){
        return lastName;
    }

}

class ClassDataApp{
    public static void main(String[] args){
        int maxSize = 100;
        ClassDataArray array = new ClassDataArray(maxSize);

        array.insert("Evans","Patty",24);
        array.insert("Smith","Lorraine",27);
        array.insert("Yee","Tom",43);
        array.insert("Adams","Henry",63);
        array.insert("Hashimto","sato",21);
        array.insert("Stimson","Henry",29);
        array.insert("Velasquez","Jose",72);
        array.insert("Lamarque","Henry",54);
        array.insert("Vang","Minh",22);
        array.insert("Creswell","Lucinda",18);

        array.display();

        String searchName = "Stimson";
        Person found = array.find(searchName);

        if (found != null){
            System.out.print("Found ");
            found.displayPerson();
        }else {
            System.out.println("Can't first " + searchName);
        }

        System.out.println("Deleting Smith, Yee, and Creswell");
        array.delete("Smith");
        array.delete("Yee");
        array.delete("Creswell");

        array.display();
    }
}
package JavaPractice;
import java.io.*;
class BankAccount{
    private double balance;
    public BankAccount(double openingBalance){
        balance = openingBalance;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public void display(){
        System.out.println("balance = " + balance);
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        s = getString();
        return String.valueOf(s.charAt(0));
    }
    public int getDouble() throws IOException{
        String s = getString();
        Double aDub = Double.valueOf(s);
        return (int) aDub.doubleValue();
    }
}
class BankApp{
    public static void main(String[] args){
        BankAccount ba1 = new BankAccount(100.00);
        System.out.print("Before transaction,");
        ba1.display();
        ba1.deposit(74.35);
        ba1.withdraw(20.00);
        System.out.print("After transactions, ");
        ba1.display();
    }
}

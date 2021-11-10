import java.io.*;
import java.util.Scanner;

public class Class3 {
    public static void main(String[] args) throws ClassNotFoundException {
       
    	
    Scanner sc = new Scanner (System.in); 	
    System.out.println("entrer le num d 'empl");
    int num =sc.nextInt();
    Employee emp = new Employee (null, null, num, num);
    try {
    	RandomAccessFile rafile = new RandomAccessFile("empdirect.dat", "rw");
    rafile.readUTF(); 	
    if (num == Employee.number) {
    	
    	
    	System.out.println(emp.getname()+ "\n"+ emp.getaddress()+ "\n"+ emp.getSSN() + "\n"+ emp.getnumber());
    	
    }
    else {
    	
    	System.out.println("erreur");

    	
    		}
    	
    	}
    catch (IOException i)	{
    	
    	i.printStackTrace();
   }
    	
   }
  }
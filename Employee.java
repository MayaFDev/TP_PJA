import java.io.*;
public class Employee implements Serializable
{
   public static String name;
   public static String address;
   public transient static int SSN;
   public static int number;
   
   
   public Employee (String name, String address , int SSN , int number )
   
   
{
	   this.name= name ;
	   this.address= address;
	   this.SSN= SSN;
	   this.number= number;
	   
	   }
   
   public static String getname() {
	   return name;
   }
   
   
   public static String getaddress() {
	   return address;
   }
   
   public static int getSSN() {
	   return SSN;
   }
   
   public static  int getnumber() {
	   return number;
   }
   
   
   
   public void mailCheck()
   {
      System.out.println("Mail de verification de " + name + " " + address);
   }
}

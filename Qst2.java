import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.*;


public class Qst2 {
	
	   public static void main(String [] args) throws ClassNotFoundException {
 
		   try
		      {
		         FileInputStream fileIn = new FileInputStream("emp.dat");
		         	ObjectInputStream in = new ObjectInputStream(fileIn);
		         	
		        		         
		         in.close();
		         fileIn.close();
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return;
		      }
		     
		   System.out.println("Employee deserialise...");
		   

		    }
}
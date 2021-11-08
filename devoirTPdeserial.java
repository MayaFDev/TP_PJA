import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class devoirTPdeserial {
	public static void main(String [] args)
	   {
	      Employee obj1 = null;
	      Employee obj2 = null;

	      
	      try
	      {
	   
	         FileInputStream fileIn = new FileInputStream("emp.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         obj1 = (Employee) in.readObject();
	         obj2 = (Employee) in.readObject();

	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("classe Employee non trouvee");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Employee deserialise...");
	      System.out.println("Nom: " + obj1.name);
	      System.out.println("Adresse: " + obj1.address);
	      System.out.println("SSN: " + obj1.SSN);
	      System.out.println("Number: " + obj1.number);
	      
	      System.out.println("Employee 2 deserialise...");
	      System.out.println("Nom: " + obj2.name);
	      System.out.println("Adresse: " + obj2.address);
	      System.out.println("SSN: " + obj2.SSN);
	      System.out.println("Number: " + obj2.number);


	    }
	
}

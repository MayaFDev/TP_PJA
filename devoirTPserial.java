import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class devoirTPserial {

	   public static void main(String [] args) {
		   
    Employee obj1 = new Employee(); 
		  
		   obj1.name = "BENHACINE SERINE";
		   obj1.address = "ALIM.";
		   obj1.SSN = 2009;
		   obj1.number = 2000;
		 
		   System.out.println(obj1);
		   
	Employee obj2 = new Employee(); 
			  
		   obj2.name = "ALIHADEF MAYA";
		   obj2.address = "ALIM.";
		   obj2.SSN = 0711;
		   obj2.number = 1998;
		   
		   System.out.println(obj2);
   
		   
	   try
	      {
	         FileOutputStream fos =
	         new FileOutputStream("emp.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fos);
	         out.writeObject(obj1);
	         out.writeObject(obj2);

	         out.close();
	         fos.close();
	         System.out.printf("données serialisées sauvegardées dans emp.dat");
	      }catch(IOException e)
	      {
	          e.printStackTrace();
	      }
	   }
	}


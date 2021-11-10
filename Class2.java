import java.io.*;


public class Class2 {
	
	   public static void main(String [] args) throws ClassNotFoundException {
		   
		   
		      Employee matrice[][] = null;

 
		   try
		      {
		         FileInputStream fileIn = new FileInputStream("emp.dat");
		         	ObjectInputStream in = new ObjectInputStream(fileIn);
					   FileOutputStream fileOut = new FileOutputStream("empdirect.dat");


		        		         
		         in.close();
		         fileIn.close();
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return;
		      }
		     
		  
		   System.out.println("les données des employés sont désérialisées ");

		   System.out.println("Employee deserialise...");
		      
		    }
		 
		    
}
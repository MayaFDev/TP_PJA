import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Qst1 {
	
	
	   public static void main(String [] args) {
	
		   int j ;
	
		   
		   Scanner sc = new Scanner (System.in);
		   System.out.println("entrer le nombre des employ�s");
		   j= sc.nextInt();

		   
		   
		   Employee matrice[] []= new Employee [j][4];
		   
		   for (int x=0; x<j ; x++ ) {
			   
			   for(  int a=0; a<1 ; a++) {
				   
				   System.out.println("entrer le nom d'employ�"+x);
				   		Employee.name= sc.next();
				   		
				   System.out.println("entrer l'@ d'employ�"+x);
				   		Employee.address= sc.next();
				   		
			   System.out.println("entrer le SSN d'employ�"+x);
			   			Employee.SSN= sc.nextInt();
			   			
			   System.out.println("entrer le num d'employ�"+x);
			   			Employee.number= sc.nextInt();

			   							}
		   							}
		   System.out.println("les donn�es des employ�s sont enregistr�es avec succ�s ");
	   		

		   try{ 
			   FileOutputStream fileOut = new FileOutputStream("emp.dat");
		      
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         
		         out.writeObject(matrice);
		         out.close();
		         fileOut.close();
		         
		         System.out.printf("donnees serialisees sauvegardees dans employee.ser");
		         
		      }
		   catch (IOException i) {
		          i.printStackTrace();
		      }
		   }
		

		   
	   }
	   
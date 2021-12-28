package UN;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class CLIENT {
    public static void main(String args[]) throws Exception {
    														
    String commande_user , chemin_user  , file_client , chemintexte , contenu_txt , adr_client ;
    int port_client; 
    
    // creation de la socket du client.
    Socket socket_client = new Socket("localhost", 7500);
    // pour afficher le local port =/= 7500.
     int port = socket_client.getLocalPort();
    // pour afficher l'@ du client .

     String adr = socket_client.getInetAddress().toString();
   

     // pour lire la commande du client si list ou get ou quit ou aute .

    	BufferedReader from_user_one = new BufferedReader(new InputStreamReader(System.in));

   		System.out.println("Le client dont l@ est " + adr + " est connecté sur le port ! " + port + '\n' 
   				+ "pour le contenue d'un dossier tapez (list)" +"\n"+ "pour obtenir le contenu d_un fichier texe tapez (get)"  + "\n" 
   				+ "pour quiter tapez (quit)");
   		commande_user = from_user_one.readLine();
   
		if (commande_user .equals("list")) {
   		//envoyer la commande au server
   		DataOutputStream to_server_one = new DataOutputStream(socket_client.getOutputStream());
   		to_server_one.writeBytes(commande_user + '\n');
   		
   	    
   		BufferedReader from_user_two = new BufferedReader(new InputStreamReader(System.in));
   		System.out.println("entrer le CHEMIN du dossier SVP ! " + "\n");
   		chemin_user = from_user_two.readLine();
    
   		//envoyer le chemin  au server .
   		DataOutputStream to_server_two = new DataOutputStream(socket_client.getOutputStream());
   		to_server_one.writeBytes(chemin_user + '\n');
   		

   		
   		
   		// affichage des fichiers 

   		BufferedReader from_server_two = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
        file_client = from_server_two.readLine();
   		System.out.println("les files sont " + file_client  + '\n');
		}
 
        // Si la commande = get .

		 if (commande_user.equals("get")) {
			 // envoyer la commande au server 
		   		DataOutputStream to_server_one = new DataOutputStream(socket_client.getOutputStream());
		   		to_server_one.writeBytes(commande_user + '\n');

   		//lire le chemin du fichier texte .
   		BufferedReader from_user_three = new BufferedReader(new InputStreamReader(System.in));
   		System.out.println("entrer le CHEMIN du FICHIER TEXTE que vous voulez obtenir son contenu ! ");
   		chemintexte = from_user_three.readLine();

   		// envoyer le chemin au server .
   		DataOutputStream to_server_three = new DataOutputStream(socket_client.getOutputStream());
   		to_server_three.writeBytes(chemintexte + '\n');
   		
   		BufferedReader from_server_three = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
        contenu_txt = from_server_three.readLine();
   		System.out.println("le contenu est :   " + contenu_txt + '\n');
   	
		}
   			 
        // Si la commande = quit ou autre et =/= (get / list )
		if (!commande_user.equals("get")|| (!commande_user.equals("list")) || (commande_user.equals("quit"))) {
	   		System.out.println(" Voulez-vous ressayez ? ");
	   	   	

		 }
		//fermeture de la socket client.
   		socket_client.close();
	
		}
    
    
    
    }




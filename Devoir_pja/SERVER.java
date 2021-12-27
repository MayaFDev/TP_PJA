package UN;


import java.io.*;
import java.net.*;

public class SERVER {
    public static void main(String args[]) throws Exception {
    	
    	int port = 7500; 
    	String   commande_client, chemin_client ,  existance = null , file = null , txt_client , contenu = null ; 
    	
        ServerSocket socket_server = new ServerSocket(port);

        System.out.println("Bienvenu_Server_is here!");
        
        while(true) {
        	/* accepter la socket du client */
            Socket socket_client = socket_server.accept();

           
            
            /*lire la commande entrante */
            BufferedReader from_client_one = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));

            commande_client = from_client_one.readLine();
            
    /*Si la commande est get*/////////////////////////////////////////////////////////////////////        	
            
            	if (commande_client.equals("list")) {
            		
                    /*récupération du chemin */
                    BufferedReader from_client_two = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
                    chemin_client = from_client_two.readLine() ;

                    /*verification si le dossier existe */
                    File dossier = new File (chemin_client);
                    
                    	if (dossier.exists()) {
                    		
                    		
                    		/*le contenue du dossier */
                    		String [] liste = dossier.list();
                   	      
                    		if (liste != null) {         
                				for (int i = 0; i < liste.length; i++) {
                                            
                					file = liste[i];
                						
                					DataOutputStream to_client_two = new DataOutputStream(socket_client.getOutputStream());
                					to_client_two.writeBytes(file);
                														}                   		
                    							}
                    							}
                    	
                    	else {
                    		System.out.println("dossier  inexistant !");
                        	break ;
                    		}
                    	/*envoyer l'existance au client*/
                    	DataOutputStream to_client_one = new DataOutputStream(socket_client.getOutputStream());
                		to_client_one.writeBytes(existance + '\n');
         
            	}
                		
  /*Si la commande est get*/////////////////////////////////////////////////////////////////////        	
            	
            											 

            		if (commande_client.equals("get")) {
                        
            			 /*récupération du nom de fichier texte */
                       BufferedReader from_client_three = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
                       txt_client = from_client_three.readLine() ;
          
                        
                        File fichier = new File (txt_client); 
                        /*Si le fichier text existe */

                        if (fichier.exists()) {
                        	                        	
                      	BufferedReader in = new BufferedReader(new FileReader(txt_client));
            			String line;
            				while ((line = in.readLine()) != null)
            				{
                        	contenu = line ; 
            				
            				}
            				// envoyer le contenu au client
           				DataOutputStream to_client_three = new DataOutputStream(socket_client.getOutputStream());
                		to_client_three.writeBytes(contenu + '\n'); 	
                        	
                        }
                        
                        else {
                        	//fichier texte inexistant ou chemin incorrect
                    		System.out.println("Désolé _ fichier texte inexistant ! ");
                        	break ;
                    		}                    
                        				}
            	
            
            	}
		//fermeture de la socket server
        
        socket_server.close();   
     	    	
    														}
}

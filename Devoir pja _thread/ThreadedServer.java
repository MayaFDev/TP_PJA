package Exo;

import java.io.*;
import java.net.ServerSocket;


class ThreadedServer{
	private static int SERVER_PORT = 5045;
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			 while(true)
			 {
			    	ThreadTask socket;
			        try
			        {
			            socket = new ThreadTask(serverSocket.accept());
			            Thread t = new Thread(socket);
			            t.start();
			           
			        }
			        			
			        catch(Exception e)
			        {
			                System.out.println(e.toString());
			        }
			 }
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	       System.out.println("Server Listening on Port "+SERVER_PORT);
	}

    

}
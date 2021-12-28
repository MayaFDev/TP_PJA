package Exo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ThreadTask implements Runnable{
Socket client;
private static final String SERVER_IP = "127.0.0.20";
private static int SERVER_PORT = 5045;
ThreadTask(Socket client)
{
    this.client = client;
}
public void run()
{
	  try 
	  {
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner input=new Scanner(System.in);
		System.out.println("Enter File name pls");
		String nomFile=input.nextLine();
		out.println(nomFile);//send nameFile to server
        out.close();
        socket.close();
    	} 
        catch(Exception e)
        {
                System.out.println(e.toString());
        } 
 }
}
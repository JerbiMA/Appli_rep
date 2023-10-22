package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


import client.ClientProcess;

public class Server extends Thread{
	int nombreClient;

	public static void main(String[] args) {
		new Server().start();
	}
		
	public void run()
	{
				
		try (ServerSocket ss = new ServerSocket(1234)) 
		{
			System.out.println("Démarrage du serveur");
			while(true)
			{
				Socket s = ss.accept();
				new ClientProcess(s,++nombreClient).start();
			}
		}
		catch (IOException e)
		{			
			e.printStackTrace();	 
		{ 
	}
}
}
}
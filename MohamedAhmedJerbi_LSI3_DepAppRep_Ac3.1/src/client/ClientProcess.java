package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess extends Thread
	{
		private int numClient;
		private Socket s;
		public ClientProcess(Socket s, int numClient) 
		{
			this.s = s;
			this.numClient = numClient;
		}
		public void run()
		{
			try {
				PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
				pw.println("Bienvenu, vous etes le client numero"+numClient+"de l'adresse IP: "
				+s.getRemoteSocketAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
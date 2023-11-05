package server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import clientprocess.ClientProcess;

public class Server extends Thread{

    public static void main(String[] args) {
        new Server().start();//appel du serveur
    }
    public void run(){
        try {
            //creation objet serversocket
            ServerSocket ss = new ServerSocket(501);
            System.out.println("demarage de server ");
            while (true){//attendre la connextion du plusieurs client
                Socket s = ss.accept();// Attend qu'un client se connecte et accepte la connexion.
                System.out.println("New client connected.");
                ClientProcess clientProcess = new ClientProcess(s);
                clientProcess.start(); // Démarre un thread pour gérer ce client.
               clientProcess.num();// Appelle la méthode "num" sur l'objet clientProcess
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}	
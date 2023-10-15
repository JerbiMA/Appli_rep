package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(2020);
        System.out.println("Je suis un server en attente la connexion d'un client");
        Socket s = ss.accept();
        System.out.println("un client est connecté");

        s.close();
        ss.close();
    }
}
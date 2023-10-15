package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main (String[] args) throws IOException{
        System.out.println("Je suis un client pas encore connecté");
        Socket s = new Socket("localhost",2020);
        System.out.println("Je suis un client connecté");

        s.close();
    }
}
package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args){
        try
        {

            InetAddress IA = InetAddress.getByName("192.168.218.20");
            InetSocketAddress ISA = new InetSocketAddress(IA,1234);

            Socket s = new Socket();

            s.connect(ISA);

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            System.out.println("Je suis Connecté au serveur");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer un entier: ");
            int nb = scanner.nextInt();
            os.write(nb);
            int res = is.read();
            System.out.println( res);
            s.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
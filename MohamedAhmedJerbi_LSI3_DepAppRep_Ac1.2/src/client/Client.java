package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws IOException{
        System.out.println("Je suis un client pas encore connecté");
        Socket s = new Socket("localhost",2020);
        System.out.println("Je suis un client connecté");

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        os.write(nb);
        int res = is.read();
        System.out.println(res);

        s.close();
    }
}
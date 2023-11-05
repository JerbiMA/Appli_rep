package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // Server IP and Port
            System.out.println("Connected to server.");
            InputStream is = socket.getInputStream();
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String msg = br.readLine();
            System.out.println(msg);

            // Rest of the client code here...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
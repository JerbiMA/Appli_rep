package client;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import operation.Operation;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
	        {
			 System.out.println("je suis un client non connecté ");
		     Socket s = new Socket("localhost", 1238);

		     System.out.println("je suis connecté ");

		     OutputStream output = s.getOutputStream();
		     ObjectOutputStream os = new ObjectOutputStream(output);

		     Operation op = new Operation(40,20,'+');

		     os.writeObject(op);

		     InputStream input = s.getInputStream();
		     ObjectInputStream is = new ObjectInputStream(input);

		     op = (Operation) is.readObject();

		     System.out.println(op.getRes());
    }catch(Exception e){
        System.out.println("CLient here");
        throw new RuntimeException(e);
    }
	}

}
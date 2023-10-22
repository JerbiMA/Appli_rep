package client;

import java.io.*;
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
		     
		     Scanner sc = new Scanner(System.in);
		     
		     System.out.println("donner nb1 = ");
	            int nb1 = sc.nextInt();
	            System.out.println("donner nb2 = ");
	            int nb2 = sc.nextInt();

	           char oper;
	            do{
	                System.out.println("donner op = ");
	                oper = sc.next().charAt(0);
	            }while(!((oper == '+') || (oper == '-') || (oper == '*') || (oper == '/')));

		     Operation op = new Operation(nb1,nb2,oper);

		     os.writeObject(op);

		     InputStream input = s.getInputStream();
		     ObjectInputStream is = new ObjectInputStream(input);

		     op = (Operation) is.readObject();

		     System.out.println("la resultat est :"+op.getRes());
    }catch(Exception e){
        System.out.println("CLient here");
        throw new RuntimeException(e);
    }
	}

}
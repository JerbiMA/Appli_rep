package server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import operation.Operation;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try(ServerSocket ss = new ServerSocket(1238))
	        {
	            Socket clientSocket = ss.accept();

	            InputStream input = clientSocket.getInputStream();
	            ObjectInputStream oi = new ObjectInputStream(input);

	            Operation op = (Operation) oi.readObject();

	            int nb1 = op.getNb1();
	            int nb2 = op.getNb2();
	            char ops = op.getOp();

	            int res = 0;

	            switch(ops){
	                case '+' : res = nb1 + nb2;break;
	                case '-' : res = nb1 - nb2;break;
	                case '*' : res = nb1 * nb2;break;
	                case '/' : res = nb1 / nb2;break;
	            }

	            op.setRes(res);

	            OutputStream output = clientSocket.getOutputStream();
	            ObjectOutputStream oo = new ObjectOutputStream(output);

	            oo.writeObject(op);

	        }catch (IOException | ClassNotFoundException e) {
	            System.out.println("here");
	            throw new RuntimeException(e);
	        } ;
	    }

}
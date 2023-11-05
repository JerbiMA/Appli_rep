package udpClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	private static final int PORT=1234;
	private static byte[] buffer = new byte[1024];
	public static void main(String args[]) throws Exception {
		DatagramSocket s = new DatagramSocket();
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
		DatagramPacket data= new DatagramPacket(userName.getBytes(),userName.length(),InetAddress.getByName("localhost"), PORT);
		s.send(data);
		DatagramPacket recData = new DatagramPacket(buffer,buffer.length);
		s.receive(recData);
		System.out.println("server :"+ new String(recData.getData(),0,recData.getLength()));		
	}
	

}

package udpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
	private static final int PORT=1234;
	private static byte[] buffer = new byte[1024];
	public static void main(String args[]) throws IOException {
		DatagramSocket s = new DatagramSocket(PORT);
		System.out.println("Demarrage du serveur");
		while(true) {
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			s.receive(packet);
			String username = new String(packet.getData(),0,packet.getLength());
			String message = "Bienvenue"+username;
			DatagramPacket messageToSend = new DatagramPacket(message.getBytes(),message.length(),packet.getAddress(),packet.getPort());
			s.send(messageToSend);
		}
	}

}

package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		String respuesta;

		// Create a client socket, connect to server
		Socket clientSocket = new Socket("127.0.0.1", 2009);

		

		// Create output stream, attached to socket
		DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
		// Create input stream, attached to socket
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nIntroduce mensaje para el servidor");
			String mensaje = sc.nextLine();

			// Write out line to socket
			outToClient.writeBytes(mensaje + '\n');

			// Read in line from socket
			respuesta = inFromClient.readLine();

			System.out.println("Servidor: " + respuesta);

		}
	}
}
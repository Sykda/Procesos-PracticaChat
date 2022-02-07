package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		String respuesta;

		// Create welcoming socket at port 2009
		ServerSocket welcomeSocket = new ServerSocket(2009);
		System.out.println("SERVER Conectado al socket de servidor en el puerto: " + welcomeSocket.getLocalPort()
				+ ". Esperando conexiones de clientes.\n");

		// Wait, on welcoming socket for contact by client
		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("CLIENTE Conectado!");

		// Create input stream, attached to socket
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

		// Create output stream, attached to socket
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nIntroduce mensaje para el cliente");
			String mensaje = sc.nextLine();

			// Write out line to socket
			outToClient.writeBytes(mensaje + '\n');

			// Read in line from socket
			respuesta = inFromClient.readLine();

			System.out.println("Cliente: " + respuesta);

		}
	}
}
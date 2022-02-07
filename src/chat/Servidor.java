package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		String respuesta;

		// Crear el socket en el puerto 2009
		ServerSocket welcomeSocket = new ServerSocket(2009);
		System.out.println("SERVER Conectado al socket de servidor en el puerto: " + welcomeSocket.getLocalPort()
				+ ". Esperando conexiones de clientes.\n");

		// Esperamos a que el socket se conecte con el cliente
		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("CLIENTE Conectado!");

		while (true) {

			// Stream del socket
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			// Un reader para introducir por teclado
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

			// Stream de salida
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			// Leemos la respuesta del cliente
			respuesta = inFromClient.readLine();

			System.out.println("Cliente: " + respuesta);

			// Mandamos mensaje al cliente
			System.out.println("\nIntroduce mensaje para el cliente");
			String mensaje = inFromUser.readLine();

			// Write out line to socket
			outToClient.writeBytes(mensaje + '\n');

		}
	}
}
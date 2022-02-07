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

		// Socket para conectar con el servidor
		Socket clientSocket = new Socket("127.0.0.1", 2009);

		// Stream del socket para enviar
		DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
		// Stream del socket para leer
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Scanner para meter la respuesta
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nIntroduce mensaje para el servidor");
			String mensaje = sc.nextLine();

			// Enviamos respuesta al servidor
			outToClient.writeBytes(mensaje + '\n');

			// Leemos desde el servidor
			respuesta = inFromClient.readLine();

			System.out.println("Servidor: " + respuesta);

		}
	}
}
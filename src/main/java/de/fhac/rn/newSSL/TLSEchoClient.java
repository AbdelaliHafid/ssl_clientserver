package de.fhac.rn.newSSL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSEchoClient {
	static final int port = 8000;
	public static void main(String[] args) throws UnknownHostException, IOException {
		
    //truststore
	System.setProperty("javax.net.ssl.trustStore","C:\\Users\\ROGSTRIX\\Server-Client\\newSSL\\src\\main\\java\\de\\fhac\\rn\\rn-fhac-de.jks");
	//truststorePaswword
    System.setProperty("javax.net.ssl.trustStorePassword", "geheim");
		System.out.println("client starts");

        //sslSocketFactory
		SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        //sslSocket
		SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", port);

		Scanner scanner = new Scanner(System.in);
		DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());
		while (scanner.hasNextLine()) {
			System.out.print("Next Message: ");
			dataOutputStream.writeUTF(scanner.nextLine());
			System.out.println(dataInputStream.readUTF());
		}
		scanner.close();
	}
}


package de.fhac.rn.newSSL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
// TODO: import SSL-Classes
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSEchoServer {
	 static final int port = 8000;
    public static void main(String[] args) throws IOException {
    	
        //keystore
        System.setProperty("javax.net.ssl.keyStore","C:\\\\Users\\\\ROGSTRIX\\\\Server-Client\\\\newSSL\\\\src\\\\main\\\\java\\\\de\\\\fhac\\\\rn\\\\rn-fhac-de.jks");
        //keystorepassword
        System.setProperty("javax.net.ssl.keyStorePassword", "geheim");
		
        System.out.println("server starts");
        //sslServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory  = 
                (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        //sslServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        //sslSocket and accepting connection
        Socket sslSocket = sslServerSocket.accept();
        System.out.println("ServerSocket accepted");
            DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());
        while (true) {
            dataOutputStream.writeUTF(dataInputStream.readUTF().toUpperCase());
            System.out.println("Received message and send back");
        }
    }
}

package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
 public static void main(String[] args) {
     ServerSocket serverSocket = null;
     try {
         serverSocket = new ServerSocket(12345); 
         System.out.println("Server is running...");
         
         while (true) {
             Socket clientSocket = serverSocket.accept();
             System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());
             
             ClientHandler clientHandler = new ClientHandler(clientSocket);
             new Thread(clientHandler).start();
         }
     } catch (IOException e) {
         e.printStackTrace();
     } finally {
         try {
             if (serverSocket != null) {
                 serverSocket.close(); 
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
 
 

 static class ClientHandler implements Runnable {
     private Socket clientSocket;
     private PrintWriter out;
     private BufferedReader in;

     public ClientHandler(Socket socket) {
         this.clientSocket = socket;
         try {
             this.out = new PrintWriter(clientSocket.getOutputStream(), true);
             this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     @Override
     public void run() {
         try {
             String request = in.readLine();
             System.out.println("Received from client: " + request);
             
             String response = processRequest(request);
             out.println(response);
             
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 clientSocket.close(); 
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

     private String processRequest(String request) {
         return "Server received: " + request;
     }
 }
}


package Client;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

import Controllers.DangNhapController;
import View.DangNhapView;

public class Client {
 private Socket socket;
 private PrintWriter out;
 private BufferedReader in;
 private DangNhapView dangNhapView;

 public Client(DangNhapView dangNhapView) {
     this.dangNhapView = dangNhapView;
     connect();
 }

 private void connect() {	
     try {
         socket = new Socket("localhost", 12345); 
         System.out.println("Connected to server.");

         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         out.println("Yêu cầu đăng nhập.");

         String response = in.readLine();
         System.out.println("Server response: " + response);

         displayResponseOnUI(response);
         
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 private void displayResponseOnUI(String response) {
     JOptionPane.showMessageDialog(dangNhapView, response);
 }

 public static void main(String[] args) {
     EventQueue.invokeLater(() -> {
         try {
             DangNhapView frame = new DangNhapView();
             DangNhapController controller = new DangNhapController(frame);
             Client client = new Client(frame);
             frame.setVisible(true);
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
 }
}





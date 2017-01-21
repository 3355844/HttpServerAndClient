import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 33558 on 20.01.2017.
 */
public class MainServerRunner {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        String line;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Wait for a client....");
            Socket socket = serverSocket.accept();
            System.out.println("Got a client");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(is);
            DataOutputStream dataOutputStream = new DataOutputStream(os);

            while (true) {
                line = dataInputStream.readUTF();
                System.out.println("Client sent this  Line: " + line);
                System.out.println("Sending it back...");
                dataOutputStream.writeUTF(line);
                System.out.println("Wait for the next line...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

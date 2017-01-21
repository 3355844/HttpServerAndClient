import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 33558 on 20.01.2017.
 */
public class MainServerRunner {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(9999);
            while (true){
                Socket socket = serverSocket.accept();
                System.err.println("Client accepted");
                new Thread(new SocketProcessor(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

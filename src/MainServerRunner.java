import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 33558 on 20.01.2017.
 */
public class MainServerRunner {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        HtmlTransformer htmlTransformer = new HtmlTransformer();
        htmlTransformer.setHeadTitle("My String Title");
        htmlTransformer.setBody("here can be eny information");
        String filePath = "index.html";
        String line;
        PrintWriter printWriter;
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Wait for a client....");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Got a client");
                new Thread(new SocketProcessor(socket, htmlTransformer.toString())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

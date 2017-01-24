import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 33558 on 20.01.2017.
 */
public class MainServerRunner {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        String body = "<form action=\"HttpServer.iml\" method=\"post\" name=\"answer\" >\n" +
                "\n" +
                "    <p><input type=\"text\" name=\"name\">Your Name</p>\n" +
                "    <p>\n" +
                "        <input type=\"radio\" name=\"sex\" value=\"man\"> Man\n" +
                "        <input type=\"radio\" name=\"sex\" value=\"women\"> Women\n" +
                "    </p>\n" +
                "    <p></p>\n" +
                "    <p><select name=\"salary\" size=\"1\"  >\n" +
                "        <option value=\"500\">Start salary 500$</option>\n" +
                "        <option value=\"600\">Start salary 600$</option>\n" +
                "        <option value=\"800\">Start salary 800$</option>\n" +
                "        <option value=\"1000\">Start salary 1000$</option>\n" +
                "    </select>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        <input type=\"checkbox\" name=\"transport\" value=\"car\">Car<br />\n" +
                "        <input type=\"checkbox\" name=\"transport\" value=\"bicycle\">Bicycle<br />\n" +
                "        <input type=\"checkbox\" name=\"transport\" value=\"motorcycle\">Motorcycle<br />\n" +
                "        <input type=\"checkbox\" name=\"transport\" value=\"boat\">Boat<br />\n" +
                "    </p>\n" +
                "    <p><input type=\"submit\" value=\"OK\"> </p>\n" +
                "</form>\n";
        HtmlTransformer htmlTransformer = new HtmlTransformer();
        htmlTransformer.setHeadTitle("My String Title");
        htmlTransformer.setBody(body);
//        String filePath = "index.html";
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

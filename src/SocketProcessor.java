import java.io.*;
import java.net.Socket;

/**
 * Created by 33558 on 23.01.2017.
 */
public class SocketProcessor implements Runnable {

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String html;

    public SocketProcessor(Socket socket, String html) {
        this.socket = socket;
        this.html = html;
        try {
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        readInputHeaders();

        writeResponse(html);
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeResponse(String s) {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + s.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        try {
            outputStream.write(result.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInputHeaders() {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        while (true) {
            try {
                String s = br.readLine();
                buffer.append(s);
                if (s == null || s.trim().length() == 0) {
                    System.out.print(s);
                    break;
                }
                System.out.println(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 33558 on 21.01.2017.
 */
public class HttpClientRunner {
    public static void main(String[] args) {
        int serverPort = 9999;
        String address = "127.0.0.1";
        try {
            InetAddress inetAddress = InetAddress.getByName(address);
            System.out.println("Any of heart of socket with IP address " + address);
            Socket socket = new Socket(inetAddress, serverPort);
            System.out.println("Yes! I just hold of the program.");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line ;
            System.out.println("Type in something and press Enter. Will send it to the Server....");
            System.out.println();
            while (true){
                line = reader.readLine();
                System.out.println("sending this line to the Server...");
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
                line = dataInputStream.readUTF();
                System.out.println("Server answer this...  " + line);
                System.out.println("Enter next Line");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

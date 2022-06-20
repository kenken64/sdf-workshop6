package vtp2022.workshop6.client;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp 
{public static void main(String[] args){
    System.out.println("Cookie Client");
    String[] arr = args[0].split(":");
    
    try {
        Socket sock = new Socket(arr[0], Integer.parseInt(arr[1]));
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Console cons = System.console();
        String input = cons.readLine("Send command to server > ");
        dos.writeUTF(input);
        dos.flush();
        
        String response = dis.readUTF();
        if(response.contains("cookie-text")){
            System.out.println(response);
            String[] cookieValue = response.split(" ");
            System.out.printf("Cookie from server >> %s\n", cookieValue[1]);
        }

        is.close();
        os.close();
        sock.close();
        
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}   
}

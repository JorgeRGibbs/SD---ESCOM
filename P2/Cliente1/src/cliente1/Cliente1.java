/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente1;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente1 {
    static String time;
    public static void main(String[] args) throws IOException {
        while(true){
        // don't need to specify a hostname, it will be the current machine
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");
        
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // read the message from the socket
        time = dataInputStream.readUTF();
        System.out.println("The message sent from the socket was: " + time);
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        //return time;
        }
    }
    public String getTime() {
        return time;
    }

}



package clientes;
import  clientes.Hilo;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import javax.swing.JTextField;
//import hilo.Hilito;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloServer implements Runnable {
    static int port;
    
     public static void setPort(int port) {
        HiloServer.port = port;
    }
    
    @Override
    public void run(){
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        while(true){
        ServerSocket ss;
        try {
            ss = new ServerSocket(port);
            System.out.println("ssa");
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + socket + "!");
        
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // read the message from the socket
        String time = dataInputStream.readUTF();
        System.out.println(time);
        //editar(uno,hora1,time);
        char stringA[] = time.toCharArray();
        Hilo.hora = Integer.parseInt(stringA[0]+""+stringA[1]);
        Hilo.minuto = Integer.parseInt(stringA[3]+""+stringA[4]);
        Hilo.segundo = Integer.parseInt(stringA[6]+""+stringA[7])+1;
        int i = 8;
        String vel ;
        vel = time.substring(8,time.length());
        System.out.println(vel);
        if (vel.equals("")) {
            vel = "1000";
        }
        Hilo.velocidad = Integer.parseInt(vel);
        //Texto.setText(time);
        //Texto.setText(time);
        System.out.println("The message sent from the socket was: " + time);
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        String hora = time.substring(0,8);
        System.out.println(hora);
        Jugador1.hora1.setText(hora);
        //uno.run();
        //return time;
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        }
    
}
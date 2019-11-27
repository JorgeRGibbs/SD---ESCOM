package clientes;
import  clientes.Hilo;
import clientes.TiempoServer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TiempoServer implements Runnable {
    static int port;
    
     public static void setPort(int port) {
        TiempoServer.port = port;
    }
    
    @Override
    public void run(){
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        int this_server = 5802;
        int client_addr = 5803;
        while(true){
        ServerSocket ss;
        try {
            ss = new ServerSocket(this_server);
            System.out.println("ssa");
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + socket + "!");
        
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        BufferedInputStream bis;
        BufferedOutputStream bos;
        InetAddress ip = InetAddress.getLocalHost();
        Socket client = new Socket("localhost", client_addr); //servidor
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        // read the message from the socket
        String request = dataInputStream.readUTF();
        System.out.println("Client sent: "+request+".");
        if(request.equals("T0")){
            String str_time = Tiempo.hora1.getText();
            //Long serv_time = Long.parseLong(str_time);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            System.out.println("simon");
            String dateInString = str_time;
            System.out.println("Nel");
            Date date = sdf.parse(dateInString);
            System.out.println(dateInString);
            System.out.println("Date - Time in milliseconds : " + date.getTime());
            Long mil_sec = date.getTime();
            //dos.writeUTF("TS");
            dos.writeUTF(mil_sec.toString());
        }
        //editar(uno,hora1,time);
        //char stringA[] = time.toCharArray();
        //Hilo.hora = Integer.parseInt(stringA[0]+""+stringA[1]);
        //Hilo.minuto = Integer.parseInt(stringA[3]+""+stringA[4]);
        //Hilo.segundo = Integer.parseInt(stringA[6]+""+stringA[7])+1;
        //int i = 8;
        //String vel ;
        //vel = time.substring(8,time.length());
        //System.out.println(vel);
        /*if (vel == "") {
            vel = "1000";
        }
        Hilo.velocidad = Integer.parseInt(vel);
        //Texto.setText(time);
        //Texto.setText(time);
        System.out.println("The message sent from the socket was: " + time);*/
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        //uno.run();
        //return time;
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(TiempoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        }
    
}
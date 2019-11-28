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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.mysql.jdbc.Connection;
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
    private static Connection conn;
    
     public static void setPort(int port) {
        TiempoServer.port = port;
    }
     
     public static Connection getconn() {
        if (conn == null) {

            try {
                String url = new String();
                String user = new String();
                String password = new String();
                url = "jdbc:mysql://localhost:3306/clk";
                user = "root";
                password = "root";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                System.out.println("yes");
                conn = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("Alles ist gut");
                //JOptionPane.showMessageDialog(null,"Connection Successful");
            } catch (SQLException e) {
                System.out.println(e);
                //JOptionPane.showMessageDialog(null, "Connection Failed" +e);
            }
        }
        return conn;
    }
     
    
    @Override
    public void run(){
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        TiempoServer.getconn(); //obtiene conexion a la base de datos 
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
        System.out.println(socket.getLocalPort());
        Socket client = new Socket("localhost", /*socket.getLocalPort()*/5803); //servidor
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        // read the message from the socket
        String request = dataInputStream.readUTF();
        System.out.println("Client sent: "+request+".");
        if(request.equals("T0")){
            String t0 = dataInputStream.readUTF();
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
            String Latency = dataInputStream.readUTF();
            String Error = dataInputStream.readUTF();
            String Tc = dataInputStream.readUTF();
            String sent_ip = dataInputStream.readUTF();
            String name = dataInputStream.readUTF();
            /*String query = " INSERT INTO HoraCentral (HPrev, HRef)" + " values (?, ?)"; //inserta valores recibidos en base de datos
            PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
            System.out.println("sending ip");
            preparedStmt.setString(1, str_time);
            preparedStmt.setString(2, str_time);
            preparedStmt.execute(); //ejecuta comando sql
            query = " INSERT INTO HoraEquipos (hEquipo,aEquipo,ralentizar,Equipos_ID)" + " values (?, ?, ?, ?)"; //inserta valores recibidos en base de datos
            preparedStmt = (PreparedStatement) conn.prepareStatement(query);
            preparedStmt.setString(1, t0);
            preparedStmt.setString(2, str_time); //no c que va aqui 
            preparedStmt.setString(3, str_time);
            preparedStmt.setString(4, "1");
            preparedStmt.execute(); //ejecuta comando sql
            query = " INSERT INTO Equipos (IP,Nombre,Latencia,HoraEquipos_ID)" + " values (?, ?, ?,?)"; //inserta valores recibidos en base de datos
            preparedStmt = (PreparedStatement) conn.prepareStatement(query);
            preparedStmt.setString(1, sent_ip);
            preparedStmt.setString(2, name); //no c que va aqui 
            preparedStmt.setString(3, Latency);
            preparedStmt.setString(4, "12");
            preparedStmt.execute(); //ejecuta comando sql*/
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
            } /*catch (SQLException ex) {
                Logger.getLogger(TiempoServer.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }
        }
    
}
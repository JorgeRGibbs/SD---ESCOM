package clientes;

import clientes.Hilo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
//import hilo.Hilito;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.mysql.jdbc.Connection;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
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

    public static void insert(String str_time, String sent_ip, String name, String Latency, String Tc, String Error, String ral, String id, int type, int IDSincr, int IDEquipo) throws SQLException {
        String query;
        PreparedStatement preparedStmt;
        if (type == 0) {
            query = " INSERT INTO HoraCentral (HRef)" + " values (?)"; //inserta valores recibidos en base de datos
            preparedStmt = (PreparedStatement) conn.prepareStatement(query);
            System.out.println("sending ip");
            preparedStmt.setString(1, str_time);
            //preparedStmt.setString(2, str_time);
            preparedStmt.execute(); //ejecuta comando sql
            System.out.println("Inserted HoraCentral");
        }
        query = " INSERT INTO Equipos (Nombre,Ip,Latencia)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
        preparedStmt = (PreparedStatement) conn.prepareStatement(query);
        preparedStmt.setString(2, name);
        preparedStmt.setString(1, sent_ip);
        preparedStmt.setString(3, Latency);
            //preparedStmt.setString(4, Latency);
        //preparedStmt.setString(4, "3");
        preparedStmt.execute(); //ejecuta comando sql*/
        System.out.println("Inserted Equipos");
        query = " INSERT INTO HoraEquipos (IDhSincr, IDequipo,hEquipo, Error,ralentizar)" + " values (?, ?, ?, ?, ?)"; //inserta valores recibidos en base de datos
        preparedStmt = (PreparedStatement) conn.prepareStatement(query);
        preparedStmt.setInt(1, IDSincr);
        preparedStmt.setInt(2, IDEquipo);
        preparedStmt.setString(3, Tc);
        preparedStmt.setString(4, Error); //no c que va aqui 
        preparedStmt.setString(5, ral);
        //preparedStmt.setString(4, "3");
        preparedStmt.execute(); //ejecuta comando sql   
        System.out.println("Inserted HoraEquipos");
    }
    
     public void respaldarBD(){
        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u root -proot clk");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("respaldo.sql");

            byte[] buffer = new byte[1000];

            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            fos.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
     
     public void cargarBD(){
        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u root -proot clk");
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream("respaldo.sql");

            byte[] buffer = new byte[1000];

            int leido = fis.read(buffer);
            while (leido > 0) {
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }
            os.flush();
            os.close();
            fis.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        TiempoServer.getconn(); //obtiene conexion a la base de datos 
        int this_server = 5802;
        int client_addr = 5803;
        int type = 0;
        while (true) {
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
                Socket client = new Socket("localhost", /*socket.getLocalPort()*/ 5803); //servidor
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                // read the message from the socket
                String request = dataInputStream.readUTF();
                System.out.println("Client sent: " + request + ".");
                if (request.equals("T0")) {
                    String t0 = dataInputStream.readUTF();
                    String str_time = Tiempo.hora1.getText();
            //Long serv_time = Long.parseLong(str_time);
                    //SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("simon");
                    //  String dateInString = str_time;
                    System.out.println("Nel");
            //Date date = sdf.parse(dateInString);
                    // System.out.println(dateInString);
                    //System.out.println("Date - Time in milliseconds : " + date.getTime());
                    //Long mil_sec = date.getTime();
                    //dos.writeUTF("TS");
                    System.out.println("Sending time:" + str_time);
                    dos.writeUTF(str_time);
                    String IDSincr = dataInputStream.readUTF();
                    String IDEquipo = dataInputStream.readUTF();
                    String Latency = dataInputStream.readUTF();
                    String Error = dataInputStream.readUTF();
                    String Tc = dataInputStream.readUTF();
                    String sent_ip = dataInputStream.readUTF();
                    String name = dataInputStream.readUTF();
                    String id = dataInputStream.readUTF();

                    int idsincr = Integer.parseInt(IDSincr);
                    int idEqui = Integer.parseInt(IDEquipo);
                    String ral = Integer.toString(((int) (Math.random() * ((1 - 0) + 1)) + 0));
                    insert(str_time, sent_ip, name, Latency, Tc, Error, ral, id, type, idsincr, idEqui = 0);
                    try {
                        String player_addr = dataInputStream.readUTF();
                        String player_name = dataInputStream.readUTF();
                        insert(str_time, player_addr, player_name, Latency, Tc, Error, ral, id, type, idsincr, idEqui = 1);
                    } catch (Exception e) {
                        System.out.println("No player data recieved.");
                    }
                }
                
                System.out.println("Closing sockets.");
                ss.close();
                socket.close();
        //uno.run();
                //return time;
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TiempoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

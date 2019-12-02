/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author GIBS
 */

public class ServidorTiempo {
    public void run(){
        ServerSocket server;
        Socket connection;
        int this_server = 5802;
        //int server2 = 5803;
        DataOutputStream output;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        Long serv_time;
        String str_milis;
        //Long serv2_time;
        //byte[] = recievedData;
        int in; 
        String flag;
        
        try{
            //Servidor Socket en el puerto 5000
            server = new ServerSocket( this_server );
            while ( true ) {
                //Aceptar conexiones
                connection = server.accept();
                //Buffer de 1024 bytes
                //receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis=new DataInputStream(connection.getInputStream());
                //file = "Hola.txt";
                //file = dis.readUTF();
                flag = dis.readUTF();
                str_milis = dis.readUTF();
                serv_time = Long.parseLong(str_milis);
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String dateInString = hora1B.getText();
                Date date = sdf.parse(dateInString);	
                System.out.println(dateInString);
            System.out.println("Date - Time in milliseconds : " + date.getTime());
            Long mil_sec = date.getTime();
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorTiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

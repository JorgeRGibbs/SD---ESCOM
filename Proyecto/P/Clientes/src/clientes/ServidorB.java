/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import static clientes.Jugador1.listen;
import static clientes.Jugador1.dos;
import java.rmi.RemoteException;
import java.util.Calendar;
import javax.swing.JTextField;
//import hilo.Hilito;//
//import static servidor.Interfaz.cuatro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.millis;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static practica1.CoordinadorServer.model;
//import static practica1.CoordinadorServer.readFile_suma;

/**
 *
 * @author GIBS
 */
public class ServidorB extends javax.swing.JFrame implements Runnable {

    Thread h;
    private static Connection conn;
    static DefaultTableModel model;

    /**
     * Creates new form NADA
     * @throws java.rmi.RemoteException
     */
    public ServidorB() throws RemoteException {
        initComponents();
        h = new Thread(this);
        h.start();
        hora1B.setEnabled(false);
        
        
        Calendar calendario = Calendar.getInstance();
        int hora, minuto, segundo;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND);
        dos = new Hilo((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora1B);
        Thread t1 = new Thread(dos);
        listen = new HiloServer();
        HiloServer.setPort(8891);
        Thread t2 = new Thread(listen);
        t1.start();
        t2.start();
    }
    

    void editar(Hilo hilo, JTextField hora1B) {

        hora1B.setEnabled(false);
        String cadena = hora1B.getText();
        char cadenaA[] = cadena.toCharArray();
        int i = 0;
        int num = 0, num2 = 0;
        while (i < cadenaA.length) {
            if (cadenaA[i] != ':') {
                if (i == 0 || i == 3 || i == 6) {
                    num = Integer.parseInt("" + cadenaA[i]) * 10;
                }
                if (i == 1 || i == 4 || i == 7) {
                    num = num + Integer.parseInt("" + cadenaA[i]);
                    if (i == 1) {
                        if (num >= 24) {
                            JOptionPane.showMessageDialog(null, "Error! Formato incorrecto");
                        } else {
                            hilo.hora = num;
                        }
                    } else if (i == 4) {
                        if (num >= 60) {
                            JOptionPane.showMessageDialog(null, "Error! Formato incorrecto");
                        } else {
                            hilo.minuto = num;
                        }
                    } else if (i == 7) {
                        if (num >= 60) {
                            JOptionPane.showMessageDialog(null, "Error! Formato incorrecto");
                        } else {
                            hilo.segundo = num;
                        }
                    }
                }
            }
            i++;

        }
        //System.out.println(hora1B.getText());
        hilo.valor = true;
    }

    void sendTime() throws IOException{
        String name = "ServerB";
        InetAddress ip = InetAddress.getLocalHost();
        int time_port = 5802;
        int this_client = 5803;
        int player_port = 8889;
        String player_addr = "localhost";
        String player_name = "Jugador1";
        String player_id = "P1";
        String server_id = "SB";
        ServerSocket serverSocket = new ServerSocket(this_client);
        System.out.println(hora1B.getText());
        //SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String t0 = hora1B.getText();
        //Date date = sdf.parse(dateInString);
        System.out.println("T0 -"+ t0);
        //System.out.println("T0 - Time in milliseconds : " + date.getTime());
        //Long t0 = date.getTime();
        Socket socket = new Socket("localhost",time_port);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("T0"); //Mandar un flag para indicar la peticion de la hora
        dos.writeUTF(t0); //Mandar t0, hora actual del reloj al servidor
        //dos.writeUTF(t0.toString());
        //t0.toString();
        //System.out.println(t0.toString());
        socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //InetAddress ip = InetAddress.getLocalHost();
        //Socket client = new Socket("localhost", this_server); //servidora
        //dos=new DataOutputStream(client.getOutputStream());
        // read the message from the socket
        String Ts = dataInputStream.readUTF(); //Leer la hora Tserver (en miliseg.)
        System.out.println("Ts: "+Ts);
        String t1 = hora1B.getText();
        System.out.println("T1 -"+ t1);
        char[] ts_array = Ts.toCharArray();
        System.out.println(ts_array);
        for (int i = 0; i < 8; i++) {
            System.out.println(ts_array[i]);
        }
        //String aux = String.copyValueOf(ts_array);
        int Ts_s = (Integer.parseInt(Ts.substring(6)));
        System.out.println("Ts seconds:"+Ts_s);
        //char[] array = t0.toCharArray();
        int t0_s = (Integer.parseInt(t0.substring(6)));
        //char [] array1= t1.toCharArray();
        int t1_s = (Integer.parseInt(t1.substring(6)));
        int Latency = t1_s - t0_s;
        int Error = Latency/2;
        int Tc_s = Error + Ts_s;
        String Tc = Ts.subSequence(0,6)+String.format("%02d",Tc_s);//+Integer.toString(Tc_s);
        String hora  = Ts.subSequence(0,2)+"";
        String minuto = Ts.subSequence(3,5)+"";
        String segundo = Ts.subSequence(6,8)+"";
        System.out.println(hora+":"+minuto+":"+segundo);
        Hilo.hora = Integer.parseInt(hora);
        Hilo.minuto = Integer.parseInt(minuto);
        Hilo.segundo = Integer.parseInt(segundo);
        //ts_array[0]+ts_array[1]+ts_array[2]+ts_array[3]+ts_array[4]+ts_array[5]+Integer.toString(Tc_s);
        System.out.println("Tc: "+Tc);
        System.out.println("Error  (s): "+Integer.toString(Error));
        System.out.println("Latency (s) : "+Integer.toString(Latency));
        //date = sdf.parse(dateInString);
        //System.out.println(dateInString);
        // System.out.println("T1 -"+ t1);
        //Long t1 = date.getTime();
        //System.out.println(t1.toString());
        dos.writeUTF(Integer.toString(Latency)); //Mandar Latencia
        dos.writeUTF(Integer.toString(Error)); //Mandar Error
        dos.writeUTF(Tc);  //Mandar tiempo de cliente
        dos.writeUTF(ip.getHostAddress());
        dos.writeUTF(name);
        dos.writeUTF(server_id);
        //String request = dataInputStream.readUTF();

        try{
            socket = new Socket(player_addr,player_port);
            dos.writeUTF(player_addr);
            dos.writeUTF(player_name);
            dos.writeUTF(player_id);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            System.out.println(Tc);
            dos.writeUTF(Tc+"1000");
            
            
            socket.close();
            dos.flush();
            dos.close();
            socket.close();
            serverSocket.close();
        }catch(Exception e){
            System.out.println("Player unavailable");
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        campoHora = new javax.swing.JTextField();
        campoSuma = new javax.swing.JTextField();
        campoIp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hora1B = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHoraActionPerformed(evt);
            }
        });

        campoSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSumaActionPerformed(evt);
            }
        });

        campoIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIpActionPerformed(evt);
            }
        });

        jLabel1.setText("       HORA");

        jLabel2.setText("        SUMA");

        jLabel3.setText("            IP");

        hora1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora1BActionPerformed(evt);
            }
        });

        jLabel4.setText("Hora Servidor: ");

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Pedir hora");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hora1B, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hora1B, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHoraActionPerformed

    private void campoSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSumaActionPerformed

    private void campoIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIpActionPerformed

    private void hora1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora1BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora1BActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //dos.valor = false;
        hora1B.setEnabled(true);
        dos.valor = false;
        //editar(dos,hora1B);
        //hora1B.setEnabled(true);
        //hora1B.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*try {
            // TODO add your handling code here:
            sendTime();
        } catch (IOException ex) {
            Logger.getLogger(ServidorB.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        editar(dos,hora1B);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            sendTime();
        } catch (IOException ex) {
            Logger.getLogger(ServidorB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
                           
    public static void editar(Hilo hilo, JTextField hora1B, String time) {

        System.out.println("editando");
        hora1B.setEnabled(false);
        String cadena = time;
        char cadenaA[] = cadena.toCharArray();
        int i = 0;
        int num = 0, num2 = 0;
        String horaS = cadenaA[0] + "" + cadenaA[1];
        hilo.hora = Integer.parseInt(horaS);
        String minutoS = cadenaA[3] + "" + cadenaA[4];
        hilo.minuto = Integer.parseInt(minutoS);
        String segundoS = cadenaA[6] + "" + cadenaA[7];
        hilo.segundo = Integer.parseInt(segundoS);
        //hilo.setSegundo(Integer.parseInt(segundoS));
        System.out.println(hilo.hora);
        System.out.println(hilo.minuto);
        System.out.println(hilo.segundo);
        System.out.println("yes");
        hilo.valor = true;
        hora1B.setText(time);

    }

    public static Connection getconn() {
        if (conn == null) {

            try {
                String url = new String();
                String user = new String();
                String password = new String();
                url = "jdbc:mysql://localhost:3306/coordinador1";
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

    public static int readFile_suma(String file_path) throws IOException {
        int sum = 0;
        File file = new File(file_path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = "";
        st = br.readLine();

        //System.out.println(st);
        //list[i] = Integer.parseInt(st);
        //i++;
        //System.out.println(st);
        String[] numeros = st.split(",");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] " + Integer.parseInt(numeros[i]));
            sum += Integer.parseInt(numeros[i]);
        }

        return sum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ServidorB().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(ServidorB.class.getName()).log(Level.SEVERE, null, ex);
                }
                ServidorB.getconn(); //obtiene conexion a la base de datos  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoHora;
    private javax.swing.JTextField campoIp;
    private javax.swing.JTextField campoSuma;
    private javax.swing.JTextField hora1B;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServerSocket server;
        Socket connection;

        int this_server, next_server;
        this_server = 5800;
        next_server = 5801;
        
        DataOutputStream output;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        List lista = new ArrayList();
        byte[] receivedData;
        String fileName;
        int in;
        String file;
        String localFile;
        String flag;
        try {
            //Servidor Socket en el puerto 5000
            server = new ServerSocket(this_server);
            while (true) {
                //Aceptar conexio0nes
                connection = server.accept();
                //Buffer de 1024 bytes
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis = new DataInputStream(connection.getInputStream());
                //file = "Hola.txt";//dis.readUTF();
                //file = dis.readUTF();
                flag = dis.readUTF();
                int lim = dis.readInt();
                String cadena = "";
                int tam = cadena.length();
                int resultado = 0;
                char ce;
                //System.out.println(file);
                System.out.println(flag);
                if (flag.equals("0")) {
                    int i = 0;
                    //INICIALIZAR LA SUMA
                    //int resultado = 0;
                    System.out.println("imma read the numbas");
                    //eNTRA FUNCION EVALUAR CADENA
                    while (i < lim) {
                        //lista.add(Integer.parseInt(dis.readUTF()));
                        //System.out.println(lista);
                        cadena = cadena + dis.readUTF();
                        i++;
                    }
                    
        
    
        for(int j=0; j<tam; j++){
            ce = cadena.charAt(j);
            switch (ce){
                case 'a':
                    resultado += 1;
                    break;
                case 'e':
                    resultado += 1;
                    break;
                case 'i':
                    resultado += 1;
                    break;
                case 'o':
                    resultado += 1;
                    break;
                case 'u':
                    resultado += 1;
                    break;
                case 'A':
                    resultado += 1;
                    break;
                case 'E':
                    resultado += 1;
                    break;
                case 'I':
                    resultado += 1;
                    break;
                case 'O':
                    resultado += 1;
                    break;
                case 'U':
                    resultado += 1;
                    break;
                case '1':
                    resultado += 1;
                    break;
                case '2':
                    resultado += 1;
                    break;
                case '3':
                    resultado += 1;
                    break;
                case '4':
                    resultado += 1;
                    break;
                case '5':
                    resultado += 1;
                    break;
                case '.':
                    resultado += 1;
                    break;
                case ',':
                    resultado += 1;
                    break;
                case ';':
                    resultado += 1;
                    break;
                case ':':
                    resultado += 1;
                    break;
                case '\'':
                    resultado += 1;
                    break; 
                case '+':
                    resultado += 1;
                    break;
                case '-':
                    resultado += 1;
                    break;
                case '*':
                    resultado += 1;
                    break;
                case '/':
                    resultado += 1;
                    break;
                case '=':
                    resultado += 1;
                    break; 
                default:
                    break;
            } 
        }
                    
                    //int suma = lista.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(lista);
                    String ip = dis.readUTF();
                    String hour = dis.readUTF();
                    System.out.println("recieved ip");
                    //System.out.println("Recibi archivo: " + file); //recibe archivo
                    //System.out.println("Desde: " + ip); //recibe la direccion ip
                    System.out.println(hour); // recibe hora
                    //file = file.substring(file.indexOf("\\")+1,file.length()); //obtiene solo el nombre del archivo
                    //System.out.println(list);
                    //Para guardar fichero recibido
                    //bos = new BufferedOutputStream(new FileOutputStream("..\\" + file)); //almacena en el escritorio
                    while ((in = bis.read(receivedData)) != -1) {
                        //bos.write(receivedData,0,in);
                        System.out.println(hour);
                        hour = hour.substring(0, 2) + ":" + hour.substring(2, 4) + ":" + hour.substring(4, 6);
                        //int suma = readFile_suma(file);//lee numeros
                        campoHora.setText(hour);
                        campoSuma.setText(Integer.toString(resultado));
                        campoIp.setText(ip);

                        System.out.println("Los caracteres se repiten: " + resultado + " veces");
                        String query = " INSERT INTO PLAYER (IP, HORA , SUMA)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
                        PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                        System.out.println("sending ip");
                        preparedStmt.setString(1, ip);
                        preparedStmt.setString(2, hour);
                        preparedStmt.setInt(3, resultado);
                        preparedStmt.execute(); //ejecuta comando sql
                        //llenaTabla();
                        //if(flag.equals("0")){
                        DataInputStream input;
                        BufferedInputStream s_bis;
                        BufferedOutputStream s_bos;
                        flag = "1";
    //                String fileName;
                        //int in;
                        try {
                        //InetAddress ip = InetAddress.getLocalHost();
                            //final File s_localFile = new File( this.fileName );
                            Socket client = new Socket("localhost", next_server); //servidor
                            //bis = new BufferedInputStream(new FileInputStream(localFile));
                            //bos = new BufferedOutputStream(client.getOutputStream());
                            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                        //Scanner scanner = new Scanner(new File(this.fileName));
                        /*dos.writeUTF(localFile.getName());
                             while (scanner.hasNextLine()) {
                             String line = scanner.nextLine();
                             dos.writeUTF(line);
                             // process the line
                             }*/
                            dos.writeUTF(flag);
                            dos.writeUTF(ip);
                            dos.writeUTF(hour);
                            dos.writeUTF(Integer.toString(resultado));
                            /*//dos.writeUTF(ip.getHostAddress());
                             String uhr;
                             String minuten;
                             String sekunden;
                             if (Hilo.hora < 10) {
                             uhr = "0"+Integer.toString(Hilo.hora);
                             }
                             else {
                             uhr = Integer.toString(Hilo.hora);
                             }
                             if (Hilo.minuto < 10) {
                             minuten = "0"+Integer.toString(Hilo.minuto);
                             }
                             else {
                             minuten = Integer.toString(Hilo.minuto);
                             }
                             if (Hilo.segundo < 10) {
                             sekunden = "0"+Integer.toString(Hilo.segundo);
                             }
                             else {
                             sekunden = Integer.toString(Hilo.segundo);
                             }

                             dos.writeUTF(uhr+minuten+sekunden);
                             byteArray = new byte[8192];
                             while ((in = bis.read(byteArray)) != -1){
                             bos.write(byteArray,0,in);
                             }
                             */
                            //s_bis.close();
//                       bos.close();
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                } else {
                    System.out.println(flag);
                    System.out.println("Recieveing forwarded data...");
                    String ip = dis.readUTF();
                    System.out.println("ip:" + ip + "");
                    String hour = dis.readUTF();
                    System.out.println("time:" + hour + "");
                    String suma = dis.readUTF();
                    System.out.println("sum:" + suma + "");
                    campoHora.setText(hour);
                    campoSuma.setText(suma);
                    campoIp.setText(ip);
                    System.out.println("La suma es: " + suma);
                    String query = " INSERT INTO PLAYER (IP, HORA , SUMA)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
                    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                    System.out.println("sending ip");
                    preparedStmt.setString(1, ip);
                    preparedStmt.setString(2, hour);
                    preparedStmt.setInt(3, Integer.parseInt(suma));
                    preparedStmt.execute(); //ejecuta comando sql

                }
                byte[] byteArray;
                //bos.close();
                dis.close();
                //conn.close();
            }
        } catch (Exception e) {
            System.err.println(e);
            System.out.println(e);
        }
    }

    public static void llenaTabla() throws SQLException {
        String query = "SELECT * FROM PLAYER"; // consulta a la tabla informacion
        int i = 0;
        //System.out.println("AJAAAAAAAAAAAA");
        // create the java statement
        Statement st = (Statement) conn.createStatement();

        // execute the query,nd get a java resultset
        ResultSet rs = st.executeQuery(query); //Conjunto de valores devueltos por la consulta
        //model = (DefaultTableModel) jTable1.getModel(); //para modificar tabla JTable
        //model.getDataVector().removeAllElements();//borra valores de la tabla para volver a llenar

        // iterate through the java resultset
        while (rs.next()) {
            String ip = rs.getString("IP");
            String hora = rs.getString("HORA");
            int suma = rs.getInt("SUMA");
        // print the results
            //System.out.format("Consulta ["+i+"]: %s, %s, %s\n", ip, hora, suma);
            i++;
            String[] row = {Integer.toString(suma), ip, hora}; //agrega los valores 
            model.addRow(row);
        }
    }
}

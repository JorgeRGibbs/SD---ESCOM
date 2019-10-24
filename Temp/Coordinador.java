/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static practica1.CoordinadorServer.model;
//import static practica1.CoordinadorServer.readFile_suma;


/**
 *
 * @author cesargasca
 */
public class Coordinador extends javax.swing.JFrame implements Runnable{
Thread h;
private static Connection conn;
static DefaultTableModel model;
    /**
     * Creates new form NADA
     */
    public Coordinador() {
        initComponents();
        //recibe();
        h = new Thread(this);
        h.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Suma", "IP", "Hora"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton1)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            llenaTabla(); //refresca tabla con valores de la base de datos
        } catch (SQLException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static Connection getconn() {
        if (conn==null) {  
            
          try {
           String url = new String();
           String user = new String();
           String password = new String();
           url = "jdbc:mysql://localhost:3306/coordinador";
           user = "root";
           password = "root";
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                      System.out.println("yes");
           conn = (Connection) DriverManager.getConnection(url,user,password);
              System.out.println("Alles ist gut");
           //JOptionPane.showMessageDialog(null,"Connection Successful");
                } catch (SQLException e) {
                    System.out.println(e);
                    //JOptionPane.showMessageDialog(null, "Connection Failed" +e);
                }       
        }
        return conn;
    }
    
    public static int readFile_suma(String file_path) throws IOException{
        int sum = 0;
        File file = new File(file_path);
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String st = ""; 
        st = br.readLine();
            
        //System.out.println(st);
         //list[i] = Integer.parseInt(st);
                //i++;
         //System.out.println(st);
        String [] numeros = st.split(",");
        for(int i = 0 ; i < numeros.length ; i++){
            System.out.println("["+i+"] " + Integer.parseInt(numeros[i]));
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
            java.util.logging.Logger.getLogger(Coordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Coordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Coordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Coordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Coordinador().setVisible(true);
                Coordinador.getconn(); //obtiene conexion a la base de datos  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServerSocket server;
        Socket connection;

        DataOutputStream output;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        List lista = new ArrayList();
        byte[] receivedData;
        int in;
        String file;

        try{
            //Servidor Socket en el puerto 5000
            server = new ServerSocket( 5800 );
            while ( true ) {
                //Aceptar conexiones
                connection = server.accept();
                //Buffer de 1024 bytes
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis=new DataInputStream(connection.getInputStream());
                file = dis.readUTF();
                int i = 0;
                int suma = 0;
                while(i<100){
                    //lista.add(Integer.parseInt(dis.readUTF()));
                    //System.out.println(lista);
                    suma = suma + Integer.parseInt(dis.readUTF());
                    i++;
                }
                //int suma = lista.stream().mapToInt(Integer::intValue).sum();
                System.out.println(lista);
                String client_host = dis.readUTF();
                String hour = dis.readUTF();
                //System.out.println("Recibi archivo: " + file); //recibe archivo
                //System.out.println("Desde: " + client_host); //recibe la direccion ip
                System.out.println(hour); // recibe hora
                file = file.substring(file.indexOf("\\")+1,file.length()); //obtiene solo el nombre del archivo
                //System.out.println(list);
                //Para guardar fichero recibido
                bos = new BufferedOutputStream(new FileOutputStream("..\\" + file)); //almacena en el escritorio
                while ((in = bis.read(receivedData)) != -1){
                bos.write(receivedData,0,in);
                System.out.println(hour);
                hour = hour.substring(0,2)+":"+hour.substring(2,4)+":"+hour.substring(4,6);
                //int suma = readFile_suma(file);//lee numeros
                System.out.println("La suma es: " + suma);
                String query = " INSERT INTO PLAYER (IP, HORA , SUMA)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
                PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                preparedStmt.setString (1, client_host);
                preparedStmt.setString (2, hour);
                preparedStmt.setInt(3, suma);
                preparedStmt.execute(); //ejecuta comando sql
                //llenaTabla();
              
            }
            bos.close();
            dis.close();
            //conn.close();
            }
        }catch (Exception e ) {
            System.err.println(e);
            System.out.println(e);
        }
    }
    public static void llenaTabla() throws SQLException{
    String query = "SELECT * FROM PLAYER"; // consulta a la tabla informacion
    int i = 0;
        //System.out.println("AJAAAAAAAAAAAA");
      // create the java statement
      Statement st = (Statement) conn.createStatement();
      
      // execute the query,nd get a java resultset
      ResultSet rs = st.executeQuery(query); //Conjunto de valores devueltos por la consulta
      model = (DefaultTableModel) jTable1.getModel(); //para modificar tabla JTable
      model.getDataVector().removeAllElements();//borra valores de la tabla para volver a llenar


      // iterate through the java resultset
      while (rs.next())
      {
        String ip = rs.getString("IP");
        String hora = rs.getString("HORA");
        int suma = rs.getInt("SUMA");
        // print the results
        //System.out.format("Consulta ["+i+"]: %s, %s, %s\n", ip, hora, suma);
        i++;
        String [] row = {Integer.toString(suma),ip,hora}; //agrega los valores 
        model.addRow(row);
      }
    }
    
          
}

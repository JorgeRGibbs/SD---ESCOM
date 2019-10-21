package clientes;
import static clientes.Cliente1.uno;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
//import hilo.Hilito;//
//import static servidor.Interfaz.cuatro;

import java.io.IOException;


public class Cliente1 extends javax.swing.JFrame {

    static Hilo uno;
    static Hilo dos;
    static Hilo tres;
    static Hilo cuatro;
    static HiloServer listen;
    int port;
    //HiloServer.setPort(8888);
   
    
     
    public Cliente1() throws RemoteException, IOException {
        initComponents();
        this.setTitle("Cliente1");
        System.out.println("Iniciando UI");
        hora1.setEnabled(false);
        //hora2.setEnabled(false);
        //hora3.setEnabled(false);
        //hora4.setEnabled(false);

        this.setLocationRelativeTo(null);

        Calendar calendario = Calendar.getInstance();

        int hora, minuto, segundo;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND);
        uno = new Hilo((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60),hora1);
        Thread t1 = new Thread(uno);
        listen = new HiloServer();
        HiloServer.setPort(8889);
        Thread t2 = new Thread(listen);
        t1.start();
        t2.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrpEditar = new javax.swing.ButtonGroup();
        hora1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        hora1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora1ActionPerformed(evt);
            }
        });
        hora1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hora1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hora1KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Ajustar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 204));
        jLabel7.setText("PRÁCTICA 1. RELOJES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /* void enviar(Hilo hilo, JTextField hora) throws IOException {
        int port = (int)(Math.random() * 10000 + 1200);
        // need host and port, we want to connect to the ServerSocket at port 7777
        String time = hora.getText();
        System.out.println(time);
        Socket socket = new Socket("localhost", 7559);
        System.out.println("Connected!");
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("Sending string to the ServerSocket");
        dataOutputStream.writeUTF(time);
        dataOutputStream.flush(); 
        dataOutputStream.close(); 
        System.out.println("Closing socket and terminating program.");
        socket.close();
    }*/
   
        
    public static void editar(Hilo hilo, JTextField hora1,String time) {

        System.out.println("editando");
        hora1.setEnabled(false);
        String cadena = time;
        char cadenaA[] = cadena.toCharArray();
        int i = 0;
        int num = 0, num2 = 0;
        String horaS = cadenaA[0]+""+cadenaA[1];
        hilo.hora = Integer.parseInt(horaS);
        String minutoS = cadenaA[3]+""+cadenaA[4];
        hilo.minuto = Integer.parseInt(minutoS);
        String segundoS = cadenaA[6]+""+cadenaA[7];
        hilo.segundo = Integer.parseInt(segundoS);
        //hilo.setSegundo(Integer.parseInt(segundoS));
        System.out.println(hilo.hora);
        System.out.println(hilo.minuto);
        System.out.println(hilo.segundo);
        System.out.println("yes");
        hilo.valor = true;
        hora1.setText(time);
        //System.out//.println(hilo.segundo);
       //hilo.valor = true;
        //hora.SetText()
       /* while (i < cadenaA.length) {
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

        }*/
        
    }

    public static void setUno(Hilo uno) {
        Cliente1.uno = uno;
    }


    private void hora1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora1KeyPressed

    private void hora1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora1KeyTyped

        if (hora1.getText().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_hora1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void hora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora1ActionPerformed

    public static void main(String args[]) throws RemoteException, MalformedURLException, InterruptedException, AlreadyBoundException, IOException {

//        recibir(hora1);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Cliente1().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
           /* public void recibir(){

            }*/
            
        });
    }
        
        

        /* Create and display the form */
        //hora1.setEditable(false);
        //hora1.setText("Esperando hora...");
        

        


       /* Naming.rebind("rhilito1", dos);
        Naming.rebind("rhilito2", tres);
        Naming.rebind("rhilito3", cuatro);
               */
       
         //java.rmi.registry.Registry rmiRegistry = java.rmi.registry.LocateRegistry.
         //createRegistry(6060); //Puerto
         //rmiRegistry.rebind("rhilito1", dos);
         //rmiRegistry.rebind("rhilito2", tres);
         //rmiRegistry.rebind("rhilito3", cuatro);
         
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrpEditar;
    private static javax.swing.JTextField hora1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
   /* //@Override
    public void run() throws IOException {
    while(true){
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        ServerSocket ss = new ServerSocket(7559);
        System.out.println("ssa");
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");
        
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // read the message from the socket
        time = dataInputStream.readUTF();
        //editar(uno,hora1,time);
        hora1.setText(time);
        hora1.setText(time);
        System.out.println("The message sent from the socket was: " + time);
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        uno.run();
        //return time;
        }
    }*/
}


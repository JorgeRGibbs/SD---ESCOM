package clientes;
import clientes.Hilo;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import hilo.Hilito;
import static clientes.Interfaz.cuatro;
import com.mysql.jdbc.Connection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;

import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class Interfaz extends javax.swing.JFrame {

    static Hilo uno;
    static Hilo dos;
    static Hilo tres;
    static Hilo cuatro;
    
private static Connection conn;
static DefaultTableModel model;

       AlgoritmoAnillo aa = new AlgoritmoAnillo();
       
       public static boolean procesando = false;
       public static MulticastSocket s1;
       
    

    public Interfaz() throws RemoteException {
        
        initComponents();
        this.setTitle("Reloj");

        try {
            //Saber cuál es el nombre de la máquina
            //Suponiendo que todos tienen un número de nombre xD
            String da = InetAddress.getLocalHost().getHostName()+"";
            //String aux = "E1";
            String aux = InetAddress.getLocalHost().getHostName()+"";
            System.out.println(aux);
            aa.name = Integer.parseInt(aux.charAt(1)+"");
            System.out.println("Mi nombre "+aa.name);
        } catch (UnknownHostException ex) {
            System.out.println("Error al obtener mi nombre... Who am i?: "+ ex);
        }
        
         //Hilo que se encarga de todo el algoritmo del anillo
        aa.eleccion();
        
        //Hilo para que informe si esta vivo el nodo
        aa.vivo();
        
        //Cargar los siguientes de un archivo
        //Si esta vacío es la primera vez que aparece el nodo
        aa.namae = aa.cargarLista();
        
        //Iniciar el canal de comunicación que envía cuando hay nuevo coordinador a los FE
        aa.iniciarMulti();
        
                
        //Si no hay siguientes
        if(aa.namae.size() == 0){
            //Si es el primerísimo de todos 
            if(aa.name == 1){
                System.out.println("Estoy solo en el mundo\nHello darkness my old friend");
                aa.elsujeto = aa.name;

                aa.namae.add(2);
            }
            //Si es un nodo nuevo y es secundario
            else{
                //El nodo 1 siempre debe estar encendido cuando se inicia un nodo nuevo
                aa.namae.add(1);
                aa.timeToDuel();
                aa.beat();
                //Escuchar a los FE cuando se caíga el principal
                aa.serverChismes();
                
                }
        }
        //Si esta reviviendo de sus cenizas cual ave fénix
        else if(aa.name!=1){
            aa.timeToDuel();
            aa.beat();
           
            //Escuchar a los FE cuando se caíga el principal
            aa.serverChismes();
           
        }
        //Y ya si es el coordinador principal el que revive
        else{
            //Escuchar cada que hay una replica
            
            aa.timeToDuel();
            
        }
       //****************************************
        
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(false);

        this.setLocationRelativeTo(null);

        Calendar calendario = Calendar.getInstance();

        int hora, minuto, segundo;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND);

        uno = new Hilo(hora, minuto, segundo, hora1);
        Thread t1 = new Thread(uno);
        t1.start();
        dos = new Hilo((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora2);
        Thread t2 = new Thread(dos);
        t2.start();
        tres = new Hilo((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora3);
        Thread t3 = new Thread(tres);
        t3.start();
        cuatro = new Hilo((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora4);
        Thread t4 = new Thread(cuatro);
        t4.start();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        BtnGrpEditar = new javax.swing.ButtonGroup();
        hora1 = new javax.swing.JTextField();
        hora2 = new javax.swing.JTextField();
        hora3 = new javax.swing.JTextField();
        hora4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        segundosV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        BtnModificar = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        hora2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora2ActionPerformed(evt);
            }
        });

        hora3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        hora4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hora4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Velocidad segundos en miliseg");

        segundosV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundosVActionPerformed(evt);
            }
        });
        segundosV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                segundosVKeyTyped(evt);
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
        jLabel7.setText("RELOJES.");

        BtnGrpEditar.add(jRadioButton1);
        jRadioButton1.setText("Cliente 1");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("2"), jRadioButton1, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        BtnGrpEditar.add(jRadioButton2);
        jRadioButton2.setText("Cliente 2");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("3"), jRadioButton2, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        BtnGrpEditar.add(jRadioButton3);
        jRadioButton3.setText("Maestro  (Hora Local)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("1"), jRadioButton3, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        BtnGrpEditar.add(jRadioButton4);
        jRadioButton4.setText("Cliente3");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("4"), jRadioButton4, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        BtnModificar.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(102, 0, 102));
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        Enviar.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        Enviar.setForeground(new java.awt.Color(102, 0, 102));
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jButton2.setText("Conectar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(82, 82, 82))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segundosV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(BtnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(Enviar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(segundosV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(149, 149, 149))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void enviar(Hilo hilo, JTextField hora,int puerto) throws IOException {
        hilo.valor = true;
        // need host and port, we want to connect to the ServerSocket at port 7777
        String time = hora.getText()+""+segundosV.getText();
        System.out.println(time);
        Socket socket = new Socket("localhost", puerto);
        System.out.println("Connected!");
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("Sending string to the ServerSocket");
        dataOutputStream.writeUTF(time);
        dataOutputStream.flush(); 
        dataOutputStream.close(); 
        System.out.println("Closing socket and terminating program.");
        socket.close();
        //hilo.valor = true;
    }
    

    

    void editar(Hilo hilo, JTextField hora) {

        hora.setEnabled(false);
        String cadena = hora.getText();
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
        hilo.valor = true;
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
        String cad = segundosV.getText();
        int v = Integer.parseInt(cad);
        String option = BtnGrpEditar.getSelection().getActionCommand();
        switch (option) {
            case "1":
                uno.velocidad = v;
                uno.valor = true;
                break;
            case "2":
                dos.velocidad = v;
                dos.valor = true;
                break;
            case "3":
                tres.velocidad = v;
                tres.valor = true;
                break;
            case "4":
                cuatro.velocidad = v;
                cuatro.valor = true;
            default:
                break;
        }
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void segundosVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_segundosVKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_segundosVKeyTyped

    private void segundosVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundosVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segundosVActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        hora1.setEnabled(true);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(false);
        uno.valor = false;
        dos.valor = true;
        tres.valor = true;
        cuatro.valor = true;
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(true);
        hora3.setEnabled(false);
        hora4.setEnabled(false);
        uno.valor = true;
        dos.valor = false;
        tres.valor = true;
        cuatro.valor = true;
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(true);
        hora4.setEnabled(false);
        uno.valor = true;
        dos.valor = true;
        tres.valor = false;
        cuatro.valor = true;
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(true);
        uno.valor = true;
        dos.valor = true;
        tres.valor = true;
        cuatro.valor = false;
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        String selectedOption = BtnGrpEditar.getSelection().getActionCommand();

        switch (selectedOption) {
            case "1":
                editar(uno, hora1);
                break;
            case "2":
                editar(dos, hora2);
                break;
            case "3":
                editar(tres, hora3);
                break;
            case "4":
                editar(cuatro, hora4);
                break;
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void hora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora1ActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        try {
            // TODO add your handling code here:
            String selectedOption = BtnGrpEditar.getSelection().getActionCommand();
            int puerto = 8888;
            switch (selectedOption) {
                case "1":
                    enviar(uno, hora1,puerto);
                    break;
                case "2":
                    enviar(dos, hora2,puerto+1);
                    break;
                case "3":
                    enviar(tres, hora3,puerto+2);
                    break;
                case "4":
                    enviar(cuatro, hora4,puerto+3);
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EnviarActionPerformed

    private void hora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora2ActionPerformed

    private void hora4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("El coordinador es: "+aa.elsujeto);
        System.out.println("Mi tabla de siguientes es ");
        for(int a : aa.namae){
            System.out.print(a+" ");
        }
        System.out.println("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) throws RemoteException, MalformedURLException, InterruptedException, AlreadyBoundException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                    new clientes.ServidorB().setVisible(true);
                clientes.ServidorB.getconn();
              //      new clientes.ServidorB().setVisible(true);
              //  clientes.ServidorB.getconn(); //obtiene conexion a la base de datos  
                } catch (RemoteException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
            
            }
              
        });


         
    }
    
    
   
        
      
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrpEditar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton Enviar;
    private javax.swing.JTextField hora1;
    private javax.swing.JTextField hora2;
    private javax.swing.JTextField hora3;
    private javax.swing.JTextField hora4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField segundosV;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

public class ServidorB extends javax.swing.JFrame implements Runnable{
   
Thread h;
private Connection conn;
DefaultTableModel model;
    /**
     * Creates new form NADA
     */
    public ServidorB() {
        initComponents();
        //recibe();
        h = new Thread(this);
        h.start();
    }
    
    public Connection getconn() {
        if (conn==null) {  
            
          try {
           String url = new String();
           String user = new String();
           String password = new String();
           url = "jdbc:mysql://localhost:3306/coordinador1";
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
    
    public int readFile_suma(String file_path) throws IOException{
    
    return 1;
       
    }
    
    
    public void run1() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServerSocket server;
        Socket connection;
        
        int this_server,next_server;
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
        try{
            //Servidor Socket en el puerto 5000
            server = new ServerSocket( this_server );
            while ( true ) {
                //Aceptar conexiones
                connection = server.accept();
                //Buffer de 1024 bytes
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis=new DataInputStream(connection.getInputStream());
                //file = "Hola.txt";//dis.readUTF();
                //file = dis.readUTF();
                flag = dis.readUTF();
                String cadena = "";
                
                //System.out.println(file);
                System.out.println(flag);
                if(flag.equals("0")){
                    int i = 0;
                    int suma = 0;
                    int lim = dis.readInt();
                    System.out.println("imma read the numbas");
                    while(i<lim){
                        //lista.add(Integer.parseInt(dis.readUTF()));
                        //System.out.println(lista);
                         cadena += dis.readUTF();
                        i++;
                    }
                    
                    int tam = cadena.length();
      //  int suma = 0;
        char ce;
        
        for(int j=0; j<tam; j++){
            ce = cadena.charAt(j);
            switch (ce){
                case 'a':
                    suma += 1;
                    break;
                case 'e':
                    suma += 1;
                    break;
                case 'i':
                    suma += 1;
                    break;
                case 'o':
                    suma += 1;
                    break;
                case 'u':
                    suma += 1;
                    break;
                case 'A':
                    suma += 1;
                    break;
                case 'E':
                    suma += 1;
                    break;
                case 'I':
                    suma += 1;
                    break;
                case 'O':
                    suma += 1;
                    break;
                case 'U':
                    suma += 1;
                    break;
                case '1':
                    suma += 1;
                    break;
                case '2':
                    suma += 1;
                    break;
                case '3':
                    suma += 1;
                    break;
                case '4':
                    suma += 1;
                    break;
                case '5':
                    suma += 1;
                    break;
                case '.':
                    suma += 1;
                    break;
                case ',':
                    suma += 1;
                    break;
                case ';':
                    suma += 1;
                    break;
                case ':':
                    suma += 1;
                    break;
                case '\'':
                    suma += 1;
                    break; 
                case '+':
                    suma += 1;
                    break;
                case '-':
                    suma += 1;
                    break;
                case '*':
                    suma += 1;
                    break;
                case '/':
                    suma += 1;
                    break;
                case '=':
                    suma += 1;
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
                    while ((in = bis.read(receivedData)) != -1){
                    //bos.write(receivedData,0,in);
                    System.out.println(hour);
                    hour = hour.substring(0,2)+":"+hour.substring(2,4)+":"+hour.substring(4,6);
                    //int suma = readFile_suma(file);//lee numeros
                    /*campoHora.setText(hour);
                    campoSuma.setText(Integer.toString(suma));
                    campoIp.setText(ip);*/

                    System.out.println("La suma es: " + suma);
                        System.out.println("Cadena: "+cadena);
                        System.out.println("Tam: "+tam);
                    String query = " INSERT INTO PLAYER (IP, HORA , SUMA)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
                    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                    System.out.println("sending ip");
                    preparedStmt.setString (1, ip);
                    preparedStmt.setString (2, hour);
                    preparedStmt.setInt(3, suma);
                    preparedStmt.execute(); //ejecuta comando sql
                    //llenaTabla();
                    //if(flag.equals("0")){
                    DataInputStream input;
                    BufferedInputStream s_bis;
                    BufferedOutputStream s_bos;
                    flag = "1";
    //                String fileName;
                    //int in;
                    try{
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
                        dos.writeUTF(Integer.toString(suma));
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

                       }catch ( Exception e ) {
                        System.err.println(e);
                        }
                }
            }else{
                    System.out.println(flag);
                    System.out.println("Recieveing forwarded data...");
                    String ip = dis.readUTF();
                    System.out.println("ip:"+ip+"");
                    String hour = dis.readUTF();
                    System.out.println("time:"+hour+"");
                    String suma = dis.readUTF();
                    System.out.println("sum:"+suma+"");
                    /*campoHora.setText(hour);
                    campoSuma.setText(suma);
                    campoIp.setText(ip);*/
                    System.out.println("La suma es: " + suma);
                    String query = " INSERT INTO PLAYER (IP, HORA , SUMA)" + " values (?, ?, ?)"; //inserta valores recibidos en base de datos
                    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                    System.out.println("sending ip");
                    preparedStmt.setString (1, ip);
                    preparedStmt.setString (2, hour);
                    preparedStmt.setInt(3, Integer.parseInt(suma));
                    preparedStmt.execute(); //ejecuta comando sql
                
                }
        byte[] byteArray;
            //bos.close();
            dis.close();
            //conn.close();
            }
        }catch (Exception e ) {
            System.err.println(e);
            System.out.println(e);
        }
    }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    
 }   
}

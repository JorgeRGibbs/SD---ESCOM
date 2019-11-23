package servidor;
import servidor.Hilo;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import hilo.Hilito;
import static servidor.Interfaz.cuatro;

import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.OutputStream;


public class Interfaz extends javax.swing.JFrame {

    static Hilo uno;
    static Hilo dos;
    static Hilo tres;
    static Hilo cuatro;

    public Interfaz() throws RemoteException {
        initComponents();
        this.setTitle("Reloj");
 
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
        jLabel7.setText("PRÁCTICA 1. RELOJES");

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
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
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
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(245, 245, 245)
                        .addComponent(segundosV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(BtnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segundosV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Enviar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    public static void main(String args[]) throws RemoteException, MalformedURLException, InterruptedException, AlreadyBoundException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       /* Naming.rebind("rhilito1", dos);
        Naming.rebind("rhilito2", tres);
        Naming.rebind("rhilito3", cuatro);
               */
       
         //java.rmi.registry.Registry rmiRegistry = java.rmi.registry.LocateRegistry.
         //createRegistry(6060); //Puerto
         //rmiRegistry.rebind("rhilito1", dos);
         //rmiRegistry.rebind("rhilito2", tres);
         //rmiRegistry.rebind("rhilito3", cuatro);
         
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField segundosV;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

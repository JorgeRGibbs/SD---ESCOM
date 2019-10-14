package Practica1;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import interfacereloj.InterfaceReloj;
import java.util.Random;


public class RelojGUI extends javax.swing.JFrame {

    static Reloj reloj1;
    static Reloj reloj2;
    static Reloj reloj3;
    static Reloj reloj4;

    public RelojGUI() throws RemoteException {
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

        reloj1 = new Reloj(hora, minuto, segundo, hora1);
        reloj1.InicializarReloj(reloj1);
        reloj2 = new Reloj((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora2);
        reloj2.InicializarReloj(reloj2);
        reloj3 = new Reloj((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora3);
        reloj3.InicializarReloj(reloj3);
        reloj4 = new Reloj((int) (Math.random() * 24), (int) (Math.random() * 60), (int) (Math.random() * 60), hora4);
        reloj4.InicializarReloj(reloj4);
        
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
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        segundosV = new javax.swing.JTextField();
        AjustarVel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        hora1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hora1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hora1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hora1KeyTyped(evt);
            }
        });

        hora2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        hora3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hora3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hora3MouseClicked(evt);
            }
        });

        hora4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Velocidad en milisegundos:");

        BtnGrpEditar.add(jRadioButton1);
        jRadioButton1.setText("Reloj1 (Hora local)");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("1"), jRadioButton1, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
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
        jRadioButton2.setText("Reloj2");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("2"), jRadioButton2, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        BtnGrpEditar.add(jRadioButton3);
        jRadioButton3.setText("Reloj3");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("3"), jRadioButton3, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

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

        AjustarVel.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        AjustarVel.setForeground(new java.awt.Color(102, 0, 102));
        AjustarVel.setText("Ajustar");
        AjustarVel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjustarVelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 204));
        jLabel7.setText("PRÁCTICA 1. RELOJES");

        Modificar.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        Modificar.setForeground(new java.awt.Color(102, 0, 102));
        Modificar.setText("Modificar Hora");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        BtnGrpEditar.add(jRadioButton4);
        jRadioButton4.setText("Reloj4");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BtnGrpEditar, org.jdesktop.beansbinding.ELProperty.create("4"), jRadioButton4, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
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
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(segundosV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AjustarVel))
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Modificar)
                                .addGap(71, 71, 71))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Modificar)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(segundosV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AjustarVel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(6, 6, 6)
                        .addComponent(hora1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hora4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void hora1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora1KeyPressed

    private void hora1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora1KeyTyped

        if (hora1.getText().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_hora1KeyTyped

    private void AjustarVelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjustarVelActionPerformed
        String VelCad = segundosV.getText();
        int Vel = Integer.parseInt(VelCad);
        String option = BtnGrpEditar.getSelection().getActionCommand();
        switch (option) {
            case "1":
                reloj1.ajustarVelocidad(reloj1, Vel);
                break;
            case "2":
                reloj2.ajustarVelocidad(reloj2, Vel);
                break;
            case "3":
                reloj3.ajustarVelocidad(reloj3, Vel);
                break;
            case "4":
                reloj4.ajustarVelocidad(reloj4, Vel);
                break;
        }
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(false);
    }//GEN-LAST:event_AjustarVelActionPerformed

    private void segundosVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_segundosVKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_segundosVKeyTyped

    private void segundosVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundosVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segundosVActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        String selectedOption = BtnGrpEditar.getSelection().getActionCommand();

        switch (selectedOption) {
            case "1":
                reloj1.modificarHora(reloj1, hora1);
                break;
            case "2":
                reloj2.modificarHora(reloj2, hora2);
                break;
            case "3":
                reloj3.modificarHora(reloj3, hora3);
                break;
            case "4":
                reloj4.modificarHora(reloj4, hora4);
                break;
            default:
                System.out.println("No");
                break;
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        hora1.setEnabled(true);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(false);
        reloj1.setValor(false);
        reloj2.setValor(true);
        reloj3.setValor(true);
        reloj4.setValor(true);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(true);
        hora3.setEnabled(false);
        hora4.setEnabled(false);
        reloj1.setValor(true);
        reloj2.setValor(false);
        reloj3.setValor(true);
        reloj4.setValor(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(true);
        hora4.setEnabled(false);
        reloj1.setValor(true);
        reloj2.setValor(true);
        reloj3.setValor(false);
        reloj4.setValor(true);
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        hora1.setEnabled(false);
        hora2.setEnabled(false);
        hora3.setEnabled(false);
        hora4.setEnabled(true);
        reloj1.setValor(true);
        reloj2.setValor(true);
        reloj3.setValor(true);
        reloj4.setValor(false);
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void hora3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hora3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hora3MouseClicked

    public static void main(String args[]) throws RemoteException, AlreadyBoundException, MalformedURLException {
        java.rmi.registry.Registry registry = null;
        //int port;
        Random r = new Random();
        int low = 10;
        int high = 100;
        int port = r.nextInt(high-low) + low;
        //try {
            //registry = java.rmi.registry.LocateRegistry.createRegistry(port);
        //} catch (Exception ex) {
        //    port = port+1;
        //registry = java.rmi.registry.LocateRegistry.getRegistry(port);
       // } 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RelojGUI().setVisible(true);
                    try{
                        
                       //System.setProperty("java.rmi.server.hostname","localhost");
                       Naming.rebind("//localhost/rhilito1", reloj2);
                        //Naming.rebind("rhilito2", reloj3);
                        //Naming.rebind("rhilito3", reloj4);
        
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    } 
                   System.out.println(reloj2);
                } catch (RemoteException ex) {
                    Logger.getLogger(RelojGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        java.rmi.registry.Registry rmiRegistry = java.rmi.registry.LocateRegistry.
                createRegistry(port); //Puerto
        // rmiRegistry.rebind("rhilito1", reloj2);
        // rmiRegistry.rebind("rhilito2", reloj3);
        // rmiRegistry.rebind("rhilito3", reloj4);
        // rmiRegistry.bind("rhilito1", reloj2);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjustarVel;
    private javax.swing.ButtonGroup BtnGrpEditar;
    private javax.swing.JButton Modificar;
    private javax.swing.JTextField hora1;
    private javax.swing.JTextField hora2;
    private javax.swing.JTextField hora3;
    private javax.swing.JTextField hora4;
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

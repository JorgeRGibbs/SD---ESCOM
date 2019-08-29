
package reloj;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reloj extends javax.swing.JFrame implements Runnable{
    String hora, minutos, segundos;
    Calendar calendario;
    Thread h1;
    
    public Reloj() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        
        
       setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reloj1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        reloj2 = new javax.swing.JLabel();
        reloj3 = new javax.swing.JLabel();
        reloj4 = new javax.swing.JLabel();
        horaNueva = new javax.swing.JTextField();
        minNuevo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reloj1.setText("jLabel1");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        reloj2.setText("jLabel1");

        reloj3.setText("jLabel1");

        reloj4.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reloj1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(btnModificar)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reloj2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reloj4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reloj3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(horaNueva)
                            .addComponent(minNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reloj1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloj2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloj3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(reloj4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modifica();
        
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField horaNueva;
    private javax.swing.JTextField minNuevo;
    private javax.swing.JLabel reloj1;
    private javax.swing.JLabel reloj2;
    private javax.swing.JLabel reloj3;
    private javax.swing.JLabel reloj4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        
        while(ct==h1){
            calcula();
            reloj1.setText(hora+":"+minutos+":"+segundos);
            reloj2.setText(hora+":"+minutos+":"+segundos);
            //textHour1.setText(hora+":"+minutos+":"+segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            
            
            
        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        
        calendario.setTime(horaActual);
        int h = calendario.get(Calendar.HOUR_OF_DAY);
        hora = h>9?""+h:"0"+h;
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
    
    private void modifica(){
        Calendar calendario = new GregorianCalendar();
        Date nuevaHora = new Date();
        
        calendario.setTime(nuevaHora);
        int hn = Integer.parseInt(horaNueva.getText());
        int mn = Integer.parseInt(minNuevo.getText());
        //int 
        reloj2.setText(hn+":"+mn+":"+segundos);
    }
}

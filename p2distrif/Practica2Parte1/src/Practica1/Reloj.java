package Practica1;


import interfacereloj.InterfaceReloj;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Reloj extends UnicastRemoteObject implements Runnable, Serializable, InterfaceReloj {
    
    private int hora,minuto,segundo;
    JTextField Texto = new JTextField();
    private boolean valor = true;
    private int velocidad = 1000;
    
    public Reloj(int hora,int minuto,int segundo,JTextField Texto) throws RemoteException {
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
        this.Texto=Texto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public JTextField getTexto() {
        return Texto;
    }

    public boolean isValor() {
        return valor;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public void setTexto(JTextField Texto) {
        this.Texto = Texto;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
    public void ajustarVelocidad(Reloj reloj, int velocidadNueva){
        reloj.setVelocidad(velocidadNueva);
        reloj.setValor(true);
    }
    
    public void modificarHora(Reloj reloj,JTextField hora){

        hora.setEnabled(false);
        String cadena=hora.getText();
        char cadenaA[]=cadena.toCharArray();
        int i=0;
        int num=0,num2=0;
        while(i<cadenaA.length){ 
            if(cadenaA[i]!=':'){
                if(i==0 || i==3 || i==6){
                    num=Integer.parseInt(""+cadenaA[i])*10;
                }
                if(i==1 || i==4 || i==7){
                    num=num+Integer.parseInt(""+cadenaA[i]);                       
                    switch (i) {
                        case 1:
                            if(num>=24){
                                JOptionPane.showMessageDialog(null,"Error! Formato incorrecto");
                            }else{
                                reloj.setHora(num);
                            }   break;
                        case 4:
                            if(num>=60){
                                JOptionPane.showMessageDialog(null,"Error! Formato incorrecto");
                            }else{
                                reloj.setMinuto(num);
                            }   break;
                        case 7:
                            if(num>=60){
                                JOptionPane.showMessageDialog(null,"Error! Formato incorrecto");
                            }else{
                                reloj.setSegundo(num);  
                            }   break;
                        default:
                            break;
                    }
                }
            }
            i++;
            reloj.setValor(true);
        }
    }
    
    
    public void InicializarReloj(Reloj reloj){
        Thread t1 = new Thread(reloj); 
        t1.start();
}
    
    
    public void run(){
        
        while(true){
            String horaS=""+hora;
            String minutoS=""+minuto;
            String segundoS=""+segundo;
            
            if(segundo<10){
                segundoS="0"+segundoS;
            }
            
            if(minuto<10){
                minutoS="0"+minutoS;
            }
            
            if(hora<10){
                horaS="0"+horaS;
            }
            
            if(valor==true){
               Texto.setText(horaS+":"+minutoS+":"+segundoS); 
            }
            

            segundo++;
            if(segundo>=60){
                segundo=0;
                minuto++;
                if(minuto>=60){
                    minuto=0;
                    hora++;
                    if(hora>=24){
                        hora=0;
                    }
                }
            }
           
            try{
                Thread.sleep (velocidad);
            }catch (Exception e){
                System.out.println("Error: "+e);
            }
        }

    }

    @Override
    public void setHora() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMinuto() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSegundo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTexto() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValor() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVelocidad() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajustarVelocidad() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarHora() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializarReloj() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

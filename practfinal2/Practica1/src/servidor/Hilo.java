package servidor;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import javax.swing.JTextField;
import hilo.Hilito;

public class Hilo extends UnicastRemoteObject implements Hilito, Runnable, Serializable {

    int hora, minuto, segundo;
    JTextField Texto = new JTextField();
    boolean valor = true;
    int velocidad = 1000;
    private static final long serialVersionUID = 1L;

    public Hilo(int hora, int minuto, int segundo, JTextField Texto) throws RemoteException {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.Texto = Texto;
    }

    @Override
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public JTextField getTexto() {
        return Texto;
    }

    public void setTexto(JTextField Texto) {
        this.Texto = Texto;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {

        while (true) {
            String horaS = "" + hora;
            String minutoS = "" + minuto;
            String segundoS = "" + segundo;

            if (segundo < 10) {
                segundoS = "0" + segundoS;
            }

            if (minuto < 10) {
                minutoS = "0" + minutoS;
            }

            if (hora < 10) {
                horaS = "0" + horaS;
            }

            if (valor == true) {
                Texto.setText(horaS + ":" + minutoS + ":" + segundoS);
            }

            segundo++;
            if (segundo >= 60) {
                segundo = 0;
                minuto++;
                if (minuto >= 60) {
                    minuto = 0;
                    hora++;
                    if (hora >= 24) {
                        hora = 0;
                    }
                }
            }

            try {
                Thread.sleep(velocidad);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

    }

    @Override
    public void Interfaz() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}

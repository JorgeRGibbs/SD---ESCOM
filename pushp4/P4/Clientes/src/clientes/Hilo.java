package clientes;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import javax.swing.JTextField;
//import hilo.Hilito;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilo extends UnicastRemoteObject implements Runnable, Serializable {

    static int hora, minuto, segundo;
    JTextField Texto = new JTextField();
    boolean valor = true;
    static int velocidad = 1000;
    private static final long serialVersionUID = 1L;

    public Hilo(int hora, int minuto, int segundo, JTextField Texto) throws RemoteException {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.Texto = Texto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    //@Override
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    //@Override
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
        //System.out.println("start");
        while (true) {
//        System.out.println("start");
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
        // don't need to specify a hostname, it will be the current machine
        //int port = (int)(Math.random() * 10000 + 1200);
        /*ServerSocket ss;
        try {
            ss = new ServerSocket(7559);
            System.out.println("ssa");
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + socket + "!");
        
        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // read the message from the socket
        String time = dataInputStream.readUTF();
        //editar(uno,hora1,time);
        char stringA[] = time.toCharArray();
        hora = Integer.parseInt(stringA[0]+""+stringA[1]);
        minuto = Integer.parseInt(stringA[3]+""+stringA[4]);
        segundo = Integer.parseInt(stringA[6]+""+stringA[7]);
        
        //Texto.setText(time);
        //Texto.setText(time);
        System.out.println("The message sent from the socket was: " + time);
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        //uno.run();
        //return time;
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
    
            try {
                Thread.sleep(velocidad);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

    }

    //@Override
    public void Interfaz() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void editar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void setHora() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void setMinuto() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void setSegundo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

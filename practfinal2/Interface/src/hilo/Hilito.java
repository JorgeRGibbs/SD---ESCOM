package hilo;
import java.rmi.Remote;
import java.rmi.RemoteException;
//package servidor.Hilo; 
/**
 *
 * @author Uziel
 */
public interface Hilito extends Remote {

    void run() throws RemoteException;

    void Interfaz() throws RemoteException;

    void editar() throws RemoteException;
    
    void setHora() throws RemoteException; 
    
    void setMinuto() throws RemoteException; 
    
    void setSegundo() throws RemoteException; 
            
    int getHora() throws RemoteException; 
    
    int getMinuto() throws RemoteException; 
    
    int getSegundo() throws RemoteException;
    
    
    
    

}

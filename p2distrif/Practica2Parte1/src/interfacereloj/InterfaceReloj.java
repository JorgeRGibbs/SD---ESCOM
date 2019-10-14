/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacereloj;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Uziel
 */
public interface InterfaceReloj extends Remote {
    
    int getHora() throws RemoteException;

    int getMinuto() throws RemoteException;

    int getSegundo() throws RemoteException;

    //void getTexto() throws RemoteException;
    
    boolean isValor() throws RemoteException; 
    
    int getVelocidad () throws RemoteException; 
    
    void setHora() throws RemoteException; 
    
    void setMinuto() throws RemoteException; 
     
    void setSegundo () throws RemoteException; 
    
    void setTexto() throws RemoteException; 
    
    void setValor() throws RemoteException; 
    
    void setVelocidad () throws RemoteException; 
    
    ///////////////////////////////////////////////
    
      
    void ajustarVelocidad() throws RemoteException; 
    
    void modificarHora () throws RemoteException; 
    
    void inicializarReloj() throws RemoteException; 
    
    void run () throws RemoteException;    
    
}

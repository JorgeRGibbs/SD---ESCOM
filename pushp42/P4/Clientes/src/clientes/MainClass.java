/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import clientes.Jugador1;
import clientes.ServidorB;
//import clientes.ServidorB1;
import clientes.Tiempo;
import java.io.IOException;

/**
 *
 * @author GIBS
 */
public class MainClass {
    
    static ServidorB ServerB;
    //static ServidorB1 ServerB1;
    static Tiempo TimeServer;
    static Jugador1 Player1;
    
    public static void builder() throws IOException {
        //public MainClass() throws IOException {
        MainClass.TimeServer = new Tiempo();
        MainClass.Player1 = new Jugador1();
        //MainClass.ServerB1 = new ServidorB1();
        MainClass.ServerB = new ServidorB();
        MainClass.TimeServer.setVisible(true);
        //MainClass.ServerB1.setVisible(true);
        MainClass.ServerB.setVisible(true);
        MainClass.Player1.setVisible(true);
        System.out.println("All components running propely");
    }
    
    public static void main(String[] args) throws IOException 
    {   
        builder();
    }
    
    
    
}

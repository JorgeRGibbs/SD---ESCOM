
package intercliente;
import hilo.Hilito; 
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Uziel
 */
public class Intercliente {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
       Hilito h1 = (Hilito) Naming.lookup("//localhost/rhilito1");
       Hilito h2 = (Hilito) Naming.lookup("//localhost/rhilito2"); 
       Hilito h3 = (Hilito) Naming.lookup("//localhost/rhilito3"); 
       
        //////////////////////
        Remote lookup = Naming.lookup("//localhost/rhilito1");
        /////////////////////
    }
    
}

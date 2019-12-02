package evaluarcadena;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LeerArchivo {
    
    private String cadena;

    public LeerArchivo(String cadena) {
        this.cadena = cadena;
    }

    LeerArchivo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
    
    public String ConvierteArchivo(String archivo) throws FileNotFoundException, IOException {

        
        FileReader fr = new FileReader(archivo);
        BufferedReader brfr = new BufferedReader(fr);
        
        //cadena = brfr.readLine();
        
        
         while((cadena = brfr.readLine()) != null)
              return cadena += brfr.readLine();
             
         
        fr.close();
        
        return cadena;
    } 
    
}

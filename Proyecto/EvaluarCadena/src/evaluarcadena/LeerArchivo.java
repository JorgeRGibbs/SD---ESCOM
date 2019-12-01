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
        BufferedReader br = new BufferedReader(fr);
        String[] cadenas = br.readLine().split("´");
            //while ((cadena = br.readLine())!= null) {
                //System.out.println(cadena);
                //return cadena;
            //}
            
          //String cadenas[] = cadena1.split("´");

        for(int i = 0 ; i < cadenas.length ; i++){
            //System.out.println(cadena);
            cadena = cadena + cadenas[i];
            System.out.println(cadena);
            //System.out.println("["+i+"] " + Integer.parseInt(numeros[i]));
            //sum += Integer.parseInt(numeros[i]);
        }  
        
        return cadena;
    } 
    
}

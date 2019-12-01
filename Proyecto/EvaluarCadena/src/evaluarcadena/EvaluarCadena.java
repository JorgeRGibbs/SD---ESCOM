package evaluarcadena;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EvaluarCadena {


    public static void main(String[] args) throws IOException {
        String textoPrueba =  "abcdefghijkl ABCDEFGHIJKL +-++++++...";
        String cadena;
        String fichero = "C:/Users/gerar/Desktop/archivo.txt";
        
        Calcular  calc = new Calcular();
        LeerArchivo arch = new LeerArchivo();
        cadena = arch.ConvierteArchivo(fichero);
        int res = calc.Calcula(cadena);
        
        System.out.println("Texto del archivo : " + cadena);
        System.out.println("Resultado: " + res);
        
    }
    
}

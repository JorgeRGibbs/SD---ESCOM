package evaluarcadena;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EvaluarCadena {


    public static void main(String[] args) throws IOException {
        String cadena = "";
        String archivo = "C:/Users/gerar/Documents/GitHub/SD---ESCOM/Proyecto/EvaluarCadena/archivo.txt";
        Scanner scan = new Scanner(new File(archivo));
        while (scan.hasNextLine())
            cadena += scan.nextLine();
        
        int tam = cadena.length();
        int resultado = 0;
        char ce;
    
        for(int i=0; i<tam; i++){
            ce = cadena.charAt(i);
            switch (ce){
                case 'a':
                    resultado += 1;
                    break;
                case 'e':
                    resultado += 1;
                    break;
                case 'i':
                    resultado += 1;
                    break;
                case 'o':
                    resultado += 1;
                    break;
                case 'u':
                    resultado += 1;
                    break;
                case 'A':
                    resultado += 1;
                    break;
                case 'E':
                    resultado += 1;
                    break;
                case 'I':
                    resultado += 1;
                    break;
                case 'O':
                    resultado += 1;
                    break;
                case 'U':
                    resultado += 1;
                    break;
                case '1':
                    resultado += 1;
                    break;
                case '2':
                    resultado += 1;
                    break;
                case '3':
                    resultado += 1;
                    break;
                case '4':
                    resultado += 1;
                    break;
                case '5':
                    resultado += 1;
                    break;
                case '.':
                    resultado += 1;
                    break;
                case ',':
                    resultado += 1;
                    break;
                case ';':
                    resultado += 1;
                    break;
                case ':':
                    resultado += 1;
                    break;
                case '\'':
                    resultado += 1;
                    break; 
                case '+':
                    resultado += 1;
                    break;
                case '-':
                    resultado += 1;
                    break;
                case '*':
                    resultado += 1;
                    break;
                case '/':
                    resultado += 1;
                    break;
                case '=':
                    resultado += 1;
                    break; 
                default:
                    break;
            } 
        }
        
        System.out.println("Texto del archivo : " + cadena);
        System.out.println("Resultado: " + resultado);
        
    }
    
}

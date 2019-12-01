package evaluarcadena;


public class Calcular {
    
    private int resultado;
    //private String[] cads;
    private char ce;

    Calcular() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getResultado() {
        return resultado;
    }

    public char getCe() {
        return ce;
    }

    public Calcular(int resultado, char ce) {
        this.resultado = resultado;
        this.ce = ce;
    }
    
    
    
public int Calcula(String texto){

    int tam = texto.length();
    
    for(int i=0; i<tam; i++){
        ce = texto.charAt(i);
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
            case '\'':
                resultado += 1;
                break;   
            default:
                break;
        } 
    }
    
return resultado;
}
    
}

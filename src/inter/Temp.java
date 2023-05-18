package inter; // Archivo Temp.java

import symbols.Tipo;
import analizadorLexico.*;

//los nombres temporales tienen tipo, junto con todas las demás
//expresiones. Por lo tanto, el constructor Temp se llama con el tipo como un parámetro
public class Temp extends Expr {

    static int conteo = 0;

    int numero = 0;

    public Temp(Tipo p) {
        super(Palabra.temp, p);
        numero = ++conteo;
    }

    public String toString() {
        return "t" + numero;
    }
}

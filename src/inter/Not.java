package inter; // Archivo Not.java
//El archivo and es similar a los archivos and y or ya que osn expresiones booleanas
import analizadorLexico.*;

public class Not extends Logica {

    public Not(Token tok, Expr x2) {
        super(tok, x2, x2);
    }

    public void salto(int t, int f) {//llama a y.salto con las salidas verdadera y falsa
//invertidas.
        expr2.salto(f, t);
    }

    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}

package inter; // Archivo Or.java

import analizadorLexico.*;

public class Or extends Logica {

    public Or(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public void salto(int t, int f) {//genera el código de salto para una expresión
//booleana B = B1||B2.

//Por el momento, suponga que ni la salida verdadera t ni la salida falsa f
//de B son la etiqueta especial 0.
        int etiqueta = t != 0 ? t : nuevaEtiqueta();
        expr1.salto(etiqueta, 0);
        expr2.salto(t, f);
        if (t == 0) {
            emitirEtiqueta(etiqueta);
        }
    }//Las salidas verdadera y falsa de B2 son iguales que las de B.
}

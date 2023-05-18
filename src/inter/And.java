package inter; // Archivo And.java

//El código para la clase And es similar al código para Or.
//YA QUE SON AND OR EXPRESIONES BOOLEANAS

import analizadorLexico.*;

public class And extends Logica {

    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public void salto(int t, int f) {
        int etiqueta = f != 0 ? f : nuevaEtiqueta();
        expr1.salto(etiqueta, 0);
        expr2.salto(t, f);
        if (f == 0) {
            emitirEtiqueta(etiqueta);
        }
    }
}

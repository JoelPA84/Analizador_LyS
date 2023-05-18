package inter; // Archivo Unario.java

import symbols.Tipo;
import analizadorLexico.*;

//es la contraparte de la clase Arit, con un operando:

public class Unario extends Op {

    public Expr expr;

    public Unario(Token tok, Expr x) { // maneja el menos, para ! vea Not
        super(tok, null);//empieza por llamar a super(tok,null)
        expr = x;
        tipo = Tipo.max(Tipo.Int, expr.tipo);//comprueba si los dos operandos pueden forzarse a un tipo numerico comun
        if (tipo == null) {
            error("error de tipo");
        }
    }

    public Expr gen() {
        return new Unario(op, expr.reducir());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}

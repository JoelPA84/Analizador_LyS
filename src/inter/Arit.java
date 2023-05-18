package inter; // Archivo Arit.java

import symbols.Tipo;
import analizadorLexico.*;

public class Arit extends Op {//implementa los operadores binarios como + y *.

    public Expr expr1, expr2;

    public Arit(Token tok, Expr x1, Expr x2) {
        super(tok, null);//empieza por llamar a super(tok,null)
        expr1 = x1;
        expr2 = x2;
        tipo = Tipo.max(expr1.tipo, expr2.tipo);//comprueba si los dos operandos pueden forzarse a un tipo numérico común
        if (tipo == null) {
            error("error de tipo");
        }
    }

    public Expr gen() {
        return new Arit(op, expr1.reducir(), expr2.reducir());
    }

    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}

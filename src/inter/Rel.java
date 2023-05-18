package inter; // Archivo Rel.java

import symbols.*;
import analizadorLexico.*;

public class Rel extends Logica {
    //La clase Rel implementa los operadores <, <=, ==, !=, >= y >.

    public Rel(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public Tipo comprobar(Tipo p1, Tipo p2) {
        //comprueba que los dos operandos tienen el mismo tipo y no son arreglos.
        if (p1 instanceof Arreglo || p2 instanceof Arreglo) {
            return null;
        } else if (p1 == p2) {
            return Tipo.Bool;
        } else {
            return null;
        }
    }

    public void salto(int t, int f) {
        Expr a = expr1.reducir();////empieza generando código para las subex-presiones x y y
        Expr b = expr2.reducir();
        String prueba = a.toString() + " " + op.toString() + " " + b.toString();//Después llama al método emitirSaltos
        emitirsaltos(prueba, t, f);
    }
}

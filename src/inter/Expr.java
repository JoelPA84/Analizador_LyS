package inter; // Archivo Expr.java
//
import symbols.Tipo;
import analizadorLexico.*;

public class Expr extends Nodo {
//Las construcciones de expresiones se implementan mediante subclases de Expr.
    
    public Token op;//La clase Expr tiene los campos op y tipo
    public Tipo tipo;

    Expr(Token tok, Tipo p) {//representan al operador y el tipo, respectivamente, en un nodo.
        op = tok;
        tipo = p;
    }

    
    //devuelve un “término” que puede caber del lado derecho de una instrucción de tres direcciones.
    //Dada la expresión E = E1 + E2, el método gen devuelve un término x 1+ x 2, en donde x 1 y x 2
    //son direcciones para los valores de E1 y E2, respectivamente.
    public Expr gen() {
        return this;
    }

    public Expr reducir() {//devuelve una constante, un identificador o un nombre temporal.
        return this;
    }
    
//genera el código de salto para las expresiones booleanas.
    public void salto(int t, int f) {
        emitirsaltos(toString(), t, f);
    }

    public void emitirsaltos(String prueba, int t, int f) {
        if (t != 0 && f != 0) {
            emitir("if " + prueba + " goto L" + t);
            emitir("goto L" + f);
        } else if (t != 0) {
            emitir("if " + prueba + " goto L" + t);
        } else if (f != 0) {
            emitir("iffalse " + prueba + " goto L" + f);
        } else ; // nada, ya que tanto t como f pasan directo
    }

    public String toString() {
        return op.toString();
    }
}
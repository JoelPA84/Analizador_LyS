package inter; // Archivo Acceso.java

//permite asignar valores booleanos a identificadores y elementos de arreglos, por lo que una
//expresión booleana puede ser un acceso a un arreglo.
import symbols.Tipo;
import analizadorLexico.*;

public class Acceso extends Op {
    //La clase Acceso tiene el método gen para
//generar código “normal” y el método salto para el código de salto.

    public Id arreglo;
    public Expr indice;

    public Acceso(Id a, Expr i, Tipo p) { // p es el tipo de elemento despues de aplanar el arreglo
        super(new Palabra("[]", Etiqueta.INDEX), p);//se llama con un arreglo a aplanado,
        arreglo = a;
        indice = i;
    }

    public Expr gen() {
        return new Acceso(arreglo, indice.reducir(), tipo);
    }

    public void salto(int t, int f) {
        //llama a emitirSaltos después de reducir este acceso a arreglo a un nombre temporal.
        emitirsaltos(reducir().toString(), t, f);
    }

    public String toString() {
        return arreglo.toString() + " [ " + indice.toString() + " ]";
    }
}

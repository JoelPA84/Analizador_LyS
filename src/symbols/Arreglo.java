package symbols; // Archivo Arreglo.java

import analizadorLexico.*;
//Los arreglos son el único tipo construido en el lenguaje fuente.

public class Arreglo extends Tipo {

    public Tipo de; // arreglo *de* tipo
    public int tamanio = 1; // numero de elementos

    public Arreglo(int tm, Tipo p) {
        super("[]", Etiqueta.INDEX, tm * p.anchura);//super establece el campo anchura,
        tamanio = tm;
        de = p;
    }

    @Override
    public String toString() {
        return "[" + tamanio + "] " + de.toString();
    }
}

package inter; // Archivo Nodo.java, inter contiene la jerarquía de clases Nodo,

import analizadorLexico.*;

public class Nodo {//se implementan como objetos de la clase Nodo.

    int linealex = 0;//para reportar errores se guarda el número de línea de
//código fuente de la construcción en este nodo.

    Nodo() {
        linealex = AnalizadorLexico.linea;
    }

    void error(String s) {
        throw new Error("cerca de la linea " + linealex + ": " + s);
    }
    static int etiquetas = 0;//se utilizan para emitir el código de tres direcciones.

    public int nuevaEtiqueta() {
        return ++etiquetas;
    }

    public void emitirEtiqueta(int i) {
        System.out.print("L" + i + ":");
    }

    public void emitir(String s) {
        System.out.println("\t" + s);
    }
}

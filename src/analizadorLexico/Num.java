package analizadorLexico; // Archivo Num.java

public class Num extends Token {

    public final int valor;//La clase Num extiende a Token me-
//diante la declaración de un campo entero valor

    public Num(int v) {
        super(Etiqueta.NUM);//llama a super(Etiqueta.NUM), que establece el campo etiqueta en la superclase Token a
//Etiqueta.NUM.
        valor = v; //Se declara t de forma que no puede modificarse una vez establecido.
    }

    public String toString() {
        return "" + valor;//se utiliza para crear objetos token, como en: new Token(’+’)
    }
}

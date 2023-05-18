package analizadorLexico; // Archivo Token.java

public class Token {

    public final int etiqueta;

    public Token(int t) {
        etiqueta = t;// Se declara t de forma que no puede modificarse una vez establecido.
    }

    public String toString() {
        return "" + (char) etiqueta;//4 se utiliza para crear objetos token, como en: new Token(’+’)
    }
}

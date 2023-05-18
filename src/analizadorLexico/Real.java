package analizadorLexico; // Archivo Real.java
//es para los números de punto flotante:
public class Real extends Token {

    public final float valor;

    public Real(float v) {
        super(Etiqueta.REAL);//llama a super(Etiqueta.REAL), que establece el campo etiqueta en la superclase Token a
//Etiqueta.REAL.
        valor = v;
    }

    public String toString() {
        return "" + valor;//se utiliza para crear objetos token, como en: new Token(’+’)
    }
}

package analizadorLexico; // Archivo AnalizadorLexico.java

import symbols.Tipo;
import java.io.*;
import java.util.*;
//la función reconoce números,
//identificadores y palabras reservadas,
public class AnalizadorLexico {

    public static int linea = 1;
    char preanalisis = ' ';
    Map<String, Palabra> palabras = new HashMap(); //HashMap - Hashtable

    void reservar(Palabra w) {
        palabras.put(w.lexema, w);
    }
    public AnalizadorLexico() {
        reservar(new Palabra("if", Etiqueta.IF));//reservan las palabras clave seleccionadas.
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(Palabra.True);//reservan los lexemas para los objetos definidos en cualquier otra parte.
        reservar(Palabra.False);
        reservar(Tipo.Int);
        reservar(Tipo.Char);
        reservar(Tipo.Bool);
        reservar(Tipo.Float);
    }
    //NUEVO
    public void print() {//Imprimer  LINEA mas la linea de codigo y la palabra con su propia llave unica
        System.out.println("Linea:" + linea);
        for (String keys : palabras.keySet()) {
            System.out.println(keys + ":" + palabras.get(keys));
        }
    }

    void readch() throws IOException {//se utiliza para leer el siguiente carácter de entrada y colo-
//carlo en la variable preanalisis.
        preanalisis = (char) System.in.read();
    }

    boolean readch(char c) throws IOException {//se usa para ayudar a reconocer los tokens compuestos.
        readch();
        if (preanalisis != c) {
            return false;
        }
        preanalisis = ' ';//lee el siguiente carácter y lo coloca en preanalisis, y comprueba si es =.
        return true;
    }

    public Token explorar() throws IOException {
        for (;; readch()) {//empieza ignorando los espacios en blanco
            if (preanalisis == ' ' || preanalisis == '\t') {
                continue;
            } else if (preanalisis == '\n') {
                linea = linea + 1;
            } else {
                break;
            }
        }
        switch (preanalisis) {//Reconoce los tokens compuestos como <=
            case '&':
                if (readch('&')) {
                    return Palabra.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Palabra.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Palabra.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readch('=')) {
                    return Palabra.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('=')) {
                    return Palabra.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Palabra.ge;
                } else {
                    return new Token('>');
                }
        }
        if (Character.isDigit(preanalisis)) {//reconoce los números como 365 y 3.14
            int v = 0;
            do {
                v = 10 * v + Character.digit(preanalisis, 10);
                readch();
            } while (Character.isDigit(preanalisis));
            if (preanalisis != '.') {
                return new Num(v);
            }
            float x = v;
            float d = 10;
            for (;;) {
                readch();
                if (!Character.isDigit(preanalisis)) {
                    break;
                }
                x = x + Character.digit(preanalisis, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }
        if (Character.isLetter(preanalisis)) {//recolecta las palabras
            StringBuffer b = new StringBuffer();
            do {
                b.append(preanalisis);
                readch();
            } while (Character.isLetterOrDigit(preanalisis));
            String s = b.toString();
            Palabra w = (Palabra) palabras.get(s);
            if (w != null) {
                return w;
            }
            w = new Palabra(s, Etiqueta.ID);
            palabras.put(s, w);
            return w;
        }
        Token tok = new Token(preanalisis);//por ultimo los caracteres restantes se devuelven como tokens
        preanalisis = ' ';
        return tok;
    }
}

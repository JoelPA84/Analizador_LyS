 package inter; // Archivo Constante.java
import symbols.Tipo;
import analizadorLexico.*;
 
 //Construye una hoja en el árbol sintáctico con la etiqueta tok y el tipo p.
 public class Constante extends Expr {
  public Constante(Token tok, Tipo p) { super(tok, p); } //recibe un token tok y un tipo p como parámetros.
  public Constante(int i) { super(new Num(i), Tipo.Int); }//se usa para crear un objeto constante a partir de un entero.
  public static final Constante
    True = new Constante(Palabra.True, Tipo.Bool),
    False = new Constante(Palabra.False, Tipo.Bool);
  public void salto(int t, int f) {//recibe dos parámetros, las etiquetas
//t y f. Si esta constante es el objeto estático True y t no es la etiqueta especial 0, 
//entonces se genera un salto a t. de lo contrario, genera un salto f.
    if ( this == True && t != 0 ) emitir("goto L" + t);
    else if ( this == False && f != 0) emitir("goto L" + f);
  }
 }
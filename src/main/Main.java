package main; //El método main crea un analizador
//léxico (analizadorLexico) y un analizador sintáctico (analizador), y después llama al método
//programa en el analizador sintáctico:
import java.io.*; 
import analizadorLexico.*; 
import analizador.*;

public class Main {
  public static void main(String[] args) throws IOException {
    AnalizadorLexico lex = new AnalizadorLexico();
    Analizador analizar = new Analizador(lex);
    analizar.programa();
    System.out.write('\n');
    lex.print();
  }
}
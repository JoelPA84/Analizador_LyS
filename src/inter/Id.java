package inter; // Archivo Id.java
//hereda las implementaciones predeterminadas de gen y reducir en la clase
//Expr, ya que un identificador es una dirección.
import symbols.Tipo;
import analizadorLexico.*;

public class Id extends Expr {

    public int desplazamiento; // direccion relativa

    public Id(Palabra id, Tipo p, int b) {
        super(id, p);// "super" almacena a id y p en los campos heredados op y tipo, respectivamente.
        desplazamiento = b;
    }
}

package inter; // Archivo Op.java

import symbols.Tipo;
import analizadorLexico.*;

public class Op extends Expr {//proporciona una implementación de reducir

    public Op(Token tok, Tipo p) {
        super(tok, p);
    }

    public Expr reducir() {//heredan las subclases Arit para los operadores aritméticos
        //reducir llama a gen para generar un término, emite una instrucción para 
       //asignar el término a un nuevo nombre temporal y devuelve ese temporal.
        Expr x = gen();
        Temp t = new Temp(tipo);
        emitir(t.toString() + " = " + x.toString());
        return t;
    }
}

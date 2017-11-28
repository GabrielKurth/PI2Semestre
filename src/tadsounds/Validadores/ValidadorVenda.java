
package tadsounds.Validadores;

import tadsounds.Models.Venda;
import tadsounds.Exceptions.VendaException;

public class ValidadorVenda {
    
    public static void validar(Venda venda) throws VendaException {
        if (venda == null) {
            throw new VendaException("Venda inválida");
        } 
    }
    
}

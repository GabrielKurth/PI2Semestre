package tadsounds.Mocks;

import java.util.ArrayList;
import tadsounds.Models.Venda;
import tadsounds.Models.ItemCarrinho;

public class MockVenda {

    private static int totalVendas;
    private static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
    int seqIReserva = 0;

    public static void inserir(Venda venda) throws Exception {
        try {
            venda.setId(totalVendas++);
            int seqIReserva = 0;
            for (ItemCarrinho ir : venda.getCarrinho()) {
                ir.setId(seqIReserva++);
            }
            listaVendas.add(venda);

        } catch (Exception ex) {

        }
    }

    public static ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }

}

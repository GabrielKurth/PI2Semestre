package tadsounds.Mocks;

import java.util.ArrayList;
import java.util.List;
import tadsounds.Models.Instrumento;

public class MockInstrumento {

    private static int totalInstrumentos = 0;

    private static List<Instrumento> listaInstrumentos = new ArrayList<Instrumento>();

    public static void inserir(Instrumento instrumento)
            throws Exception {
        instrumento.setId(totalInstrumentos++);
        listaInstrumentos.add(instrumento);
    }

    public static List<Instrumento> listar() throws Exception {
        return listaInstrumentos;
    }

    public static void atualizar(Instrumento instrumentoProcura) throws Exception {
        if (instrumentoProcura != null && instrumentoProcura.getId() != null && !listaInstrumentos.isEmpty()) {
            for (Instrumento instrumento : listaInstrumentos) {
                if (instrumento != null && instrumento.getId() == instrumentoProcura.getId()) {
                    instrumento.setNome(instrumentoProcura.getNome());
                    instrumento.setDescricao(instrumentoProcura.getDescricao());
                    instrumento.setMarca(instrumentoProcura.getMarca());
                    instrumento.setTipoInstrumento(instrumentoProcura.getTipoInstrumento());
                    instrumento.setCor(instrumentoProcura.getCor());
                    instrumento.setQuantidade(instrumentoProcura.getQuantidade());
                    instrumento.setPreco(instrumentoProcura.getPreco());
                    break;
                }
            }
        }
    }

    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaInstrumentos.isEmpty()) {
            for (int i = 0; i < listaInstrumentos.size(); i++) {
                Instrumento instrumentos = listaInstrumentos.get(i);
                if (instrumentos != null && instrumentos.getId() == id) {
                    listaInstrumentos.remove(i);
                    break;
                }
            }
        }
    }

    public static List<Instrumento> procurar(String valor) throws Exception {
        List<Instrumento> listaResultado = new ArrayList<Instrumento>();
        if (valor != null && !listaInstrumentos.isEmpty()) {
            for (Instrumento instrumento : listaInstrumentos) {
                if (instrumento != null && instrumento.getNome() != null) {
                    if (instrumento.getNome().toUpperCase().contains(valor.toUpperCase())) {
                        listaResultado.add(instrumento);
                    }
                }
            }
        }

        return listaResultado;
    }

    public static Instrumento obter(Integer id) throws Exception {
        if (id != null && !listaInstrumentos.isEmpty()) {
            for (int i = 0; i < listaInstrumentos.size(); i++) {
                if (listaInstrumentos.get(i) != null && listaInstrumentos.get(i).getId() == id) {
                    return listaInstrumentos.get(i);
                }
            }
        }
        return null;
    }
}

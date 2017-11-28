package tadsounds.Servicos;

import java.util.List;
import tadsounds.Models.Instrumento;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Exceptions.InstrumentoException;
import tadsounds.Mocks.MockInstrumento;
import tadsounds.Validadores.ValidadorInstrumento;

public class ServicoInstrumento {

    public static void cadastrarInstrumento(Instrumento instrumento)
            throws InstrumentoException, DataSourceException {

        ValidadorInstrumento.validar(instrumento);

        try {
            MockInstrumento.inserir(instrumento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void atualizarInstrumento(Instrumento instrumento)
            throws InstrumentoException, DataSourceException {

        ValidadorInstrumento.validar(instrumento);

        try {
            MockInstrumento.atualizar(instrumento);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static List<Instrumento> procurarInstrumento(String valor)
            throws InstrumentoException, DataSourceException {
        try {
            if (valor == null) {
                return MockInstrumento.listar();
            } else {
                return MockInstrumento.procurar(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static Instrumento obterInstrumento(Integer id)
            throws InstrumentoException, DataSourceException {
        try {
            return MockInstrumento.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void excluirQuarto(Integer id)
            throws InstrumentoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do quarto informado
            MockInstrumento.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}

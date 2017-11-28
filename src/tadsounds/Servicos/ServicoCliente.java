package tadsounds.Servicos;

import java.util.List;
import tadsounds.Dao.DAOCliente;
import tadsounds.Models.Cliente;
import tadsounds.Exceptions.ClienteException;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Mocks.MockCliente;
import tadsounds.Validadores.ValidadorCliente;

public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente) throws ClienteException, DataSourceException {
        ValidadorCliente.validar(cliente);
        try {
            DAOCliente.inserir(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static List<Cliente> procurarCliente(String nome) throws ClienteException, DataSourceException {
        try {
            if (nome == null || "".equals(nome)) {
                return DAOCliente.listar();
            } else {
                return DAOCliente.procurar(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void atualizarCliente(Cliente cliente) throws ClienteException, DataSourceException {
        ValidadorCliente.validar(cliente);
        try {
            MockCliente.atualizar(cliente);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

    public static Cliente obterCliente(Integer id) throws ClienteException, DataSourceException {
        try {
            return MockCliente.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

    public static void excluirCliente(Integer id) throws ClienteException, DataSourceException {
        try {
            MockCliente.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }
}

package tadsounds.Mocks;

import java.util.ArrayList;
import java.util.List;
import tadsounds.Models.Cliente;

public class MockCliente {

    private static int totalClientes = 1;
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public static void inserir(Cliente cliente) throws Exception {
        cliente.setId(totalClientes++);
        listaClientes.add(cliente);
    }

    public static ArrayList<Cliente> listar() throws Exception {
        return listaClientes;
    }

    public static List<Cliente> procurar(String valor) throws Exception {
        List<Cliente> listaResultado = new ArrayList<Cliente>();
        if (valor != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if (cliente != null && cliente.getNome() != null) {
                    if (cliente.getNome().toUpperCase().contains(valor.toUpperCase())) {
                        listaResultado.add(cliente);
                    }
                }
            }
        }
        return listaResultado;
    }

    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                if (cliente != null && cliente.getId() == id) {
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }

    public static Cliente obter(Integer id) throws Exception {
        if (id != null || !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i) != null && listaClientes.get(i).getId() == id) {
                    return listaClientes.get(i);
                }
            }
        }
        return null;
    }

    public static void atualizar(Cliente clienteProcura) throws Exception {
        if (clienteProcura != null && !listaClientes.isEmpty() && clienteProcura.getId() > 0) {
            for (Cliente cliente : listaClientes) {
                if (cliente != null && cliente.getId() == clienteProcura.getId()) {
                    cliente.setNome(clienteProcura.getNome());
                    cliente.setCpf(clienteProcura.getCpf());
                    cliente.setSexo(clienteProcura.getSexo());
                    cliente.setDataNascimento(clienteProcura.getDataNascimento());
                    cliente.setEstadoCivil(clienteProcura.getEstadoCivil());
                    cliente.setEndereco(clienteProcura.getEndereco());
                    cliente.setNumeroEnd(clienteProcura.getNumeroEnd());
                    cliente.setBairro(clienteProcura.getBairro());
                    cliente.setCidade(clienteProcura.getCidade());
                    cliente.setEstado(clienteProcura.getEstado());
                    cliente.setEmail(clienteProcura.getEmail());
                    cliente.setTelefone(cliente.getTelefone());
                    break;
                }
            }
        }
    }
}

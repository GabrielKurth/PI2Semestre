package tadsounds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tadsounds.Models.Cliente;
import tadsounds.UtilidadesBD.Conexao;

public class DAOCliente {

    public static void inserir(Cliente cliente) throws SQLException, Exception {
        String sql = "INSERT INTO Cliente(Nome, Cpf, Sexo, DataNascimento, EstadoCivil, Endereco, Numero,"
                + " Bairro, Cidade, Estado, Email, Telefone, Ativo)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getSexo());
            Timestamp dataBD = new Timestamp(cliente.getDataNascimento().getTime());
            preparedStatement.setTimestamp(4, dataBD);
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getEndereco());
            preparedStatement.setString(7, cliente.getNumeroEnd());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getEstado());
            preparedStatement.setString(11, cliente.getEmail());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setBoolean(13, true);
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Cliente> listar() throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE(Ativo = ?)";
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setSexo(rs.getString("Sexo"));
                Date data = new Date(rs.getTimestamp("DataNascimento").getTime());
                cliente.setDataNascimento(data);
                cliente.setEstadoCivil(rs.getString("EstadoCivil"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setNumeroEnd(rs.getString("Numero"));
                cliente.setBairro(rs.getString("Bairro"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefone(rs.getString("Telefone"));
                listaClientes.add(cliente);
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

    public static List<Cliente> procurar(String valor) throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE Nome LIKE ? AND Ativo = ?";
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + valor + "%");
            preparedStatement.setBoolean(2, true);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setSexo(rs.getString("Sexo"));
                Date data = new Date(rs.getTimestamp("DataNascimento").getTime());
                cliente.setDataNascimento(data);
                cliente.setEstadoCivil(rs.getString("EstadoCivil"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setNumeroEnd(rs.getString("Numero"));
                cliente.setBairro(rs.getString("Bairro"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefone(rs.getString("Telefone"));
                listaClientes.add(cliente);
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

    public static Cliente obter(Integer id) throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE IdCliente = ? AND Ativo = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setSexo(rs.getString("Sexo"));
                Date data = new Date(rs.getTimestamp("DataNascimento").getTime());
                cliente.setDataNascimento(data);
                cliente.setEstadoCivil(rs.getString("EstadoCivil"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setNumeroEnd(rs.getString("Numero"));
                cliente.setBairro(rs.getString("Bairro"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefone(rs.getString("Telefone"));
                return cliente;
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return null;
    }

    public static void atualizar(Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE Cliente SET Nome = ?, Cpf = ?, Sexo = ?, DataNascimento = ?, EstadoCivil = ?, Endereco = ?"
                + ", Numero = ?, Bairro = ?, Cidade = ?, Estado = ?, Email = ?, Telefone = ? WHERE(IdCliente = ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getSexo());
            Timestamp dataBD = new Timestamp(cliente.getDataNascimento().getTime());
            preparedStatement.setTimestamp(4, dataBD);
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getEndereco());
            preparedStatement.setString(7, cliente.getNumeroEnd());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getEstado());
            preparedStatement.setString(11, cliente.getEmail());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setInt(13, cliente.getId());
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE Cliente SET Ativo = ? WHERE(IdCliente = ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}

package tadsounds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import tadsounds.Models.Cliente;
import tadsounds.UtilidadesBD.Conexao;

public class DAOCliente {

    public static void inserir(Cliente cliente) throws SQLException, Exception {
        int id = cliente.getId();
        cliente.setId(id++);
        String sql = "INSERT INTO Cliente(Nome, Cpf, Sexo, DataNascimento, EstadoCivil, Endereco, Numero, Bairro, Cidade, Estado, Email, Telefone, Ativo)"
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
}

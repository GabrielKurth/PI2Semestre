package tadsounds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import tadsounds.Models.Instrumento;
import tadsounds.Models.ItemCarrinho;
import tadsounds.Models.Venda;
import tadsounds.UtilidadesBD.Conexao;

public class DAOVenda {

    public static void inserir(tadsounds.Models.Venda venda) throws SQLException, Exception {
        String sql = "INSERT INTO Venda(IdCliente, FormaPagamento, DataVenda, ValorTotal)"
                + "VALUES(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda.getCliente().getId());
            preparedStatement.setString(2, venda.getFormaPagamento());
            Timestamp dataBD = new Timestamp(venda.getDate().getTime());
            preparedStatement.setTimestamp(3, dataBD);
            preparedStatement.setFloat(4, venda.getTotal());
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

    public static void inserirProdutos(Venda venda) throws SQLException, Exception {
        ItemCarrinho carrinho = new ItemCarrinho();
        String sql = "INSERT INTO ItemCarrinho(IdInstrumento, IdVenda, Quantidade, SubTotal) VALUES(?, ?, ?, ?)";
        String sqlVenda = "SELECT COUNT(*) AS Id FROM Venda";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sqlVenda);
            rs = preparedStatement.executeQuery();
            int idVenda = 0;
            if (rs.next()) {
                idVenda = rs.getInt("Id");
            }
            preparedStatement = connection.prepareStatement(sql);
            for (ItemCarrinho c : venda.getCarrinho()) {
                preparedStatement.setInt(1, c.getInstrumento().getId());
                preparedStatement.setInt(2, idVenda);
                preparedStatement.setInt(3, c.getQuantidade());
                preparedStatement.setFloat(4, c.getSubtotal());
                preparedStatement.executeUpdate();
            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void decrementoProduto(Venda venda) throws SQLException, Exception {
        ItemCarrinho carrinho = new ItemCarrinho();
        String sql = "UPDATE Instrumento SET Estoque = ? "
                + "WHERE Instrumento.IdInstrumento = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for(ItemCarrinho c : venda.getCarrinho()){
                preparedStatement.setInt(1, c.getInstrumento().getQuantidade());
                preparedStatement.setInt(2, c.getInstrumento().getId());
                preparedStatement.executeUpdate();
            }
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

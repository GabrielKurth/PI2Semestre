package tadsounds.Servicos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tadsounds.Models.Cliente;
import tadsounds.Models.Venda;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Exceptions.VendaException;
import tadsounds.Mocks.MockVenda;
import tadsounds.Validadores.ValidadorVenda;

public class ServicoVenda {

    public static void fazerVenda(Venda venda) throws VendaException, DataSourceException {
        ValidadorVenda.validar(venda);
        try {
            MockVenda.inserir(venda);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static boolean verificarInstrSelec(JRootPane rootPane, DefaultTableModel tabelaInstrModel,
            DefaultTableModel tabelaCarrinhoModel, int row) {
        boolean instr = false;
        try {
            Integer idInstrumentoAComprar = (Integer) tabelaInstrModel.getValueAt(row, 0);
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                Integer idInstrumentoComprado = (Integer) tabelaCarrinhoModel.getValueAt(i, 0);
                if (idInstrumentoAComprar == idInstrumentoComprado) {
                    instr = false;
                    return instr;
                } else {
                    instr = true;
                }
            }
            if (tabelaCarrinhoModel.getRowCount() == 0) {
                instr = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Instrumento "
                    + "não selecionado!", "Instrumento",
                    JOptionPane.ERROR_MESSAGE);
        }
        return instr;
    }

    public static boolean verificarClienteSelec(Cliente clienteVenda, JTable tabelaClientes) {
        boolean clienteSelecionado = false;
        try {
            int linhaSelCli = tabelaClientes.getSelectedRow();

            if (linhaSelCli >= 0) {
                clienteVenda = ServicoCliente.
                        obterCliente((Integer) tabelaClientes.getValueAt(linhaSelCli, 0));
                return true;
            }
        } catch (Exception ex) {

        }
        return clienteSelecionado;
    }

    public static void atualizarTotalLabel(DefaultTableModel tabelaCarrinhoModel,
            JTable tabelaCarrinho, JLabel labelTotal) {
        DecimalFormat doisForm = new DecimalFormat("#.##");
        float totalLabel = 0;
        try {
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                if (tabelaCarrinho.getValueAt(i, 0) != null) {
                    totalLabel += ((Float) tabelaCarrinhoModel.getValueAt(i, 4));
                }
            }

            labelTotal.setText(String.valueOf(doisForm.format(totalLabel)));
        } catch (Exception e) {
            System.out.println("erro");
        }
    }

    public static void limpaTabelaInstrumento(JTextField field, DefaultTableModel tabelaInstrModel) {
        field.setText("");
        tabelaInstrModel.setRowCount(0);
    }

    public static void limpaTabelaVendas(JLabel labelCliente, DefaultTableModel tabelaCarrinhoModel,
            JTextField fieldCliente, DefaultTableModel tabelaClienteModel, JComboBox formaPagamento, 
            JTextField fieldRecebido, JLabel labelTroco) {
        labelCliente.setText("");
        tabelaCarrinhoModel.setRowCount(0);
        tabelaClienteModel.setRowCount(0);
        fieldCliente.setText("");
        formaPagamento.setSelectedIndex(0);
        fieldRecebido.setText("");
        labelTroco.setText("00,00");
    }

    public static boolean verificarFormaPgto(JComboBox comboPagamento) {
        boolean selecionado = false;
        if (comboPagamento.getSelectedIndex() == 0) {
            return selecionado;
        } else {
            selecionado = true;
        }
        return selecionado;
    }

    public static ArrayList<Venda> listarVendasPeriodo(Date dataInicio, Date dataTermino) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Venda> vendas = MockVenda.getListaVendas();
        ArrayList<Venda> vendasPeriodo = new ArrayList();
        for (Venda venda : vendas) {
            if (formatador.format(venda.getDate()).compareTo(formatador.format(dataInicio)) >= 0
                    && formatador.format(venda.getDate()).compareTo(formatador.format(dataTermino)) <= 0) {
                vendasPeriodo.add(venda);
            }
        }
        return vendasPeriodo;
    }
    
    public static float calcularTroco(JTextField fieldRecebido, JLabel labelTotal) {
        float troco = 0;
        try {
            String receb = fieldRecebido.getText().replaceAll(",", ".");
            float recebido = Float.parseFloat(receb);
            String total = labelTotal.getText().replaceAll(",", ".");
            float totalVenda = Float.parseFloat(total);
            troco = recebido - totalVenda;
        } catch (Exception ex) {

        }
        return troco;
    }

}

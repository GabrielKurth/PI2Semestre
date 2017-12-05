package tadsounds.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private Cliente cliente;
    private ArrayList<ItemCarrinho> carrinho = new ArrayList();
    private String formaPagamento;
    private float total;
    Date date;
    private int id;

    @Override
    public String toString() {
        return "Venda{" + "cliente=" + cliente + ", carrinho=" + carrinho + ", formaPagamento=" + formaPagamento + ", total=" + total + ", date=" + date + ", id=" + id + '}';
    }

    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the carrinho
     */
    public ArrayList<ItemCarrinho> getCarrinho() {
        return carrinho;
    }

    /**
     * @param carrinho the carrinho to set
     */
    public void setCarrinho(ArrayList<ItemCarrinho> carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}

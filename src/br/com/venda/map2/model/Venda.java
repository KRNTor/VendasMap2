/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.model;

/**
 *
 * @author Computador
 */
public class Venda {
    private Cliente cliente;
    private Item item;
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    private String modoDePagamento;

    public Venda() {
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setModoDePagamento(String modoDePagamento) {
        this.modoDePagamento = modoDePagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Item getItem() {
        return item;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getModoDePagamento() {
        return modoDePagamento;
    }
    
}

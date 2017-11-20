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
public class Item {

    public Item() {
    }
    
    private String nome;
    private double precoCompraItem;
    private double precoVendaItem;
    private Fornecedor fornecedor;
    private String validade;

    public String getNome() {
        return nome;
    }

    public double getPrecoCompraItem() {
        return precoCompraItem;
    }

    public double getPrecoVendaItem() {
        return precoVendaItem;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public String getValidade() {
        return validade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoCompraItem(double precoCompraItem) {
        this.precoCompraItem = precoCompraItem;
    }

    public void setPrecoVendaItem(double precoVendaItem) {
        this.precoVendaItem = precoVendaItem;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
}

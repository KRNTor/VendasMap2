/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.model;

import br.com.venda.map2.prototype.IPrototype;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Computador
 */
@Entity
public class Item implements IPrototype<Item>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private double precoCompraItem;
    private double precoVendaItem;
    @OneToOne(fetch = FetchType.EAGER)
    private Fornecedor fornecedor;
    private String validade;

    public Item() {
    }

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

    @Override
    public Item clone() {
        return new Item();
    }

}

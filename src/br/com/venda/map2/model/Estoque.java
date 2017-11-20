/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.model;

import java.util.List;

/**
 *
 * @author Computador
 */
public class Estoque {

    public Estoque() {
    }
    
    private List<Item> itens;

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }
    
    
}

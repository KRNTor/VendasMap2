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
public class Funcionario extends Pessoa{
       private double salario;
       private String funcao;

    public Funcionario() {
    }

    public double getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
       
       
}

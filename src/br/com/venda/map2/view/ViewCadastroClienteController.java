/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Cliente;
import br.com.venda.map2.model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Computador
 */
public class ViewCadastroClienteController {
    @FXML
    private TextField tfnome;
    @FXML
    private TextField tfcpf;
    @FXML
    private TextField tfdatanascimento;
    @FXML
    private TextField tfrua;
    @FXML
    private TextField tfbairro;
    @FXML
    private TextField tfcep;
    @FXML
    private TextField tfuf;
    @FXML
    private TextField tfcidade;
    @FXML
    private TextField tfcomplemento;
    @FXML
    private TextField tfnumero;
    
    private Facade fa = new Facade();
    
    @FXML
    public void cadastrar() throws DAOException{
        Cliente c = new Cliente();
        c.setNome(this.tfnome.getText());
        c.setCpf(this.tfcpf.getText());
        c.setDataNascimento(this.tfdatanascimento.getText());
        c.getEndereco().setRua(this.tfrua.getText());
        c.getEndereco().setCep(this.tfcep.getText());
        c.getEndereco().setBairro(this.tfbairro.getText());
        c.getEndereco().setCidade(this.tfcidade.getText());
        c.getEndereco().setComplemento(this.tfcomplemento.getText());
        c.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
        c.setQtdCompras(0);
        fa.saveCliente(c);
    }
}

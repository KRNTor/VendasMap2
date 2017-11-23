/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Fornecedor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Computador
 */
public class ViewCadastroFornecedorController {
    @FXML
    private TextField tfnome;
    @FXML
    private TextField tfcnpj;
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
        Fornecedor f = new Fornecedor();
        f.setNome(this.tfnome.getText());
        f.setCnpj(this.tfcnpj.getText());
        f.getEndereco().setRua(this.tfrua.getText());
        f.getEndereco().setCep(this.tfcep.getText());
        f.getEndereco().setBairro(this.tfbairro.getText());
        f.getEndereco().setCidade(this.tfcidade.getText());
        f.getEndereco().setComplemento(this.tfcomplemento.getText());
        f.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
        fa.saveFornecedor(f);
    }

}

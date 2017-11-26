/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Endereco;
import br.com.venda.map2.model.Fornecedor;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Computador
 */
public class ViewCadastroFornecedorController implements Initializable {

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

    private Facade fa;
    private Stage stage;

    @FXML
    public void cadastrar() {
        try {
            Fornecedor f = new Fornecedor();
            f.setNome(this.tfnome.getText());
            f.setCnpj(this.tfcnpj.getText());
            Endereco end = new Endereco();
            end.setRua(this.tfrua.getText());
            end.setCep(this.tfcep.getText());
            end.setBairro(this.tfbairro.getText());
            end.setCidade(this.tfcidade.getText());
            end.setComplemento(this.tfcomplemento.getText());
            end.setNumero(Integer.valueOf(this.tfnumero.getText()));
            f.setEndereco(end);
            this.fa.saveFornecedor(f);
            this.stage.close();
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fa = new Facade();
    }

}

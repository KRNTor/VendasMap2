/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.Main;
import br.com.venda.map2.model.Funcionario;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author felpz
 */
public class ViewContaController implements Initializable {

    @FXML
    private Pane paneCliente;
    @FXML
    private Pane paneFuncionario;
    @FXML
    private Pane paneFornecedor;
    @FXML
    private Pane paneItem;
    @FXML
    private Pane paneVenda;
    @FXML
    private Label lbName;
    @FXML
    private JFXButton btnCadCliente;
    @FXML
    private JFXButton btnCadFuncionario;
    @FXML
    private JFXButton btnCadFornecedor;
    @FXML
    private JFXButton btnCadItem;
    @FXML
    private JFXButton btnCadVenda;

    private Stage stage;
    private Funcionario func;

    @FXML
    public void showPaneCliente() {
        this.paneCliente.setVisible(true);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
    }

    @FXML
    public void showPaneFuncionario() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(true);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
    }

    @FXML
    public void showPaneFornecedor() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(true);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
    }

    @FXML
    public void showPaneItem() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(true);
        this.paneVenda.setVisible(false);
    }

    @FXML
    public void showPaneVenda() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(true);
    }

    @FXML
    public void showCadCliente() {
        try {
            Main.showStageCadastrarCliente();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void showCadFuncionario() {
        try {
            Main.showStageCadastrarFuncinario();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void showCadFornecedor() {
        try {
            Main.showStageCadastrarFornecedor();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void showCadItem() {
        try {
            Main.showStageCadastrarItem();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void showCadVenda() {
        try {
            Main.showStageCadastrarVenda();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void showPaneLogin() {
        try {
            Main.showViewLogin();
        } catch (IOException ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setFuncionario(Funcionario func) {
        this.func = func;
        this.lbName.setText("nome: " + func.getNome());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.Main;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Funcionario;
import br.com.venda.map2.modelGeneric.GenericCliente;
import br.com.venda.map2.modelGeneric.GenericClienteController;
import br.com.venda.map2.modelGeneric.GenericFornecedor;
import br.com.venda.map2.modelGeneric.GenericFornecedorController;
import br.com.venda.map2.modelGeneric.GenericFuncionario;
import br.com.venda.map2.modelGeneric.GenericFuncionarioController;
import br.com.venda.map2.modelGeneric.GenericItem;
import br.com.venda.map2.modelGeneric.GenericItemController;
import br.com.venda.map2.modelGeneric.GenericVenda;
import br.com.venda.map2.modelGeneric.GenericVendaController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<GenericCliente> tableCliente;
    @FXML
    private TableColumn<GenericCliente, String> colunaClienteNome;
    @FXML
    private TableColumn<GenericCliente, String> colunaClienteQunt;
    @FXML
    private TableView<GenericFuncionario> tableFuncionario;
    @FXML
    private TableColumn<GenericFuncionario, String> colunaFuncionarioNome;
    @FXML
    private TableColumn<GenericFuncionario, String> colunaFuncionarioLogin;
    @FXML
    private TableView<GenericFornecedor> tableFornecedor;
    @FXML
    private TableColumn<GenericFornecedor, String> colunaFornecedorNome;
    @FXML
    private TableColumn<GenericFornecedor, String> colunaFornecedorCnpj;
    @FXML
    private TableView<GenericItem> tableItem;
    @FXML
    private TableColumn<GenericItem, String> colunaItemNome;
    @FXML
    private TableColumn<GenericItem, String> colunaItemEstq;
    @FXML
    private TableView<GenericVenda> tableVenda;
    @FXML
    private TableColumn<GenericVenda, String> colunaVendaData;
    @FXML
    private TableColumn<GenericVenda, String> colunaVendaNomeCliente;
    @FXML
    private TableColumn<GenericVenda, String> colunaVendaValor;

    private Stage stage;
    private Funcionario func;
    private Facade fac;

    private ObservableList<GenericCliente> olCl;
    private final GenericClienteController controllerCl = new GenericClienteController();
    private ObservableList<GenericFuncionario> olFunc;
    private final GenericFuncionarioController controllerFunc = new GenericFuncionarioController();
    private ObservableList<GenericFornecedor> olForn;
    private final GenericFornecedorController controllerForn = new GenericFornecedorController();
    private ObservableList<GenericItem> olItem;
    private final GenericItemController controllerItem = new GenericItemController();
    private ObservableList<GenericVenda> olVenda;
    private final GenericVendaController controllerVenda = new GenericVendaController();

    @FXML
    public void showPaneCliente() {
        this.paneCliente.setVisible(true);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
        preencherTableCliente();
    }

    @FXML
    public void showPaneFuncionario() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(true);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
        preencherTableFuncionario();
    }

    @FXML
    public void showPaneFornecedor() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(true);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(false);
        preencherTableFornecedor();
    }

    @FXML
    public void showPaneItem() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(true);
        this.paneVenda.setVisible(false);
        preencherTableItem();
    }

    @FXML
    public void showPaneVenda() {
        this.paneCliente.setVisible(false);
        this.paneFuncionario.setVisible(false);
        this.paneFornecedor.setVisible(false);
        this.paneItem.setVisible(false);
        this.paneVenda.setVisible(true);
        preencherTableVenda();
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

    private void preencherTableCliente() {
        try {
            this.colunaClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaClienteQunt.setCellValueFactory(new PropertyValueFactory<>("qunt"));
            this.olCl = FXCollections.observableArrayList(this.controllerCl.listarAll(this.fac.getAllCliente()));
            this.tableCliente.setItems(null);
            this.tableCliente.setItems(this.olCl);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableFuncionario() {
        try {
            this.colunaFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaFuncionarioLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            this.olFunc = FXCollections.observableArrayList(this.controllerFunc.listarAll(this.fac.getAllFuncionario()));
            this.tableFuncionario.setItems(null);
            this.tableFuncionario.setItems(this.olFunc);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableFornecedor() {
        try {
            this.colunaFornecedorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaFornecedorCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
            this.olForn = FXCollections.observableArrayList(this.controllerForn.listarAll(this.fac.getAllFornecedor()));
            this.tableFornecedor.setItems(null);
            this.tableFornecedor.setItems(this.olForn);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableItem() {
        try {
            this.colunaItemNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemEstq.setCellValueFactory(new PropertyValueFactory<>("qunt_estq"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(this.fac.getAllItem()));
            this.tableItem.setItems(null);
            this.tableItem.setItems(this.olItem);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableVenda() {
        try {
            this.colunaVendaData.setCellValueFactory(new PropertyValueFactory<>("data"));
            this.colunaVendaNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome_cliente"));
            this.colunaVendaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            this.olVenda = FXCollections.observableArrayList(this.controllerVenda.listarAll(this.fac.getAllVenda()));
            this.tableVenda.setItems(null);
            this.tableVenda.setItems(this.olVenda);
        } catch (Exception ex) {
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
        this.fac = new Facade();
    }

}

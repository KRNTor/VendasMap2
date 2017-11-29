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
import br.com.venda.map2.model.Item;
import br.com.venda.map2.model.Pessoa;
import br.com.venda.map2.model.Venda;
import br.com.venda.map2.modelGeneric.GenericItem;
import br.com.venda.map2.modelGeneric.GenericItemController;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author felpz
 */
public class ViewVendaController implements Initializable {

    @FXML
    private JFXTextField tfValor;
    @FXML
    private JFXDatePicker dtVenda;
    @FXML
    private JFXComboBox cbCliente;
    @FXML
    private TableView<GenericItem> tableItem;
    @FXML
    private TableColumn<GenericItem, String> colunaItemNome;
    @FXML
    private TableColumn<GenericItem, String> colunaItemEstq;
    @FXML
    private TableColumn<GenericItem, String> colunaItemValor;
    @FXML
    private TableView<GenericItem> tableItem2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemNome2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemQunt2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemValor2;

    private Facade fac;
    private Funcionario func;
    private Stage stage;
    private String dia;
    private String mes;
    private String ano;
    private ObservableList<GenericItem> olItem;
    private final GenericItemController controllerItem = new GenericItemController();

    @FXML
    public void cadastrar() {
        try {
            if (this.dtVenda.getValue() != null) {
                this.dia = String.valueOf(this.dtVenda.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.dtVenda.getValue().getMonthValue());
                this.ano = String.valueOf(this.dtVenda.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            Venda venda = new Venda();
            Cliente c = this.fac.getClienteByName((String) this.cbCliente.getSelectionModel().getSelectedItem());
            venda.setCliente(c);
            venda.setDtVenda(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
            venda.setFuncionario(this.func);
//            venda.setItem(item);
//            venda.setModoDePagamento(modoDePagamento);
            venda.setValor(0);
            this.fac.saveVenda(venda);
        } catch (DAOException ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableItem() {
        try {
            this.colunaItemNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemEstq.setCellValueFactory(new PropertyValueFactory<>("qunt_estq"));
            this.colunaItemValor.setCellValueFactory(new PropertyValueFactory<>("valor_und"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(this.fac.getAllItem()));
            this.tableItem.setItems(null);
            this.tableItem.setItems(this.olItem);
            this.tableItem.setRowFactory(tv -> {
                TableRow<GenericItem> row = new TableRow<>();
                List<Item> lista = new ArrayList<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        try {
                            String qunt = addItemToCart(lista);
                            GenericItem rowData = row.getItem();
                            Item item = this.fac.getItemByName(rowData.getNome());
                            lista.add(item);
                            preencherTableItemCart(lista);
                        } catch (Exception ex) {
                            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                return row;
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableItemCart(List<Item> listaAux) {
        try {
            this.colunaItemNome2.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemQunt2.setCellValueFactory(new PropertyValueFactory<>("qunt"));
            this.colunaItemValor2.setCellValueFactory(new PropertyValueFactory<>("valor_und"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(listaAux));
            this.tableItem2.setItems(null);
            this.tableItem2.setItems(this.olItem);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void repreencherTableItem(List<Item> lista) {
        try {
            this.colunaItemNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemEstq.setCellValueFactory(new PropertyValueFactory<>("qunt_estq"));
            this.colunaItemValor.setCellValueFactory(new PropertyValueFactory<>("valor_und"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(lista));
            this.tableItem.setItems(null);
            this.tableItem.setItems(this.olItem);
        } catch (Exception ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public String addItemToCart(List<Item> lista) {
        String qunt = JOptionPane.showInputDialog(null, "quantidade de itens:");
        repreencherTableItem(lista);
        return qunt;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setFuncionario(Funcionario func) {
        this.func = func;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.fac = new Facade();
            for (Pessoa c : this.fac.getAllCliente()) {
                this.cbCliente.getItems().add(c.getNome());
            }
            preencherTableItem();
        } catch (DAOException ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

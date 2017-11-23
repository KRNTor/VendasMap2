/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Fornecedor;
import br.com.venda.map2.model.Item;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

/**
 *
 * @author Computador
 */
public class ViewCadastroItemController {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfpreco;
    @FXML
    private JFXTextField tfprecovenda;
    @FXML
    private JFXDatePicker dtvalidade;
    @FXML
    private JFXComboBox cbFornecedor;
    @FXML
    private JFXTextField tfquantidade;

    private Facade fa = new Facade();
    private String dia;
    private String mes;
    private String ano;

    @FXML
    public void cadastrar() {
        try {
            if (this.dtvalidade.getValue() != null) {
                this.dia = String.valueOf(this.dtvalidade.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.dtvalidade.getValue().getMonthValue());
                this.ano = String.valueOf(this.dtvalidade.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            Item i = new Item();
            i.setNome(this.tfnome.getText());
            i.setPrecoCompraItem(Double.valueOf(this.tfpreco.getText()));
            i.setPrecoVendaItem(Double.valueOf(this.tfprecovenda.getText()));
            i.setValidade(new SimpleDateFormat("dd/MM/yyyy").parse(this.dia + '/' + this.mes + '/' + this.ano));
            Fornecedor f = new Facade().getFornecedorByName(String.valueOf(this.cbFornecedor.getSelectionModel().getSelectedItem()));
            i.setFornecedor(f);
            i.setQuantidade(Integer.valueOf(this.tfquantidade.getText()));
            this.fa.saveItem(i);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCadastroItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

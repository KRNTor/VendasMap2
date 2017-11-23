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
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Computador
 */
public class ViewCadastroItemController {
    @FXML
    private TextField tfnome;
    @FXML
    private TextField tfpreco;
    @FXML
    private TextField tfprecovenda;
    @FXML
    private TextField tfvalidade;
    @FXML
    private ComboBox tffornecedor;
    @FXML
    private TextField tfquantidade;
    
     private Facade fa = new Facade();
     
     @FXML
    public void cadastrar() throws DAOException{
        Item i = new Item();
        i.setNome(this.tfnome.getText());
        i.setPrecoCompraItem(Double.valueOf(tfpreco.getText()));
        i.setPrecoVendaItem(Double.valueOf(tfprecovenda.getText()));
        i.setValidade(tfvalidade.getText());
        Fornecedor f= new Facade().getFornecedorByName(String.valueOf(tffornecedor.getSelectionModel().getSelectedItem()));
        i.setFornecedor(f);
        i.setQuantidade(Integer.valueOf(tfquantidade.getText()));
        
        fa.saveItem(i);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 *
 * @author felpz
 */
public class ViewVendaController {

    @FXML
    private JFXTextField tfValor;
    @FXML
    private JFXDatePicker dtVenda;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}

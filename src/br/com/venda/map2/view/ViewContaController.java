/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.model.Funcionario;
import javafx.stage.Stage;

/**
 *
 * @author felpz
 */
public class ViewContaController {

    private Stage stage;
    private Funcionario func;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setFuncionario(Funcionario func) {
        this.func = func;
    }

}

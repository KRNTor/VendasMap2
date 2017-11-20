/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.model.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Computador
 */
public class ViewLoginController {

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfSenha;

    @FXML
    public void Logar(Pessoa p) {
        if (p.getLogin().equals(this.tfLogin) && p.getSenha().equals(this.tfSenha)) {

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao logar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}

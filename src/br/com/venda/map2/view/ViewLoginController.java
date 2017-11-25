/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.Main;
import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Funcionario;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import salao.util.CriptografiaUtil;

/**
 *
 * @author Computador
 */
public class ViewLoginController {

    @FXML
    private JFXTextField tfLogin;
    @FXML
    private JFXPasswordField tfSenha;

    @FXML
    public void logar() {
        try {
            //Colocar Criptografia MD5
            Funcionario func = new Facade().getFuncionarioByLogin(this.tfLogin.getText(), CriptografiaUtil.md5(this.tfSenha.getText()));
            if (func != null) {
                Main.showViewConta(func);
            } else {
                //(Wanderson)joptionpane personalizado. 
                JOptionPane.showMessageDialog(null, "Erro ao logar", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrar_Se() {
        try {
            Main.showStageCadastrarFuncinario();
        } catch (IOException ex) {
            Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

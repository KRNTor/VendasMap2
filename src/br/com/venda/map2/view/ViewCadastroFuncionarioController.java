/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.dao.FuncionarioDAO;
import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Endereco;
import br.com.venda.map2.model.Funcionario;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
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
public class ViewCadastroFuncionarioController {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfcpf;
    @FXML
    private JFXDatePicker dtNascimento;
    @FXML
    private JFXTextField tfrua;
    @FXML
    private JFXTextField tfbairro;
    @FXML
    private JFXTextField tfcep;
    @FXML
    private JFXTextField tfuf;
    @FXML
    private JFXTextField tfcidade;
    @FXML
    private JFXTextField tfcomplemento;
    @FXML
    private JFXTextField tflogin;
    @FXML
    private JFXPasswordField tfsenha;
    @FXML
    private JFXTextField tfsalario;
    @FXML
    private JFXTextField tffuncao;
    @FXML
    private JFXTextField tfnumero;

    private Facade fa = new Facade();
    private String dia;
    private String mes;
    private String ano;

    @FXML
    public void cadastrar() {
        try {
            if (this.dtNascimento.getValue() != null) {
                this.dia = String.valueOf(this.dtNascimento.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.dtNascimento.getValue().getMonthValue());
                this.ano = String.valueOf(this.dtNascimento.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            Funcionario f = new Funcionario();
            f.setNome(this.tfnome.getText());
            f.setCpf(this.tfcpf.getText());
            f.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
            f.setLogin(this.tflogin.getText());
            f.setSenha(this.tfsenha.getText());
            Endereco end = new Endereco();
            end.setRua(this.tfrua.getText());
            end.setCep(this.tfcep.getText());
            end.setBairro(this.tfbairro.getText());
            end.setCidade(this.tfcidade.getText());
            end.setComplemento(this.tfcomplemento.getText());
            end.setNumero(Integer.valueOf(this.tfnumero.getText()));
            f.setSalario(Double.valueOf(this.tfsalario.getText()));
            f.setEndereco(end);
            f.setFuncao(this.tffuncao.getText());
            new FuncionarioDAO().save(f);
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCadastroFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

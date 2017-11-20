/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import static javassist.CtMethod.ConstParameter.integer;

/**
 *
 * @author Computador
 */
public class ViewCadastroFuncionarioController {
    @FXML
    private TextField tfnome;
    @FXML
    private TextField tfcpf;
    @FXML
    private TextField datanascimento;
    @FXML
    private TextField tfrua;
    @FXML
    private TextField tfbairro;
    @FXML
    private TextField tfcep;
    @FXML
    private TextField tfuf;
    @FXML
    private TextField tfcidade;
    @FXML
    private TextField tfcomplemento;
    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfsenha;
    @FXML
    private TextField tfsalario;
    @FXML
    private TextField tffuncao;
     @FXML
    private TextField tfnumero;
    
    private Facade fa = new Facade();
     
     @FXML
    public void cadastrar() throws DAOException{
        Funcionario f = new Funcionario();
        f.setNome(this.tfnome.getText());
        f.setCpf(this.tfcpf.getText());
        f.setDataNascimento(this.datanascimento.getText());
        f.setLogin(this.tflogin.getText());
        f.setSenha(this.tfsenha.getText());
        f.getEndereco().setRua(this.tfrua.getText());
        f.getEndereco().setCep(this.tfcep.getText());
        f.getEndereco().setBairro(this.tfbairro.getText());
        f.getEndereco().setCidade(this.tfcidade.getText());
        f.getEndereco().setComplemento(this.tfcomplemento.getText());
        f.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
        f.setSalario(Double.valueOf(this.tfsalario.getText()));
        f.setFuncao(this.tffuncao.getText());
        
        fa.saveFuncionario(f);
    }
}

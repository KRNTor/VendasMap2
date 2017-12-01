/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.view;

import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.facade.Facade;
import br.com.venda.map2.model.Cliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Computador
 */
public class ViewCadastroClienteController {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfcpf;
    @FXML
    private JFXDatePicker tfdtNascimento;
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
    private JFXTextField tfnumero;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    private JFXToggleButton tbEditar;

    private Facade fa = new Facade();
    private String dia;
    private String mes;
    private String ano;
    private Stage stage;
    private Cliente cliente;

    @FXML
    public void cadastrar() {
        try {
            if (this.tfdtNascimento.getValue() != null) {
                this.dia = String.valueOf(this.tfdtNascimento.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.tfdtNascimento.getValue().getMonthValue());
                this.ano = String.valueOf(this.tfdtNascimento.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            if (btnCadastrar.getText().equalsIgnoreCase("cadastrar")) {
                Cliente c = new Cliente();
                c.setNome(this.tfnome.getText());
                c.setCpf(this.tfcpf.getText());
                c.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
                c.getEndereco().setRua(this.tfrua.getText());
                c.getEndereco().setCep(this.tfcep.getText());
                c.getEndereco().setBairro(this.tfbairro.getText());
                c.getEndereco().setCidade(this.tfcidade.getText());
                c.getEndereco().setComplemento(this.tfcomplemento.getText());
                c.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
                fa.saveCliente(c);
                JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso!", "cadastro cliente", JOptionPane.INFORMATION_MESSAGE);
                this.stage.close();
            }
            if (btnCadastrar.getText().equalsIgnoreCase("editar")) {
                cliente.setNome(this.tfnome.getText());
                cliente.setCpf(this.tfcpf.getText());
                cliente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
                cliente.getEndereco().setRua(this.tfrua.getText());
                cliente.getEndereco().setCep(this.tfcep.getText());
                cliente.getEndereco().setBairro(this.tfbairro.getText());
                cliente.getEndereco().setCidade(this.tfcidade.getText());
                cliente.getEndereco().setComplemento(this.tfcomplemento.getText());
                cliente.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
                fa.saveCliente(cliente);
                JOptionPane.showMessageDialog(null, "cliente editado com sucesso!", "cadastro cliente", JOptionPane.INFORMATION_MESSAGE);
                this.stage.close();
                
            }
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setItem(Cliente cliente) {
        this.cliente = cliente;
        fillAndLock(cliente);
    }

    private void fillAndLock(Cliente cliente) {
        if (cliente != null) {
            //--------------fill--------------
            this.tfnome.setText(cliente.getNome());
            this.tfcpf.setText(cliente.getCpf());
            //Não consegui converter essa porra em String!!!!!!!!!
            this.tfdtNascimento.setText(String.valueOf(cliente.getDataNascimento()));
            this.tfrua.setText(cliente.getEndereco().getRua());
            this.tfbairro.setText(cliente.getEndereco().getBairro());
            this.tfcep.setText(cliente.getEndereco().getCep());
            this.tfuf.setText(cliente.getEndereco().getUF());
            this.tfcidade.setText(cliente.getEndereco().getCidade());
            this.tfcomplemento.setText(cliente.getEndereco().getComplemento());
            this.tfnumero.setText(String.valueOf(cliente.getEndereco().getNumero()));

            this.btnCadastrar.setText("editar");
            //--------------lock--------------
            this.tfnome.setEditable(false);
            this.tfcpf.setEditable(false);
            this.tfbairro.setEditable(false);
            this.tfcep.setEditable(false);
            this.tfcidade.setEditable(false);
            this.tfnumero.setEditable(false);
            this.tfcomplemento.setEditable(false);
            this.tfuf.setEditable(false);
            this.tfrua.setEditable(false);
            //Ficou faltando a data que essa porra não da pra mexer com DATE!!!!!
            this.tbEditar.setVisible(true);
        }
    }

    //Ficou faltando mexer com as DATAS!!!!!    
    @FXML
    private void setEditable() {
        if (this.tbEditar.isSelected()) {
            this.tfnome.setEditable(true);
            this.tfcpf.setEditable(true);
            this.tfbairro.setEditable(true);
            this.tfcep.setEditable(true);
            this.tfcidade.setEditable(true);
            this.tfnumero.setEditable(true);
            this.tfcomplemento.setEditable(true);
            this.tfuf.setEditable(true);
            this.tfrua.setEditable(true);
        } else {
            this.tfnome.setEditable(false);
            this.tfcpf.setEditable(false);
            this.tfbairro.setEditable(false);
            this.tfcep.setEditable(false);
            this.tfcidade.setEditable(false);
            this.tfnumero.setEditable(false);
            this.tfcomplemento.setEditable(false);
            this.tfuf.setEditable(false);
            this.tfrua.setEditable(false);
        }
    }
}

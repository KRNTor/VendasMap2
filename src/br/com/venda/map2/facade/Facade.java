/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.facade;

import br.com.venda.map2.dao.*;
import br.com.venda.map2.exception.DAOException;
import br.com.venda.map2.model.*;
import java.util.List;

/**
 *
 * @author felpz
 */
public class Facade {

    private IDaoPessoa daoPessoa;
    private IClienteDAO daoCliente;
    private IEnderecoDAO daoEndereco;
    private IEstoqueDAO daoEstoque;
    private IFuncionarioDAO daoFuncionario;
    private IFornecedorDAO daoFornecedor;
    private IItemDAO daoItem;
    private IVendaDAO daoVenda;

    public Facade() {
        this.daoCliente = new ClienteDAO();
        this.daoEndereco = new EnderecoDAO();
        this.daoEstoque = new EstoqueDAO();
        this.daoFornecedor = new FornecedorDAO();
        this.daoFuncionario = new FuncionarioDAO();
        this.daoItem = new ItemDAO();
        this.daoVenda = new VendaDAO();
    }

    //-----C L I E N T E-----
    public Cliente saveCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.save(cliente);
    }

    public Cliente getClienteById(long id) throws DAOException {
        return this.daoCliente.getById(id);
    }

    public List<Cliente> getAllCliente() throws DAOException, DAOException, DAOException {
        return this.daoCliente.getAll();
    }

    public Cliente updateCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.update(cliente);
    }

    public Cliente removeCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.remove(cliente);
    }

    //-----E N D E R E C O-----
    public Endereco saveEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.save(end);
    }

    public Endereco getEnderecoById(long id) throws DAOException {
        return this.daoEndereco.getById(id);
    }

    public List<Endereco> getAllEndereco() throws DAOException {
        return this.daoEndereco.getAll();
    }

    public Endereco updateEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.update(end);
    }

    public Endereco removeEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.remove(end);
    }

    //-----E S T O Q U E-----
    public Estoque saveEstoque(Estoque est) throws DAOException {
        return this.daoEstoque.save(est);
    }

    public Estoque getEstoqueById(long id) throws DAOException {
        return this.daoEstoque.getById(id);
    }

    public List<Estoque> getAllEstoque() throws DAOException {
        return this.daoEstoque.getAll();
    }

    public Estoque updateEstoque(Estoque est) throws DAOException {
        return this.daoEstoque.update(est);
    }

    public Estoque removeEstoque(Estoque est) throws DAOException {
        return this.daoEstoque.remove(est);
    }

    //-----E S T O Q U E-----
    public Fornecedor saveFornecedor(Fornecedor forn) throws DAOException {
        return this.daoFornecedor.save(forn);
    }

    public Fornecedor getFornecedorById(long id) throws DAOException {
        return this.daoFornecedor.getById(id);
    }

    public List<Fornecedor> getAllFornecedor() throws DAOException {
        return this.daoFornecedor.getAll();
    }

    public Fornecedor updateFornecedor(Fornecedor forn) throws DAOException {
        return this.daoFornecedor.update(forn);
    }

    public Fornecedor removeFornecedor(Fornecedor forn) throws DAOException {
        return this.daoFornecedor.remove(forn);
    }

    //-----F U N C I O N A R I O-----
    public Funcionario saveFuncionario(Funcionario func) throws DAOException {
        return this.daoFuncionario.save(func);
    }

    public Funcionario getFuncionarioById(long id) throws DAOException {
        return this.daoFuncionario.getById(id);
    }

    public Funcionario getFuncionarioByLogin(String login, String senha) throws DAOException {
        return this.daoFuncionario.getByLogin(login, senha);
    }

    public List<Funcionario> getAllFuncionario() throws DAOException {
        return this.daoFuncionario.getAll();
    }

    public Funcionario updateFuncionario(Funcionario func) throws DAOException {
        return this.daoFuncionario.update(func);
    }

    public Funcionario removeFuncionario(Funcionario func) throws DAOException {
        return this.daoFuncionario.remove(func);
    }

    //-----I T E M-----
    public Item saveItem(Item item) throws DAOException {
        return this.daoItem.save(item);
    }

    public Item getItemById(long id) throws DAOException {
        return this.daoItem.getById(id);
    }

    public List<Item> getAllItem() throws DAOException {
        return this.daoItem.getAll();
    }

    public Item updateItem(Item item) throws DAOException {
        return this.daoItem.update(item);
    }

    public Item removeItem(Item item) throws DAOException {
        return this.daoItem.remove(item);
    }

    //-----V E N D A-----
    public Venda saveVenda(Venda venda) throws DAOException {
        return this.daoVenda.save(venda);
    }

    public Venda getVendaById(long id) throws DAOException {
        return this.daoVenda.getById(id);
    }

    public List<Venda> getAllVenda() throws DAOException {
        return this.daoVenda.getAll();
    }

    public Venda updateVenda(Venda venda) throws DAOException {
        return this.daoVenda.update(venda);
    }

    public Venda removeVenda(Venda venda) throws DAOException {
        return this.daoVenda.remove(venda);
    }
}

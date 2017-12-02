/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.map2.dao;

import br.com.venda.map2.model.Funcionario;
import br.com.venda.map2.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Computador
 */
public class FuncionarioDAO extends DaoGenericImpl<Funcionario> implements IFuncionarioDAO {

    private EntityManager em;

    @Override
    public Funcionario getByLogin(String login, String senha) {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select p from Pessoa p where p.login = :login and p.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            return (Funcionario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }

    @Override
    public Funcionario getByName(String nome) {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select p from Pessoa p where p.nome: =nome");
            query.setParameter("nome", nome);
            return (Funcionario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }
}

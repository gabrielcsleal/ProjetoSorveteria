/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ProdutosMySqlDAO {
   
    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;
    MateriaPrimaMySqlDAO cDAO = new MateriaPrimaMySqlDAO();
    public ProdutosMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(ProdutosBEAN c) {
        String sql = "insert into produto (pronome,"
                + " protamanho,"
                + " prodescricao, proprecoBase) values (?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getDescricao());
            stmt.setFloat(4, c.getPrecoBase());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    

    public ProdutosBEAN localizarCod(int codigo) {
        String sql = "select * from produto where proCodigo = ?";
        ProdutosBEAN pb = new ProdutosBEAN();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                pb.setCod(rs.getInt(1));
                pb.setNome(rs.getString(2));
                pb.setTamanho(rs.getString(3));
                pb.setDescricao(rs.getString(4));
                pb.setPrecoBase(rs.getFloat(5));
                
            }
            stmt.close();
            return pb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editar(ProdutosBEAN c) {
        String sql = "update produto set proNome = ?, proTamanho = ?,"
                + " proDescricao = ?, proPrecoBase = ? where proCodigo =?;";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getDescricao());
            stmt.setFloat(4, c.getPrecoBase());
            stmt.setInt(5, c.getCod());
            
            // executa
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            
            if(linhasAtualizadas > 0){
                System.out.println("Foram alterados " + linhasAtualizadas + " registos.");
            }
            return true;
            
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }

    public boolean remover(int codigo) {
        String sql = "delete from produto where procodigo = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<ProdutosBEAN> listarALL() {
        String sql = "select * from produto;";
        ArrayList<ProdutosBEAN> produtoAL = new ArrayList<ProdutosBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                ProdutosBEAN c = new ProdutosBEAN(); 
                c.setCod(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                c.setNome(rs.getString(2));
                c.setTamanho(rs.getString(3));
                c.setDescricao(rs.getString(4));
                c.setPrecoBase(rs.getFloat(5));
                //adiciona os dados no ArrayLIst
                produtoAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtoAL;
    }
    
    
    

    public ProdutosBEAN localizarNome(String nome) {
         String sql = "select * from produto where proNome = ?";
        ProdutosBEAN pb = new ProdutosBEAN();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, nome);
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                pb.setCod(rs.getInt(1));
                pb.setNome(rs.getString(2));
                pb.setTamanho(rs.getString(3));
                pb.setDescricao(rs.getString(4));
                pb.setPrecoBase(rs.getFloat(5));
                
            }
            stmt.close();
            return pb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.ConnectionFactory;
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
public class FornecedorMySqlDAO {

    //armazernar meu objeto de conexao com o BD MySQL    
    private Connection connection;
    //objeto stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public FornecedorMySqlDAO() {
        //inicializa a conexão com o BD - chamando o FActory e Singleton
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(FornecedorBEAN c) {
        String sql = "insert into fornecedor (forNomeCompleto,"
                + " forNomeFantasia,"
                + " forRua, "
                + " forComplemento,"
                + " forBairro,"
                + " forCidade,"
                + " forEstado,"
                + " forCEP,"
                + " forEmail,"
                + " forCNPJ,"
                + " forInscricaoEstadual,"
                + " forCPF,"
                + " forRG,"
                + " forNumero) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getNomeCompleto());
            stmt.setString(2, c.getNomeFantasia());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getComplemento());
            stmt.setString(5, c.getBairro());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getEstado());
            stmt.setString(8, c.getCep());
            stmt.setString(9, c.getEmail());
            stmt.setString(10, c.getCnpj());
            stmt.setString(11, c.getInscricaoEstadual());
            stmt.setString(12, c.getCpf());
            stmt.setString(13, c.getRG());
            stmt.setString(14, c.getNumero());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FornecedorBEAN localizarCod(int codigo) {
        String sql = "select * from fornecedor where forCodigo = ?;";
        FornecedorBEAN c = new FornecedorBEAN();
        try {

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c.setCod(rs.getInt(1));
                c.setNomeCompleto(rs.getString(2));
                c.setNomeFantasia(rs.getString(3));
                c.setEndereco(rs.getString(4));
                c.setComplemento(rs.getString(5));
                c.setBairro(rs.getString(6));
                c.setCidade(rs.getString(7));
                c.setEstado(rs.getString(8));
                c.setCep(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setCnpj(rs.getString(11));
                c.setInscricaoEstadual(rs.getString(12));
                c.setCpf(rs.getString(13));
                c.setRG(rs.getString(14));
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public boolean editar(FornecedorBEAN c) {
        String sql = "update fornecedor set forNomeCompleto = ?, forNomeFantasia = ?,"
                + " forEndereco = ?, forComplemento = ?, forBairro = ?, forCidade = ?, forEstado = ?, forCEP = ?, forEmail = ?, forCNPJ = ?, "
                + " forInscricaoEstadual = ?,for CPF = ?, forRG = ? where forCodigo = ?;";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, c.getNomeCompleto());
            stmt.setString(2, c.getNomeFantasia());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getComplemento());
            stmt.setString(5, c.getBairro());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getEstado());
            stmt.setString(8, c.getCep());
            stmt.setString(9, c.getEmail());
            stmt.setString(10, c.getCnpj());
            stmt.setString(11, c.getInscricaoEstadual());
            stmt.setString(12, c.getCpf());
            stmt.setString(13, c.getRG());

            // executa
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();

            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " registos.");
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover(int codigo) {
        String sql = "delete from fornecedor where forCodigo = ?";
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
        /**
         *
         * @return
         */
    }

    public ArrayList<FornecedorBEAN> listarALL() {
        String sql = "select * from fornecedor;";
        ArrayList<FornecedorBEAN> fornecedorAL = new ArrayList<FornecedorBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
                FornecedorBEAN c = new FornecedorBEAN();
                c.setCod(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                c.setNomeCompleto(rs.getString(2));
                c.setNomeFantasia(rs.getString(3));
                c.setEndereco(rs.getString(4));
                c.setComplemento(rs.getString(5));
                c.setBairro(rs.getString(6));
                c.setCidade(rs.getString(7));
                c.setEstado(rs.getString(8));
                c.setCep(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setCnpj(rs.getString(11));
                c.setInscricaoEstadual(rs.getString(12));
                c.setCpf(rs.getString(13));
                c.setRG(rs.getString(14));
                //adiciona os dados no ArrayLIst
                fornecedorAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fornecedorAL;
    }
    public FornecedorBEAN localizarNome(int codigo) {
        String sql = "select * from fornecedor where forNomeFantasia = ?;";
        FornecedorBEAN c = new FornecedorBEAN();
        try {

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c.setCod(rs.getInt(1));
                c.setNomeCompleto(rs.getString(2));
                c.setNomeFantasia(rs.getString(3));
                c.setEndereco(rs.getString(4));
                c.setComplemento(rs.getString(5));
                c.setBairro(rs.getString(6));
                c.setCidade(rs.getString(7));
                c.setEstado(rs.getString(8));
                c.setCep(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setCnpj(rs.getString(11));
                c.setInscricaoEstadual(rs.getString(12));
                c.setCpf(rs.getString(13));
                c.setRG(rs.getString(14));
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

}

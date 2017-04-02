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
import javax.swing.JOptionPane;

/**
 *
 * @author Gabi
 */
public class MateriaPrimaMySqlDAO {

    private PreparedStatement stmt;

    private Connection connection;

    public MateriaPrimaMySqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(MateriaPrimaBEAN mp) {
        String sql = "insert into materia_prima (matNome, matUnidade) values (?,?);";

        try {

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, mp.getNome());
            stmt.setString(2, mp.getUnidade());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<MateriaPrimaBEAN> listarALL() {
        String sql = "select * from materia_prima;";
        ArrayList<MateriaPrimaBEAN> mpAL = new ArrayList<MateriaPrimaBEAN>();
        try {
            // prepared statement para seleção
            stmt = connection.prepareStatement(sql);

            // executa a consulta SQL usando o comando executeQuery
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                //joga os dados do rs dentro de um objeto c do tipo ContatoBEAN
              MateriaPrimaBEAN c = new MateriaPrimaBEAN(); 
                c.setCodigo(rs.getInt(1));//indica que o cod ta no campo 1 do rs
                c.setNome(rs.getString(2));
               c.setUnidade(rs.getString(3));
                //adiciona os dados no ArrayLIst
                mpAL.add(c);
            }
            stmt.close();//fecha conexão - OBRIGATORIO SEMPRE!
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mpAL;
    }

    public void excluir(int codigo) {
        String sql = "Delete from materia_prima where mpCodigo = ?";

        try {

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1,codigo);
            

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editar(MateriaPrimaBEAN materia) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE materia_prima SET matNome=?"
                    + ",matUnidade=? where matCodigo=?");
           
            stmt.setString(1, materia.getNome());
            stmt.setString(2, materia.getUnidade());
          
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:\n" + ex);
        } finally {
         ConnectionFactory.closeConnection(con);
        }
    }

    public MateriaPrimaBEAN localizarCod(int codigo) {
String sql = "select * from materia_prima where matCodigo = ?";
        MateriaPrimaBEAN pb = new MateriaPrimaBEAN();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, codigo);
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                pb.setCodigo(rs.getInt(1));
                pb.setNome(rs.getString(2));
                pb.setUnidade(rs.getString(3));
                
                
                
            }
            stmt.close();
            return pb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    public MateriaPrimaBEAN localizarNome(String nome) {
    String sql = "select * from materia_prima where matNome = ?";
        MateriaPrimaBEAN pb = new MateriaPrimaBEAN();
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, nome);
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                pb.setCodigo(rs.getInt(1));
                pb.setNome(rs.getString(2));
                pb.setUnidade(rs.getString(3));
                
                
            }
            stmt.close();
            return pb;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }
    
    

    
    

}

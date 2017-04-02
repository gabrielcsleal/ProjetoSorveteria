/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.ConnectionFactory;
import Modelo.ProdutosBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gabi
 */
public class VendasMySqlDAO {
    private PreparedStatement stmt;

    private Connection connection;

    public VendasMySqlDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void vendas(VendasBEAN v) {
        String sql = "insert into Vendas (venData, venHora) values (?,?);";

        try {

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, v.getData());
            stmt.setString(2, v.getHora());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Venda_Produto(VendasBEAN v,ProdutosBEAN p) {
        String sql = "insert into Vendas_Produto ( ven_proCodigo, ven_proPrecoFinal)"
                + " values (?,?);";

        try {

            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, v.getCodigo());
            stmt.setFloat(2, v.getPrecoFinal());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}}

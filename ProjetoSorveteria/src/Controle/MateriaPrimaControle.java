/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.MateriaPrimaBEAN;
import Modelo.MateriaPrimaMySqlDAO;
import Modelo.ProdutosBEAN;
import Modelo.VendasBEAN;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabi
 */
public class MateriaPrimaControle {
    
    private MateriaPrimaMySqlDAO cDAO = new MateriaPrimaMySqlDAO();
    private int codigo = 0;
    
    public ArrayList<MateriaPrimaBEAN> listarALL() {
       return cDAO.listarALL();
    }
    public int atualizaCodigo() {
        codigo++;        
        return codigo;
    }
    
    public void cadastrar(MateriaPrimaBEAN mp, String nome, String unidade) {        
        mp.setNome(nome);
        mp.setUnidade(unidade);//ADICIONANDO ATRIBUTOS
        MateriaPrimaMySqlDAO mpsd = new MateriaPrimaMySqlDAO();
        mpsd.cadastrar(mp);
        
    }
    public void excluir(int codigo){
        cDAO.excluir(codigo);
    }
    public void editar(MateriaPrimaBEAN mp,String nome,String unidade ){
    mp.setNome(nome);
        mp.setUnidade(unidade);
       
        cDAO.editar(mp);
    }

    
   
    public MateriaPrimaBEAN localizarCod(int codigo) {
        return cDAO.localizarCod(codigo);
    }

   public MateriaPrimaBEAN localizarNome(String nome) {
        return cDAO.localizarNome(nome);
    }    
       
    
    
    
    
       
    
    
}

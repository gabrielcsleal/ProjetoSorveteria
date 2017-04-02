/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelo.ProdutosBEAN;
import Modelo.ProdutosMySqlDAO;
import java.util.ArrayList;



/**
 *
 * @author User
 */
public class ProdutosControle {
        //private ContatoDAO cDAO = new ContatoDAO(); //acesso via arraylist
    private ProdutosMySqlDAO pDAO = new ProdutosMySqlDAO();
    private int codigo = 0;
    
    public ArrayList<ProdutosBEAN> listarALL() {
       return pDAO.listarALL();
    }
    
    public int atualizaCodigo(){
       codigo++;   
       return codigo;
    }
    
    public void cadastrar(ProdutosBEAN c) {                
        c.setCod(this.atualizaCodigo());
        pDAO.cadastrar(c);
    }
    
    public ProdutosBEAN localizar(int codigo) {
        return pDAO.localizar(codigo);
    }    
        
    public boolean editar(ProdutosBEAN c) {
        return pDAO.editar(c);
    }
    
    public boolean remover(int codigo) {     
        return pDAO.remover(codigo);
    }
}

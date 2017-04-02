/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelo.FornecedorBEAN;
import Modelo.FornecedorMySqlDAO;
import Modelo.FornecedorBEAN;
import Modelo.FornecedorMySqlDAO;
import java.util.ArrayList;



/**
 *
 * @author User
 */
public class FornecedorControle {
        //private ContatoDAO cDAO = new ContatoDAO(); //acesso via arraylist
    private FornecedorMySqlDAO fDAO = new FornecedorMySqlDAO();
    private int codigo = 0;
    
    public ArrayList<FornecedorBEAN> listarALL() {
       return fDAO.listarALL();
    }
    
    public int atualizaCodigo(){
       codigo++;   
       return codigo;
    }
    
    public void cadastrar(FornecedorBEAN c) {                
        c.setCod(this.atualizaCodigo());
        fDAO.cadastrar(c);
    }
    
    public boolean editar(FornecedorBEAN c) {
        return fDAO.editar(c);        
    }
    
    public boolean remover(int codigo) {     
        return fDAO.remover(codigo);
    }

    public FornecedorBEAN localizarCod(int codigo) {
        return fDAO.localizarCod(codigo);
    }
    public FornecedorBEAN localizarNome(int codigo) {
        return fDAO.localizarNome(codigo);
    }

    
}
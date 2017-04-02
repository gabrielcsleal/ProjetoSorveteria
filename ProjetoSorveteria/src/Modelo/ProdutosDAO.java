/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ProdutosDAO {
    private static ArrayList<ProdutosBEAN> arrayProdutos = new ArrayList<ProdutosBEAN>();
    
    public void cadastrar(ProdutosBEAN c) {
        arrayProdutos.add(c);
    }
    
    public ArrayList<ProdutosBEAN> listarALL() {
        return arrayProdutos;
    }
    
    public ProdutosBEAN localizar(int codigo) {
        for (ProdutosBEAN produtoBEAN : arrayProdutos) {
            if (produtoBEAN.getCod() == codigo) {
                return produtoBEAN;
            }
        }
        return null;
    }
    
    public int localizarIndex(int codigo) {
        int index = 0;
        for (ProdutosBEAN produtoBEAN : arrayProdutos) {            
            if (produtoBEAN.getCod() == codigo) {         
                return index;
            }
            index++;
        }
        return -1;
    }
    
    public boolean editar(ProdutosBEAN c) {
        boolean modificou = false;
        int index = this.localizarIndex(c.getCod());        
        if (index  != -1) {            
            arrayProdutos.set(index,c);         
            modificou = true;
        } 
         
        return modificou;
    }
    
    public boolean remover(int codigo) {
        boolean removeu = false;
        int index = this.localizarIndex(codigo);        
        if (index  != -1) {            
            arrayProdutos.remove(index);
            removeu = true;
        } 
        return removeu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gabi
 */
public class VendasBEAN {
    private int codigo;
    private String data;
    private String hora;
    private float PrecoFinal;

    public float getPrecoFinal() {
        return PrecoFinal;
    }

    public void setPrecoFinal(float PrecoFinal) {
        this.PrecoFinal = PrecoFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

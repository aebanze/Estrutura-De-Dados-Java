/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espalhamento;

/**
 *
 * @author Banze
 */
public class Vocabulo {
    String palavra;
    String significado;

    public Vocabulo() {
    }

    public Vocabulo(String palavra, String significado) {
        this.palavra = palavra;
        this.significado = significado;
    }

    public Vocabulo(String palavra) {
        this.palavra = palavra;
        this.significado = significado;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }
    
    
}

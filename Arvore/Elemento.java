/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 *
 * @author Banze
 * @param <TIPO>
 */
public class Elemento <TIPO> {
    private TIPO info;
    private Elemento <TIPO> esquerda;
    private Elemento <TIPO> direita;

    public Elemento(TIPO info) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public TIPO getInfo() {
        return info;
    }

    public void setInfo(TIPO info) {
        this.info = info;
    }

    public Elemento<TIPO> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<TIPO> esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento<TIPO> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<TIPO> direita) {
        this.direita = direita;
    }
    
    
}

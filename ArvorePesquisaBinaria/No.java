/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvorePesquisaBinaria;

/**
 *
 * @author Banze
 */
public class No {
    private No esquerda;
    private No direita;
    private Comparable <Object> info;

    public No(Comparable <Object> info){
        this.info = info;
    }

    public No getEsquerda(){
        return esquerda;
    }

    public void setEsquerda (No esquerda){
        this.esquerda = esquerda;
    }

    public No getDireita(){
        return direita;
    }

    public void setDireita(No direita){
        this.direita = direita;
    }

    public Comparable<Object> getInfo(){
        return info;
    }

    public void setInfo(Comparable<Object> info){
        this.info = info;
    }
}

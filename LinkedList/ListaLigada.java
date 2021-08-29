/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasligadas; 

import listasligadas.Lists.ArrayList;


/**
 *
 * @author Banze
 */
public class ListaLigada implements InterfaceGeral{
    private NO primeiro;
    private NO ultimo;
    private int totalElem;
    

    public ListaLigada() {
        this.totalElem = 0;
    }

    
    @Override
    public void adicionaInicio(Object elemento) {
        NO novo = new NO (primeiro, elemento);
        if (totalElem == 0){
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
        }
        primeiro = novo;
        totalElem++;
    }

    @Override
    public void adicionaPosicao(int posicao, Object elemento) {
        NO novo = new NO (elemento);
        NO temp = primeiro;
        int i = 1;
        
        if (!this.posicaoValida(posicao)){
            throw new IllegalArgumentException ("posicao invalida");
        }
        if (posicao == 0){
            this.adicionaInicio(elemento);
        } else  
            if (posicao == totalElem){
                this.adicionaFim(elemento);
        } else {
                while (i < (posicao - 1)){
                    temp = temp.getProximo();
                    i++;
                }
                novo.setProximo(temp.getProximo());
                temp.setProximo(novo);
            }
        totalElem++;
    }

    @Override
    public void adicionaFim(Object elemento) {
        NO novo = new NO (elemento);
        
        if (totalElem == 0){
            this.adicionaInicio(elemento);
        } else {
            this.ultimo.setProximo(novo);
        }
        this.ultimo = novo;
        totalElem ++;
    }

    @Override
    public Object pega(int posicao) {
        NO obj = primeiro;
        int i = 1;
        if (this.posicaoValida(posicao)){
            if (posicao == 0){
                obj = primeiro;
            } else if (posicao == totalElem){
                obj = ultimo;
            }else {
                while (i <= posicao){
                    obj = obj.getProximo();
                    i++;
                }
            }
        } else {
            throw new IllegalArgumentException ("posição inválida");
        }
            return obj;
    }

    @Override
    public void removeInicio() {
        if (totalElem == 1){
            primeiro = null;
        } else {
            primeiro = primeiro.getProximo();
        }
        totalElem--;
    }

    @Override
    public void removePosicao(int posicao) {
        if (!this.posicaoValida(posicao)){
            throw new IllegalArgumentException ("posição inválida");
        }
        NO temp = primeiro;
        NO ant = null;
        int i = 1;
            if (posicao == 1){
                this.removeInicio();
            } else if (posicao == totalElem){
                this.removeFim();
            } else {
                while (i < posicao){
                    ant = temp;
                    temp = temp.getProximo();
                    i++;
                }
                ant.setProximo(temp.getProximo());
                totalElem--;
            }
    }

    @Override
    public void removeFim() {
        NO temp = primeiro;
        int i = 0;
        while (i < (totalElem-2)){
            temp = temp.getProximo();
            i++;
        }
        temp.setProximo(null);
        ultimo = temp;
        totalElem--;
    }

    @Override
    public boolean contem(Object elemento) {
        NO temp = this.primeiro;
        int i = 0;
        boolean valor = false;
        if (elemento == null){
            throw new NullPointerException ("parametro nao pode ser nulo");
        }
        while (i < totalElem ){
            if (temp.getElemento().equals(elemento)){
                valor = true;
                break;
            }
            temp = temp.getProximo();
            i++;
        }
        return valor;
    }

    @Override
    public int tamanho() {
        return totalElem;
    }
    public boolean posicaoValida (int posicao){
        return (posicao >= 0 && posicao <= totalElem);
    }
    public void show (){
        int i = 1;
        NO temp = primeiro;
        while (temp != null){
            System.out.println("Elemento " + temp.getElemento() + " na posicao " + i);
            temp = temp.getProximo();
            i++;
        }
        System.out.println("O tamanho é " + this.tamanho());
        System.out.println("==========================================");
    }
    
    //exercise
    public void adicionaFim (ListaLigada list){
        if (list.tamanho() == 0){
            throw new IllegalArgumentException("Lista vazia");
        }
        this.ultimo.setProximo(list.primeiro);
        this.ultimo = list.ultimo;
    }
    public void removeTodos (ArrayList list){
        for (int i = 1; i <= list.tamanho(); i++){
            if (this.contem(list.pega(i))){
                this.removePosicao(i);
            }
        }
    }
}

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
public class ListaLigada2 implements InterfaceGeral{
    private NO primeiro;
    private NO ultimo;
    private int totalElem;

    public ListaLigada2() {
        totalElem = 0;
    }
    

    @Override
    public ListaLigada2 clone() throws CloneNotSupportedException{
        ListaLigada2 list = new ListaLigada2();
        for (int i = 0; i < this.tamanho(); i++){
            list.adicionaFim(this.pega(i));
        }
        return list;
    }
    @Override
    public void adicionaInicio(Object elemento) {
        NO novo = new NO(ultimo, primeiro, elemento);
        if (totalElem == 0){
            ultimo = novo;
            ultimo.setAnterior(novo);
        } else {
            primeiro.setAnterior(novo);
            novo.setProximo(primeiro);
        }
        primeiro = novo;
        totalElem++;
    }

    @Override
    public void adicionaPosicao(int posicao, Object elemento) {
        if (!this.posicaoValida(posicao)){
            throw new IndexOutOfBoundsException ("posição inválida");
        }
        NO novo = new NO (elemento);
        
        if (posicao == 1){
            this.adicionaInicio(elemento);
        } else if (posicao == totalElem){
            this.adicionaFim(elemento);
        } else {
           NO actual = this.pegaNO(posicao);
           NO anterior = actual.getAnterior();
           actual.setAnterior(novo);
           novo.setProximo(actual);
           anterior.setProximo(novo);
           novo.setAnterior(anterior);
           totalElem++;
        }
    }

    @Override
    public void adicionaFim(Object elemento) {
        NO novo = new NO(elemento);
        if (totalElem == 0){
            this.adicionaInicio(elemento);
        } else {
            novo.setAnterior(ultimo);
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
            totalElem ++;
        }
    }

    
    private NO pegaNO(int posicao) {
        NO temp;
        int pMeio = this.totalElem/2;
        if (this.posicaoValida(posicao)){
            if (posicao == 0){
                temp = primeiro;
            } else if (posicao == (totalElem-1)){
                temp = ultimo;
            }else if (posicao >= pMeio){
                temp = ultimo;
                for (int i = (totalElem-1); i >= posicao; i--){
                    temp = temp.getAnterior();
                }
            } else {
                temp = primeiro;
                for (int i = 0; i < posicao; i++){
                    temp = temp.getProximo();
                }
            }
        } else {
            throw new IndexOutOfBoundsException ("posição inválida");
        }
            return temp;
    }

    @Override
    public void removeInicio() {
        if (totalElem == 1){
            primeiro = null;
            ultimo = null;
        } else {
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
            
        }
        totalElem--;
    }

    @Override
    public void removePosicao(int posicao) {
        if(!this.posicaoValida(posicao)){
            throw new IndexOutOfBoundsException ("posição inválida");
        }
        if (posicao == 1){
            this.removeInicio();
        } else if (posicao == totalElem){
            this.removeFim();
        } else {
            NO actual = this.pegaNO(posicao);
            NO anterior = actual.getAnterior();
            NO proximo = actual.getProximo();
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
            totalElem--;
        }
    }

    @Override
    public void removeFim() {
        if (totalElem == 1){
            this.removeInicio();
        }else {
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
            this.totalElem--;
        }
        
    }

    @Override
    public boolean contem(Object elemento) {
        NO temp = this.primeiro;
        int i = 0;
        boolean valor = false;
        if (elemento == null){
            throw new NullPointerException ("parametro nao pode ser nulo");
        }
        while (i < totalElem){
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
        return (posicao >=0 && posicao <= totalElem);
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

    @Override
    public Object pega(int posicao) {

        if (!this.posicaoValida(posicao)){
            throw new IndexOutOfBoundsException ("posição inválida");
        }
        return this.pegaNO(posicao).getElemento();
    }
    public void adicionaInicio (Object a[]){
        for (int i = (a.length-1); i >= 0; i--){
            this.adicionaInicio(a[i]);
        }
    }
    public void adicionaInicio (ArrayList lista){
        if(lista.tamanho() == 0){
            throw new NullPointerException ("Parametro nulo");
            
        }
        for (int i = (lista.tamanho() - 1); i >= 0; i--){
            this.adicionaInicio(lista.pega(i));
        }
    }
    public void adicionaInicio (ListaLigada2 lista){
        if (lista == null){
            throw new NullPointerException ("parametro nulo");
        }
        if (lista.tamanho()> 0){
            lista.ultimo.setProximo(this.primeiro);
            this.primeiro.setAnterior(lista.ultimo);
            this.totalElem += lista.tamanho();
            this.primeiro = lista.primeiro;
        }
    }
    public boolean eVazia (){
        if (this.totalElem == 0){
            return true;
        }
        return false;
    }
    //exercise
    
}

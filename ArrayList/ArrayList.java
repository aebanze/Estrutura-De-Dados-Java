/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasligadas.Lists;

/**
 *
 * @author Banze
 */
public class ArrayList {
    private Object elementos [];
    private int totalElem;
    
    public ArrayList (){
        this.elementos = new Object[10];
        this.totalElem = 0;
    }
    public ArrayList (int tamanho){
        this.elementos = new Object [tamanho];
        this.totalElem = 0;
    }
    
    public boolean eVazia (Object a[]){
        int cont = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == null){
                cont++;
            }
        }
        if (cont == 0){
            return true;
        }
        return false;
    }
    public boolean posicaoValida (int posicao){
        if (posicao >= 0 && posicao < totalElem){
            return true;
        }
        return false;
    }
    public void garanteEspaco (){
        if (totalElem == elementos.length){
            Object elemento2[] = new Object [2 * elementos.length];
            for (int i = 0; i <= elementos.length; i++){
            elemento2 [i] = elementos[i];
            elementos = elemento2;
            }
        }
    }
        
    public void adicionaInicio (Object elemento){
        if (elemento == null){
            throw new IllegalArgumentException ("Parametro nulo");
        }
        this.garanteEspaco();
        for (int i = totalElem; i > 0; i--){
            elementos [i] = elementos [i - 1];
        }
        elementos[0] = elemento;
        totalElem++;
    }
    
    public void adicionaPosicao (int posicao, Object elemento){
        if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
        if (elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
        this.garanteEspaco();
        for (int i = totalElem; i >= (posicao -1); i--){
            elementos[i] = elementos[i-1];
        }
        elementos[posicao - 1] = elemento;
        totalElem++;
    }
    public void adicionaFim (Object elemento){
        if (elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
            elementos[totalElem] = elemento;
            totalElem++;
    }
    public Object pega (int posicao){
        if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
        return elementos[posicao];
    }
    public void removeInicio () {
    for(int i = 0; i < totalElem; i++){
        elementos[i] = elementos[i+1];
    }
    totalElem--;
    }
    public void removePosicao (int posicao){
         if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
         for (int i = posicao-1; i < totalElem; i++){
             elementos [i] = elementos[i+1];
         }
         totalElem--;
    }
    public void removeFim(){
        totalElem--;
    }
    public boolean contem (Object elemento){
        if(elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
        for (int i = 0; i < elementos.length; i++){
            if (elementos[i] == elemento){
                return true;
            }
        }
        return false;
    }
    public int tamanho(){
        return totalElem;
    
    }
    //Homework
    
    public void adicionaInicio (Object a[]){
        if(eVazia(a)){
            throw new  NullPointerException ("Parametro nulo");
        }
        this.garanteEspaco();
        int cont = 0;
        while (a[cont] != null){
            cont++;
        }
        for (int i = totalElem -1; i > 0; i--){
            elementos[i + cont] = elementos[i];
            totalElem++;
        }
        for(int i = 0; i < totalElem; i++ ){
            elementos[i] = a[i];
            
        }
    }
    public void removeElement (Object obj){
        for (int i = 0; i < elementos.length; i++){
            if (elementos[i] == obj){
                for (int j = i; j <elementos.length; j++){
                    elementos[j] = elementos[j+1];
                    totalElem--;
                }
            }
        }
    }
    public void remove (ArrayList list){
        if (list == null){
            throw new NullPointerException("parametro nulo");
        }
        for (int i = 0; i < list.tamanho(); i++){
            Object obj = list.pega(i);
            for (int j =0; j< list.tamanho(); j++){
                if (obj.equals(elementos[j])){
                    removePosicao(j);
                    j++;
                }
            }
        }
    }
}

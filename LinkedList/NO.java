/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasligadas;

/**
 *
 * @author Banze
 */
public class NO {
    private NO proximo;
    private NO anterior;
    private Object elemento;

    public NO(NO proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public NO(NO proximo, NO anterior, Object elemento) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.elemento = elemento;
    }
    

    public NO(Object elemento) {
        this.elemento = elemento;
    }
    
    public void setProximo (NO proximo){
        this.proximo = proximo;
    }
    public NO getProximo (){
        return this.proximo;
    }
    public Object getElemento (){
        return elemento;
    }
    public NO getAnterior() {
        return anterior;
    }

    public void setAnterior(NO anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NO{" + "elemento=" + elemento + '}';
    }
    
}

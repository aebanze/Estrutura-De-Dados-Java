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
public interface InterfaceGeral {
    public abstract void adicionaInicio (Object elemento);
    public abstract void adicionaPosicao (int posicao, Object elemento);
    public abstract void adicionaFim (Object elemento);
    public abstract Object pega (int posicao);
    public abstract void removeInicio ();
    public abstract void removePosicao (int posicao);
    public abstract void removeFim ();
    public abstract boolean contem (Object elemento);
    public abstract int tamanho ();
}

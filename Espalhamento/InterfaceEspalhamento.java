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
public interface InterfaceEspalhamento {
    public abstract void adiciona(String palavra) ;
    public abstract void adiciona(Vocabulo vocabulo);
    public abstract void removeVocabulo(String palavra);
    public abstract void removeVocabulo(Vocabulo vocabulo);
    public abstract void atribuiSignificado (String palavra, String significado);
    public abstract boolean contem(String palavra);
    public abstract Vocabulo pegaVocabulo(String palavra);
    public abstract String consultaSignificado(String palavra);
    public abstract int tamanho();
}

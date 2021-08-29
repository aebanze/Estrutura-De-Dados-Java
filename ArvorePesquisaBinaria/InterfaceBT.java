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
public interface InterfaceBT {
    public abstract void inserir (Comparable <Object> info);
    public abstract void listInOrder();
    public abstract void listPreorder();
    public abstract void listPosOrder();
    public abstract boolean existe(Comparable <Object> info); 

}

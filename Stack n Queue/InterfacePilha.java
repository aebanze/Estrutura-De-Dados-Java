/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilasPilhas;

/**
 *
 * @author Banze
 */
public interface InterfacePilha {
    public abstract void push (Object element);
    public abstract void pop ();
    public abstract Object peek();
    public abstract Object peekAndPop ();
    public abstract boolean isEmpty ();
    public abstract int size ();
}

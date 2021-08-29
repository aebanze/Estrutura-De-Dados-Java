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
public interface InterfaceFila {
    public abstract void enqueue (Object element);
    public abstract void dequeue ();
    public abstract Object peek ();
    public abstract Object peekAndDequeue ();
    public boolean isEmpty ();
    public abstract int size ();
}

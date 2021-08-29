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
public class BSTree implements InterfaceBT{
    
    private No raiz;
    
    @Override
    public void inserir (Comparable <Object> info){
        if (info == null){
            throw new IllegalArgumentException ("Parametro nao pode ser nulo");
        }
        if (this.raiz == null){
            raiz = new No(info);
        } else {
            insert(this.raiz, info);
        }
    }

    private void insert (No raiz, Comparable<Object> info){
        if (info.compareTo(raiz.getInfo()) <= 0){
            if (raiz.getEsquerda() == null){
                raiz.setEsquerda(new No(info));
            } else {
                insert(raiz.getEsquerda(), info);
            }
        } else {
            if (raiz.getDireita() == null){
                raiz.setDireita(new No (info));
            } else {
                insert(raiz.getDireita(), info);
            }
        }
    }

    @Override
	public void listInOrder(){
        System.out.println("inOrder");
        inOrder(this.raiz);
        System.out.println();
    }

    private void inOrder(No info){
        if (raiz == null){
            return;
        }
        inOrder(info.getEsquerda());
        System.out.print(info.getInfo());
        inOrder(info.getDireita());
    }

    @Override
	public void listPreorder(){
        System.out.println("preOrder");
        preOrder(this.raiz);
        System.out.println();
    }

    private void preOrder (No info){
        if (info == null){
            return;
        }
        System.out.print(info.getInfo());
        preOrder(info.getEsquerda());
        preOrder(info.getDireita());
    }

    @Override
	public void listPosOrder(){
        System.out.println("postOrder");
        postOrder(this.raiz);
        System.out.println();
    }

    private void postOrder (No info){
        if (info == null){
            return;
        }
        postOrder(info.getEsquerda());
        postOrder(info.getDireita());
        System.out.print(info.getInfo());
    }

    @Override
	public boolean existe(Comparable <Object> info){
        if (info == null){
            throw new IllegalArgumentException("Parametro nao pode ser nulo");
        }
        return contem(this.raiz, info);
    }

    private boolean contem (No actual, Comparable<Object> info){
        if(actual.getInfo().compareTo(info) == 0){
            return true;
        }
        if (info.compareTo(this.raiz.getInfo()) <= 0 ){
            return false || contem(actual.getEsquerda(), info);
        } else {
            return false || contem(actual.getDireita(), info);
        }
    }
}

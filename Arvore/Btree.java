/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 *
 * @author Banze
 * @param <TIPO>
 */
public class Btrue <TIPO extends Comparable> {
    private Elemento <TIPO> raiz;
    
    public Btrue (){
        this.raiz = raiz;
    }
    
    public void adiciona (TIPO info){
        if (info == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
        
        Elemento <TIPO> novo = new Elemento <>(info);
        if (raiz == null){
            this.raiz = novo;
        } else {
            Elemento<TIPO> actual = this.raiz;
            while (true){
                if (novo.getInfo().compareTo(actual.getInfo()) == -1){
                    if (actual.getEsquerda() != null){
                        actual = actual.getEsquerda();
                    } else {
                        actual.setEsquerda(novo);
                        return;
                    }
                } if ( novo.getInfo().compareTo (actual.getInfo()) == 1){
                    if (actual.getDireita() != null){
                        actual = actual.getDireita();
                    } else {
                        actual.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }
    public void inOrder (){
        if (this.raiz != null){
            System.out.println("inOrder");
            printInOrder(this.raiz);
            System.out.println();
        }
    }
    private void printInOrder (Elemento<TIPO> info){
        if (info != null){
            printInOrder(info.getEsquerda());
            System.out.print("    "+info.getInfo());
            printInOrder(info.getDireita());
        }
    }
    
    public void preOrder (){
        if (this.raiz != null){
            System.out.println("preOrder");
            printPreOrder(this.raiz);
            System.out.println();
        }
    }
    private void printPreOrder (Elemento<TIPO> info){
        if (info != null){
            System.out.print("    "+info.getInfo());
            printPreOrder(info.getEsquerda());
            printPreOrder(info.getDireita());
        }
    }
    
    public void postOrder (){
        if (this.raiz != null){
            System.out.println("postOrder");
            printPostOrder(this.raiz);
            System.out.println();
        }
    }
    private void printPostOrder (Elemento <TIPO> info){
        if (info != null){
            printPostOrder(info.getEsquerda());
            printPostOrder(info.getDireita());
            System.out.print("    "+info.getInfo());
        }
    }
    public int folhas(){
        return contaFolhas(this.raiz);
    }
    private int contaFolhas (Elemento <TIPO> info){
        if (info == null){
            return 0;
        }
        if (info.getEsquerda() == null && info.getDireita() == null){
            return 1;
        }
        return contaFolhas(info.getDireita()) + contaFolhas(info.getEsquerda());
    }
}

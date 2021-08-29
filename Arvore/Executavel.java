/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 *
 * @author Banze
 */
public class Executavel {
    public static void main(String[] args) {
        Btrue <Integer> arvore = new Btrue <>();
        
        arvore.adiciona(5);
        arvore.adiciona(16);
        arvore.adiciona(81);
        arvore.adiciona(3);
        arvore.adiciona(2);
        arvore.adiciona(7);
        arvore.adiciona(12);
        arvore.adiciona(4);
        arvore.adiciona(11);
        arvore.adiciona(87);
        arvore.adiciona(9);
        arvore.adiciona(10);
        arvore.adiciona(21);
        arvore.adiciona(6);
        arvore.inOrder();
        arvore.preOrder();
        arvore.postOrder();
        System.out.println (arvore.folhas());
    }
}

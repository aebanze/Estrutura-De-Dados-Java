/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilasPilhas;

import listasligadas.ListaLigada2;
import listasligadas.Lists.ArrayList;

/**
 *
 * @author Banze
 */
public class Executavel {
    public static void main(String[] args){
        Fila f = new Fila ();
        Pilha p = new Pilha ();
        Pilha list = new Pilha ();
        //ArrayList lista = new ArrayList();
        ListaLigada2 lista = new ListaLigada2 ();
        //filas
        /*f.enqueue("Angel");
        f.enqueue(256);
        f.enqueue(65.5f);
        f.enqueue('D');
        f.list.show();
        System.out.println(f.peekAndDequeue());
        f.list.show();
        //pilhas
        list.push("Angel");
        list.push(256);
        list.list.show();*/
        p.push("Banze");
        p.push(1998);
        p.push(22.6f);
        p.push('E');
        p.list.show();
        System.out.println(p.peekAndPop());
        p.list.show();
        p.push(list);
        p.list.show();
        lista.adicionaInicio(1);
        lista.adicionaInicio(5);
        lista.adicionaFim(3);
        System.out.println(f.isEmpty());
        f.enqueue(3);
        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(4);
        f.list.show();
        p.push(f);
        p.list.show();
        /*f.dequeue(lista);
        f.list.show();
        System.out.println(f.isEmpty());*/
        
    }
}

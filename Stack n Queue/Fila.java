/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilasPilhas;

import Espalhamento.Dicionario;
import listasligadas.ListaLigada2;
import listasligadas.Lists.ArrayList;

/**
 *
 * @author Banze
 */
public class Fila implements InterfaceFila{

    //FIFO = first in, first out
    ListaLigada2 list = new ListaLigada2 ();
    @Override
    public void enqueue(Object element) {
        //inserir um elemento na fila
        list.adicionaFim(element);
    }

    @Override
    public Fila clone() throws CloneNotSupportedException{
        Fila aux = new Fila();
        Fila nova = new Fila();
        
        while(!this.isEmpty()){
            aux.enqueue(this.peekAndDequeue());
        }
        while (!aux.isEmpty()){
            nova.enqueue(aux.peek());
            this.enqueue(nova.peekAndDequeue());
        }
        return nova;
    }
    @Override
    public void dequeue() {
        //remover elemento no inicio da fila
        if (!this.isEmpty()){
            list.removeInicio();
        } else {
            throw new NullPointerException ("Fila vazia");
        }
    }

    @Override
    public Object peek() {
        //retorna o elemento no inicio da fila;
        if (this.isEmpty()){
            throw new NullPointerException ("Fila vazia");
        }
        return this.list.pega(1);
    }

    @Override
    public Object peekAndDequeue() {
        //retorna e remove o elemento no inicio da fila
        if (this.isEmpty()){
            throw new NullPointerException ("Fila vazia");
        }
        Object pega = this.peek();
        this.dequeue();
        return pega;
    }

    @Override
    public boolean isEmpty() {
        //verifica se a fila esta  vazia ou nao
        return (this.size() == 0);
    }

    @Override
    public int size() {
        //retorna a quantidade de elementos na fila
        return this.list.tamanho();
    }
 
    //HW
    public void dequeue (ArrayList list){
        //remover os elementos da list na fila caso existam sem alterar a ordem da fila
        if (list == null){
            throw new NullPointerException ("Parametro nulo");
        }
        Fila temp = new Fila();
            while (!this.isEmpty()){
                if (list.contem(this.peek())){
                    this.dequeue();
                } else {
                    temp.enqueue(this.peekAndDequeue());
                }
            }
            
        while (!temp.isEmpty()){
            this.enqueue(temp.peekAndDequeue());
        }
    }
    public Pilha topilha (){
        //transformar a fila em pilha
        Pilha nova = new Pilha ();
        while (!this.isEmpty()){
            nova.push(this.peekAndDequeue());
        }
        return nova;
    }
    //Exercise
    public Fila inverte (Fila fila) {
        Pilha temp = new Pilha();
        Fila nova = new Fila();
        while (!fila.isEmpty()){
            temp.push(fila.peekAndDequeue());
        }
        while (!temp.isEmpty()){
            nova.enqueue(temp.peekAndPop());
        }
        return nova;
    }
    public void enqueue(Dicionario d) throws CloneNotSupportedException{
	// adiciona os vocabulos de d na estrutura
	for (int i = 0; i < 26; i++){
		list = d.pega(i);
		while (!list.eVazia()){
			this.enqueue(list.pega(0));
			list.removeInicio();
		}
	}

}
}

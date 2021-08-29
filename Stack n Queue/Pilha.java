/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilasPilhas;
import Espalhamento.Dicionario;
import Espalhamento.Vocabulo;
import listasligadas.ListaLigada2;
import listasligadas.Lists.ArrayList;
import listasligadas.NO;
/**
 *
 * @author Banze
 */
public class Pilha implements InterfacePilha{

    //LIFO= last in, first out
    ListaLigada2 list = new ListaLigada2();
    @Override
    public Pilha clone () throws CloneNotSupportedException{
        Pilha aux = new Pilha();
        Pilha nova = new Pilha();
        while (!this.isEmpty()){
            aux.push(this.peekAndPop());
        }
        while (!aux.isEmpty()){
            nova.push(aux.peek());
            this.push(aux.peekAndPop());
        }
        return nova;
    }
    @Override
    public void push(Object element) {
        //insere um elemento na pilha
        list.adicionaFim(element);
    }

    @Override
    public void pop() {
        //remove o elemento no topo da pilha
        if (this.isEmpty()){
            throw new NullPointerException ("Lista vazia");
        }
        list.removeFim();
    }

    @Override
    public Object peek() {
       //retorna o elemento que esta no topo da pilha
       if (this.isEmpty()){
           throw new NullPointerException ("Lista vazia");
       }
       return list.pega(list.tamanho());
    }

    @Override
    public Object peekAndPop() {
        //retorna e remove o elemento no topo da pilha
        Object pega = this.peek();
        this.pop();
        return pega;
    }

    @Override
    public boolean isEmpty() {
        //verifica se a pilha esta vazia ou nao
        return (this.size()==0);
    }

    @Override
    public int size() {
        //retorna o numero de elementos na pilha
        return this.list.tamanho();
    }
    
    //HW
    public void push (Pilha p) {
        //inserir os valores de p na pilha sem alterar a ordem do p
        Pilha temp = new Pilha ();
        while (!p.isEmpty()){
            temp.push(p.peekAndPop());
        }
        while (!temp.isEmpty()){
            this.push(temp.peekAndPop());
        }
    }
    //pratice
    
    public void push (ListaLigada2 lista){
        if (lista.tamanho() == 0){
            throw new NullPointerException ("Lista Vazia");
        }
        for (int i = 0; i < lista.tamanho(); i++){
            this.push(lista.pega(i+1));
        }
    }
    public void push (Fila f){
        if (f.size() == 0){
            throw new NullPointerException ("Fila Vazia");
        }
        while (!f.isEmpty()){
            this.push(f.peekAndDequeue());
        }
    }
    public void push (Pilha p[]){
        for (int i = 0; i < p.length; i++){
            if (!p[i].equals(null)){
            this.push(p[i]);
            }
        }   
    }
    public Fila copyElements (Fila f){
        //retornar uma fila de valores de f constantes da pilha
        Fila nova = new Fila ();
        while (!f.isEmpty()){
            if (list.contem(f.peek())){
                nova.enqueue(f.peekAndDequeue());
            } else {
                f.dequeue();
            }
        }
        return nova;
    }
    public boolean isSubGroup (Fila f){
        //return (this.copyElements(f).size() == f.size());
        //Outra opcao;
        Fila aux = f;
        Fila resultado = new Fila();
        while (!aux.isEmpty()){
            if (list.contem(aux.peek())){
                resultado.enqueue(aux.peekAndDequeue());
            }
        }
        return (resultado.size() == f.size());
    }
    
    public Pilha sum (Object vect [], Fila f){
        Pilha nova = new Pilha ();
        for (int i = 0; i < vect.length; i++){
            nova.push(vect[i]);
        }
        if (!f.isEmpty()){
            while (!f.isEmpty()){
                nova.push(f.peekAndDequeue());
            }
        } else {
            throw new NullPointerException ("Fila vazia");
        }
        return nova;
    }
    public Fila toFila (){
        Fila nova = new Fila ();
        while (!this.isEmpty()){
            nova.enqueue(this.peekAndPop());
        }
        return nova;
    }
    public void pop (Fila f){
        //remover elementos de f na pilha  sem alterar a ordem
        Pilha copia = new Pilha ();
        ArrayList list = new ArrayList ();
        while (!this.isEmpty()){
            copia.push(this.peekAndPop());
        }
        while (!f.isEmpty()){
            list.adicionaFim(f.peekAndDequeue());
        }
        while (!copia.isEmpty()){
            if (list.contem(copia.peek())){
                copia.pop();
            } else {
                this.push(copia.peekAndPop());
            }
        }
    }
    public boolean isSubset (Pilha p){
        //verificar se P é subconjunto da pilha
        ArrayList list = new ArrayList ();
        Pilha copia = new Pilha ();
        
        while (!p.isEmpty()){
            list.adicionaFim(p.peekAndPop());
        }
        while (!this.isEmpty()){
            if (list.contem(this.peek())){
                copia.push(this.peekAndPop());
            } else {
                this.pop();
            }
        }
        if (copia.size() == p.size()){
            return true;
        }
        return false;
    }
    public void adicionaFilaPilha (Fila fila, Pilha pilha){
        if (fila.isEmpty()){
            throw new NullPointerException ("Fila vazia");
        }
        Pilha nova = new Pilha();
        while(!fila.isEmpty()){
            nova.push(fila.peekAndDequeue());
        }
        while (!nova.isEmpty()){
            pilha.push(nova.peekAndPop());
        }
    }
    public void adicionaListaDuplamenteLigada (ListaLigada2 lista, Pilha pilha){
        for (int i = lista.tamanho(); i > 0; i--){
            pilha.push(lista.pega(i));
        }
    }
    public Dicionario toDicionario() throws CloneNotSupportedException{
        //Converte pilha para Dicionario
        Dicionario novo = new Dicionario();
        Pilha temp = (Pilha) this.clone();
        while(!temp.isEmpty()){
            novo.adiciona(((Vocabulo)temp.peekAndPop()));
        }
        return novo;
    }
    public void push ( Dicionario d) throws CloneNotSupportedException {
	// adiciona os vocábulos de d na estrutura
        for (int i = 0; i < 26; i++){
            this.push(d.pega(i));
	}
    }
    public boolean isSubset(Dicionario d) throws CloneNotSupportedException{
        Pilha temp = new Pilha();
        Pilha aux = new Pilha();
        if (d.tamanho() > this.size()){
            return false;
        } else {
            for (int i = 0; i < 26; i++){
                temp = d.pegaP(i);
                aux = this.clone();
                while (!aux.isEmpty()){
                    if (!aux.peek().equals(temp.peekAndPop())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}

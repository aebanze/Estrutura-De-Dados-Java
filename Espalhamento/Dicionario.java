/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espalhamento;

import FilasPilhas.Fila;
import FilasPilhas.Pilha;
import listasligadas.ListaLigada2;
import listasligadas.Lists.ArrayList;

/**
 *
 * @author Banze
 */
public class Dicionario implements InterfaceEspalhamento{

    private ListaLigada2 tabelaHash [] = new ListaLigada2 [26];
    
    public Dicionario (){
        for (int i = 0; i < 26; i++){
            ListaLigada2 lista = new ListaLigada2 ();
            tabelaHash[i] = lista;
        }
    }
    
    private int codigoHash (String palavra){
        return palavra.toLowerCase().charAt(0) % 26;
    }
    @Override
    public void adiciona(String palavra) {
        if (palavra.equals(null)){
            throw new NullPointerException ("parametro nulo");
        }
        this.adiciona (new Vocabulo(palavra));
    }

    @Override
    public void adiciona(Vocabulo vocabulo) {
        if (vocabulo == null){
            throw new NullPointerException ("parametro nulo");
        }
        String palavra = vocabulo.getPalavra();
        if (this.contem(palavra)){
            throw new IllegalArgumentException ("O vocabulo já existe");
        }
        int index = this.codigoHash(palavra);
        ((ListaLigada2)tabelaHash[index]).adicionaFim(vocabulo);        
    }

    @Override
    
    public void removeVocabulo(String palavra) {
         if (palavra == null){
            throw new NullPointerException ("parametro nulo");
        }
         int index = this.codigoHash(palavra);
         ListaLigada2 list = ((ListaLigada2)tabelaHash[index]);
         int tamanho = list.tamanho();
         for (int i = 0; i < tamanho; i++){
             if (((Vocabulo)list.pega(i)).getPalavra().equalsIgnoreCase(palavra)){
                 list.removePosicao(i);
                 return;
             }
         }
    }
    @Override
    public void removeVocabulo(Vocabulo vocabulo){
        if (vocabulo == null){
            throw new NullPointerException ("parametro nulo");
        }
        String palavra = vocabulo.getPalavra();
        this.removeVocabulo(palavra);
    }
    @Override
    public void atribuiSignificado(String palavra, String significado) {
        if (palavra == null || significado == null){
            throw new NullPointerException ("parametro nulo");
        }
        this.pegaVocabulo(palavra).setSignificado(significado);
    }

    @Override
    public boolean contem(String palavra) {
        if (palavra == null){
            throw new NullPointerException ("Parametro nulo");
        }
        int index = this.codigoHash(palavra);
        ListaLigada2 list = ((ListaLigada2)tabelaHash[index]);
        for (int i = 0; i < list.tamanho(); i++){
            if (((Vocabulo)list.pega(i)).getPalavra().equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String consultaSignificado(String palavra) {
        return this.pegaVocabulo(palavra).getSignificado();
    }

    @Override
    public int tamanho() {
        int total = 0;
        for (int i = 0; i < tabelaHash.length; i++){
            total += tabelaHash[i].tamanho();
        }
        return total;
    }

    @Override
    public Vocabulo pegaVocabulo(String palavra) {
        int index = this.codigoHash(palavra);
        ListaLigada2 list = ((ListaLigada2)tabelaHash[index]);
        for (int i = 0; i < list.tamanho(); i++){
            if (((Vocabulo)list.pega(i)).getPalavra().equalsIgnoreCase(palavra)){
                String significado = ((Vocabulo)list.pega(i)).getSignificado();
                Vocabulo novo = new Vocabulo (palavra, significado);
                return novo;
            }
            
        }
        return null;
    }
    
    //Exercise
    public boolean eSubDicionario (Dicionario d){
        ListaLigada2 tabela [] = new ListaLigada2 [26];
        tabela = d.tabelaHash;
        ListaLigada2 list = new ListaLigada2();
        for (int i = 0; i < tabela.length; i++){
            list = tabela[i];
            while (!list.eVazia()){
                if (!this.contem(((Vocabulo)list.pega(0)).getPalavra())){
                    return false;
                }
                list.removeInicio();
            }
        }
        return true;
     }
    public void adiciona(Fila f) throws CloneNotSupportedException{
        // adiciona f ao dicionario
        Fila temp;
        temp = ((Fila) f.clone());
        while (!temp.isEmpty()){
            this.adiciona((Vocabulo)temp.peekAndDequeue());
        }
    } 
        
    public ListaLigada2 paraLista(){
        //transforma dicionario em lista ligada
        ListaLigada2 list = new ListaLigada2 ();
        for (int i = tabelaHash.length; i > 0; i--){
            list.adicionaInicio(tabelaHash[i]);
        }
        return list;
    }
    public void adiciona(ArrayList a){
        // adiciona a ao dicionario
        for (int i = 0; i < a.tamanho(); i++){
            this.adiciona(((Vocabulo)a.pega(i)));
        }
    }
    public void adiciona(Pilha p) throws CloneNotSupportedException{
        // adiciona p ao dicionario
        Pilha temp = (Pilha) p.clone(); 
        while (!temp.isEmpty()){
            this.adiciona(((Vocabulo)temp.peekAndPop()));
        }
    }
    public ListaLigada2 pega (int index) throws CloneNotSupportedException{
	//devolve uma lista ligada contendo o vocabulo da posicao index da tabelaHash
	ListaLigada2 list = ((ListaLigada2)tabelaHash[index]).clone();
	return list;
  }
    public Pilha pegaP(int pos) throws CloneNotSupportedException{
	// devolve uma pilha contendo os vocabulos da posicao pos da tableHash
	Pilha p = new Pilha();
	ListaLigada2 list = ((ListaLigada2)tabelaHash[pos].clone());
	while (!list.eVazia()){
		p.push(list.pega(0));
		list.removeInicio();
	}
	return p;
}
}

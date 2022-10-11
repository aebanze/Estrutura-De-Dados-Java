package Arraylist;

public class ArrayList {
	private Object elementos [];
    private int totalElem;

    //construtor sem parametro
    public ArrayList (){
        this.elementos = new Object[10];
        this.totalElem = 0;
    }
    
    //construtor que recebe um tamanho para inicialização da estrutura ArrayList
    public ArrayList (int tamanho){
        this.elementos = new Object [tamanho];
        this.totalElem = 0;
    }
    
    //Metodo que verifica se array de objecto dado está vazio ou não
    public boolean eVazia (Object a[]){
        int cont = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] != null){
                cont++;
            }
        }
        if (cont == 0){
            return true;
        }
        return false;
    }
    
    //Metodo que verifica se a posição inserida pelo usuário esta dentro dos parametros ou não
    public boolean posicaoValida (int posicao){
        if (posicao >= 0 && posicao < totalElem){
            return true;
        }
        return false;
    }
    
    //Metodo que aumenta a capacidade da nossa estrutura (ArrayList) caso ela esteja cheia
    public void garanteEspaco (){
        if (totalElem == elementos.length){
            Object elemento2[] = new Object [2 * elementos.length];
            for (int i = 0; i <= elementos.length; i++){
            elemento2[i] = elementos[i];
            elementos = elemento2;
            }
        }
    }
     
    //Metodo que adiciona o elemento dado no início da estrutura, ou seja, na posição zero
    public void adicionaInicio (Object elemento){
        if (elemento == null){
            throw new IllegalArgumentException ("Parametro nulo");
        }
        this.garanteEspaco();
        for (int i = totalElem; i > 0; i--){
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = elemento;
        totalElem++;
    }
    
    //Metodo que adiciona o elemento dado à uma posição dada pelo usuário
    public void adicionaPosicao (int posicao, Object elemento){
        if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
        if (elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
        this.garanteEspaco();
        for (int i = totalElem; i >= (posicao -1); i--){
            elementos[i] = elementos[i-1];
        }
        elementos[posicao - 1] = elemento;
        totalElem++;
    }
    
    //Metodo que adiciona um elemento no final da estrutura, ou seja na ultima posição válida
    public void adicionaFim (Object elemento){
        if (elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
            elementos[totalElem] = elemento;
            totalElem++;
    }
    
    //Esse metodo retorna o elemento na posição desejada
    public Object pega (int posicao){
        if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
        return elementos[posicao];
    }
    
    //Esse metodo remove o primeiro elemento da estrutura (posição [0])
    public void removeInicio () {
    	if(totalElem == 0) {
    		throw new NullPointerException("Estrutura Vazia");
    	}
	    for(int i = 0; i < totalElem; i++){
	        elementos[i] = elementos[i+1];
	    }
	    totalElem--;
    }
    
    //Esse metodo elimina o elemento na posição desejada
    public void removePosicao (int posicao){
        if (!posicaoValida(posicao)){
            throw new IndexOutOfBoundsException("posição fora dos parâmetros");
        }
        for (int i = (posicao-1); i < totalElem; i++){
             elementos [i] = elementos[i+1];
        }
        totalElem--;
    }
    
    //Metodo que remove o elemento na ultima posição válida da estrutura
    public void removeFim(){
        totalElem--;
    }
    
    // Metodo que retorna true caso um dado elemento esteja contido na estrutura e false caso não
    public boolean contem (Object elemento){
        if(elemento == null){
            throw new IllegalArgumentException ("parametro nulo");
        }
        for (int i = 0; i < elementos.length; i++){
            if (elementos[i] == elemento){
                return true;
            }
        }
        return false;
    }
    public int tamanho(){
        return totalElem;
    
    }
    //Homework
    
    public void adicionaInicio (Object a[]){
        if(eVazia(a)){
            throw new  NullPointerException ("Parametro nulo");
        }
        this.garanteEspaco();
        int cont = 0;
        while (a[cont] != null){
            cont++;
        }
        for (int i = totalElem -1; i > 0; i--){
            elementos[i + cont] = elementos[i];
            totalElem++;
        }
        for(int i = 0; i < totalElem; i++ ){
            elementos[i] = a[i];
            
        }
    }
    public void removeElement (Object obj){
        for (int i = 0; i < elementos.length; i++){
            if (elementos[i] == obj){
                for (int j = i; j <elementos.length; j++){
                    elementos[j] = elementos[j+1];
                    totalElem--;
                }
            }
        }
    }
    public void remove (ArrayList list){
        if (list == null){
            throw new NullPointerException("parametro nulo");
        }
        for (int i = 0; i < list.tamanho(); i++){
            Object obj = list.pega(i);
            for (int j =0; j< list.tamanho(); j++){
                if (obj.equals(elementos[j])){
                    removePosicao(j);
                    j++;
                }
            }
        }
    }
}

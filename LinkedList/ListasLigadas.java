/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasligadas;

/**
 *
 * @author Banze
 */
public class ListasLigadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Object aa, ab, ac, ad, ae, af;
        aa = "Angel";
        ab = 2021;
        ac = 'A';
        ad = 5879.65f;
        ae = "Banze";
        af = "B";
        ListaLigada2 l1 = new ListaLigada2();
        //ListaLigada l1 = new ListaLigada();
        l1.adicionaInicio(aa);
        l1.show();
        l1.adicionaFim(ae);
        l1.show();
        l1.adicionaInicio(ab);
        l1.adicionaFim(af);
        l1.show();
        l1.adicionaFim(ad);
        l1.show();
        l1.removeFim();
        //l1.removePosicao(3);
        l1.adicionaPosicao(2, ac);
        l1.show();
        l1.removePosicao(2);
        l1.show();
        System.out.println(l1.contem(ad));
        System.out.println(l1.pega(1));
    }
    
}

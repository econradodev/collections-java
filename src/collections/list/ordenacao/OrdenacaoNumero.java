package collections.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumero implements Comparable<Integer> {

    @Override
    public int compareTo(Integer i) {
        return 0;
    }

    private List<Integer> numeros;

    public OrdenacaoNumero() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public void imprimir () {
        System.out.println("Os números da lista são: " + this.numeros);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosCrescente = new ArrayList<>(this.numeros);

        if (!numeros.isEmpty()) {
            Collections.sort(numerosCrescente);
            return numerosCrescente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDecrescente = new ArrayList<>(this.numeros);
        if (!numeros.isEmpty()) {
            numerosDecrescente.sort(Collections.reverseOrder());
            return numerosDecrescente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumero ordenacaoNumero = new OrdenacaoNumero();

        ordenacaoNumero.adicionarNumero(3);
        ordenacaoNumero.adicionarNumero(8);
        ordenacaoNumero.adicionarNumero(5);

        ordenacaoNumero.imprimir();

        System.out.println("A ordem crescente é:" + ordenacaoNumero.ordenarAscendente());
        System.out.println("A ordem decrescente é:" + ordenacaoNumero.ordenarDescendente());

    }
}


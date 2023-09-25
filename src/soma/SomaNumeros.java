package soma;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int num) {
        this.numeros.add(num);
    }

    public int calcularSoma() {

        int soma = 0;

        for (Integer num : numeros) {
            soma += num;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;

        for (Integer num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        System.out.println("Maior numero: " + maior);
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;

        for (Integer num : numeros) {
            if (num < menor) {
                menor = num;
            }
        }
        System.out.println("Menor numero: " + menor);
        return menor;
    }

    public void exibirNumeros () {
        if (!numeros.isEmpty()) {
            System.out.println(this.numeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {

        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(4);
        somaNumeros.adicionarNumero(27);
        somaNumeros.adicionarNumero(8);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(9);

        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        somaNumeros.encontrarMaiorNumero();
        somaNumeros.encontrarMenorNumero();


    }



}



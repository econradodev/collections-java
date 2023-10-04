package collections.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotal = 0d;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produtoAtual : estoqueProdutosMap.values()) {
                valorTotal += produtoAtual.getQuantidade() * produtoAtual.getPreco();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for (Produto produtoAtual : estoqueProdutosMap.values()) {
            if (produtoAtual.getPreco() > maiorPreco) {
                produtoMaisCaro = produtoAtual;
                maiorPreco = produtoAtual.getPreco();
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto produtoAtual : estoqueProdutosMap.values()) {
            if (produtoAtual.getPreco() < menorPreco) {
                produtoMaisBarato = produtoAtual;
                menorPreco = produtoAtual.getPreco();
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidade = null;
        double maiorQuantidade = Double.MIN_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto produtoAtual : estoqueProdutosMap.values()) {
                if ((produtoAtual.getPreco() * produtoAtual.getQuantidade()) > maiorQuantidade) {
                    produtoMaiorQuantidade = produtoAtual;
                    maiorQuantidade = produtoAtual.getQuantidade() * produtoAtual.getPreco();
                }
            }
        }
        return produtoMaiorQuantidade;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Notebook", 3, 1500.0);
        estoqueProdutos.adicionarProduto(2L, "Mouse", 5, 75.0);
        estoqueProdutos.adicionarProduto(3L, "Monitor", 4, 800.0);
        estoqueProdutos.adicionarProduto(4L, "Teclado", 2, 48.0);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoqueProdutos.calcularValorTotalEstoque());

        Produto produtoMaisCaro = estoqueProdutos.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        Produto produtoMaisBarato = estoqueProdutos.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        Produto produtoMaiorQuantidadeValorTotal = estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);

    }
}

package mercado;

import tarefas.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add (item);
    }

    public void removerItem (String nome) {
        List<Item> itemParaRemover = new ArrayList<>();

        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemParaRemover.add(i);
                }
            }
            itemList.removeAll(itemParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double total = 0d;

        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                total += valorItem;
            }
            return total;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens () {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }


    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Leite", 2.75, 3);
        carrinhoDeCompras.adicionarItem("Arroz", 3.50, 2);
        carrinhoDeCompras.adicionarItem("Ovos", 14.50, 1);
        carrinhoDeCompras.adicionarItem("Feijão", 8.00, 1);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Feijão");

        carrinhoDeCompras.exibirItens();

        System.out.println("O valor total da compra é: R$ " + carrinhoDeCompras.calcularValorTotal());
    }

}

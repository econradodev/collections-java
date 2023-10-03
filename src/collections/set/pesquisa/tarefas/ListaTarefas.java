package collections.set.pesquisa.tarefas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        for (Tarefa tarefaAtual : tarefaSet) {
            if (tarefaAtual.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaSet.remove(tarefaAtual);
                break;
            }
        }
    }

    public void exibirTarefas() {
        if (!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("O Set está vazio!");
        }
    }

    public void contarTarefas() {
        System.out.println("Existem " + tarefaSet.size() + " tarefas no Set");
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefaAtual : tarefaSet) {
            if (tarefaAtual.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaAtual.setConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {

        Tarefa tarefaParaMarcarComoPendente = null;

        for (Tarefa tarefaAtual : tarefaSet) {
            if (tarefaAtual.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarComoPendente = tarefaAtual;
            }
        }

        if (tarefaParaMarcarComoPendente != null) {
            if (tarefaParaMarcarComoPendente.isConcluida()) {
                tarefaParaMarcarComoPendente.setConcluida(false);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa tarefaAtual : tarefaSet) {
            if (tarefaAtual.isConcluida()) {
                tarefasConcluidas.add(tarefaAtual);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa tarefaAtual : tarefaSet) {
            if (!tarefaAtual.isConcluida()) {
                tarefasPendentes.add(tarefaAtual);
            }
        }
        return tarefasPendentes;
    }

    public void limparListaTarefas() {
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Lavar carro");
        listaTarefas.adicionarTarefa("Limpar casa");
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");


        listaTarefas.contarTarefas();

        listaTarefas.removerTarefa("Limpar casa");
        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");
        listaTarefas.marcarTarefaConcluida("Lavar carro");

        System.out.println(listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}

package com.projeto.crud;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    private List<Pessoa> pessoas;
    private int contadorId;

    public PessoaRepository() {
        pessoas = new ArrayList<>();
        contadorId = 1; // Inicia com id 1 para as pessoas
    }

    // Criar (Inserir)
    public Pessoa criarPessoa(String nome, int idade) {
        Pessoa novaPessoa = new Pessoa(contadorId++, nome, idade);
        pessoas.add(novaPessoa);
        return novaPessoa;
    }

    // Ler (Listar)
    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

    // Atualizar (PUT)
    public boolean atualizarPessoa(int id, String nome, int idade) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                pessoa.setNome(nome);
                pessoa.setIdade(idade);
                return true;
            }
        }
        return false; // Pessoa não encontrada
    }

    // Deletar (DELETE)
    public boolean deletarPessoa(int id) {
        return pessoas.removeIf(pessoa -> pessoa.getId() == id);
    }
}

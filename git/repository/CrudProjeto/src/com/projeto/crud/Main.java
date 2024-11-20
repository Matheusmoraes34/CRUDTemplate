package com.projeto.crud;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaRepository repository = new PessoaRepository();
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Atualizar Pessoa");
            System.out.println("4 - Deletar Pessoa");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: // Criar
                    System.out.println("Digite o nome da pessoa:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade da pessoa:");
                    int idade = scanner.nextInt();
                    repository.criarPessoa(nome, idade);
                    System.out.println("Pessoa criada com sucesso!");
                    break;

                case 2: // Listar
                    List<Pessoa> pessoas = repository.listarPessoas();
                    for (Pessoa pessoa : pessoas) {
                        System.out.println(pessoa);
                    }
                    break;

                case 3: // Atualizar
                    System.out.println("Digite o ID da pessoa para atualizar:");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite a nova idade:");
                    int novaIdade = scanner.nextInt();
                    boolean atualizado = repository.atualizarPessoa(idAtualizar, novoNome, novaIdade);
                    if (atualizado) {
                        System.out.println("Pessoa atualizada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 4: // Deletar
                    System.out.println("Digite o ID da pessoa para deletar:");
                    int idDeletar = scanner.nextInt();
                    boolean deletado = repository.deletarPessoa(idDeletar);
                    if (deletado) {
                        System.out.println("Pessoa deletada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 5: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

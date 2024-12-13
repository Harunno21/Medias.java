package ProjetoAlunos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal para gerenciar o sistema de alunos.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    do {
                        cadastrarAluno(scanner, alunos);
                        System.out.print("Deseja cadastrar mais um aluno? (S/N): ");
                    } while (scanner.nextLine().equalsIgnoreCase("S"));
                    break;
                case 2:
                    exibirTabelaDeAlunos(alunos);
                    break;
                case 3:
                    calcularMediaDaTurma(alunos);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    /**
     * Exibe o menu principal do programa.
     */
    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Exibir Informações de Alunos (Tabela)");
        System.out.println("3. Calcular Média da Turma");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Cadastra um novo aluno no sistema.
     *
     * @param scanner Scanner para entrada de dados.
     * @param alunos Lista de alunos cadastrados.
     */
    private static void cadastrarAluno(Scanner scanner, ArrayList<Aluno> alunos) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite a turma do aluno: ");
        String turma = scanner.nextLine();

        Aluno aluno = new Aluno(nome, matricula, turma);

        double[] notas = new double[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        aluno.calcularMedia(notas);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    /**
     * Exibe uma tabela com as informações dos alunos cadastrados.
     *
     * @param alunos Lista de alunos cadastrados.
     */
    private static void exibirTabelaDeAlunos(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n----------------------------------------------");
            System.out.println("| Nome          | Matrícula  | Média | Status |");
            System.out.println("----------------------------------------------");
            for (Aluno a : alunos) {
                String status = a.verificarAprovacao() ? "Aprovado" : "Reprovado";
                System.out.printf("| %-13s | %-10s | %-5.2f | %-7s |%n", a.getNome(), a.getMatricula(), a.getMedia(), status);
            }
            System.out.println("----------------------------------------------");
        }
    }

    /**
     * Calcula e exibe a média da turma.
     *
     * @param alunos Lista de alunos cadastrados.
     */
    private static void calcularMediaDaTurma(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado para calcular a média da turma.");
        } else {
            double somaMedias = 0;
            for (Aluno a : alunos) {
                somaMedias += a.getMedia();
            }
            double mediaTurma = somaMedias / alunos.size();
            System.out.printf("Média da turma: %.2f%n", mediaTurma);
        }
    }
}

package ProjetoAlunos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Classe que representa um aluno, contendo suas informações pessoais e métodos
 * para cálculo de médias e verificação de aprovação.
 */
public class Aluno {

    private String nome;
    private String matricula;
    private String turma;
    private double media;

    /**
     * Construtor da classe Aluno.
     *
     * @param nome Nome do aluno.
     * @param matricula Matrícula do aluno.
     * @param turma Turma do aluno.
     */
    public Aluno(String nome, String matricula, String turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
    }

    /**
     * Obtém o nome do aluno.
     *
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a matrícula do aluno.
     *
     * @return A matrícula do aluno.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Obtém a turma do aluno.
     *
     * @return A turma do aluno.
     */
    public String getTurma() {
        return turma;
    }

    /**
     * Calcula a média aritmética de quatro notas.
     *
     * @param notas Array com quatro notas do aluno (entre 0 e 10).
     * @return A média aritmética das quatro notas.
     * @throws IllegalArgumentException Se alguma das notas estiver fora do intervalo 0 a 10.
     */
    public double calcularMedia(double[] notas) {
        if (notas.length != 4) {
            throw new IllegalArgumentException("Devem ser fornecidas exatamente 4 notas.");
        }

        double soma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Todas as notas devem estar entre 0 e 10.");
            }
            soma += nota;
        }
        this.media = soma / 4;
        return this.media;
    }

    /**
     * Verifica se o aluno foi aprovado com base na média mínima de 6.0.
     *
     * @return {@code true} se o aluno foi aprovado, {@code false} caso contrário.
     */
    public boolean verificarAprovacao() {
        return this.media >= 6.0;
    }

    /**
     * Obtém a média do aluno.
     *
     * @return A média calculada do aluno.
     */
    public double getMedia() {
        return this.media;
    }
}

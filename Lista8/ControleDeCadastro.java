package Programacao_2.Lista8;
import java.util.Scanner;

public class ControleDeCadastro {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();
        int resposta;
        System.out.println("Vamos começar o nosso cadastro de alunos.");
        do {
            exibeMenu();
            resposta = in.nextInt(); in.nextLine();
            switch(resposta) {
                case 1:
                    Aluno aluno = montaAluno();
                    cadastro.cadastraAluno(aluno);
                    break;
                case 2: cadastro.exibeAlunos(); break;
                case 3: cadastro.ordenaMatriculas(); break;
                case 4: cadastro.ordenarMedia(); break;
                case 5: cadastro.ordenarFaltas(); break;
                case 6:
                    System.out.print("Infome a matrícula a ser buscada: ");
                    String matricula = in.nextLine();
                    cadastro.procurarAluno(matricula);
                    break;
                case 0: System.out.println("Obrigado e até logo."); break;
                default: System.out.println("Opção inválida.");
            }
        }while (resposta != 0);
    }

    public static void exibeMenu() {
        String menu = "Opções\n" +
                        "1 - Cadastrar um aluno\n" +
                        "2 - Exibir dados de todos os alunos\n" +
                        "3 - Ordenar crescente por matricula\n" +
                        "4 - Ordenar decrescente por média\n" +
                        "5 - Ordenar crescente por faltas\n" +
                        "6 - Consultar um aluno\n" +
                        "0 - Sair do programa\n" +
                        "Informe a opção: ";
        System.out.print(menu);
    }

    public static Aluno montaAluno() {
        System.out.print("Informe.\nMatricula: ");
        String matricula = in.nextLine();
        Aluno aluno = new Aluno(matricula);
        System.out.print("Nome: ");
        String nome = in.nextLine();
        aluno.setNome(nome);
        System.out.print("Média: ");
        double media = in.nextDouble(); in.nextLine();
        aluno.setMedia(media);
        System.out.print("Faltas: ");
        int faltas = in.nextInt(); in.nextLine();
        aluno.setFaltas(faltas);
        return aluno;
    }


}

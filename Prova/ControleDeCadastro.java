import java.util.Scanner;

public class ControleDeCadastro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int resposta, estoque;
        double preco;
        String titulo, autor;
        CadastroLivros cadastro = new CadastroLivros();
        do{
            exibeMenu();
            resposta = in.nextInt(); in.nextLine();
            switch(resposta) {
                case 0: System.out.println("Obrigado e até mais!"); break;
                case 1:
                    System.out.print("Informe o título do livro: ");
                    titulo = in.nextLine();
                    Livro livro = new Livro(titulo);
                    System.out.print("Informe o nome do autor: ");
                    autor = in.nextLine();
                    livro.setAutor(autor);
                    System.out.print("Informe o valor do livro: ");
                    preco = in.nextDouble(); in.nextLine();
                    while(preco <= 0){
                        System.out.println("O valor dever ser maior que zero.");
                        System.out.print("Informe o valor do livro: ");
                        preco = in.nextDouble(); in.nextLine();
                    }
                    livro.setPreco(preco);
                    System.out.print("Informe a quantidade em estoque: ");
                    estoque = in.nextInt(); in.nextLine();
                    while(estoque < 0) {
                        System.out.println("A quantidade em estoque não pode ser menor que zero.");
                        System.out.print("Informe a quantidade em estoque: ");
                        estoque = in.nextInt(); in.nextLine();
                    }
                    livro.setEstoque(estoque);
                    cadastro.cadastrarLivro(livro);
                    break;
                case 2: cadastro.exibirLivros(); break;
                case 3:
                    System.out.print("Informe o titulo do livro a ser consultado: ");
                    titulo = in.nextLine();
                    cadastro.exibirLivro(titulo);
                    break;
                case 4:
                    System.out.print("Informe o título do livro a ser alterado: ");
                    titulo = in.nextLine();
                    cadastro.alterarDadosLivro(titulo);
                    break;
                case 5:
                    System.out.print("Informe o título do livro a ser removido: ");
                    titulo = in.nextLine();
                    cadastro.removerLivro(titulo);
                    break;
                default: System.out.println("Opção inválida."); break;
                    
            }
        }while(resposta != 0);
        in.close();
    }

    public static void exibeMenu() {
        String m = 
        "Informe uma das opções abaixo:" + " \n" +
        "1 - Cadastrar um Livro" + "\n" +
        "2 - Exibir todos os livros" + "\n" +
        "3 - Consultar um livro por titulo" + "\n" +
        "4 - Alterar preço unitário ou estoque de um livro" + "\n" +
        "5 - Remover um livro" + "\n" +
        "0 - Sair do programa" + "\n" + 
        "Opção: ";
        System.out.print(m);
    }
}
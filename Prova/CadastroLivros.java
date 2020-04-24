import java.util.Scanner;

public class CadastroLivros {
    private Livro[] vLivros;
    private int cont;

    public CadastroLivros() {
        vLivros = new Livro[100];
    }

    public CadastroLivros(int quantidadeLivros) {
        if(quantidadeLivros > 100 || quantidadeLivros < 0) {
            vLivros = new Livro[100];
        }
        else {
            vLivros = new Livro[quantidadeLivros];
        }
    }
    public void cadastrarLivro(Livro livro) {
        if(cont == vLivros.length){
            System.out.println("Sem espaço para cadastro.");
        }
        else {
            if(cont == 0) {
                vLivros[cont] = livro;
                System.out.println("Livro cadastrado com sucesso.");
                cont++;
            }
            else {
                if(vLivros[cont - 1].getTitulo().compareToIgnoreCase(livro.getTitulo()) < 0) {
                    vLivros[cont] = livro;
                    System.out.println("Livro cadastrado com sucesso.");
                    cont++;
                }
                else {
                    for(int i = 0; i < cont; i++) {
                        if(vLivros[i].getTitulo().compareToIgnoreCase(livro.getTitulo()) > 0) {
                            for(int index = cont; index > i; index--) {
                                vLivros[index] = vLivros[index - 1];
                            }
                            vLivros[i] = livro;
                            System.out.println("Livro cadastrado com sucesso.");
                            cont++;
                            break;
                        }
                        else if (vLivros[i].getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                            System.out.println("Livro já existe no cadastro.");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void exibirLivros() {
        if (cont == 0) {
            System.out.println("Não há livros a serem exibidos.");
        } else {
            for (int i = 0; i < cont; i++) {
                System.out.print(vLivros[i]);
            }
        }
    }

    private int buscar(String titulo) {
        int inicio = 0;
        int fim = cont - 1;
        int meio;
        int pos = -1;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (vLivros[meio].getTitulo().equalsIgnoreCase(titulo)) {
                pos = meio;
                break;
            }
            else if(vLivros[meio].getTitulo().compareToIgnoreCase(titulo) < 0) {
                inicio = meio + 1;
            }
            else {
                fim = meio - 1;
            }
        }
        return pos;
    }

    public void removerLivro(String titulo) {
        if(cont == 0) {
            System.out.println("Não há livros a serem removidos.");
        }
        else {
            int index = buscar(titulo);
            if(index == -1) {
                System.out.println("O livro não existe no cadastro.");
            }
            else {
                for(int i = index; i < cont - 1; i++) {
                    vLivros[i] = vLivros[i + 1];
                }
                vLivros[cont - 1] = null;
                System.out.println("Livro removido com sucesso.");
                cont--;
            }
        }
    }

    public void alterarDadosLivro(String titulo) {
        if(cont == 0) {
            System.out.println("Não a livros a serem alterados.");
        }
        else {
            int index = buscar(titulo);
            if(index == -1) {
                System.out.println("O livro não existe no cadastro.");
            }
            else {
                Scanner in = new Scanner(System.in);
                System.out.print("Deseja alterar o preço do livro (S - N)? ");
                char r = in.next().charAt(0); in.nextLine();
                r = Character.toUpperCase(r);
                while(r != 'S' && r != 'N') {
                    System.out.println("Resposta inválida.");
                    System.out.print("Deseja alterar o preço do livro (S - N): ");
                    r = in.next().charAt(0); in.nextLine();
                    r = Character.toUpperCase(r);
                }
                if(r == 'S') {
                    System.out.print("Informe o novo preço do livro: ");
                    double p = in.nextDouble(); in.nextLine();
                    while(p <= 0) {
                        System.out.println("O valor deve ser maior que zero.");
                        System.out.print("Informe o novo preço do livro: ");
                        p = in.nextDouble(); in.nextLine();
                    }
                    vLivros[index].setPreco(p);
                }
                System.out.print("Deseja alterar a quantidade em estoque (S - N)? ");
                r = in.next().charAt(0); in.nextLine();
                r = Character.toUpperCase(r);
                while(r != 'S' && r != 'N') {
                    System.out.println("Resposta inválida.");
                    System.out.print("Deseja alterar a quantidade em estoque (S - N)? ");
                    r = in.next().charAt(0); in.nextLine();
                    r = Character.toUpperCase(r);
                }
                if(r == 'S') {
                    System.out.print("Informe a nova quantidade em estoque: ");
                    int e = in.nextInt(); in.nextLine();
                    while(e < 0) {
                        System.out.println("O valor não pode ser menor que zero.");
                        System.out.print("Informe a nova quantidade em estoque: ");
                        e = in.nextInt(); in.nextLine();
                    }
                    vLivros[index].setEstoque(e);
                }
            }
        }
    }
    public void exibirLivro(String titulo) {
        if(cont == 0) {
            System.out.println("Não há livros a serem exibidos.");
        }
        else {
            int index = buscar(titulo);
            if(index == -1) {
                System.out.println("O livro não existe no cadastro.");
            }
            else {
                System.out.println(vLivros[index]);
            }
        }
    }
}
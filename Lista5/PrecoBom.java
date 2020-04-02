package Programacao_2.Lista5;
import java.util.Scanner;

public class PrecoBom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q, o, quantidade;
        String codigo;
        char r;
        System.out.println("Bem vindo ao sistema do mercado Preço Bom.");
        System.out.print("Informe a quantidade de produtos de sua loja: ");
        q = in.nextInt();
        while(q <= 0) {
            System.out.println("A quantidade de produtos deve ser maior que zero.");
            System.out.print("Informe a quantidade de produtos de sua loja: ");
            q = in.nextInt();
        }
        Loja l = new Loja(q);
        System.out.println("Perfeito, agora vamos ao menu.");
        do {
            System.out.println("Informe a opção desejada:" + "\n" + 
                                "1 - Cadastrar um novo produto" + "\n" +
                                "2 - Exibir produtos da loja" + "\n" +
                                "3 - Exibir produtos de um fornecedor" + "\n" +
                                "4 - Alterar preço de um produto" + "\n" +
                                "5 - Atualizar estoque de um produto" + "\n" +
                                "6 - Realizar venda de um produto" + "\n" + 
                                "0 - Encerrar" + "\n");
            o = in.nextInt(); in.nextLine();
            while(o < 0 || o > 6) {
                System.out.println("Opção inválida.");
                System.out.println("Informe a opção desejada:" + "\n" + 
                                    "1 - Cadastrar um novo produto" + "\n" +
                                    "2 - Exibir produtos da loja" + "\n" +
                                    "3 - Exibir produtos de um fornecedor" + "\n" +
                                    "4 - Alterar preço de um produto" + "\n" +
                                    "5 - Atualizar estoque de um produto" + "\n" +
                                    "6 - Realizar venda de um produto" + "\n" + 
                                    "0 - Encerrar" + "\n");
                o = in.nextInt(); in.nextLine();
            }
            switch(o) {
                case 1: do { 
                            if(l.getQuantidadeProdutos() < l.getTamanhoArray()) {
                                System.out.print("Informe o código do produto: ");
                                codigo = in.nextLine();
                                l.cadastrarProduto(codigo);
                                System.out.print("Deseja cadastra mais um produto? (S ou N) ");
                                r = in.next().charAt(0); in.nextLine();
                                r = Character.toUpperCase(r);
                                while(r != 'S' && r != 'N') {
                                    System.out.println("Resposta inválida.");
                                    System.out.print("Deseja cadastra mais um produto? (S ou N) ");
                                    r = in.next().charAt(0); in.nextLine();
                                    r = Character.toUpperCase(r);
                                }
                            }
                            else {
                                r = 'N';
                                System.out.println("Não é possível cadastrar mais produtos.");
                            }
                        }while(r == 'S' || l.getQuantidadeProdutos() < l.getTamanhoArray());
                        break;
                case 2: l.exibeProdutos(); break;
                case 3: System.out.print("Informe o nome do fornecedor: ");
                        String fornecedor = in.nextLine();
                        l.exibeProdutosFornecedor(fornecedor);
                        break;
                case 4: System.out.print("Informe o código do produto: ");
                        codigo = in.nextLine();
                        System.out.print("Informe o percentual a ser alterado: ");
                        double percentual = in.nextDouble();;
                        System.out.print("Infome o tipo de alteração (1 - almento / 2 - desconto): ");
                        char tipoAlteracao = in.next().charAt(0);
                        l.alteraPrecoProduto(codigo, percentual, tipoAlteracao);
                        break;
                case 5: System.out.print("Informe o código do produto: ");
                        codigo = in.nextLine();
                        System.out.print("Informe a quantidade a ser acrescentada ao estoque: ");
                        quantidade = in.nextInt();
                        l.atualizaEstoque(codigo, quantidade);
                        break;
                case 6: do {
                            System.out.print("Infome o código do produto que deseja comprar: ");
                            codigo = in.nextLine();
                            System.out.print("Informe a quantidade a ser comprada: ");
                            quantidade = in.nextInt();
                            l.realizaVenda(codigo, quantidade); 
                            System.out.print("Deseja fazer mais uma compra? (S ou N)");
                            r = in.next().charAt(0);
                            r = Character.toUpperCase(r);
                            while(r != 'S' && r != 'N') {
                                System.out.println("Resposta inválida.");
                                System.out.print("Deseja fazer mais uma compra? (S ou N)");
                                r = in.next().charAt(0);
                                r = Character.toUpperCase(r);
                            }
                        }while(r == 'S');
                        break;
                default: System.out.println("Obrigado e até logo!"); break;                        
            }
        }while(o != 0);
        in.close();
    }
}
package Programacao_2.Lista5;
import java.util.Scanner;

public class Loja {
    private Produto[] prods;
    private int qProds;
    Scanner in = new Scanner(System.in);   

    public int getQuantidadeProdutos() {
        return qProds;
    }
    public int getTamanhoArray() {
        return prods.length;
    }

    public Loja(int i) {
        prods = new Produto[i];
    }

    public void cadastrarProduto() { 
        if(qProds < prods.length){
            System.out.print("Informe o código do produto: ");
            String codigo = in.nextLine();
            int i = buscar(codigo);
            if(i == -1) {
                prods[qProds] = new Produto(codigo);
                System.out.print("Descrição do produto: ");
                String d = in.nextLine();
                prods[qProds].setDescricao(d);
                System.out.print("Fornecedor: ");
                String f = in.nextLine();
                prods[qProds].setFornecedor(f);
                System.out.print("Quantidade em estoque: ");
                int e = in.nextInt();
                while(e < 0) {
                    System.out.println("Valor para estoque inválido.");
                    System.out.print("Quantidade em estoque: ");
                    e = in.nextInt();
                }
                prods[qProds].setEstoque(e);
                System.out.print("Preço: ");
                double p = in.nextDouble();
                while(p <= 0) {
                    System.out.println("Valor do preço inválido.");
                    System.out.print("Preço: ");
                    p = in.nextDouble();
                }
                prods[qProds].setPreco(p);
                qProds++;
            }
            else {
                System.out.println("Código já existente para outro produto.");
            }
        }
        else {
            System.out.println("Não há espaço para mais produtos.");
        }
    }

    public void exibeProdutos() {
        if(qProds > 0){
            for(int i = 0; i < qProds; i++) {
                System.out.println(prods[i]);
            }
        }
        else {
            System.out.println("Não há produtos na loja.");
        }
    }

    public void exibeProdutosFornecedor(String fornecedor) {
        boolean f = true;
        for(int i = 0; i < qProds; i++) {
            if(prods[i].getFornecedor().equalsIgnoreCase(fornecedor)) {
                System.out.println(prods[i]);
                f = false;
            }
        }
        if(f) {
            System.out.println("Não há produtos deste fornecedor." + "\n");
        }
    }

    public void alteraPrecoProduto(String codigo, double percentual, char tipoAlteracao) {
        int i = buscar(codigo);
        if(i == -1) {
            System.out.println("Produto não cadastrado." + "\n");
        }
        else {
            double p = prods[i].getPreco();
            if(percentual <= 0) {
                System.out.println("Percental deve ser maior que zero." + "\n");
            }
            else {
                if(tipoAlteracao != '1' && tipoAlteracao != '2') {
                    System.out.println("Tipo de alteração inválida." + "\n");
                }
                else if(tipoAlteracao == '1'){
                    p *= (1 + (percentual/100));
                }
                else if(percentual < 100){
                    p *= (1 - (percentual/100));
                }
                else {
                    System.out.println("O desconto não pode ser maior ou igual a 100%" + "\n");
                }
            }
            prods[i].setPreco(p);
        }
    }

    private int buscar(String c) {
        int v = -1;
        for(int i = 0; i < qProds; i++) {
            if(prods[i].getCodigo().equalsIgnoreCase(c)) {
                v = i;
                break;
            }
        }
        return v;
    }

    public void atualizaEstoque(String codigo, int quantidade) {
        
        if(quantidade > 0) {
            int i = buscar(codigo);
            if(i == -1) {
                System.out.println("Produto não cadastrado." + "\n");
            }
            else {
                int e = prods[i].getEstoque();
                prods[i].setEstoque(e + quantidade);
            }
        }
        else {
            System.out.println("A quantidade a ser acrencentada deve ser maior que zero." + "\n");
        }
    }

    public void realizaVenda(String codigo, int quantidade) {
        double p = 0;
        int i = buscar(codigo);
        if(quantidade > 0) {
            if(i == -1) {
                System.out.println("Produto não cadastrado." + "\n");
            }
            else {
                if(quantidade <= prods[i].getEstoque()) {
                    p = prods[i].getPreco() * quantidade;
                    int e = prods[i].getEstoque();
                    prods[i].setEstoque(e - quantidade);
                    System.out.println("A total a pagar é: R$" + p + "\n");
                }
                else {
                    System.out.println("Não há esta quantidade em estoque." + "\n");
                }
                i = qProds;
            }
        }
        else {
            System.out.println("A quantidade deve ser maior que zero." + "\n");
        }
    }
}
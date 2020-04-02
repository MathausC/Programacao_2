package Programacao_2.Lista5;
import java.util.Scanner;

public class Loja {
    private Produto[] prods;
    private int qProds;

    public int getQuantidadeProdutos() {
        return qProds;
    }
    public int getTamanhoArray() {
        return prods.length;
    }

    public Loja(int i) {
        prods = new Produto[i];
    }

    public void cadastrarProduto(String codigo) {
        Scanner in = new Scanner(System.in);
        boolean nCadas = !verifCodExiste(codigo);
        if(qProds < prods.length){
            if(nCadas) {
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
            if(prods[i].getFornecedor().equals(fornecedor)) {
                System.out.println(prods[i]);
                f = false;
            }
        }
        if(f) {
            System.out.println("Não há produtos deste fornecedor.");
        }
    }

    public void alteraPrecoProduto(String codigo, double percentual, char tipoAlteracao) {
        for(int i = 0; i < qProds; i++) {
            if(prods[i].getCodigo().equals(codigo)) {
                double p = prods[i].getPreco();
                if(percentual <= 0) {
                    System.out.println("Percental deve ser maior que zero.");
                }
                else {
                    if(tipoAlteracao != '1' && tipoAlteracao != '2') {
                        System.out.println("Tipo de alteração inválida.");
                    }
                    else if(tipoAlteracao == '1'){
                        p *= (1 + (percentual/100));
                    }
                    else if(percentual < 100){
                        p *= (1 - (percentual/100));
                    }
                    else {
                        System.out.println("O desconto não pode ser maior ou igual a 100%");
                    }
                }
                prods[i].setPreco(p);
                i = qProds;
            }
        }
        if(!verifCodExiste(codigo)){
            System.out.println("Código do produto não existe.");
        }
    }

    private boolean verifCodExiste(String c) {
        boolean v = false;
        for(int i = 0; i < qProds; i++) {
            if(prods[i].getCodigo().equals(c)) {
                v = true;
                i = qProds;
            }
        }
        return v;
    }

    public void atualizaEstoque(String codigo, int quantidade) {
        if(quantidade > 0) {
            for(int i = 0; i < qProds; i++) {
                if(prods[i].getCodigo().equals(codigo)) {
                    int e = prods[i].getEstoque();
                    prods[i].setEstoque(e + quantidade);
                    i = qProds;
                }
            }
            if(!verifCodExiste(codigo)){
                System.out.println("Código não existe.");
            }
        }
        else {
            System.out.println("A quantidade a ser acrencentada deve ser maior que zero.");
        }
    }

    public void realizaVenda(String codigo, int quantidade) {
        double p = 0;
        if(quantidade > 0) {
            for(int i = 0; i < qProds; i++) {
                if(prods[i].getCodigo().equals(codigo)) {
                    if(quantidade <= prods[i].getEstoque()) {
                        p = prods[i].getPreco() * quantidade;
                        int e = prods[i].getEstoque();
                        prods[i].setEstoque(e - quantidade);
                        System.out.println("A total a pagar é: R$" + p);
                    }
                    else {
                        System.out.println("Não há esta quantidade em estoque.");
                    }
                    i = qProds;
                }
            }
            if(!verifCodExiste(codigo)) {
                System.out.println("Código não existente.");
            }
        }
        else {
            System.out.println("A quantidade deve ser maior que zero.");
        }
    }
}
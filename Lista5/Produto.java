package Programacao_2.Lista5;

public class Produto {
    private String codi;
    private String desc;
    private String fornec;
    private int estoq;
    private double preco;

    public String getCodigo() {
        return codi;
    }
    public void setCodigo(String c) {
        codi = c;
    }

    public String getDescricao() {
        return desc;
    }
    public void setDescricao(String d) {
        desc = d;
    }

    public String getFornecedor() {
        return fornec;
    }
    public void setFornecedor(String f) {
        fornec = f;
    }

    public int getEstoque() {
        return estoq;
    }
    public void setEstoque(int e) {
        estoq = e;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double p) {
        preco = p;
    }

    public Produto(String codigo) {
        setCodigo(codigo);
    }

    public String toString() {
        String m;
        m = "Código: " + getCodigo() + "\n" +
            "Descrição: " + getDescricao() + "\n" +
            "Fornecedor: " + getFornecedor() + "\n" +
            "Estoque: " + getEstoque() + "\n" +
            "Preço: " + getPreco() + "\n";
        return m;
    }
}
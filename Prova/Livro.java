
public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int qEstoque;

    public String getTitulo() {
        return this.titulo;
    }
    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return this.qEstoque;
    }
    public void setEstoque(int estoque) {
        this.qEstoque = estoque;
    }

    public Livro(String titulo) {
        this.setTitulo(titulo);
    }

    public String toString() {
        String m;
        m = "Titulo: " + getTitulo() +"\n" +
            "Autor: " + getAutor() + "\n" +
            "Preço: " + getPreco() + "\n" +
            "Quantidade em estoque: " + getEstoque() + "\n";
        return m;
    }
}
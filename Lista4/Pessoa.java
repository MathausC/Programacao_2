package Programacao_2.Lista4;

public class Pessoa {
    private String nome;
    private int idade;
    private char genero;
    private double peso;
    private double altura;
    private double pesoIdeal;

    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    private void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }
    private void setGenero(char genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }
    private void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }
    private void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPesoIdeal() {
        return pesoIdeal;
    }
    private void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public Pessoa() {
        setNome("anonimo");
        setIdade(0);
        setAltura(0);
        setPeso(0);
        setPesoIdeal(calcularPesoIdeal(altura, genero));
    }

    public Pessoa(String nome, int idade, char genero, double peso, double altura) {
        setNome(nome);
        if(idade < 0 && idade > 150) {
            setIdade(0);
        }
        else{
            setIdade(idade);
        }
        genero = Character.toUpperCase(genero);
        if(genero != 'M' && genero != 'F') {
            setGenero('M');
        }
        else {
            setGenero(genero);
        }
        if(peso <= 0 || peso > 300) {
            setPeso(0);
        }
        else {
            setPeso(peso);
        }
        if(altura <= 0 || altura > 3) {
            setAltura(0);
        }
        else {
            setAltura(altura);
        }
        setPesoIdeal(calcularPesoIdeal(altura, genero));
    }

    private double calcularPesoIdeal(double altura, char genero) {
        double pesoIdeal;
        if(genero == 'M') {
            pesoIdeal = (72.7 * altura) - 58;
        }
        else {
            pesoIdeal = (62.1 * altura) - 44.7;
        }
        return pesoIdeal;
    }
}
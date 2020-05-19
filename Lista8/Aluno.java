package Programacao_2.Lista8;

public class Aluno implements Comparable<Aluno> {
    private String matricula;
    private String nome;
    private double media;
    private int faltas;

    public String getMatricula() {
        return this.matricula;
    }
    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return this.media;
    }
    public void setMedia(double media) {
        this.media = media;
    }

    public int getFaltas() {
        return this.faltas;
    }
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Aluno(String matricula) {
        this.setMatricula(matricula);
    }

    public int compareTo(Aluno aluno) {
        return  this.getMatricula().compareToIgnoreCase(aluno.getMatricula());
    }

    public String toString() {
        String texto = "Matricula: " + this.getMatricula() + "\n" +
                        "Aluno: " + this.getNome() + "\n" +
                        "Média: " + this.getMedia() + "\n" +
                        "Faltas: " + this.getFaltas() + "\n";
        return texto;
    }
}

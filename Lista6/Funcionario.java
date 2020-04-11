public class Funcionario {
    private String matricula;
    private String nome;
    private double salario;
    private int anoContrat;

    public String getMatricula() {
        return matricula;
    }
    private void setMatricula(String m) {
        matricula = m;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String n) {
        nome = n;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double s) {
        salario = s;
    }

    public int getAnoContratacao() {
        return anoContrat;
    }
    public void setAnoContrato(int a) {
        anoContrat = a;
    }

    public Funcionario(String matricula) {
        setMatricula(matricula);
    }

    public String toString() {
        String m;
        m = "Matrícula: " + getMatricula() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Salario: " + getSalario() + "\n" +
            "Ano de contratação: " + getAnoContratacao() + "\n";
        return m;
    }
}
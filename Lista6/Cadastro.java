public class Cadastro {
    private Funcionario[] vetF;
    private int contF;
    
    public Cadastro (int tamanho) {
        if(tamanho < 1) {
            System.out.println("A quantidade deve ser maior que zero (0).");
        }
        else if(tamanho > 1000) {
            vetF = new Funcionario[1000];
        }
        else {
            vetF = new Funcionario[tamanho];
        }
    }
    public void adimitirFuncionarios(Funcionario funcionario) {        
        if(contF == vetF.length) {
            System.out.println("Não é possível cadastrar mais funcionários" + "\n");
        }
        else if(contF == 0) {
            vetF[contF] = funcionario;
            System.out.println("Funcionario cadastrado." + "\n");
            contF++;
        }
        else if(vetF[contF-1].getMatricula().compareTo(funcionario.getMatricula()) < 0){
            vetF[contF] = funcionario;
            contF++;
            System.out.println("Funcionario cadastrado." + "\n"); 
        }
        else {
            for(int i = 0; i < contF; i++) {
                if(vetF[i].getMatricula().compareTo(funcionario.getMatricula()) > 0){
                    for(int index = contF; index > i; index--){
                        vetF[index] = vetF[index - 1];
                    }
                    vetF[i] = funcionario;
                    System.out.println("Funcionario cadastrado." + "\n");
                    contF++;
                    break;
                }
                if(vetF[i].getMatricula().compareTo(funcionario.getMatricula()) == 0) {
                    System.out.println("Matrícula já existente." + "\n");
                    break;
                }
            }
        }
    }
    public void exibeFuncionarios() {
        for(int i = 0; i < contF; i++) {
            System.out.println(vetF[i]);
        }
    }
    private int buscar (String chave) {
        int fim = contF - 1;
        int inicio = 0;
        int meio;
        int posicao = -1;
        while(inicio <= fim) {

            meio = ((fim + inicio)/2);
            if(chave.compareTo(vetF[meio].getMatricula()) == 0) {
                posicao =  meio;
            }
            if(chave.compareTo(vetF[meio].getMatricula()) < 0){
                fim = meio - 1;
            }
            else {
                inicio = meio + 1;
            }
        }
        return posicao;
    }
    public void almentaSalario(String matricula, double percentual) {
        if(percentual <= 0){
            System.out.println("O percentual deve ser maior que zero." + "\n");
        }
        else {            
            int index = buscar(matricula);
            if(index != -1) {
                double salario = vetF[index].getSalario();
                salario *= (1 + (percentual/100));
                vetF[index].setSalario(salario);
                System.out.println("Almento efetuado." + "\n");
            }
            else {
                System.out.println("Matrícula inexistente." + "\n");
            }
        }
    }
    public void buscarFuncionario(String matricula) {
        int index = buscar(matricula);
        if(index != -1) {
            System.out.println(vetF[index]);
        }
        else {
            System.out.println("Matrícula inexistente" + "\n");
        }
    }
    public void demitir(String matricula) {
        int index = buscar(matricula);
        if(index != -1) {
            for(int i = index; i < contF; i++) {
                vetF[i] = vetF[i + 1];
            }
            System.out.println("Funcionário removido." + "\n");
            contF--;
        }
        else {
            System.out.println("Matrícula inexistente." + "\n");
        }
    }
}
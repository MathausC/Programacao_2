package Programacao_2.Lista8;

public class CadastroAlunos {
    private Aluno[] alunos = new Aluno[60];
    private int cont;
    private boolean flag = false;

    public void cadastraAluno(Aluno aluno) {
        String mensagem;
        if(cont == 0) {
            alunos[cont] = aluno;
            cont++;
            flag = false;
            mensagem = "Aluno cadastrado.";
        }
        else {
            if(buscarAluno(aluno.getMatricula()) == -1) {
                alunos[cont] = aluno;
                cont++;
                flag = false;
                mensagem = "Aluno cadastrado.";
            }
            else {
                mensagem ="Matricula já existente.";
            }
        }
        System.out.println(mensagem);
    }

    private int buscaAlunoSequencial(String matricula) {
        int pos = -1;
        for(int i = 0; i < cont; i++) {
            if(alunos[i].getMatricula().equalsIgnoreCase(matricula)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public void exibeAlunos() {
        if(cont != 0) {
            for(int i = 0; i < cont; i++) {
                System.out.println(alunos[i]);
            }
        }
        else {
            System.out.println("Não há alunos cadastrados a serem exibidos.");
        }
    }

    public void ordenaMatriculas() {
        int i, j;
        Aluno chave;
        int fim = cont - 1;
        for(i = 1; i <= fim; i++) {
            chave = alunos[i];
            j = i - 1;
            while(j >= 0 && alunos[j].compareTo(chave) > 0) {
                alunos[j+1] = alunos[j];
                j--;
            }
            alunos[j+1] = chave;
        }
        flag = true;
        System.out.println("Ordenado por matricula.");
    }

    public void ordenarMedia() {
        int i;
        int pos = 0;
        int fim = cont -1;
        Aluno aux;
        boolean trocou;
        do{
            trocou = false;
            for(i = 0; i < fim; i++) {
                if(alunos[i].getMedia() < alunos[i+1].getMedia()) {
                    aux = alunos[i];
                    alunos[i] = alunos[i+1];
                    alunos[i+1] = aux;
                    trocou =  true;
                    pos = i;
                }
            }
            fim = pos;
        }while(trocou);
        flag = false;
        System.out.println("Ordenado por médias.");
    }

    public void ordenarFaltas() {
        int i, j, menor;
        int fim = cont - 1;
        Aluno aux;
        for(i = 0; i <= fim; i++) {
            menor = i;
            for (j = i+1; j <= fim; j++) {
                if (alunos[j].getFaltas() < alunos[menor].getFaltas()) {
                    menor = j;
                }
            }
            aux = alunos[i];
            alunos[i] = alunos[menor];
            alunos[menor] = aux;
        }
        flag = false;
        System.out.println("Ordenado por faltas.");
    }

    private int buscarAluno(String matricula) {
        int pos;
        if(flag) {
            pos = buscaBinaria(matricula);
        }
        else {
            pos = buscaAlunoSequencial(matricula);
        }
        return pos;
    }

    private int buscaBinaria(String matricula) {
        int pos = -1;
        int inicio = 0;
        int fim = cont -1;
        int meio = (inicio + fim)/2;
        while(inicio <= fim) {
            if(alunos[meio].getMatricula().equalsIgnoreCase(matricula)) {
                pos = meio;
                break;
            }
            else if(alunos[meio].getMatricula().compareToIgnoreCase(matricula) > 0){
                fim = meio - 1;
            }
            else {
                inicio = meio + 1;
            }
        }
        return pos;
    }

    public void procurarAluno(String matricula) {
        if(cont > 0){
            int pos = buscarAluno(matricula);
            String mensagem;
            if(pos != -1) {
                mensagem = alunos[pos].toString();
            }
            else {
                mensagem = "Matrícula não existente.";
            }
            System.out.println(mensagem);
        }
        else {
            System.out.println("Não a alunos a serem buscados.");
        }
    }
}

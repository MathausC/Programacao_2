import java.util.Scanner;

public class Aplicacao {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("z".compareTo("a"));
        System.out.println("a".compareTo("z"));
        System.out.println(9/2);
        char r;
        String m;
        System.out.print("Informe a quantidade de funcionarios: ");
        int q = in.nextInt(); in.nextLine();
        Cadastro c = new Cadastro(q);
        System.out.println("Perfeito.");
        do{
            exibeMenu();
            q = in.nextInt(); in.nextLine();
            switch(q) {
                case 0: System.out.println("Adeus."); break;
                case 1:
                    do {
                        c.adimitirFuncionarios(criaFuncionário());
                        System.out.println("deseja admitir mais um funcionário? S - N");
                        r = in.next().charAt(0); in.nextLine();
                        Character.toUpperCase(r);
                        while(r != 'S' && r != 'N') {
                            System.out.println("Resposta inválida.");
                            System.out.println("deseja admitir mais um funcionário? S - N");
                            r = in.next().charAt(0); in.nextLine();
                            Character.toUpperCase(r);
                        }
                    }while(r == 'S');
                    break;
                case 2: c.exibeFuncionarios(); break;
                case 3: 
                    System.out.print("Informe a matrícula: ");
                    m = in.nextLine();
                    System.out.print("Informe o percentual a ser almentado: ");
                    double p = in.nextDouble(); in.nextLine();
                    c.almentaSalario(m, p);
                    break;
                case 4: 
                    System.out.print("Informe matricula do funcionário: ");
                    m = in.nextLine();
                    c.buscarFuncionario(m);
                    break;
                case 5:
                    System.out.print("Infome a matrícula do funcionário: ");
                    m = in.nextLine();
                    c.demitir(m);
                    break;
                default: System.out.println("Opção inválida."); break;                
            }
        }while(q != 0);
        
    }
    
    public static void exibeMenu() {
        String m = "Informe uma das opções." + "\n" +
                    "1 - admitir funcionário" + "\n"+
                    "2 - exibir funcionarios" + "\n" +
                    "3 - Almentar salário de um funcionário" + "\n" +
                    "4 - Buscar funcionário" + "\n" +
                    "5 - Demitir funcionário" + "\n" + 
                    "0 - Encerrar" + "\n";
        System.out.println(m);
    }

    public static Funcionario criaFuncionário() {
        System.out.print("Informe a matricula do funcionário: ");
        String m = in.nextLine();
        Funcionario f = new Funcionario(m);
        System.out.print("Infomre o nome do funcionário: ");
        String nome = in.nextLine();
        f.setNome(nome);
        System.out.print("Informe o salário do funcionário: ");
        double s = in.nextDouble(); in.nextLine();
        while(s <= 0) {
            System.out.println("O salário deve ser menor que zero (0).");
            System.out.print("Informe o salário do funcionário: ");
            s = in.nextDouble(); in.nextLine();
        }
        f.setSalario(s);
        System.out.print("Informe o ano de contratação: ");
        int a = in.nextInt(); in.nextLine();
        while(a < 1970) {
            System.out.println("O ano de contratação não pode ser menor que 1970.");
            System.out.print("Informe o ano de contratação: ");
            a = in.nextInt(); in.nextLine();
        }
        f.setAnoContrato(a);
        return f;
    }
}
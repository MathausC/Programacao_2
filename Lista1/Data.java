package Programacao_2.Lista1;

public class Data {
        private int dia, mes, ano;

        private int getDia() {
                return this.dia;
        }

        private void setDia(int dia) {
                this.dia = dia;
        }

        private int getMes() {
                return this.mes;
        }

        private void setMes(int mes) {
                this.mes = mes;
        }

        private int getAno() {
                return this.ano;
        }

        private void setAno(int ano) {
                this.ano = ano;
        }

        public Data() {
                setDia(1);
                setMes(1);
                setAno(1);
        }

        public Data(int dia, int mes, int ano) {
                if (ano > 0 && (mes > 0 && mes <= 12) && (dia > 0 && dia <= 31)) {
                        boolean bix = ano % 4 == 0;
                        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                                if (dia <= 30) {
                                        setDia(dia);
                                        setMes(mes);
                                        setAno(ano);
                                } else {
                                        setDia(1);
                                        setMes(1);
                                        setAno(1);
                                }
                        } else if (mes == 2) {
                                if (bix) {
                                        if (dia <= 29) {
                                                setDia(dia);
                                                setMes(mes);
                                                setAno(ano);
                                        } else {
                                                setDia(1);
                                                setMes(1);
                                                setAno(1);
                                        }
                                } else {
                                        if (dia <= 28) {
                                                setDia(dia);
                                                setMes(mes);
                                                setAno(ano);
                                        } else {
                                                setDia(1);
                                                setMes(1);
                                                setAno(1);
                                        }
                                }
                        } else {
                                setDia(dia);
                                setMes(mes);
                                setAno(ano);
                        }
                } else {
                        setDia(1);
                        setMes(1);
                        setAno(1);
                }
        }

        public void exibeData() {
                if (ano < 10) {
                        System.out.println(this.getDia() + "/" + this.getMes() + "/000" + this.getAno());
                } else if (ano < 100) {
                        System.out.println(this.getDia() + "/" + this.getMes() + "/00" + this.getAno());
                } else if (ano < 1000) {
                        System.out.println(this.getDia() + "/" + this.getMes() + "/0" + this.getAno());
                } else {
                        System.out.println(this.getDia() + "/" + this.getMes() + "/" + this.getAno());
                }

        }

        public void exibeDataEstenco() {
                String mes;
                switch (this.getMes()) {
                        case 1:
                                mes = "janeiro";
                                break;
                        case 2:
                                mes = "fevereiro";
                                break;
                        case 3:
                                mes = "março";
                                break;
                        case 4:
                                mes = "abril";
                                break;
                        case 5:
                                mes = "maio";
                                break;
                        case 6:
                                mes = "junho";
                                break;
                        case 7:
                                mes = "julho";
                                break;
                        case 8:
                                mes = "agosto";
                                break;
                        case 9:
                                mes = "setembro";
                                break;
                        case 10:
                                mes = "outubro";
                                break;
                        case 11:
                                mes = "novembro";
                                break;
                        case 12:
                                mes = "dezembro";
                                break;
                        default:
                                mes = "mes inválido";
                                break;
                }

                if (ano < 10) {
                        System.out.println(this.getDia() + " de " + mes + " de 000" + this.getAno());
                } else if (ano < 100) {
                        System.out.println(this.getDia() + " de " + mes + " de 00" + this.getAno());
                } else if (ano < 1000) {
                        System.out.println(this.getDia() + " de " + mes + " de 0" + this.getAno());
                } else {
                        System.out.println(this.getDia() + " de " + mes + " de " + this.getAno());
                }
        }

        private int converteDataParaDias(Data data) {
                int dias;
                dias = converteAnosParaDias(data.getAno())
                                + converteMesParaDias(data.getMes(), data.getAno()) + data.getDia();
                return dias;
        }

        private int converteAnosParaDias(int anos) {
                int dias = (anos * 365) + ((anos - (anos % 4)) / 4);
                return dias;
        }

        private int converteMesParaDias(int mes, int ano) {
                int dias = 0;
                for (int m = 1; m < mes; m++) {
                        dias += quantidadeDiasMes(m, ano);
                }
                return dias;
        }

        public int quantidadeDiasMes(int mes, int ano) {
                int dias;
                boolean bix = ano % 4 == 0;
                switch (mes) {
                        case 1:
                                dias = 31;
                                break;
                        case 2:
                                dias = 28;
                                break;
                        case 3:
                                dias = 31;
                                break;
                        case 4:
                                dias = 30;
                                break;
                        case 5:
                                dias = 31;
                                break;
                        case 6:
                                dias = 30;
                                break;
                        case 7:
                                dias = 31;
                                break;
                        case 8:
                                dias = 31;
                                break;
                        case 9:
                                dias = 30;
                                break;
                        case 10:
                                dias = 31;
                                break;
                        case 11:
                                dias = 30;
                                break;
                        case 12:
                                dias = 31;
                                break;
                        default:
                                dias = 0;
                                break;
                }
                if (mes == 2 && bix) {
                        dias++;
                }
                return dias;
        }

        public void adicionarDias(int dias) {
                int novoMes = getMes();
                int novoAno = getAno();
                int novoDia = getDia();
                while (dias > 0) {
                        novoDia++;
                        if (novoDia > quantidadeDiasMes(novoMes, novoAno)) {
                                novoMes++;
                                novoDia = 1;
                        }
                        if (novoMes > 12) {
                                novoAno++;
                                novoMes = 1;
                        }
                        dias--;
                }
                setDia(novoDia);
                setMes(novoMes);
                setAno(novoAno);
        }

        public void compararDatas(Data data) {
                int diferencaDias;
                int dias = converteDataParaDias(data);
                int diasObj = converteDataParaDias(this);
                diferencaDias = dias - diasObj;
                if (diferencaDias < 0) {
                        diferencaDias = diferencaDias * (-1);
                }
                System.out.println("A diferença entre as datas em dias é " + diferencaDias + " dias");
        }
}
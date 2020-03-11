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
                dias = converteAnosParaDias(data.getAno()) + converteMesParaDias(data.getMes(), data.getAno())
                                + data.getDia();
                return dias;
        }

        private int converteAnosParaDias(int anos) {
                int dias = (anos * 365) + ((anos - (anos % 4)) / 4);
                return dias;
        }

        private int converteDiasParaMes(int dias, int ano) {
                int mes;
                boolean bix = ano % 4 == 0;
                if (dias <= 31) {
                        mes = 1;
                } else if (bix) {
                        if (dias <= 60) {
                                mes = 2;
                        } else if (dias <= 91) {
                                mes = 3;
                        } else if (dias <= 121) {
                                mes = 4;
                        } else if (dias <= 152) {
                                mes = 5;
                        } else if (dias <= 182) {
                                mes = 6;
                        } else if (dias <= 213) {
                                mes = 7;
                        } else if (dias <= 244) {
                                mes = 8;
                        } else if (dias <= 274) {
                                mes = 9;
                        } else if (dias <= 305) {
                                mes = 10;
                        } else if (dias <= 335) {
                                mes = 11;
                        } else {
                                mes = 12;
                        }
                } else {
                        if (dias <= 59) {
                                mes = 2;
                        } else if (dias <= 90) {
                                mes = 3;
                        } else if (dias <= 120) {
                                mes = 4;
                        } else if (dias <= 151) {
                                mes = 5;
                        } else if (dias <= 181) {
                                mes = 6;
                        } else if (dias <= 212) {
                                mes = 7;
                        } else if (dias <= 243) {
                                mes = 8;
                        } else if (dias <= 273) {
                                mes = 9;
                        } else if (dias <= 304) {
                                mes = 10;
                        } else if (dias <= 334) {
                                mes = 11;
                        } else {
                                mes = 12;
                        }
                }
                return mes;
        }

        private int converteMesParaDias(int mes, int ano) {
                boolean bix = ano % 4 == 0;
                int dias;
                if (bix) {
                        switch (mes) {
                                case 2:
                                        dias = 31;
                                        break;
                                case 3:
                                        dias = 60;
                                        break;
                                case 4:
                                        dias = 91;
                                        break;
                                case 5:
                                        dias = 121;
                                        break;
                                case 6:
                                        dias = 152;
                                        break;
                                case 7:
                                        dias = 182;
                                        break;
                                case 8:
                                        dias = 213;
                                        break;
                                case 9:
                                        dias = 244;
                                        break;
                                case 10:
                                        dias = 274;
                                        break;
                                case 11:
                                        dias = 305;
                                        break;
                                case 12:
                                        dias = 335;
                                        break;
                                default:
                                        dias = 0;
                                        break;
                        }
                } else {
                        switch (mes) {
                                case 2:
                                        dias = 31;
                                        break;
                                case 3:
                                        dias = 59;
                                        break;
                                case 4:
                                        dias = 90;
                                        break;
                                case 5:
                                        dias = 120;
                                        break;
                                case 6:
                                        dias = 151;
                                        break;
                                case 7:
                                        dias = 181;
                                        break;
                                case 8:
                                        dias = 212;
                                        break;
                                case 9:
                                        dias = 243;
                                        break;
                                case 10:
                                        dias = 273;
                                        break;
                                case 11:
                                        dias = 304;
                                        break;
                                case 12:
                                        dias = 334;
                                        break;
                                default:
                                        dias = 0;
                                        break;
                        }

                }
                return dias;
        }

        private int converteDiasParaAnos(int dias) {
                int anos = (dias - (dias / 1460)) / 365;
                return anos;
        }

        public void adicionarDias(int dias) {
                int somaDias;
                int novoAno;
                int novoMes;
                int novoDia;
                somaDias = converteDataParaDias(this) + dias;
                novoAno = converteDiasParaAnos(somaDias);
                novoMes = converteDiasParaMes((somaDias - converteAnosParaDias(novoAno)), novoAno);
                novoDia = somaDias - converteMesParaDias(novoMes, novoAno) - converteAnosParaDias(novoAno);
                setAno(novoAno);
                setMes(novoMes);
                if(novoDia == 0) {
                        setDia(novoDia + 1);
                }
                else {
                        setDia(novoDia);
                }
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
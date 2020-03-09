package com.CC;

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

    private int getAno(){
        return this.ano;
    }
    private void setAno(int ano) {
        this.ano = ano;
    }

    public Data(){
        setDia(1);
        setMes(1);
        setAno(1);
    }

    public Data(int dia, int mes, int ano) {
        if(ano > 0 && (mes > 0 && mes <= 12) && (dia > 0 && dia <= 31)) {
            boolean bix = ano % 4 == 0;
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if(dia <= 30){
                    setDia(dia);
                    setMes(mes);
                    setAno(ano);
                }
                else {
                    setDia(1);
                    setMes(1);
                    setAno(1);
                }
            }
            else if(mes == 2) {
                if(bix) {
                    if(dia <= 29) {
                        setDia(dia);
                        setMes(mes);
                        setAno(ano);
                    }
                    else {
                        setDia(1);
                        setMes(1);
                        setAno(1);
                    }
                }
                else {
                    if(dia <= 28) {
                        setDia(dia);
                        setMes(mes);
                        setAno(ano);
                    }
                    else {
                        setDia(1);
                        setMes(1);
                        setAno(1);
                    }
                }
            }
            else {
                setDia(dia);
                setMes(mes);
                setAno(ano);
            }
        }
        else {
            setDia(1);
            setMes(1);
            setAno(1);
        }
    }

    public void exibeData() {
        if(ano < 10) {
            System.out.println(this.getDia() + "/" + this.getMes() + "/000" + this.getAno());
        }
        else if(ano < 100) {
            System.out.println(this.getDia() + "/" + this.getMes() + "/00" + this.getAno());
        }
        else if(ano < 1000) {
            System.out.println(this.getDia() + "/" + this.getMes() + "/0" + this.getAno());
        }
        else {
            System.out.println(this.getDia() + "/" + this.getMes() + "/" + this.getAno());
        }
        
    }

    public void exibeDataEstenco() {
        String mes;
        switch (this.getMes()) {
            case 1: mes = "janeiro";   
                    break;
            case 2: mes = "fevereiro";
                    break;
            case 3: mes = "março";
                    break;
            case 4: mes = "abril";
                    break;
            case 5: mes = "maio";
                    break;
            case 6: mes = "junho";
                    break;
            case 7: mes = "julho";
                    break;
            case 8: mes = "agosto";
                    break;
            case 9: mes = "setembro";
                    break;
            case 10: mes = "outubro";
                    break;
            case 11: mes = "novembro";
                    break;
            case 12: mes = "dezembro";
                    break;
            default: mes = "mes inválido";
                    break;
        }

        if(ano < 10){
            System.out.println(this.getDia() + " de " + mes + " de 000" + this.getAno());
        }
        else if(ano < 100) {
            System.out.println(this.getDia() + " de " + mes + " de 00" + this.getAno());
        }
        else if(ano < 1000) {
            System.out.println(this.getDia() + " de " + mes + " de 0" + this.getAno());
        }
        else {
            System.out.println(this.getDia() + " de " + mes + " de " + this.getAno());
        }        
    }

    public void adicionarDias(int dias) {
        int novoDia = this.getDia() + dias;
        if(this.getMes() == 2){
            if(this.getAno() % 4 == 0) {
                if(novoDia <= 29){
                    this.setDia(novoDia);
                }
                else {
                    System.out.println("não foi possível adicionar essa quantidade de dias.");
                }
            }
            else {
                if(novoDia <= 28){
                    this.setDia(novoDia);
                }
                else {
                    System.out.println("não foi possível adicionar essa quantidade de dias.");
                }
            }
        }
        else if(this.getMes() == 4 || this.getMes() == 6 || this.getMes() == 9 || this.getMes() == 11) {
            if(novoDia <= 30){
                this.setDia(novoDia);
            }
            else {
                System.out.println("não foi possível adicionar essa quantidade de dias.");
            }
        }
        else {
            if(novoDia <= 31) {
                this.setDia(novoDia);
            }
            else {
                System.out.println("não foi possível adicionar essa quantidade de dias.");
            }
        }

    }

    public void compararDatas(Data data) {
        int diferencaDias;
        int anosBissextos = (data.getAno() - (data.getAno() % 4)) / 4;
        int anosBissextosObj = (this.getAno() - (this.getAno() % 4)) / 4;
        int dias = (data.getAno()* 365) + anosBissextos;
        int diasObj = (this.getAno() * 365) + anosBissextosObj;

        if(ano % 4 == 0) {
            switch (data.getMes()) {
                case 1: dias += data.getDia();
                        break;
                case 2: dias = dias + data.getDia() + 31;
                        break;
                case 3: dias = dias + data.getDia() + 60;
                        break;
                case 4: dias = dias + data.getDia() + 91;
                        break;
                case 5: dias = dias + data.getDia() + 121;
                        break;
                case 6: dias = dias + data.getDia() + 152;
                        break;
                case 7: dias = dias + data.getDia() + 182;
                        break;
                case 8: dias = dias + data.getDia() + 213;
                        break;
                case 9: dias = dias + data.getDia() + 244;
                        break;
                case 10: dias = dias + data.getDia() + 264;
                        break;
                case 11: dias = dias + data.getDia() + 295;
                        break;
                case 12: dias = dias + data.getDia() + 315;
                        break;
                default: dias = 0;
                        break;
            }
        }
        else {
            switch (data.getMes()) {
                case 1: dias += data.getDia();
                        break;
                case 2: dias = dias + data.getDia() + 31;
                        break;
                case 3: dias = dias + data.getDia() + 59;
                        break;
                case 4: dias = dias + data.getDia() + 90;
                        break;
                case 5: dias = dias + data.getDia() + 120;
                        break;
                case 6: dias = dias + data.getDia() + 151;
                        break;
                case 7: dias = dias + data.getDia() + 181;
                        break;
                case 8: dias = dias + data.getDia() + 212;
                        break;
                case 9: dias = dias + data.getDia() + 243;
                        break;
                case 10: dias = dias + data.getDia() + 263;
                        break;
                case 11: dias = dias + data.getDia() + 294;
                        break;
                case 12: dias = dias + data.getDia() + 314;
                        break;
                default: dias = 0;
                        break;
            }
        }

        if(this.getAno() % 4 == 0) {
            switch (this.getMes()) {
                case 1: diasObj = diasObj + this.getDia();
                        break;
                case 2: diasObj = diasObj + this.getDia() + 31;
                        break;
                case 3: diasObj = diasObj + this.getDia() + 60;
                        break;
                case 4: diasObj = diasObj + this.getDia() + 91;
                        break;
                case 5: diasObj = diasObj + this.getDia() + 121;
                        break;
                case 6: diasObj = diasObj + this.getDia() + 152;
                        break;
                case 7: diasObj = diasObj + this.getDia() + 182;
                        break;
                case 8: diasObj = diasObj + this.getDia() + 213;
                        break;
                case 9: diasObj = diasObj + this.getDia() + 244;
                        break;
                case 10: diasObj = diasObj + this.getDia() + 264;
                        break;
                case 11: diasObj = diasObj + this.getDia() + 295;
                        break;
                case 12: diasObj = diasObj + this.getDia() + 315;
                        break;
                default: diasObj = 0;
                        break;
            }
        }
        else {
            switch (this.getMes()) {
                case 1: diasObj = diasObj + this.getDia();
                        break;
                case 2: diasObj = diasObj + this.getDia() + 31;
                        break;
                case 3: diasObj = diasObj + this.getDia() + 59;
                        break;
                case 4: diasObj = diasObj + this.getDia() + 90;
                        break;
                case 5: diasObj = diasObj + this.getDia() + 120;
                        break;
                case 6: diasObj = diasObj + this.getDia() + 151;
                        break;
                case 7: diasObj = diasObj + this.getDia() + 181;
                        break;
                case 8: diasObj = diasObj + this.getDia() + 212;
                        break;
                case 9: diasObj = diasObj + this.getDia() + 243;
                        break;
                case 10: diasObj = diasObj + this.getDia() + 263;
                        break;
                case 11: diasObj = diasObj + this.getDia() + 294;
                        break;
                case 12: diasObj = diasObj + this.getDia() + 314;
                        break;
                default: diasObj = 0;
                        break;
            }
        }

        diferencaDias = dias - diasObj;
        if(diferencaDias < 0) {
            diferencaDias = diferencaDias * (-1);
        }

        System.out.println("A diferença entre as datas em dias é " + diferencaDias + " dias");

    }
}
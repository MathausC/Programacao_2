package Programacao_2.AtividadesDeSala;

public class Hora {
    int hora;
    int minuto;
    int formato;
    int amPm;

    private int getHora() {
        return this.hora;
    }
    private void setHora(int hora) {
        this.hora = hora;
    }

    private int getMinuto() {
        return this.minuto;
    }
    private void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    private int getFormato() {
        return formato;
    }
    private void setFormato(int formato) {
        this.formato = formato;
    }

    private int getAmPm() {
        return this.amPm;
    }
    private void setAmPm(int amPm) {
        this.amPm = amPm;
    }

    public Hora() {
        setFormato(1);
        setHora(0);
        setMinuto(0);
        setAmPm(0);
    }

    public Hora(int hora, int min, int formato, int amPm) {
        if(formato > 0 && formato < 3 && hora >= 0 && hora < 24 && min >= 0 && min < 60 && amPm >= 0 && amPm <= 2) {
            if(formato == 1){
                setHora(hora);
                setMinuto(min);
                setAmPm(0);
            }
            else if(hora <= 12 && amPm != 0){
                setHora(hora);
                setMinuto(min);
                setAmPm(amPm);
            }
            else {
                setFormato(1);
                setHora(0);
                setMinuto(0);
                setAmPm(0);
            }
        }
        else {
            setFormato(1);
            setHora(0);
            setMinuto(0);
            setAmPm(0);
        }
    }

    public void exibeHora() {
        String mensagem;
        if(getHora() < 10  && getMinuto() < 10){
            mensagem = "0" + getHora() + ":0" + getMinuto();                
        }
        else if(getHora() < 10 && getMinuto() >= 10) {
            mensagem = "0" + getHora() + ":" + getMinuto();
        }
        else if(getHora() >= 10 && getMinuto() < 10) {
            mensagem = getHora() + ":0" + getMinuto();
        }
        else {
            mensagem = getHora() + ":" + getMinuto();
        }
        
        switch (getAmPm()) {
            case 1: mensagem += " AM";
                    break;
            case 2: mensagem += " PM";
                    break;
            default: mensagem += "";
                    break;
        }

        System.out.println(mensagem);

    }        
    
    public String toString() {
        String mensagem;
        if(getHora() < 10  && getMinuto() < 10){
            mensagem = "0" + getHora() + ":0" + getMinuto();                
        }
        else if(getHora() < 10 && getMinuto() >= 10) {
            mensagem = "0" + getHora() + ":" + getMinuto();
        }
        else if(getHora() >= 10 && getMinuto() < 10) {
            mensagem = getHora() + ":0" + getMinuto();
        }
        else {
            mensagem = getHora() + ":" + getMinuto();
        }
        
        switch (getAmPm()) {
            case 1: mensagem += " AM";
                    break;
            case 2: mensagem += " PM";
                    break;
            default: mensagem += "";
                    break;
        }
        return mensagem;
    }

    private int converteHorasEmMInutos(Hora hora) {
        int minutos = 0;
        if(hora.getAmPm() == 2) {
            minutos = ((hora.getHora() + 12) * 60) + hora.getMinuto();
        }
        else {
            minutos = (hora.getHora() * 60) + hora.getMinuto();
        }

        return minutos;
    }

    public void somaHora(int value) {
        int novaHora;
        int novoMin;
        int somaMin;
        int minObj;
        minObj = converteHorasEmMInutos(this);
        somaMin = (value * 60) + minObj;
        novoMin = somaMin % 60;
        novaHora = ((somaMin - novoMin) / 60) % 24;
        if(novaHora >= 12 && getFormato() == 2){
            setHora(novaHora - 12);
            setAmPm(2);
        }
        else if(novaHora < 12 && getAmPm() == 2){
            setHora(novaHora);
            setAmPm(1);
        }
        else {
            setHora(novaHora);
        }
        setMinuto(novoMin);    
    }
}
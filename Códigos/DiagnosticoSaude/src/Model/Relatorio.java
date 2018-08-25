package Model;

import java.util.Calendar;

public class Relatorio {

    private String id;
    private String conteudo;
    private Calendar datahora;
    private String paciente;

    public Relatorio(String id, String conteudo, Calendar datahora, String paciente) {
        this.id = id;
        this.conteudo = conteudo;
        this.datahora = datahora;
        this.paciente = paciente;
    }

    public Relatorio() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getDatahora() {
        return this.datahora;
    }

    public void setDatahora(Calendar datahora) {
        this.datahora = datahora;
    }

    public String getPaciente() {
        return this.paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}

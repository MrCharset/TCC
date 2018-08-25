package Model;

public class HistoricoMedico {

    private String paciente;
    private String dadosConsulta;

    public HistoricoMedico(String paciente, String dadosConsulta) {
        this.paciente = paciente;
        this.dadosConsulta = dadosConsulta;
    }

    public HistoricoMedico() {

    }

    public String getPaciente() {
        return this.paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDadosConsulta() {
        return this.dadosConsulta;
    }

    public void setDadosConsulta(String dadosConsulta) {
        this.dadosConsulta = dadosConsulta;
    }
}

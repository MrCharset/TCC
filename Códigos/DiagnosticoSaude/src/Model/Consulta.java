package Model;
import java.util.Calendar;

public class Consulta 
{ 
    private String id;
    private String enfermeiro;
    private String paciente;
    private Calendar datahora;
    private double massaCorporal;
    private double circAbdominal;
    private double altura;
    private double glicemia;
    private String pressaoArterial;
    private int respiracao;
    private double temperatura;
    private int batimentoCardio;

    public Consulta(String id, String enfermeiro, String paciente, Calendar datahora, double massaCorporal, double circAbdominal, double altura, double glicemia, String pressaoArterial, int respiracao, double temperatura, int batimentoCardio) {
        this.id = id;
        this.enfermeiro = enfermeiro;
        this.paciente = paciente;
        this.datahora = datahora;
        this.massaCorporal = massaCorporal;
        this.circAbdominal = circAbdominal;
        this.altura = altura;
        this.glicemia = glicemia;
        this.pressaoArterial = pressaoArterial;
        this.respiracao = respiracao;
        this.temperatura = temperatura;
        this.batimentoCardio = batimentoCardio;
    }

    public String getId() { 
        return this.id;
    } 

    public void setId(String id) { 
        this.id = id;
    } 

    public String getEnfermeiro() { 
        return this.enfermeiro;
    } 

    public void setEnfermeiro(String enfermeiro) { 
        this.enfermeiro = enfermeiro;
    } 

    public String getPaciente() { 
        return this.paciente;
    } 

    public void setPaciente(String paciente) { 
        this.paciente = paciente;
    } 

    public Calendar getDatahora() { 
        return this.datahora;
    } 

    public void setDatahora(Calendar datahora) { 
        this.datahora = datahora;
    } 

    public double getMassaCorporal() { 
        return this.massaCorporal;
    } 

    public void setMassaCorporal(double massaCorporal) { 
        this.massaCorporal = massaCorporal;
    } 

    public double getCircAbdominal() { 
        return this.circAbdominal;
    } 

    public void setCircAbdominal(double circAbdominal) { 
        this.circAbdominal = circAbdominal;
    } 

    public double getAltura() { 
        return this.altura;
    } 

    public void setAltura(double altura) { 
        this.altura = altura;
    } 

    public double getGlicemia() { 
        return this.glicemia;
    } 

    public void setGlicemia(double glicemia) { 
        this.glicemia = glicemia;
    } 

    public String getPressaoArterial() { 
        return this.pressaoArterial;
    } 

    public void setPressaoArterial(String pressaoArterial) { 
        this.pressaoArterial = pressaoArterial;
    } 

    public int getRespiracao() { 
        return this.respiracao;
    } 

    public void setRespiracao(int respiracao) { 
        this.respiracao = respiracao;
    } 

    public double getTemperatura() { 
        return this.temperatura;
    } 

    public void setTemperatura(double temperatura) { 
        this.temperatura = temperatura;
    } 

    public int getBatimentoCardio() { 
        return this.batimentoCardio;
    } 

    public void setBatimentoCardio(int batimentoCardio) { 
        this.batimentoCardio = batimentoCardio;
    } 
}
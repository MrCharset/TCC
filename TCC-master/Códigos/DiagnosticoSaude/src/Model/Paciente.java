package Model;
import java.sql.Date;
import java.util.Calendar;

public class Paciente 
{ 
    private String id;
    private String nome;
    private Calendar nascimento;
    private String sexo;
    private String enfermeiro;

    public Paciente(String id, String nome, Calendar nascimento, String sexo, String enfermeiro) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.enfermeiro = enfermeiro;
    }

    public String getId() { 
        return this.id;
    } 

    public void setId(String id) { 
        this.id = id;
    } 

    public String getNome() { 
        return this.nome;
    }

    public void setNome(String nome) { 
        this.nome = nome;
    } 

    public Calendar getNascimento() { 
        return this.nascimento;
    } 

    public void setNascimento(Calendar nascimento) { 
        this.nascimento = nascimento;
    } 

    public String getSexo() { 
        return this.sexo;
    } 

    public void setSexo(String sexo) { 
        this.sexo = sexo;
    } 

    public String getEnfermeiro() { 
        return this.enfermeiro;
    } 

    public void setEnfermeiro(String enfermeiro) { 
        this.enfermeiro = enfermeiro;
    } 
} 
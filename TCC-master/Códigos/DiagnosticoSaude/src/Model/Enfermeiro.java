package Model;
import java.util.Calendar;

public class Enfermeiro
{
    private String id;
    private String nome;
    private Calendar nascimento;
    private String sexo;
    private String login;
    private String senha;

    public Enfermeiro(String id, String nome, Calendar nascimento, String sexo, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
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

    public String getLogin() { 
        return this.login;
    } 

    public void setLogin(String login) { 
        this.login = login;
    } 

    public String getSenha() { 
        return this.senha;
    } 

    public void setSenha(String senha) { 
        this.senha = senha;
    } 
}
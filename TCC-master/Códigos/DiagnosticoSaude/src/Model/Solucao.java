package Model;

public class Solucao 
{ 
    private String id;
    private String nome;
    private String descricao;

    public Solucao(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() { 
        return this.descricao;
    } 

    public void setDescricao(String descricao) { 
        this.descricao = descricao;
    } 
}
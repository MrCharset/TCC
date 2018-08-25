package Model;

public class Problema 
{ 
    private String id;
    private String nome;
    private String detalhes;
    private String descricao;

    public Problema(String id, String nome, String detalhes, String descricao) {
        this.id = id;
        this.nome = nome;
        this.detalhes = detalhes;
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

    public String getDetalhes() { 
        return this.detalhes;
    } 

    public void setDetalhes(String detalhes) { 
        this.detalhes = detalhes;
    } 

    public String getDescricao() { 
        return this.descricao;
    } 

    public void setDescricao(String descricao) { 
        this.descricao = descricao;
    }
}
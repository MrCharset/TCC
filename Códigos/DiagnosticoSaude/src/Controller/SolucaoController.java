package Controller;
import java.sql.SQLException;
import java.util.List;
import Model.Solucao;
import Model.SolucaoDAO;

public class SolucaoController 
{
    private final SolucaoDAO daoSolucao;

    public SolucaoController() throws SQLException 
    {
        daoSolucao = new SolucaoDAO();
    }

    public boolean add(String id, String nome, String descricao) throws SQLException 
    {
        return daoSolucao.add(new Solucao(id, nome, descricao));
    }

    public boolean remove(String id, String nome, String descricao) throws SQLException 
    {
        return daoSolucao.remove(new Solucao(id, nome, descricao));
    }

    public boolean update(String id, String nome, String descricao) throws SQLException 
    {
        return daoSolucao.update(new Solucao(id, nome, descricao));
    }

    public List<Solucao> selectAll() throws SQLException 
    {
        return daoSolucao.selectAll();
    }

    public List<Solucao> searchBy(String tipo, String coisa) throws SQLException 
    {
        return daoSolucao.searchBySomething(tipo, coisa);
    }
}
package Controller;
import java.sql.SQLException;
import java.util.List;
import Model.Problema;
import Dao.ProblemaDAO;

public class ProblemaController 
{
    private final ProblemaDAO daoProblema;

    public ProblemaController() throws SQLException 
    {
        daoProblema = new ProblemaDAO();
    }
    
    public boolean add(Problema prob) throws SQLException {
        return daoProblema.add(prob);
    }

    public boolean remove(String id) throws SQLException {
        Problema tmp = new Problema();
        tmp.setId(id);
        return daoProblema.remove(tmp);
    }

    public boolean update(Problema enf) throws SQLException {
        return daoProblema.update(enf);
    }

    public boolean add(String id, String nome, String detalhes, String descricao) throws SQLException 
    {
        return daoProblema.add(new Problema(id, nome, detalhes, descricao));
    }

    public boolean remove(String id, String nome, String detalhes, String descricao) throws SQLException 
    {
        return daoProblema.remove(new Problema(id, nome, detalhes, descricao));
    }

    public boolean update(String id, String nome, String detalhes, String descricao) throws SQLException 
    {
        return daoProblema.update(new Problema(id, nome, detalhes, descricao));
    }

    public List<Problema> selectAll() throws SQLException 
    {
        return daoProblema.selectAll();
    }

    public List<Problema> searchBySomething(String tipo, String coisa) throws SQLException 
    {
        return daoProblema.searchBy(tipo, coisa);
    }
}
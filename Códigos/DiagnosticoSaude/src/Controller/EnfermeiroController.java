package Controller;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import Model.Enfermeiro;
import Model.EnfermeiroDAO;

public class EnfermeiroController 
{
    private final EnfermeiroDAO daoEnfermeiro;

    public EnfermeiroController() throws SQLException 
    {
        daoEnfermeiro = new EnfermeiroDAO();
    }

    public boolean add(String id, String nome, Calendar nascimento, String sexo, String login, String senha) throws SQLException 
    {
        return daoEnfermeiro.add(new Enfermeiro(id, nome, nascimento, sexo, login, senha));
    }

    public boolean remove(String id, String nome, Calendar nascimento, String sexo, String login, String senha) throws SQLException 
    {
        return daoEnfermeiro.remove(new Enfermeiro(id, nome, nascimento, sexo, login, senha));
    }

    public boolean update(String id, String nome, Calendar nascimento, String sexo, String login, String senha) throws SQLException 
    {
        return daoEnfermeiro.update(new Enfermeiro(id, nome, nascimento, sexo, login, senha));
    }

    public List<Enfermeiro> selectAll() throws SQLException 
    {
        return daoEnfermeiro.selectAll();
    }

    public List<Enfermeiro> searchBySomething(String tipo, String coisa) throws SQLException 
    {
        return daoEnfermeiro.searchBySomething(tipo, coisa);
    }
}
package Controller;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import Model.Relatorio;
import Model.RelatorioDAO;

public class RelatorioController 
{
    private final RelatorioDAO daoRelatorio;

    public RelatorioController() throws SQLException 
    {
        daoRelatorio = new RelatorioDAO();
    }

    public boolean add(String id, String conteudo, Calendar datahora, String paciente) throws SQLException 
    {
        return daoRelatorio.add(new Relatorio(id, conteudo, datahora, paciente));
    }

    public boolean remove(String id, String conteudo, Calendar datahora, String paciente) throws SQLException 
    {
        return daoRelatorio.remove(new Relatorio(id, conteudo, datahora, paciente));
    }

    public boolean update(String id, String conteudo, Calendar datahora, String paciente) throws SQLException 
    {
        return daoRelatorio.update(new Relatorio(id, conteudo, datahora, paciente));
    }

    public List<Relatorio> selectAll() throws SQLException 
    {
        return daoRelatorio.selectAll();
    }

    public List<Relatorio> searchBySomething(String tipo, String coisa) throws SQLException 
    {
        return daoRelatorio.searchBySomething(tipo, coisa);
    }
}
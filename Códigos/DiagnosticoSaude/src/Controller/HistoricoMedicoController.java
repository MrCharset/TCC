package Controller;
import java.sql.SQLException;
import java.util.List;
import Model.HistoricoMedico;
import Model.HistoricoMedicoDAO;

public class HistoricoMedicoController 
{
    private final HistoricoMedicoDAO daoHistoricoMedico;

    public HistoricoMedicoController() throws SQLException 
    {
        daoHistoricoMedico = new HistoricoMedicoDAO();
    }

    public boolean add(String paciente, String dadosConsulta) throws SQLException 
    {
        return daoHistoricoMedico.add(new HistoricoMedico(paciente, dadosConsulta));
    }

    public boolean remove(String paciente, String dadosConsulta) throws SQLException 
    {
        return daoHistoricoMedico.remove(new HistoricoMedico(paciente, dadosConsulta));
    }

    public boolean update(String paciente, String dadosConsulta) throws SQLException 
    {
        return daoHistoricoMedico.update(new HistoricoMedico(paciente, dadosConsulta));
    }

    public List<HistoricoMedico> selectAll() throws SQLException 
    {
        return daoHistoricoMedico.selectAll();
    }

    public List<HistoricoMedico> searchBySomething(String tipo, String coisa) throws SQLException 
    {
        return daoHistoricoMedico.searchBySomething(tipo, coisa);
    }
}
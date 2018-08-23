package Controller;

import java.sql.SQLException;
import java.util.List;
import Model.HistoricoMedico;
import Dao.HistoricoMedicoDAO;

public class HistoricoMedicoController {

    private final HistoricoMedicoDAO daoHistoricoMedico;

    public HistoricoMedicoController() throws SQLException {
        daoHistoricoMedico = new HistoricoMedicoDAO();
    }

    public boolean add(HistoricoMedico his) throws SQLException {
        return daoHistoricoMedico.add(his);
    }

    public boolean update(HistoricoMedico his) throws SQLException {
        return daoHistoricoMedico.update(his);
    }

    public boolean add(String paciente, String dadosConsulta) throws SQLException {
        return daoHistoricoMedico.add(new HistoricoMedico(paciente, dadosConsulta));
    }

    public boolean remove(String paciente, String dadosConsulta) throws SQLException {
        return daoHistoricoMedico.remove(new HistoricoMedico(paciente, dadosConsulta));
    }

    public boolean update(String paciente, String dadosConsulta) throws SQLException {
        return daoHistoricoMedico.update(new HistoricoMedico(paciente, dadosConsulta));
    }

    public List<HistoricoMedico> selectAll() throws SQLException {
        return daoHistoricoMedico.selectAll();
    }

    public List<HistoricoMedico> searchBy(String campo, String valor) throws SQLException {
        return daoHistoricoMedico.searchBy(campo, valor);
    }
}

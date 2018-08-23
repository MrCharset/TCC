package Controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import Model.Relatorio;
import Dao.RelatorioDAO;

public class RelatorioController {

    private final RelatorioDAO daoRelatorio;

    public RelatorioController() throws SQLException {
        daoRelatorio = new RelatorioDAO();
    }

    public boolean add(Relatorio rel) throws SQLException {
        return daoRelatorio.add(rel);
    }

    public boolean remove(String id) throws SQLException {
        Relatorio tmp = new Relatorio();
        tmp.setId(id);
        return daoRelatorio.remove(tmp);
    }

    public boolean update(Relatorio rel) throws SQLException {
        return daoRelatorio.update(rel);
    }

    public List<Relatorio> selectAll() throws SQLException {
        return daoRelatorio.selectAll();
    }

    public List<Relatorio> searchBy(String campo, String valor) throws SQLException {
        return daoRelatorio.searchBy(campo, valor);
    }

    public boolean add(String id, String conteudo, Calendar datahora, String paciente) throws SQLException {
        return daoRelatorio.add(new Relatorio(id, conteudo, datahora, paciente));
    }

    public boolean remove(String id, String conteudo, Calendar datahora, String paciente) throws SQLException {
        return daoRelatorio.remove(new Relatorio(id, conteudo, datahora, paciente));
    }

    public boolean update(String id, String conteudo, Calendar datahora, String paciente) throws SQLException {
        return daoRelatorio.update(new Relatorio(id, conteudo, datahora, paciente));
    }

}

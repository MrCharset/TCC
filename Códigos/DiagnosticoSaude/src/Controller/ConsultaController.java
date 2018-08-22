package Controller;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import Model.Consulta;
import Model.ConsultaDAO;

public class ConsultaController 
{
    private final ConsultaDAO daoConsulta;

    public ConsultaController() throws SQLException 
    {
        daoConsulta = new ConsultaDAO();
    }
    
    
    public boolean add(Consulta consulta) throws SQLException{
        return daoConsulta.add(consulta);
    }
    
    public boolean remove(String id) throws SQLException{
        Consulta tmp = new Consulta();
        tmp.setId(id);
        return daoConsulta.remove(tmp);
    }
    
    public boolean update(Consulta consulta) throws SQLException{
        return daoConsulta.update(consulta);
    }
    
    public List<Consulta> selectAll() throws SQLException 
    {
        return daoConsulta.selectAll();
    }
    
    public List<Consulta> searchBy(String campo, String valor) throws SQLException 
    {
        return daoConsulta.searchBy(campo, valor);
    }
    
    
    public boolean add(String id, String enfermeiro, String paciente, Calendar datahora, double massaCorporal, double circAbdominal, double altura, double glicemia, String pressaoArterial, int respiracao, double temperatura, int batimentoCardio) throws SQLException 
    {
        return daoConsulta.add(new Consulta(id, enfermeiro, paciente, datahora, massaCorporal, circAbdominal, altura, glicemia, pressaoArterial, respiracao, temperatura, batimentoCardio));
    }

    public boolean remove(String id, String enfermeiro, String paciente, Calendar datahora, double massaCorporal, double circAbdominal, double altura, double glicemia, String pressaoArterial, int respiracao, double temperatura, int batimentoCardio) throws SQLException 
    {
        return daoConsulta.remove(new Consulta(id, enfermeiro, paciente, datahora, massaCorporal, circAbdominal, altura, glicemia, pressaoArterial, respiracao, temperatura, batimentoCardio));
    }

    public boolean update(String id, String enfermeiro, String paciente, Calendar datahora, double massaCorporal, double circAbdominal, double altura, double glicemia, String pressaoArterial, int respiracao, double temperatura, int batimentoCardio) throws SQLException 
    {
        return daoConsulta.update(new Consulta(id, enfermeiro, paciente, datahora, massaCorporal, circAbdominal, altura, glicemia, pressaoArterial, respiracao, temperatura, batimentoCardio));
    }

    

    
}
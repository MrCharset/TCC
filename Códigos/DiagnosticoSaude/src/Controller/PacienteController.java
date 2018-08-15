package Controller;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import Model.Paciente;
import Model.PacienteDAO;

public class PacienteController 
{
    private final PacienteDAO daoPaciente;

    public PacienteController() throws SQLException 
    {
        daoPaciente = new PacienteDAO();
    }

    public boolean add(String id, String nome, Calendar nascimento, String sexo, String enfermeiro) throws SQLException 
    {
        return daoPaciente.add(new Paciente(id, nome, nascimento, sexo, enfermeiro));
    }

    public boolean remove(String id, String nome, Calendar nascimento, String sexo, String enfermeiro) throws SQLException 
    {
        return daoPaciente.remove(new Paciente(id, nome, nascimento, sexo, enfermeiro));
    }

    public boolean update(String id, String nome, Calendar nascimento, String sexo, String enfermeiro) throws SQLException 
    {
        return daoPaciente.update(new Paciente(id, nome, nascimento, sexo, enfermeiro));
    }

    public List<Paciente> selectAll() throws SQLException 
    {
        return daoPaciente.selectAll();
    }

    public List<Paciente> searchBySomething(String tipo, String coisa) throws SQLException 
    {
        return daoPaciente.searchBySomething(tipo, coisa);
    }
}
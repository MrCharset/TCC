package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoricoMedicoDAO 
{ 
    private final Connection con;
    
    public HistoricoMedicoDAO() throws SQLException
    { 
        con = ConnectionFactory.getConnection();
    }

    public boolean add(HistoricoMedico modelo) throws SQLException
    { 
        if (searchBySomething("paciente", modelo.getPaciente()).size() > 0)
        {
            return false;
        }
        else
        {
            PreparedStatement stmt = con.prepareStatement("insert into historicomedico (paciente, dadosconsulta) values (?, ?)");
            stmt.setString(1, modelo.getPaciente());
            stmt.setString(2, modelo.getDadosConsulta());
            return stmt.executeUpdate() != 0;
        }   
    } 

    public boolean remove(HistoricoMedico modelo) throws SQLException
    {
        if (searchBySomething("paciente", modelo.getPaciente()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("delete from historicomedico where paciente = ?");
            stmt.setString(1, modelo.getPaciente());
            return stmt.execute();
        }
        else
        {
            return false;
        }
        
    } 

    public boolean update(HistoricoMedico modelo) throws SQLException
    {
        if (searchBySomething("paciente", modelo.getPaciente()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("update historicomedico set dadosconsulta = ? where paciente = ?");
            stmt.setString(1, modelo.getDadosConsulta());
            stmt.setString(2, modelo.getPaciente());
            return stmt.executeUpdate() != 0;
        }
        else
        {
            return false;
        }    
    } 

    public List<HistoricoMedico> selectAll() throws SQLException
    { 
        ArrayList <HistoricoMedico> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from historicomedico");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String paciente = rs.getString("paciente");
            String dadosConsulta = rs.getString("dadosconsulta");
            HistoricoMedico obj = new HistoricoMedico(paciente, dadosConsulta);
            lista.add(obj);
        }
        return lista;
    } 

    public List<HistoricoMedico> searchBySomething(String tipo, String coisa) throws SQLException
    { 
        ArrayList <HistoricoMedico> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from historicomedico where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String paciente = rs.getString("paciente");
            String dadosConsulta = rs.getString("dadosconsulta");
            HistoricoMedico obj = new HistoricoMedico(paciente, dadosConsulta);
            lista.add(obj);
        }
        return lista;
    }
}
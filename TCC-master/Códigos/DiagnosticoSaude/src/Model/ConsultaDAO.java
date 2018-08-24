package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO 
{ 
    private final Connection con;
    
    public ConsultaDAO() throws SQLException
    { 
        con = ConnectionFactory.getConnection();
    } 

    public boolean add(Consulta modelo) throws SQLException
    {
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            return false;
        }
        else
        {
            PreparedStatement stmt = con.prepareStatement("insert into consulta (id, enfermeiro, paciente, datahora, massacorporal, circabdominal, altura, glicemia, pressaoarterial, respiracao, temperatura, batimentocardio) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getEnfermeiro());
            stmt.setString(3, modelo.getPaciente());
            Calendar tmp4 = modelo.getDatahora();
            stmt.setTimestamp(4, new Timestamp(tmp4.getTimeInMillis()));
            stmt.setDouble(5, modelo.getMassaCorporal());
            stmt.setDouble(6, modelo.getCircAbdominal());
            stmt.setDouble(7, modelo.getAltura());
            stmt.setDouble(8, modelo.getGlicemia());
            stmt.setString(9, modelo.getPressaoArterial());
            stmt.setInt(10, modelo.getRespiracao());
            stmt.setDouble(11, modelo.getTemperatura());
            stmt.setInt(12, modelo.getBatimentoCardio());
            return stmt.executeUpdate() != 0;
        }
    } 

    public boolean remove(Consulta modelo) throws SQLException
    {
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("delete from consulta where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        }
        else
        {
            return false;
        }
    } 

    public boolean update(Consulta modelo) throws SQLException
    {
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("update consulta set enfermeiro = ?, paciente = ?, datahora = ?, massacorporal = ?, circabdominal = ?, altura = ?, glicemia = ?, pressaoarterial = ?, respiracao = ?, temperatura = ?, batimentocardio = ? where id = ?");
            stmt.setString(1, modelo.getEnfermeiro());
            stmt.setString(2, modelo.getPaciente());
            Calendar tmp3 = modelo.getDatahora();
            stmt.setTimestamp(3, new Timestamp(tmp3.getTimeInMillis()));
            stmt.setDouble(4, modelo.getMassaCorporal());
            stmt.setDouble(5, modelo.getCircAbdominal());
            stmt.setDouble(6, modelo.getAltura());
            stmt.setDouble(7, modelo.getGlicemia());
            stmt.setString(8, modelo.getPressaoArterial());
            stmt.setInt(9, modelo.getRespiracao());
            stmt.setDouble(10, modelo.getTemperatura());
            stmt.setInt(11, modelo.getBatimentoCardio());
            stmt.setString(12, modelo.getId());
            return stmt.executeUpdate() != 0;
        }
        else
        {
            return false;
        }
    } 

    public List<Consulta> selectAll() throws SQLException
    { 
        ArrayList <Consulta> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from consulta");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String enfermeiro = rs.getString("enfermeiro");
            String paciente = rs.getString("paciente");
            Calendar data1 = Calendar.getInstance();
            data1.setTimeInMillis(rs.getTimestamp("datahora").getTime());
            Calendar datahora = data1;
            double massaCorporal = rs.getDouble("massacorporal");
            double circAbdominal = rs.getDouble("circabdominal");
            double altura = rs.getDouble("altura");
            double glicemia = rs.getDouble("glicemia");
            String pressaoArterial = rs.getString("pressaoarterial");
            int respiracao = rs.getInt("respiracao");
            double temperatura = rs.getDouble("temperatura");
            int batimentoCardio = rs.getInt("batimentocardio");
            Consulta obj = new Consulta(id, enfermeiro, paciente, datahora, massaCorporal, circAbdominal, altura, glicemia, pressaoArterial, respiracao, temperatura, batimentoCardio);
            lista.add(obj);
        }
        return lista;
    } 

    public List<Consulta> searchBySomething(String tipo, String coisa) throws SQLException
    { 
        ArrayList <Consulta> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from consulta where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String enfermeiro = rs.getString("enfermeiro");
            String paciente = rs.getString("paciente");
            Calendar data1 = Calendar.getInstance();
            data1.setTimeInMillis(rs.getTimestamp("datahora").getTime());
            Calendar datahora = data1;
            double massaCorporal = rs.getDouble("massacorporal");
            double circAbdominal = rs.getDouble("circabdominal");
            double altura = rs.getDouble("altura");
            double glicemia = rs.getDouble("glicemia");
            String pressaoArterial = rs.getString("pressaoarterial");
            int respiracao = rs.getInt("respiracao");
            double temperatura = rs.getDouble("temperatura");
            int batimentoCardio = rs.getInt("batimentocardio");
            Consulta obj = new Consulta(id, enfermeiro, paciente, datahora, massaCorporal, circAbdominal, altura, glicemia, pressaoArterial, respiracao, temperatura, batimentoCardio);
            lista.add(obj);
        }
        return lista;
    }
}
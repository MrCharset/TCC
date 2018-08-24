package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO 
{ 
    private final Connection con;
    
    public RelatorioDAO() throws SQLException
    { 
        con = ConnectionFactory.getConnection();
    }

    public boolean add(Relatorio modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            return false;
        }
        else
        {
            PreparedStatement stmt = con.prepareStatement("insert into relatorio (id, conteudo, datahora, paciente) values (?, ?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getConteudo());
            Calendar tmp3 = modelo.getDatahora();
            stmt.setTimestamp(3, new Timestamp(tmp3.getTimeInMillis()));
            stmt.setString(4, modelo.getPaciente());
            return stmt.executeUpdate() != 0;
        }  
    } 

    public boolean remove(Relatorio modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("delete from relatorio where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        }
        else
        {
            return false;
        }      
    } 

    public boolean update(Relatorio modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("update relatorio set conteudo = ?, datahora = ?, paciente = ? where id = ?");
            stmt.setString(1, modelo.getConteudo());
            Calendar tmp2 = modelo.getDatahora();
            stmt.setTimestamp(2, new Timestamp(tmp2.getTimeInMillis()));
            stmt.setString(3, modelo.getPaciente());
            stmt.setString(4, modelo.getId());
            return stmt.executeUpdate() != 0;
        }
        else
        {
            return false;
        }      
    } 

    public List<Relatorio> selectAll() throws SQLException
    { 
        ArrayList <Relatorio> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from relatorio");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String conteudo =rs.getString("conteudo");
            Calendar data1 = Calendar.getInstance();
            data1.setTimeInMillis(rs.getTimestamp("datahora").getTime());
            Calendar datahora = data1;
            String paciente = rs.getString("paciente");
            Relatorio obj = new Relatorio(id, conteudo, datahora, paciente);
            lista.add(obj);
        }
        return lista;
    } 

    public List<Relatorio> searchBySomething(String tipo, String coisa) throws SQLException
    { 
        ArrayList <Relatorio> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from relatorio where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String conteudo = rs.getString("conteudo");
            Calendar data1 = Calendar.getInstance();
            data1.setTimeInMillis(rs.getTimestamp("datahora").getTime());
            Calendar datahora = data1;
            String paciente = rs.getString("paciente");
            Relatorio obj = new Relatorio(id, conteudo, datahora, paciente);
            lista.add(obj);
        }
        return lista;
    }
} 
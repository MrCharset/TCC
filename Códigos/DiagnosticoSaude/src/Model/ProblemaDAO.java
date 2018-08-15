package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDAO 
{ 
    private final Connection con;
    
    public ProblemaDAO() throws SQLException
    { 
        con = ConnectionFactory.getConnection();
    }

    public boolean add(Problema modelo) throws SQLException
    {
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
           return false; 
        }
        else
        {
            PreparedStatement stmt = con.prepareStatement("insert into problema (id, nome, detalhes, descricao) values (?, ?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getNome());
            stmt.setString(3, modelo.getDetalhes());
            stmt.setString(4, modelo.getDescricao());
            return stmt.executeUpdate() != 0;
        }      
    } 

    public boolean remove(Problema modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("delete from problema where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        }
        else
        {
            return false;
        }
    } 

    public boolean update(Problema modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("update problema set nome = ?, detalhes = ?, descricao = ? where id = ?");
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getDetalhes());
            stmt.setString(3, modelo.getDescricao());
            stmt.setString(4, modelo.getId());
            return stmt.executeUpdate() != 0;
        }
        else
        {
            return false;
        }      
    } 

    public List<Problema> selectAll() throws SQLException
    { 
        ArrayList <Problema> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from problema");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {   
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String detalhes = rs.getString("detalhes");
            String descricao = rs.getString("descricao");
            Problema obj = new Problema(id, nome, detalhes, descricao);
            lista.add(obj);
        }
        return lista;
    } 

    public List<Problema> searchBySomething(String tipo, String coisa) throws SQLException
    { 
        ArrayList <Problema> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from problema where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String detalhes = rs.getString("detalhes");
            String descricao = rs.getString("descricao");
            Problema obj = new Problema(id, nome, detalhes, descricao);
            lista.add(obj);
        }
        return lista;
    }
}
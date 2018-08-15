package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolucaoDAO 
{ 
    private final Connection con;
    
    public SolucaoDAO() throws SQLException
    { 
        con = ConnectionFactory.getConnection();
    }

    public boolean add(Solucao modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            return false;
        }
        else
        {
            PreparedStatement stmt = con.prepareStatement("insert into solucao (id, nome, descricao) values (?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getNome());
            stmt.setString(3, modelo.getDescricao());
            return stmt.executeUpdate() != 0;
        }
    } 

    public boolean remove(Solucao modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("delete from solucao where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        }
        else
        {
            return false;
        }
    } 

    public boolean update(Solucao modelo) throws SQLException
    { 
        if (searchBySomething("id", modelo.getId()).size() > 0)
        {
            PreparedStatement stmt = con.prepareStatement("update solucao set nome = ?, descricao = ? where id = ?");
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getDescricao());
            stmt.setString(3, modelo.getId());
            return stmt.executeUpdate() != 0;
        }
        else
        {
            return false;
        }
    } 

    public List<Solucao> selectAll() throws SQLException
    { 
        ArrayList <Solucao> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from solucao");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Solucao obj = new Solucao(id, nome, descricao);
            lista.add(obj);
        }
        return lista;
    } 

    public List<Solucao> searchBySomething(String tipo, String coisa) throws SQLException
    { 
        ArrayList <Solucao> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from solucao where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Solucao obj = new Solucao(id, nome, descricao);
            lista.add(obj);
        }
        return lista;
    } 
}
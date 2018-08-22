package Model;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProblemaDAO<Object> extends DAO<Problema> {

    public ProblemaDAO() throws SQLException {
        super();
    }
    
    
    @Override
    public boolean add(Problema modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            return false;
        } else {
            PreparedStatement stmt = con.prepareStatement("insert into problema (id, nome, detalhes, descricao) values (?, ?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getNome());
            stmt.setString(3, modelo.getDetalhes());
            stmt.setString(4, modelo.getDescricao());
            return stmt.executeUpdate() != 0;
        }
    }

    @Override
    public boolean remove(Problema modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            PreparedStatement stmt = con.prepareStatement("delete from problema where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Problema modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            PreparedStatement stmt = con.prepareStatement("update problema set nome = ?, detalhes = ?, descricao = ? where id = ?");
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getDetalhes());
            stmt.setString(3, modelo.getDescricao());
            stmt.setString(4, modelo.getId());
            return stmt.executeUpdate() != 0;
        } else {
            return false;
        }
    }

    @Override
    public List<Problema> selectAll() throws SQLException {
        ArrayList<Problema> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from problema");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String detalhes = rs.getString("detalhes");
            String descricao = rs.getString("descricao");
            Problema obj = new Problema(id, nome, detalhes, descricao);
            lista.add(obj);
        }
        return lista;
    }

    @Override
    public List<Problema> searchBy(String campo, String valor) throws SQLException {
        ArrayList<Problema> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from problema where " + campo + " = ?");
        stmt.setString(1, valor);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
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

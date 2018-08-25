package Dao;

import Model.Solucao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolucaoDAO<Object> extends DAO<Solucao> {

    public SolucaoDAO() throws SQLException {
        super();
    }

    @Override
    public boolean add(Solucao modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            return false;
        }

        PreparedStatement stmt = con.prepareStatement("insert into solucao (id, nome, descricao) values (?, ?, ?)");
        stmt.setString(1, modelo.getId());
        stmt.setString(2, modelo.getNome());
        stmt.setString(3, modelo.getDescricao());
        return stmt.executeUpdate() != 0;

    }

    @Override
    public boolean remove(Solucao modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).isEmpty()) {
            return false;
        }

        PreparedStatement stmt = con.prepareStatement("delete from solucao where id = ?");
        stmt.setString(1, modelo.getId());
        return stmt.execute();

    }

    @Override
    public boolean update(Solucao modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).isEmpty()) {
            return false;
        }
        
        PreparedStatement stmt = con.prepareStatement("update solucao set nome = ?, descricao = ? where id = ?");
        stmt.setString(1, modelo.getNome());
        stmt.setString(2, modelo.getDescricao());
        stmt.setString(3, modelo.getId());
        return stmt.executeUpdate() != 0;

    }

    @Override
    public List<Solucao> selectAll() throws SQLException {
        ArrayList<Solucao> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from solucao");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Solucao obj = new Solucao(id, nome, descricao);
            lista.add(obj);
        }
        return lista;
    }

    @Override
    public List<Solucao> searchBy(String campo, String valor) throws SQLException {
        ArrayList<Solucao> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from solucao where " + campo + " = ?");
        stmt.setString(1, valor);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Solucao obj = new Solucao(id, nome, descricao);
            lista.add(obj);
        }
        return lista;
    }
}

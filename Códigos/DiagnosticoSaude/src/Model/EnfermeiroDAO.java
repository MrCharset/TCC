package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnfermeiroDAO<Object> extends DAO<Enfermeiro> {

    public EnfermeiroDAO() throws SQLException {
        super();
    }

    @Override
    public boolean add(Enfermeiro modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            return false;
        } else {
            PreparedStatement stmt = con.prepareStatement("insert into enfermeiro (id, nome, nascimento, sexo, login, senha) values (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, modelo.getId());
            stmt.setString(2, modelo.getNome());
            Calendar tmp3 = modelo.getNascimento();
            stmt.setDate(3, new Date(tmp3.getTimeInMillis()));
            stmt.setString(4, modelo.getSexo());
            stmt.setString(5, modelo.getLogin());
            stmt.setString(6, modelo.getSenha());
            return stmt.executeUpdate() != 0;
        }
    }

    @Override
    public boolean remove(Enfermeiro modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            PreparedStatement stmt = con.prepareStatement("delete from enfermeiro where id = ?");
            stmt.setString(1, modelo.getId());
            return stmt.execute();
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Enfermeiro modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            PreparedStatement stmt = con.prepareStatement("update enfermeiro set nome = ?, nascimento = ?, sexo = ?, login = ?, senha = ? where id = ?");
            stmt.setString(1, modelo.getNome());
            Calendar tmp2 = modelo.getNascimento();
            stmt.setDate(2, new Date(tmp2.getTimeInMillis()));
            stmt.setString(3, modelo.getSexo());
            stmt.setString(4, modelo.getLogin());
            stmt.setString(5, modelo.getSenha());
            stmt.setString(6, modelo.getId());
            return stmt.executeUpdate() != 0;
        } else {
            return false;
        }
    }

    @Override
    public List<Enfermeiro> selectAll() throws SQLException {
        ArrayList<Enfermeiro> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from enfermeiro");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            Calendar data1 = Calendar.getInstance();
            data1.setTime(rs.getDate("nascimento"));
            Calendar nascimento = data1;
            String sexo = rs.getString("sexo");
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            Enfermeiro obj = new Enfermeiro(id, nome, nascimento, sexo, login, senha);
            lista.add(obj);
        }
        return lista;
    }

    @Override
    public List<Enfermeiro> searchBy(String campo, String valor) throws SQLException {
        ArrayList<Enfermeiro> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from enfermeiro where " + campo + " = ?");
        stmt.setString(1, valor);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            Calendar data1 = Calendar.getInstance();
            data1.setTime(rs.getDate("nascimento"));
            Calendar nascimento = data1;
            String sexo = rs.getString("sexo");
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            Enfermeiro obj = new Enfermeiro(id, nome, nascimento, sexo, login, senha);
            lista.add(obj);
        }
        return lista;
    }
}

package Dao;

import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO<Object> extends DAO<Paciente> {

    public PacienteDAO() throws SQLException {
        super();
    }

    @Override
    public boolean add(Paciente modelo) throws SQLException {
        if (searchBy("id", modelo.getId()).size() > 0) {
            return false;
        }

        PreparedStatement stmt = con.prepareStatement("insert into paciente (id, nome, nascimento, sexo) values (?, ?, ?, ?)");
        stmt.setString(1, modelo.getId());
        stmt.setString(2, modelo.getNome());
        Calendar tmp3 = modelo.getNascimento();
        stmt.setDate(3, new Date(tmp3.getTimeInMillis()));
        stmt.setString(4, modelo.getSexo());
        return stmt.executeUpdate() != 0;

    }

    @Override
    public boolean remove(Paciente modelo) throws SQLException {

        if (searchBy("id", modelo.getId()).isEmpty()) {
            return false;
        }

        PreparedStatement stmt = con.prepareStatement("delete from paciente where id = ?");
        stmt.setString(1, modelo.getId());
        return stmt.execute();

    }

    @Override
    public boolean update(Paciente modelo) throws SQLException {

        if (searchBy("id", modelo.getId()).isEmpty()) {
            return false;
        }

        PreparedStatement stmt = con.prepareStatement("update paciente set nome = ?, nascimento = ?, sexo = ? where id = ?");
        stmt.setString(1, modelo.getNome());
        Calendar tmp2 = modelo.getNascimento();
        stmt.setDate(2, new Date(tmp2.getTimeInMillis()));
        stmt.setString(3, modelo.getSexo());
        stmt.setString(5, modelo.getId());
        return stmt.executeUpdate() != 0;

    }

    @Override
    public List<Paciente> selectAll() throws SQLException {
        ArrayList<Paciente> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from paciente");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            Calendar data1 = Calendar.getInstance();
            data1.setTime(rs.getDate("nascimento"));
            Calendar nascimento = data1;
            String sexo = rs.getString("sexo");
            Paciente obj = new Paciente(id, nome, nascimento, sexo);
            lista.add(obj);
        }
        return lista;
    }

    @Override
    public List<Paciente> searchBy(String tipo, String coisa) throws SQLException {
        ArrayList<Paciente> lista = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from paciente where " + tipo + " = ?");
        stmt.setString(1, coisa);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            Calendar data1 = Calendar.getInstance();
            data1.setTime(rs.getDate("nascimento"));
            Calendar nascimento = data1;
            String sexo = rs.getString("sexo");
            Paciente obj = new Paciente(id, nome, nascimento, sexo);
            lista.add(obj);
        }
        return lista;
    }
}

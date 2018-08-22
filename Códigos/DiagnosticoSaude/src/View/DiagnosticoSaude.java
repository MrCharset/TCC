package View;

import Controller.*;
import Model.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiagnosticoSaude {

    public static void main(String[] args) throws SQLException {
        Calendar c = Calendar.getInstance();

        List<DAO> daos = new ArrayList<>();
        daos.add(new EnfermeiroDAO());
        daos.add(new PacienteDAO());
        daos.add(new ProblemaDAO());
        
        DAO dao = new ProblemaDAO();
       

        
    }
}

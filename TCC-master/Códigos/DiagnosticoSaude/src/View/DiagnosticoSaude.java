package View;
import Controller.EnfermeiroController;
import Controller.PacienteController;
import Controller.RelatorioController;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class DiagnosticoSaude 
{
    public static void main(String[] args) throws SQLException
    {
        Calendar c = Calendar.getInstance();
        
        EnfermeiroController ec = new EnfermeiroController();
        c.set(2002, 6, 18); //mês começa no zero
        ec.add("enf", "nome", c, "m", "login", "senha");
        c = ec.selectAll().get(0).getNascimento();
        System.out.println(new Date(c.getTimeInMillis()));
        
        PacienteController pc = new PacienteController();
        c.set(2001, 6, 7); //mês começa no zero
        pc.add("pac", "nome", c, "f", "enf");
        c = pc.selectAll().get(0).getNascimento();
        System.out.println(new Date(c.getTimeInMillis()));
        
        RelatorioController rc = new RelatorioController();
        c.set(2015, 11, 20, 10, 34, 59); //mês começa no zero
        rc.add("rel", "conteudo", c, "pac");
        c = rc.selectAll().get(0).getDatahora();
        System.out.println(new Timestamp(c.getTimeInMillis()));
    }
}
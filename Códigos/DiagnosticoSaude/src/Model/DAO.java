/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Uma classe abstrata que usa Generics, um recurso da linguagem Java.
 * Assim como quando queremos usar o ArrayList, a classe recebe na instância dela,
 * algum tipo genérico ou classe genérica "T". ArrayList<ClasseOuTipo> minhaLista
 * = new ArrayList<ClasseOuTipo>(); ou simplesmente = new ArrayList<>();. 
 * As classes que usam Generics, nos permitem também passar a classe genérica T
 * no momento em que herdamos dela, exemplo de código:
 * 
 * public class EnfermeiroDAO extends DAO<Enfermeiro> { ...
 * 
 * //o abstract some quando a classe filha sobrescreve o método
 * public boolean add(Enfermeiro obj) { ... } 
 * public boolean remove(Enfermeiro obj) { ... }
 * public boolean update(Enfermeiro obj){ ... }
 * pubilc List<Enfermeiro> selectAll() { ... }
 * public List<Enfermeito> searchBy(String field, String value){ ... }
 * 
 * }
 * 
 * Detalhe importante: Uso de polimorfismo, exemplo de código
 * 
 * 
 * @author psilva
 */
public abstract class DAO<T> {

    protected Connection con;
    
    //o  propósito é evitar digitar a mesma coisa sempre
    public DAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public abstract boolean add(T obj) throws SQLException;

    public abstract boolean remove(T obj) throws SQLException;

    public abstract boolean update(T obj) throws SQLException;

    public abstract List<T> selectAll() throws SQLException;

    public abstract List<T> searchBy(String campo, String valor) throws SQLException;
}

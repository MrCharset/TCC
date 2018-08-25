/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.Enfermeiro;
import java.util.*;

/**
 *
 * @author pedrohenrique
 */
public class Session {

    private static Map<String, String> session = new HashMap<>();

    private Session() {

    }

    public static String put(String key, String value) {
        return session.put(key, value);
    }

    public static String get(String key) {
        return session.get(key);
    }

    public static String remove(String key) {
        return session.remove(key);
    }

    public static void saveUser(Enfermeiro enfermeiro) {
        put("login", enfermeiro.getLogin());
        put("nome", enfermeiro.getNome());
        Date data = new Date(enfermeiro.getNascimento().getTimeInMillis());
        put("nascimento", data.getDay() + "/" + data.getMonth() + "/" + data.getYear());
        put("sexo", enfermeiro.getSexo());
        put("id", enfermeiro.getId());
    }

    public static void clearUser() {
        remove("login");
        remove("nome");
        remove("nascimento");
        remove("sexo");
        remove("id");
    }

}

package at.konsti.landania.homesystem.common.mysql;

import at.konsti.landania.homesystem.common.Config;
//import at.konsti.landania.homesystem.spigot.HomeSystem;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Connection {

    private static java.sql.Connection conn;
    private static Statement stmt;


    public static void connect(Logger l) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        conn = null;

        try {

            l.info(Config.read("prefix") + "Verbindung zur Datenbank wird hergestellt");

            conn = DriverManager.getConnection("jdbc:mysql://" + Config.read("mysql-server") + "/" + Config.read("mysql-database") + "?" + "user=" + Config.read("mysql-login") + "&password=" + Config.read("mysql-password") + "");
            l.info(Config.read("prefix") + "Verbindung zur Datenbank hergestellt");
            stmt = conn.createStatement();


        }catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void disconnect(Logger l) {
        try {
            if (conn != null) {
                conn.close();
                l.info(Config.read("prefix") + "Verbindung zur Datenbank getrennt");

            }
        } catch(SQLException e){
            e.printStackTrace();
        }

    }
    public static void onUpdate(String sql){
        try {
            stmt.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();


        }
    }
    public static ResultSet onQuery(String sql) {
        try{
            return stmt.executeQuery(sql);

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}

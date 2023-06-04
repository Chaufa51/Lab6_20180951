package models.Daos;

import models.Beans.Canciones;

import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Canciones> obtenerListaCanciones(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Canciones> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCanciones.add(new Canciones(id,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }


    public ArrayList<Canciones> obtenerListaCancionesporBandaFOB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Canciones> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT *\n" +
                     "FROM cancion\n" +
                     "WHERE banda = 'fOB' AND banda IS NOT NULL;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCanciones.add(new Canciones(id,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }


    public ArrayList<Canciones> obtenerListaCancionesFavorito(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Canciones> listaCanciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cancion where favorito = '1'")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String banda = rs.getString(3);

                listaCanciones.add(new Canciones(id,nombre,banda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaCanciones;
    }

    public void actualizarFavorito(int idcancion , int favorito){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ArrayList<Canciones> listaCanciones = new ArrayList<>();
            try (Connection conn = DriverManager.getConnection(url, user, pass);){
                String sql = "UPDATE cancion SET favorito = ? WHERE idcancion = ?;";

                try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                    pstmt.setInt(1, favorito);
                    pstmt.setInt(2,idcancion);
                    pstmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}

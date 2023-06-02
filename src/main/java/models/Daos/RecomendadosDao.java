package models.Daos;

import models.Beans.Reproduccion;
import models.Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class ReproduccionDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Reproduccion> obtenerListaReproduccion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Reproduccion> listaReproduccion = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String fecha = rs.getString(2);
                Integer cancionId = rs.getInt(3);

                listaReproduccion.add(new Reproduccion(id,fecha,cancionId));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaReproduccion;
    }




}

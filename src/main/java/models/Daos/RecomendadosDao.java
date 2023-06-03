package models.Daos;

import models.Beans.Banda;
import models.Beans.Canciones;
import models.Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadosDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Canciones> obtenerListaRecomendados(){
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
                     "WHERE idcancion IN (\n" +
                     "    SELECT cancion_idcancion\n" +
                     "    FROM reproduccion\n" +
                     "    GROUP BY cancion_idcancion\n" +
                     "    HAVING COUNT(*) > 2\n" +
                     ")\n" +
                     "ORDER BY (\n" +
                     "    SELECT COUNT(cancion_idcancion)\n" +
                     "    FROM reproduccion\n" +
                     "    WHERE cancion_idcancion = cancion.idcancion\n" +
                     ") DESC;")) {

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




}

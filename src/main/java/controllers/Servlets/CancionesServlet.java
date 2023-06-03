package controllers.Servlets;

import models.Beans.Canciones;
import models.Daos.CancionesDao;
import models.Daos.RecomendadosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesServlet",urlPatterns = {"/listaCanciones"})
public class CancionesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao CancionesDao = new CancionesDao();
        ArrayList<Canciones> listaCanciones = CancionesDao.obtenerListaCanciones();

        request.setAttribute("listaCanciones",listaCanciones);

        RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
        view.forward(request,response);
    }
}

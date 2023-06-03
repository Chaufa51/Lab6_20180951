package controllers.Servlets;

import models.Beans.Canciones;
import models.Daos.CancionesDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesFOBServlet",urlPatterns = {"/listaCancionesPorBanda"})
public class CancionesFOBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao CancionesDao = new CancionesDao();
        ArrayList<Canciones> listaCanciones = CancionesDao.obtenerListaCancionesporBandaFOB();

        request.setAttribute("listaCanciones",listaCanciones);

        RequestDispatcher view =request.getRequestDispatcher("listaCancionesBanda.jsp");
        view.forward(request,response);
    }
}

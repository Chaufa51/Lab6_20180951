package controllers.Servlets;

import models.Beans.Canciones;
import models.Beans.Tour;
import models.Daos.RecomendadosDao;
import models.Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecomendadacionesServlet",urlPatterns = {"/listaRecomendaciones"})
public class RecomendacionesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendadosDao RecomendadosDao = new RecomendadosDao();
        ArrayList<Canciones> listaRecomendaciones = RecomendadosDao.obtenerListaRecomendados();

        request.setAttribute("listaRecomendaciones",listaRecomendaciones);

        RequestDispatcher view =request.getRequestDispatcher("listaRecomendaciones.jsp");
        view.forward(request,response);
    }
}

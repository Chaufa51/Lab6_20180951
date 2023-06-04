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

@WebServlet(name = "FavoritosServlet",urlPatterns = {"/listaFavoritos"})
public class CancionesFavoritosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UFT-8");
        int idcancion = Integer.parseInt(request.getParameter("idcancion"));
        int favorito = Integer.parseInt(request.getParameter("favorito"));
        CancionesDao cancionesDao = new CancionesDao();
        cancionesDao.actualizarFavorito(idcancion,favorito);
        response.sendRedirect(request.getContextPath()+ "/listaFavoritos");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao CancionesDao = new CancionesDao();
        ArrayList<Canciones> listaFavoritos = CancionesDao.obtenerListaCancionesFavorito();

        request.setAttribute("listaFavoritos",listaFavoritos);

        RequestDispatcher view =request.getRequestDispatcher("listaFavoritos.jsp");
        view.forward(request,response);
    }
}

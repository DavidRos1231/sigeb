package mx.edu.utez.sigeb.controllers.libro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


@WebServlet(name = "ServletLibro", urlPatterns = {
        "/addLibro",
        "/updateLibro",
        "/deleteLibro",
        "/getLibro"
})
public class ServletLibro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getServletPath();
        System.out.println(opcion);
        HttpServletRequest req= (HttpServletRequest) request;
        switch (opcion){
            case "/getLibro":
                String matricula = request.getParameter("id") !=null? request.getParameter("id"):"";
                System.out.println("getLibro "+matricula);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getServletPath();
        HttpServletRequest req= (HttpServletRequest) request;
        switch (opcion){
            case "/addLibro":
                System.out.println("addlibro");
                break;
            case "/updateLibro":
                System.out.println("updateLibro");
                break;
            case "/deleteLibro":
                System.out.println("deleteLibro");
                break;

        }
    }
}

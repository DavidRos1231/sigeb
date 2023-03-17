package mx.edu.utez.sigeb.controllers.libro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import mx.edu.utez.sigeb.models.libro.Libro;
import org.bson.Document;
import org.json.simple.JSONObject;


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
                Libro libro= new Libro();
                libro= new ServiceLibro().getLibro(matricula);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(libro.toJson());
                out.flush();
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

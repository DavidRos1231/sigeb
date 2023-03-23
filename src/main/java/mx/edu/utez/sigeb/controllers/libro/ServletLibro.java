package mx.edu.utez.sigeb.controllers.libro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import mx.edu.utez.sigeb.services.ServiceLibro;
import mx.edu.utez.sigeb.utils.Mensajes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet(name = "ServletLibro", urlPatterns = {
        "/addLibro",
        "/updateLibro",
        "/deleteLibro",
        "/getLibro",
        "/getLibros"
})
public class ServletLibro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getServletPath();
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        switch (opcion) {
            case "/getLibro":
                String matricula = request.getParameter("id") != null ? request.getParameter("id") : "";
                int matriculaInt = Integer.parseInt(matricula);
                JSONObject libro = new ServiceLibro().getLibro(matriculaInt);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                System.out.println(libro);
                //string to json
                JSONObject msg = new JSONObject();
                msg.put("msg", Mensajes.noexiste);
                out.print(libro!=null?libro:msg);
                out.flush();
                break;
            case "/getLibros":
                JSONArray libros = new JSONArray();
                libros = new ServiceLibro().listLibros();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(libros);
                out.flush();
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getServletPath();
        HttpServletRequest req = (HttpServletRequest) request;
        switch (opcion) {
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

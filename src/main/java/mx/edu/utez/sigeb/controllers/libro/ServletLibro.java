package mx.edu.utez.sigeb.controllers.libro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import mx.edu.utez.sigeb.models.libro.Libro;
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
    JSONObject msg = new JSONObject();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getServletPath();
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();

        switch (opcion) {
            case "/getLibro":
                String matricula = request.getParameter("id") != null ? request.getParameter("id") : "";
                int matriculaInt = 0;
                try{ matriculaInt = Integer.parseInt(matricula);
                }catch (Exception e){
                    msg.put("msg", "Introduce un numero");
                    out.print(msg);
                    out.flush();
                    break;
                }
                JSONObject libro = new ServiceLibro().getLibro(matriculaInt);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                System.out.println(libro);
                //string to json

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
        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        ServiceLibro serviceLibro = new ServiceLibro();
        switch (opcion) {
            case "/addLibro":
                System.out.println("addlibro");
                    String name = request.getParameter("name") != null ? request.getParameter("name") : "";
                    String autor = request.getParameter("autor") != null ? request.getParameter("autor") : "";
                    String categoria = request.getParameter("categoria") != null ? request.getParameter("categoria") : "";
                    Libro libro= new Libro(name,autor,categoria);
                    if (new ServiceLibro().saveLibro(libro)) {
                        msg.put("msg","Se agrego")
                        out.print(msg);
                        out.flush();
                    } else {
                        msg.put("msg","Error al agregar")
                        out.print(msg);
                        out.flush();
                    }
                break;
            case "/updateLibro":
                System.out.println("updateLibro");
                break;
            case "/deleteLibro":
                String matricula = request.getParameter("id") != null ? request.getParameter("id") : "";
                System.out.println("hola"+matricula);
                int matriculaInt = 0;
                try{ matriculaInt = Integer.parseInt(matricula);
                }catch (Exception e){
                    msg.put("msg", "Introduce un numero");
                    out.print(msg);
                    out.flush();
                    break;
                }
                if (serviceLibro.deleteLibro(matriculaInt)) {
                    msg.put("msg", "Se elimino correctamente");
                    out.print(msg);
                    out.flush();
                } else {
                    msg.put("msg", Mensajes.noexiste);
                    out.print(msg);
                    out.flush();
                }
                System.out.println("deleteLibro");
                break;

        }
    }
}

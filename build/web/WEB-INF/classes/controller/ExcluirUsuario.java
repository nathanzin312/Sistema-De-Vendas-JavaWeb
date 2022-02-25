
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioModel;
import Entidade.Usuarios;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "ExcluirUsuario", urlPatterns = {"/ExcluirUsuario"})
public class ExcluirUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int id=Integer.parseInt(request.getParameter("id"));
          UsuarioModel m= new UsuarioModel();
          Usuarios u= m.getUsuario(id);
          m.removeUsuario(u);
          response.sendRedirect("index.html");
    }

}

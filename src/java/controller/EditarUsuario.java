/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioModel;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id= Integer.parseInt(request.getParameter("id"));
            UsuarioModel m=new UsuarioModel();
            Usuarios u= m.getUsuario(id);
            request.setAttribute("usuario",u);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             int id=Integer.parseInt(request.getParameter("id"));
             String nome=request.getParameter("usuario");
             String senha=request.getParameter("senha");
             int idade=Integer.parseInt(request.getParameter("idade"));
             Usuarios nu=new Usuarios(id,nome,senha,idade);
             UsuarioModel m=new UsuarioModel();
             m.alterarUsuario(nu, id);
             response.sendRedirect("index.html");
    }

}

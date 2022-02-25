/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidade.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioModel;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        Usuarios u = new Usuarios(nome, senha);
        UsuarioModel m = new UsuarioModel();
        Usuarios r = m.validarUsuario(u);
        if (r != null) {    
            HttpSession session = request.getSession(true);
            session.setAttribute("logado", r);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.html");
      }
    }

        
}

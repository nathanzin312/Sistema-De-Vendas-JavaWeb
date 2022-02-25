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


@WebServlet(name = "AdicionarUsuario", urlPatterns = {"/AdicionarUsuario"})
public class AdicionarUsuario extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.getRequestDispatcher("cadastroUsuario.jsp")
                .forward(request, response);
        }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nome=request.getParameter("usuario");
            String senha=request.getParameter("senha");
            int idade=Integer.parseInt(request.getParameter("idade"));
            Usuarios novoUsuario= new Usuarios(nome,senha,idade);
            UsuarioModel m = new UsuarioModel();
            Usuarios r=m.validarUsuario(novoUsuario);
            if(r!=null){
                System.out.println("usuarios ja cadastrado");
                request.setAttribute("variavelRequestMsgErro", "Usuario e senha invalidos");
                response.sendRedirect("/AdicionarUsuario");
            }
            else{
              m.adicionarUsuario(novoUsuario);
              response.sendRedirect("home.jsp");  
            }
             

    }
}

package controller;

import Entidade.Produtos;
import Entidade.Registros;
import entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProdutosModel;
import model.RegistroModel;
import model.UsuarioModel;

@WebServlet(name = "Pesquisar", urlPatterns = {"/Pesquisar"})
public class Pesquisar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        ProdutosModel model = new ProdutosModel();
        ArrayList<Produtos> produtos = model.getProdutos();

        request.setAttribute("oi", produtos);
        request.getRequestDispatcher("Pesq.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        ArrayList<Registros> retorno = new ArrayList<Registros>();
        Usuarios user = (Usuarios) session.getAttribute("teste");
        int id_usuario = user.getId();  
        int id_prod = Integer.parseInt(request.getParameter("goio"));
        String data_inicial = request.getParameter("data_inicio");
        Date date_inicial = Date.valueOf(data_inicial);
        String data_final = request.getParameter("data_final");
        Date date_final = Date.valueOf(data_final);
        RegistroModel model = new RegistroModel();
        retorno = model.getRegistros(id_prod, id_usuario, date_inicial, date_final);
        
        request.setAttribute("array", retorno);
        request.getRequestDispatcher("ListaPesquisas.jsp").forward(request, response);
        
    }

}

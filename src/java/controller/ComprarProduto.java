/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidade.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProdutosModel;

@WebServlet(name = "ComprarProduto", urlPatterns = {"/ComprarProduto"})
@MultipartConfig(location = "C:/Users/PADRAO/Pictures/uploads_curriculos")
public class ComprarProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("logado") != null){
        ProdutosModel model = new ProdutosModel();
       ArrayList<Produtos> produtos = model.getProdutos();
        
        
        
        
        request.setAttribute("oi", produtos);
        request.getRequestDispatcher("vendaProdutos.jsp").forward(request, response);
        
    }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidade.Arquivo;
import Entidade.Produtos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.ArquivoModel;
import model.ProdutosModel;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "AdicionarProduto", urlPatterns = {"/AdicionarProduto"})
@MultipartConfig(location = "C:/Users/PADRAO/Pictures/uploads_curriculos")
public class AdicionarProduto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("cadastroProduto.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        Arquivo ret = new Arquivo();
        Part filePart;
        
        filePart = request.getPart("upload");  
        String foto_nome1 = UUID.randomUUID().toString();
        String foto_nome = foto_nome1 + ".jpg";
        filePart.write(foto_nome);
        Arquivo a = new Arquivo(foto_nome, filePart.getContentType());
        
        ArquivoModel model = new ArquivoModel();
        try {
            model.inserir(a);
            ret = model.seleciona(a);
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        String nome = request.getParameter("nomeProduto");
        float preco = Float.parseFloat(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        Produtos prod = new Produtos(nome, quantidade, preco, ret.getId());
        ProdutosModel models = new ProdutosModel();
        try {
            models.AdicionaProduto(prod);
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("home.jsp");
        
        
        
        
        
        
        
    }


}

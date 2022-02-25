/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidade.Produtos;
import Entidade.Registros;
import Entidade.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
import model.RegistroModel;

@WebServlet(name = "AdicionarCarrinho", urlPatterns = {"/AdicionarCarrinho"})
public class AdicionarCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id_prod = Integer.parseInt(request.getParameter("id"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String nome = request.getParameter("nome");
        String teste = request.getParameter("goio");
        float valor = Float.parseFloat(request.getParameter("valor"));
        ProdutosModel model = new ProdutosModel();
        int quantidade_atual = model.getQuantidade(id_prod);

        ArrayList<Registros> carrinho = new ArrayList<>();

        if (session.getAttribute("carrinho") != null) {
            if (quantidade <= quantidade_atual) {

                int quant_final = quantidade_atual - quantidade;
                model.setQuantidade(quant_final, id_prod);
                Usuarios u = (Usuarios) session.getAttribute("teste");
                LocalDate data = LocalDate.now();
                float valor_compra = valor * quantidade;
                Registros compra = new Registros(u.getId(), id_prod, data, quantidade, valor_compra, nome);
                ArrayList<Registros> carrinhos = (ArrayList<Registros>) session.getAttribute("carrinho");
                carrinhos.add(compra);
                session.setAttribute("carrinho", carrinhos);
                System.out.println("aqui é o teste1 " + carrinhos.size());
                System.out.println("aqui é o teste1 " + carrinhos.size());
                System.out.println("aqui é o teste1 " + carrinhos.size());

            }
            else{
            
                System.out.println("Deu errooo");
                System.out.println("Deu errooo");
                System.out.println("Deu errooo");
            
            }
        } else {
            int quant_final = quantidade_atual - quantidade;
            model.setQuantidade(quant_final, id_prod);
            Usuarios u = (Usuarios) session.getAttribute("teste");
            LocalDate data = LocalDate.now();
            float valor_compra = valor * quantidade;
            Registros compra = new Registros(u.getId(), id_prod, data, quantidade, valor_compra, nome);
            carrinho.add(compra);
            session.setAttribute("carrinho", carrinho);

        }
        response.sendRedirect("ComprarProduto");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        ArrayList<Registros> carrinho = (ArrayList<Registros>) session.getAttribute("carrinho");
        RegistroModel model = new RegistroModel();
        model.insertRegistros(carrinho);

        carrinho.size();

    }

}

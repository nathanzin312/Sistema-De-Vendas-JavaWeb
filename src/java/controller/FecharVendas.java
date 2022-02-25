package controller;

import Entidade.Registros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RegistroModel;

@WebServlet(name = "FecharVendas", urlPatterns = {"/FecharVendas"})
public class FecharVendas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Registros> carrinho = (ArrayList<Registros>) session.getAttribute("carrinho");

        float total = 0;

        for (int i = 0; i < carrinho.size(); i++) {

            total = total + carrinho.get(i).getValor();

        }

        session.setAttribute("valor", total);
        request.setAttribute("total", total);
        request.setAttribute("oi", carrinho);
        request.getRequestDispatcher("FecharVenda.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        float valor_informado = Float.parseFloat(request.getParameter("quantidade"));
        HttpSession session = request.getSession(false);
        ArrayList<Registros> carrinho = (ArrayList<Registros>) session.getAttribute("carrinho");
        float valor_compra = (float) session.getAttribute("valor");

        float troco = 0;

        if (valor_informado >= valor_compra) {
            RegistroModel model = new RegistroModel();
            model.insertRegistros(carrinho);
            troco = valor_informado - valor_compra;
            carrinho.clear();
            request.setAttribute("troco", troco);
            request.getRequestDispatcher("CompraSucesso.jsp").forward(request, response);

        } else {
            System.out.println("Valor inválido");
            System.out.println("Valor inválido");
            System.out.println("Valor inválido");
        }

    }
}

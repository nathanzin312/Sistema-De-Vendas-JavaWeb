
package Filters;

import Entidade.Registros;
import Entidade.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "Autenticacao", urlPatterns = {"/AdicionarCarrinho", "/ComprarProduto", "/Pesquisar" })
public class Autenticacao implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1 ;
        HttpSession session = request.getSession(false);
         if (session != null && session.getAttribute("logado") != null){
             Usuarios usuario = (Usuarios) session.getAttribute("logado");
             session.setAttribute("teste", usuario);
             fc.doFilter(sr, sr1);
         
         }
         else{
            response.sendRedirect("index.html");
         }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

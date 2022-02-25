/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidade.Arquivo;
import dao.ArquivoDAO;
import java.sql.SQLException;


public class ArquivoModel {
    
    public void inserir(Arquivo a) throws SQLException {
       ArquivoDAO dao = new ArquivoDAO();
       dao.inserir(a);
    }
    
    public Arquivo seleciona (Arquivo a) throws SQLException {
        
       ArquivoDAO dao = new ArquivoDAO();
       Arquivo retorno = dao.selecionar(a);
       return retorno;
    
    }
    
}

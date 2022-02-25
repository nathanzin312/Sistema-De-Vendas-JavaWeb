
package model;

import Entidade.Produtos;
import dao.produtosDao;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosModel {
    
    public void AdicionaProduto (Produtos p) throws SQLException{
    
        produtosDao prod = new produtosDao();
        prod.adicionar(p);
    
    
    }
    public ArrayList<Produtos> getProdutos(){
     produtosDao dao = new produtosDao();
        return dao.getProdutos();
    }
    
    public int getQuantidade(int id){
     produtosDao dao = new produtosDao();
        return dao.getQuantidade(id);
    }
    
    public void setQuantidade(int quant, int id){
     produtosDao dao = new produtosDao();
     dao.setQuantidade(quant, id);
    }
    
    
}

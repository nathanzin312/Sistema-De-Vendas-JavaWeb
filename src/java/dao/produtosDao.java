
package dao;
import Entidade.Produtos;
import java.sql.PreparedStatement;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class produtosDao {
    
    public void adicionar(Produtos p) throws SQLException{
        String sql="INSERT INTO PRODUTO (NOME, QUANTIDADE, PRECO, ID_FOTO) VALUES(?,?,?,?)";
        try(Connection con = new ConnectionFactory().getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,p.getNome());
            stmt.setInt(2, p.getQuantidade());
            stmt.setFloat(3,p.getPreco());
            stmt.setInt(4, p.getId_foto());
            stmt.execute();
            stmt.close();
            con.close();
         }catch (SQLException ex) {
            Logger.getLogger(produtosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Produtos> getProdutos(){
        
        
            ArrayList<Produtos> retorno = new ArrayList<Produtos>();
            
            
            
           try {
            String sql = "SELECT ID, NOME, QUANTIDADE, PRECO, ID_FOTO FROM PRODUTO";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                int quantidade = rs.getInt("QUANTIDADE");
                float preco = rs.getFloat("PRECO");
                int id_foto = rs.getInt("ID_FOTO");
                Produtos l = new Produtos(id, nome, quantidade, preco, id_foto);
                retorno.add(l);
            }
            con.close();
   
        } catch (SQLException ex) {
            Logger.getLogger(produtosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return retorno;
}
    
    public int getQuantidade(int id){
           int retorno = 0;
            
        try {
            String sql = "SELECT QUANTIDADE FROM PRODUTO WHERE ID = ?";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                retorno = rs.getInt("QUANTIDADE");
            }

            con.close();
       
        } catch (SQLException ex) {
            Logger.getLogger(produtosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
}
    public void setQuantidade( int quant, int id){

        
        try {
            String sql = "UPDATE PRODUTO SET QUANTIDADE = ? WHERE ID = ?";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, quant);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(produtosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
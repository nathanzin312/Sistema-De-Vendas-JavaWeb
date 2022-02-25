
package dao;

import Entidade.Arquivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConnectionFactory;


public class ArquivoDAO {
    
     public void inserir(Arquivo a) throws SQLException{
        String sql = "INSERT INTO ARQUIVO (NOME, CONTENTTYPE) VALUES (?,?)";
        Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, a.getNome());        
        stmt.setString(2, a.getContentType());
        
        stmt.execute();
        
        stmt.close();
     }
       
     public Arquivo selecionar(Arquivo a) throws SQLException{
        String sql = "SELECT ID, NOME, CONTENTTYPE FROM ARQUIVO WHERE NOME = ?";
        
        Connection conexao = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, a.getNome());
        
        ResultSet rs = stmt.executeQuery();
    
        while(rs.next()){
            a.setId(rs.getInt("ID"));
            a.setNome(rs.getString("NOME"));
            a.setContentType(rs.getString("CONTENTTYPE"));
        }
        
        stmt.close();
        conexao.close();
        return a;
    }
}

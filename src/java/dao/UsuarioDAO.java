
package dao;

import entidades.Usuarios;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    
   public void adicionar(Usuarios user){
        
       try {
           String sql = "INSERT INTO USUARIO (NOME, SENHA, IDADE) VALUES (?,?,?)";
           
           Connection con = new ConnectionFactory().getConnection() ;
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, user.getNome());
           stmt.setString(2, user.getSenha());
           stmt.setInt(3, user.getIdade());
           stmt.execute();
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }   
    }
    public ArrayList<Usuarios> getUsuarios(){
        
        ArrayList<Usuarios> retorno = new ArrayList<>();
    
        try {
            String sql = "SELECT ID, NOME, SENHA, IDADE FROM USUARIO";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                String senha = rs.getString("SENHA");
                int idade = rs.getInt("IDADE");
                Usuarios u = new Usuarios(id, nome,senha, idade);
                retorno.add(u);
            }
            con.close();
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return retorno;
    }
   

 public Usuarios getUsuario(int id){
           Usuarios retorno = null;  
          try {
           String sql = "SELECT ID, NOME, SENHA, IDADE FROM USUARIO WHERE NOME = ?";
           Connection con = new ConnectionFactory().getConnection();
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();
           
           while (rs.next()){
               int id_2 = rs.getInt("ID");
               String nome = rs.getString("NOME");
               String senha = rs.getString("SENHA");
               int idade = rs.getInt("IDADE");
               retorno = new Usuarios(id_2, nome,senha,idade);
           }
           con.close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return retorno;
    }
 
   public void alterar(Usuarios u, int id){

        
       try {
           String sql = "UPDATE USUARIO SET NOME = ?,SENHA = ?, IDADE = ? WHERE ID = ?";
           Connection con = new ConnectionFactory().getConnection();
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, u.getNome());
           stmt.setString(2, u.getSenha());
           stmt.setInt(3, u.getIdade());
           stmt.setInt(4, id);
           stmt.execute();
           stmt.close();
           con.close();
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   public void remover(Usuarios usuario){  
       
       
       try {
           String sql = "DELETE FROM USUARIO WHERE ID = ?";
           Connection con = new ConnectionFactory().getConnection();
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, usuario.getId());
           stmt.execute();
           stmt.close();
           con.close();
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }    
   }   
   
   public Usuarios autenticarUsuario(Usuarios usuario){
   
       
           Usuarios retorno = null;
         try {
           String sql = "SELECT ID, NOME, SENHA, IDADE FROM USUARIO WHERE NOME = ? AND SENHA = ?";
           Connection con = new ConnectionFactory().getConnection();
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, usuario.getNome());
           stmt.setString(2, usuario.getSenha());
           ResultSet rs = stmt.executeQuery();
           
           while (rs.next()){
               int id_2 = rs.getInt("ID");
               String nome = rs.getString("NOME");
               String senha = rs.getString("SENHA");
               int idade = rs.getInt("IDADE");
               retorno = new Usuarios(id_2, nome,senha, idade );
           }
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
       }   
    return retorno;
   }  
}

   


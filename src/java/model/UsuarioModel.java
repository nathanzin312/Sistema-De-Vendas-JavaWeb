
package model;

import dao.UsuarioDAO;
import entidades.Usuarios;
import java.util.ArrayList;
public class UsuarioModel {
     public ArrayList<Usuarios> getUsuarios(){
     UsuarioDAO dao = new UsuarioDAO();
        return dao.getUsuarios();
    }
    public Usuarios getUsuario(int id){
        UsuarioDAO dao = new UsuarioDAO();
        return dao.getUsuario(id);
        }
    
    public void adicionarUsuario(Usuarios u){
            UsuarioDAO dao = new UsuarioDAO();
            dao.adicionar(u);
    }
    
    public void alterarUsuario(Usuarios nu, int id){
     UsuarioDAO dao = new UsuarioDAO();
      dao.alterar(nu, id);
    }
    
    public void removeUsuario(Usuarios u){
        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(u);
    }
    
    public Usuarios validarUsuario(Usuarios usuario){  
        UsuarioDAO dao = new UsuarioDAO();
        Usuarios u = dao.autenticarUsuario(usuario);
    
        if(u != null){
            return u;
        }
        else{
            return null;
        }
    
    }
    
}


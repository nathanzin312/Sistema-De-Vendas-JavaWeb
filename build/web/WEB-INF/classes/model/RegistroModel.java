package model;

import Entidade.Registros;
import dao.RegistroDAO;
import java.sql.Date;
import java.util.ArrayList;

public class RegistroModel {

    public void insertRegistros(ArrayList<Registros> registro) {

        RegistroDAO dao = new RegistroDAO();
        dao.insertRegistro(registro);

    }
    
   public ArrayList<Registros> getRegistros(int id, int id_usuario, Date data1, Date data2) {
       
       ArrayList<Registros> retorno = new ArrayList<Registros>();
       RegistroDAO dao = new RegistroDAO();
       retorno = dao.getRegistros(id, id_usuario, data1, data2);
       
       return retorno;
   }
}

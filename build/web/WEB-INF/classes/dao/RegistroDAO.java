package dao;

import Entidade.Registros;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionFactory;

/**
 *
 * @author PADRAO
 */
public class RegistroDAO {

    public void insertRegistro(ArrayList<Registros> registro) {
        try {

            for (int i = 0; i < registro.size(); i++) {

                String sql = "INSERT INTO REGISTRO (ID_USUARIO, ID_PRODUTO, DATAS, QUANTIDADE, VALOR, NOME) VALUES (?,?,?,?,?,?)";

                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, registro.get(i).getId_usuario());
                stmt.setInt(2, registro.get(i).getProduto());
                LocalDate l_date = registro.get(i).getData();
                Date data = Date.valueOf(l_date);
                stmt.setDate(3, (java.sql.Date) data);
                stmt.setInt(4, registro.get(i).getQuantP());
                stmt.setFloat(5, registro.get(i).getValor());
                stmt.setString(6, registro.get(i).getNome_prod());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Registros> getRegistros(int id, int id_usuario, Date data1, Date data2) {

        ArrayList<Registros> retorno = new ArrayList<Registros>();
        try {
            String sql = "SELECT ID, DATAS, QUANTIDADE, VALOR, NOME FROM REGISTRO WHERE ID_PRODUTO = ? AND DATAS >= ? AND DATAS =< ?";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setDate(2, data1);
            stmt.setDate(3, data2);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_2 = rs.getInt("ID");
                Date data_ret = rs.getDate("DATAS");
                LocalDate date_loc = data_ret.toLocalDate();
                int quantidade = rs.getInt("QUANTIDADE");
                float valor = rs.getFloat("VALOR");
                String nome = rs.getString("NOME");
                Registros ret = new Registros(id_2, date_loc, quantidade, valor, nome);
                retorno.add(ret);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}

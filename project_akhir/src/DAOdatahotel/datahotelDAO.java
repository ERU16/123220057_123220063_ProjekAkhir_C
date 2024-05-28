/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatahotel;
import java.sql.*;
import java.util.*;
import koneksi.konektor;
import model.*;
import DAOImplement.datahotelimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bagus Duta Prasetya
 */
public class datahotelDAO implements datahotelimplement{
    Connection connection;
   
    final String select = "select * from pemesanan;";
    final String insert = "INSERT INTO pemesanan (id_pemesanan, nama_pemesan, no_hp, no_kamar, type_kamar, lama_menginap, harga) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String update = "update pemesanan set nama_pemesan=?, no_hp=?, no_kamar=?, type_kamar=?, lama_menginap=?, harga=? where id_pemesanan=?";
    final String delete = "DELETE FROM pemesanan where id_pemesanan=?";
    final String search = "SELECT * FROM pemesanan WHERE nama_pemesan like ?";

    public datahotelDAO(){
        connection = konektor.connection();
    }
    
    
    @Override
    public void insert(datahotel h) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, h.getId());
            statement.setString(2, h.getNama());
            statement.setString(3, h.getNo_hp());
            statement.setInt(4, h.getNo_kamar());
            statement.setString(5, h.getType());
            statement.setInt(6, h.getLama());
            statement.setInt(7, h.getHarga()); 
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datahotel h) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, h.getNama());
            statement.setString(2, h.getNo_hp());
            statement.setInt(3, h.getNo_kamar());
            statement.setString(4, h.getType());
            statement.setInt(5, h.getLama());
            statement.setInt(6, h.getHarga()); 
            statement.setInt(7, h.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datahotel> getAll() {
        List<datahotel> dh = null;
        try{
            dh = new ArrayList<datahotel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datahotel ht = new datahotel();
                ht.setId(rs.getInt("id_pemesanan"));
                ht.setNama(rs.getString("nama_pemesan"));
                ht.setNo_hp(rs.getString("no_hp"));
                ht.setNo_kamar(rs.getInt("no_kamar"));
                ht.setType(rs.getString("type_kamar"));
                ht.setLama(rs.getInt("lama_menginap"));
                ht.setHarga(rs.getInt("harga"));
                dh.add(ht);
            }
        }catch(SQLException ex){
            Logger.getLogger(datahotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dh;
    }

    @Override
    public List<datahotel> cari(String x) {
        PreparedStatement statement = null;
        List<datahotel> dhl = null;
        try{
            dhl = new ArrayList<datahotel>();
            statement = connection.prepareStatement(search);
            statement.setString(1, "%"+x+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                datahotel ht = new datahotel();
                ht.setId(rs.getInt("id_pemesanan"));
                ht.setNama(rs.getString("nama_pemesan"));
                ht.setNo_hp(rs.getString("no_hp"));
                ht.setNo_kamar(rs.getInt("no_kamar"));
                ht.setType(rs.getString("type_kamar"));
                ht.setLama(rs.getInt("lama_menginap"));
                ht.setHarga(rs.getInt("harga"));
                dhl.add(ht);
            }
        }catch(SQLException ex){
            Logger.getLogger(datahotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dhl;
    }
}
    



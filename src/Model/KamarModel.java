package Model;

import Helper.KoneksiData;
import java.sql.Connection;
import Entity.KamarEntity;
import java.sql.*;
import java.util.ArrayList;
public class KamarModel {
    private String sql;
    public Connection conn = KoneksiData.getconection();
    public ArrayList<KamarEntity> getKamar(){
        ArrayList<KamarEntity> arraylistKamar = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kamar";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                KamarEntity kamar = new KamarEntity();
                kamar.setId(rs.getInt("id_kamar"));
                kamar.setNama_kamar(rs.getString("nama_kamar"));
                kamar.setUkuran(rs.getString("ukuran_kamar"));
                kamar.setKet_kamar(rs.getString("fasilitas_kamar"));
                kamar.setStatus(rs.getInt("status"));
                arraylistKamar.add(kamar);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistKamar;
    }
    
    public ArrayList<KamarEntity> getIDK(){
        ArrayList<KamarEntity> arraylistKamar = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT id_kamar, nama_kamar FROM kamar";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                KamarEntity kamar = new KamarEntity();
                kamar.setId(rs.getInt("id_kamar"));
                kamar.setNama_kamar(rs.getString("nama_kamar"));
                arraylistKamar.add(kamar);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistKamar;
    }
    
    public ArrayList<KamarEntity>getIdKamar(int id){
        ArrayList<KamarEntity> arraylistKamar = new ArrayList<>();
        try {
            sql = "SELECT * FROM kamar WHERE id_kamar=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                KamarEntity kamar = new KamarEntity();
                kamar.setId(rs.getInt("id_kamar"));
                kamar.setNama_kamar(rs.getString("nama_kamar"));
                kamar.setUkuran(rs.getString("ukuran_kamar"));
                kamar.setKet_kamar(rs.getString("ket_kamar"));
                kamar.setStatus(rs.getInt("status"));
                arraylistKamar.add(kamar);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistKamar;
    }

    public void insertData(KamarEntity Kamar) {
        try {
            sql = "INSERT INTO kamar (nama_kamar, ukuran_kamar, fasilitas_kamar, status) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Kamar.getNama_kamar());
            stat.setString(2, Kamar.getUkuran());
            stat.setString(3, Kamar.getKet_kamar());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }

    public void updateNamaKamar(String nama, int id) {
        try {
            sql = "update kamar SET nama_kamar =? WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    
    public void updateUkuranKamar(String ukuran_kamar, int id) {
        try {
            sql = "update kamar SET ukuran_kamar =? WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,ukuran_kamar);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateKetKamar(String fasilitas_kamar, int id) {
        try {
            sql = "update kamar SET ket_kamar =? WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,fasilitas_kamar);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
    
    public int cekVerif(int id) {
        int cek = 0;
        try {
            sql = "SELECT * FROM kamar WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("status");
            }else{
                cek = 0;
            }
        } catch (SQLException e) {
            System.out.println("Gagal !!!");
            e.printStackTrace();
        }
        return cek;
    }
}

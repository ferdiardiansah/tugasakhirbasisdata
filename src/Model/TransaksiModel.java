package Model;

import Helper.KoneksiData;
import java.sql.Connection;
import Entity.TransaksiEntity;
import java.sql.*;
import java.util.ArrayList;
public class TransaksiModel {
    private String sql;
    public Connection conn = KoneksiData.getconection();
    public ArrayList<TransaksiEntity> getTransaksi(){
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                TransaksiEntity Transaksi = new TransaksiEntity();
                Transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                Transaksi.setId_pemilik(rs.getString("id_pemilik"));
                Transaksi.setId_kamar(rs.getString("id_kamar"));
                Transaksi.setId_user(rs.getString("id_user"));
                Transaksi.setTgl_transaksi(rs.getString("tgl_transaksi"));
                Transaksi.setLama_sewa(rs.getString("lama_sewa"));
                Transaksi.setHarga_sewa(rs.getString("harga_sewa"));
                Transaksi.setTotal_harga(rs.getString("total_harga"));
                arraylistTransaksi.add(Transaksi);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistTransaksi;
    }
    
    public ArrayList<TransaksiEntity>getTransaksi(int id){
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try {
            sql = "SELECT * FROM transaksi WHERE id_transaksi=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                TransaksiEntity Transaksi = new TransaksiEntity();
                Transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                Transaksi.setId_pemilik(rs.getString("id_pemilik"));
                Transaksi.setId_kamar(rs.getString("id_kamar"));
                Transaksi.setId_user(rs.getString("id_user"));
                Transaksi.setTgl_transaksi(rs.getString("tgl_transaksi"));
                Transaksi.setLama_sewa(rs.getString("lama_sewa"));
                Transaksi.setHarga_sewa(rs.getString("harga_sewa"));
                Transaksi.setTotal_harga(rs.getString("total_harga"));
                arraylistTransaksi.add(Transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistTransaksi;
    }

    public void insertData(TransaksiEntity Transaksi) {
        try {
            sql = "INSERT INTO transaksi (id_pemilik, id_kamar, id_user, tgl_transaksi, lama_sewa, harga_sewa, total_harga) Values(?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Transaksi.getId_pemilik());
            stat.setString(2, Transaksi.getId_kamar());
            stat.setString(3, Transaksi.getId_user());
            stat.setString(4, Transaksi.getTgl_transaksi());
            stat.setString(5, Transaksi.getLama_sewa());
            stat.setString(6, Transaksi.getHarga_sewa());
            stat.setString(7, Transaksi.getTotal_harga());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    
    public void updateIDPemilik(String IDP, int id) {
        try {
            sql = "update transaksi SET id_pemilik =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,IDP);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update ID Pemilik!!!");
            e.printStackTrace();
        }
    }
    
    public void updateIDKamar(String IDK, int id) {
        try {
            sql = "update transaksi SET id_kamar =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,IDK);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update ID Kamar!!!");
            e.printStackTrace();
        }
    }
    
    public void updateIDUser(String IDU, int id) {
        try {
            sql = "update transaksi SET id_kamar =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,IDU);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update ID User!!!");
            e.printStackTrace();
        }
    }

    public void updateTglTransaksi(String Tanggal, int id) {
        try {
            sql = "update transaksi SET tgl_transaksi =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,Tanggal);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Nama!!!");
            e.printStackTrace();
        }
    }
    
    public void updateLamaSewa(String lama_sewa, int id) {
        try {
            sql = "update transaksi SET lama_sewa =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,lama_sewa);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateHargaSewa(String harga_sewa, int id) {
        try {
            sql = "update transaksi SET harga_sewa =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,harga_sewa);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateTotalHarga(String total_harga, int id) {
        try {
            sql = "update transaksi SET total_harga =? WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,total_harga);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public int cekVerif(int id) {
        int cek = 0;
        try {
            sql = "SELECT * FROM transaksi WHERE id_transaksi =?";
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

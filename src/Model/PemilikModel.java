package Model;

import Entity.PemilikEntity;
import java.sql.*;
import java.util.ArrayList;

public class PemilikModel extends ModelAbstract{
    private String sql;
    public ArrayList<PemilikEntity> getPemilik(){
        ArrayList<PemilikEntity> arraylistPemilik = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pemilik";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PemilikEntity pemilik = new PemilikEntity();
                pemilik.setId(rs.getInt("id_pemilik"));
                pemilik.setNama(rs.getString("nama_pemilik"));
                pemilik.setPassword(rs.getString("password"));
                pemilik.setNoTelp(rs.getString("noTelp"));
                pemilik.setAlamat(rs.getString("alamat"));
                arraylistPemilik.add(pemilik);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistPemilik;
    }
    
    public ArrayList<PemilikEntity> getPemilikU(){
        ArrayList<PemilikEntity> arraylistPemilik = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pemilik";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PemilikEntity pemilik = new PemilikEntity();
                pemilik.setId(rs.getInt("id_pemilik"));
                pemilik.setNama(rs.getString("nama_pemilik"));
                pemilik.setNoTelp(rs.getString("noTelp"));
                pemilik.setAlamat(rs.getString("alamat"));
                arraylistPemilik.add(pemilik);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistPemilik;
    }
    
    public ArrayList<PemilikEntity> getIDP(){
        ArrayList<PemilikEntity> arraylistPemilik = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT id_pemilik, nama_pemilik FROM pemilik";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PemilikEntity pemilik = new PemilikEntity();
                pemilik.setId(rs.getInt("id_pemilik"));
                pemilik.setNama(rs.getString("nama_pemilik"));
                arraylistPemilik.add(pemilik);
            }
        }catch (SQLException e){
             System.out.println(e);
        }
        return arraylistPemilik;
    }
    
    public ArrayList<PemilikEntity>getIdPemilik(int id){
        ArrayList<PemilikEntity> arraylistPemilik = new ArrayList<>();
        try {
            sql = "SELECT * FROM pemilik WHERE id_pemilik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PemilikEntity pemilik = new PemilikEntity();
                pemilik.setId(rs.getInt("id_pemilik"));
                pemilik.setNama(rs.getString("nama_pemilik"));
                pemilik.setPassword(rs.getString("password"));
                pemilik.setNoTelp(rs.getString("noTelp"));
                pemilik.setAlamat(rs.getString("alamat"));
                arraylistPemilik.add(pemilik);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistPemilik;
    }
    public void insertData(PemilikEntity pemilik) {
        try {
            sql = "INSERT INTO pemilik (nama, password, alamat, notelp) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, pemilik.getNama());
            stat.setString(2, pemilik.getPassword());
            stat.setString(3, pemilik.getAlamat());
            stat.setString(4, pemilik.getNoTelp());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
                System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNama(String nama, int id) {
        try {
            sql = "update pemilik SET nama =? WHERE id_pemilik =?";
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
    
    public void updatePassword(String password, int id) {
        try {
            sql = "update pemilik SET password =? WHERE id_pemilik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,password);
            stat.setInt(2, id);
            stat.executeUpdate();
        }catch (SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String noTelp, int id) {
        try {
            sql = "update pemilik SET noTelp =? WHERE id_pemilik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
    
    public void updateAlamat(String alamat, int id) {
        try {
            sql = "update pemilik SET alamat =? WHERE id_pemilik =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,alamat);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
    
    public int ceklogin(String nama, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM pemilik WHERE nama =? and password=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("id_pemilik");
            }else{
                cek = 0;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }
    
    public void verifUser(int id) {
        try {
            sql = "update user SET status = 1 WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void unverifUser(int id) {
        try {
            sql = "update user SET status = 0 WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void verifKamar(int id) {
        try {
            sql = "update kamar SET status = 1 WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void unverifKamar(int id) {
        try {
            sql = "update kamar SET status = 0 WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteDataUser(int id) {
        try {
            sql = "DELETE FROM user WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL HAPUS DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void deleteDataKamar(int id) {
        try {
            sql = "DELETE FROM kamar WHERE id_kamar =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL HAPUS DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void deleteTransaksi(int id) {
        try {
            sql = "DELETE FROM transaksi WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL HAPUS DATA!!!");
            e.printStackTrace();
        }
    }

    @Override
    public int cekLogin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

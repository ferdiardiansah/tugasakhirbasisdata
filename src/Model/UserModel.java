package Model;

import Entity.UserEntity;
import java.sql.*;
import java.util.ArrayList;
public class UserModel extends ModelAbstract{
    private String sql;
    public ArrayList<UserEntity> getUser(){
        ArrayList<UserEntity> arraylistUser = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                UserEntity User = new UserEntity();
                User.setId(rs.getInt("id_user"));
                User.setNama(rs.getString("nama_user"));
                User.setPassword(rs.getString("password"));
                User.setNoTelp(rs.getString("notelp"));
                User.setAlamat(rs.getString("alamat"));
                User.setJenis_kelamin(rs.getString("jenis_kelamin"));
                User.setStatus(rs.getInt("status"));
                arraylistUser.add(User);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistUser;
    }
    
    public ArrayList<UserEntity> getIDU(){
        ArrayList<UserEntity> arraylistUser = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT id_user, nama_user, status FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                UserEntity User = new UserEntity();
                User.setId(rs.getInt("id_user"));
                User.setNama(rs.getString("nama_user"));
                User.setStatus(rs.getInt("status"));
                arraylistUser.add(User);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
            return arraylistUser;
    }
    
    public ArrayList<UserEntity>getIdUser(int id){
        ArrayList<UserEntity> arraylistUser = new ArrayList<>();
        try {
            sql = "SELECT * FROM user WHERE id_user=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                UserEntity User = new UserEntity();
                User.setId(rs.getInt("id_user"));
                User.setNama(rs.getString("nama_user"));
                User.setPassword(rs.getString("password"));
                User.setNoTelp(rs.getString("notelp"));
                User.setAlamat(rs.getString("alamat"));
                User.setJenis_kelamin(rs.getString("jenis_kelamin"));
                User.setStatus(rs.getInt("status"));
                arraylistUser.add(User);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistUser;
    }

    public void insertData(UserEntity User) {
        try {
            sql = "INSERT INTO user (nama_user, password, no_telp, alamat, Jenis_kelamin) Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, User.getNama());
            stat.setString(2, User.getPassword());
            stat.setString(3, User.getNoTelp());
            stat.setString(4, User.getAlamat());
            stat.setString(5, User.getJenis_kelamin());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }

    public void updateNama(String nama, int id) {
        try {
            sql = "update user SET nama_user =? WHERE id_user =?";
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
            sql = "update user SET password =? WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Password!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String no_telp, int id_user) {
        try {
            sql = "update user SET no_telp =? WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,no_telp);
            stat.setInt(2, id_user);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update NoTelp!!!");
            e.printStackTrace();
        }
    }
    
    public void updateAlamat(String alamat, int id) {
        try {
            sql = "update user SET alamat =? WHERE id_user =?";
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
    
    public void updateJenisKelamin(String jeniskelamin, int id) {
        try {
            sql = "update user SET jenis_kelamin =? WHERE id_user =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,jeniskelamin);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("Gagal Update Username!!!");
            e.printStackTrace();
        }
    }
    
    public int cekLogin(String nama, String password) {
        int cek = 0;
        try {
            sql = "SELECT * FROM user WHERE nama_user =? and password=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("id_user");
                String name= rs.getString("nama_user");
                System.out.println("Selamat Datang "+ name);
            }else{
                cek = 0;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }
    
    public int cekVerif(int id) {
        int cek = 0;
        try {
            sql = "SELECT * FROM user WHERE id_user =?";
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

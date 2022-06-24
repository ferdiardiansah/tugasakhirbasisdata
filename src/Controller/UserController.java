package Controller;

import Entity.UserEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class UserController{
    public void insertData(String nama_user, String password, String no_telp, String alamat, String Jenis_kelamin){
        UserEntity User = new UserEntity();
        User.setNama(nama_user);
        User.setPassword(password);
        User.setNoTelp(no_telp);
        User.setAlamat(alamat);
        User.setJenis_kelamin(Jenis_kelamin);
        AllObjectModel.userModel.insertData(User);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.userModel.updateNama(data, id);
                break;
            case 2 : AllObjectModel.userModel.updatePassword(data, id);
                break;
            case 3 : AllObjectModel.userModel.updateNoTelp(data, id);
                break;
            case 4 : AllObjectModel.userModel.updateAlamat(data, id);
                break;
            case 5 : AllObjectModel.userModel.updateJenisKelamin(data, id);
                break;
        }
    }
    
    public ArrayList<UserEntity> getUser(){
        return AllObjectModel.userModel.getUser();
    }
    
    public ArrayList<UserEntity> getIDU(){
        return AllObjectModel.userModel.getIDU();
    }
    
    public int login(String nama, String password){
        int cek = AllObjectModel.userModel.cekLogin(nama, password);
        return cek;
    }
    
    public ArrayList<UserEntity> getIdUser(int cek){
        return AllObjectModel.userModel.getIdUser(cek);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.userModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarUser(){
    DefaultTableModel dataDaftarUser = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA","NOTELP","ALAMAT","JENIS KELAMIN","STATUS"};
    dataDaftarUser.setColumnIdentifiers(kolom);
    int size=getUser().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.userModel.getUser().get(i).getId();   
        data[1]=AllObjectModel.userModel.getUser().get(i).getNama();
        data[2]=AllObjectModel.userModel.getUser().get(i).getNoTelp();
        data[3]=AllObjectModel.userModel.getUser().get(i).getAlamat();
        data[4]=AllObjectModel.userModel.getUser().get(i).getJenis_kelamin(); 
        data[5]=AllObjectModel.userModel.getUser().get(i).getStatus();
        dataDaftarUser.addRow(data);
    }
    return dataDaftarUser;
  }
    
    public DefaultTableModel daftarIDU(){
    DefaultTableModel dataIDU = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA USER","STATUS"};
    dataIDU.setColumnIdentifiers(kolom);
    int size=getIDU().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.userModel.getUser().get(i).getId();   
        data[1]=AllObjectModel.userModel.getUser().get(i).getNama();
        data[2]=AllObjectModel.userModel.getUser().get(i).getStatus();
        dataIDU.addRow(data);
    }
    return dataIDU;
  }
}


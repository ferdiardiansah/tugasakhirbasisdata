package Controller;

import Entity.PemilikEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class PemilikController{
    public void insertData(String nama, String password, String alamat, String notelp){
        PemilikEntity Pemilik = new PemilikEntity();
        Pemilik.setNama(nama);
        Pemilik.setPassword(password);
        Pemilik.setAlamat(alamat);
        Pemilik.setNoTelp(notelp);
        AllObjectModel.pemilikModel.insertData(Pemilik);
    }
    
    public ArrayList<PemilikEntity> getPemilik(){
        return AllObjectModel.pemilikModel.getPemilik();
    }
    
    public ArrayList<PemilikEntity> getPemilikU(){
        return AllObjectModel.pemilikModel.getPemilikU();
    }
    
    public ArrayList<PemilikEntity> getIDP(){
        return AllObjectModel.pemilikModel.getIDP();
    }
    
    public ArrayList<PemilikEntity> getById(int cek){
        return AllObjectModel.pemilikModel.getIdPemilik(cek);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.pemilikModel.updateNama(data, id);
                break;
            case 2 : AllObjectModel.pemilikModel.updatePassword(data, id);
                break;
            case 3 : AllObjectModel.pemilikModel.updateNoTelp(data, id);
                break;
            case 4 : AllObjectModel.pemilikModel.updateAlamat(data, id);
                break;
        }
    }
    
    public void verifUser(int id){
        AllObjectModel.pemilikModel.verifUser(id);
    }
    
    public void unverifUser(int id){
        AllObjectModel.pemilikModel.unverifUser(id);
    }
    
    public void verifKamar(int id){
        AllObjectModel.pemilikModel.verifKamar(id);
    }
    
    public void unverifKamar(int id){
        AllObjectModel.pemilikModel.unverifKamar(id);
    }
    
    public void DeleteDataUser(int id){
        AllObjectModel.pemilikModel.deleteDataUser(id);
    }
    
    public void DeleteDataKamar(int id){
        AllObjectModel.pemilikModel.deleteDataKamar(id);
    }
    
    public void DeleteTransaksi(int id){
        AllObjectModel.pemilikModel.deleteTransaksi(id);
    }
    
    public int login(String nama, String password) {
        int log = AllObjectModel.pemilikModel.ceklogin(nama, password);
        return log;
    }
    
    public DefaultTableModel daftarPemilik(){
    DefaultTableModel dataDaftarPemilik = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA","NOTELP","ALAMAT"};
    dataDaftarPemilik.setColumnIdentifiers(kolom);
    int size=getPemilik().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.pemilikModel.getPemilik().get(i).getId();    
        data[1]=AllObjectModel.pemilikModel.getPemilik().get(i).getNama();
        data[2]=AllObjectModel.pemilikModel.getPemilik().get(i).getNoTelp();
        data[3]=AllObjectModel.pemilikModel.getPemilik().get(i).getAlamat();
        dataDaftarPemilik.addRow(data);
    }
    return dataDaftarPemilik;
    }
    
    public DefaultTableModel daftarIDPU(){
    DefaultTableModel dataIDP = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA PEMILIK"};
    dataIDP.setColumnIdentifiers(kolom);
    int size=getPemilikU().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.pemilikModel.getPemilik().get(i).getId();    
        data[1]=AllObjectModel.pemilikModel.getPemilik().get(i).getNama();
        dataIDP.addRow(data);
    }
    return dataIDP;
    }
    
    public DefaultTableModel daftarIDP(){
    DefaultTableModel dataIDP = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA PEMILIK"};
    dataIDP.setColumnIdentifiers(kolom);
    int size=getIDP().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.pemilikModel.getPemilik().get(i).getId();    
        data[1]=AllObjectModel.pemilikModel.getPemilik().get(i).getNama();
        dataIDP.addRow(data);
    }
    return dataIDP;
    }
}

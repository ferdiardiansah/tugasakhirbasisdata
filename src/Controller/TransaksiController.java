package Controller;

import Entity.TransaksiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class TransaksiController {
    public void insertData(String id_pemilik, String id_kamar, String id_user, String tgl_transaksi, String lama_sewa, String harga_sewa, String total_harga){
        TransaksiEntity Transaksi = new TransaksiEntity();
        Transaksi.setId_pemilik(id_pemilik);
        Transaksi.setId_kamar(id_kamar);
        Transaksi.setId_user(id_user);
        Transaksi.setTgl_transaksi(tgl_transaksi);
        Transaksi.setLama_sewa(lama_sewa);
        Transaksi.setHarga_sewa(harga_sewa);
        Transaksi.setTotal_harga(total_harga);
        AllObjectModel.transaksiModel.insertData(Transaksi);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.transaksiModel.updateIDPemilik(data, id);
                break;
            case 2 : AllObjectModel.transaksiModel.updateIDKamar(data, id);
                break;
            case 3 : AllObjectModel.transaksiModel.updateIDUser(data, id);
                break;
            case 4 : AllObjectModel.transaksiModel.updateTglTransaksi(data, id);
                break;
            case 5 : AllObjectModel.transaksiModel.updateLamaSewa(data, id);
                break;
            case 6 : AllObjectModel.transaksiModel.updateHargaSewa(data, id);
                break;
            case 7 : AllObjectModel.transaksiModel.updateTotalHarga(data, id);
                break;
        }
    }
    
    public ArrayList<TransaksiEntity> getTransaksi(){
        return AllObjectModel.transaksiModel.getTransaksi();
    }
    
    public ArrayList<TransaksiEntity> getIdTransaksi(int cek){
        return AllObjectModel.transaksiModel.getTransaksi(cek);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.transaksiModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarTransaksi(){
    DefaultTableModel dataDaftarTransaksi = new DefaultTableModel();
    Object[] kolom = {"ID TRANSAKSI","ID PEMILIK","ID KAMAR","ID USER","TGL TRANSAKSI","LAMA SEWA", "HARGA SEWA", "TOTAL HARGA"};
    dataDaftarTransaksi.setColumnIdentifiers(kolom);
    int size=getTransaksi().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[9];
        data[0]=AllObjectModel.transaksiModel.getTransaksi().get(i).getId_transaksi();   
        data[1]=AllObjectModel.transaksiModel.getTransaksi().get(i).getId_pemilik();
        data[2]=AllObjectModel.transaksiModel.getTransaksi().get(i).getId_kamar();
        data[3]=AllObjectModel.transaksiModel.getTransaksi().get(i).getId_user();
        data[4]=AllObjectModel.transaksiModel.getTransaksi().get(i).getTgl_transaksi();
        data[5]=AllObjectModel.transaksiModel.getTransaksi().get(i).getLama_sewa();
        data[6]=AllObjectModel.transaksiModel.getTransaksi().get(i).getHarga_sewa();
        data[7]=AllObjectModel.transaksiModel.getTransaksi().get(i).getTotal_harga();
        dataDaftarTransaksi.addRow(data);
    }
    return dataDaftarTransaksi;
  }
}

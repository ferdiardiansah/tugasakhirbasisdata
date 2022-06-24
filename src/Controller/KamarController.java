package Controller;

import Entity.KamarEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class KamarController {
    public void insertData(String nama_kamar, String ukuran_kamar, String fasilitas_kamar){
        KamarEntity Kamar = new KamarEntity();
        Kamar.setNama_kamar(nama_kamar);
        Kamar.setUkuran(ukuran_kamar);
        Kamar.setKet_kamar(fasilitas_kamar);
        AllObjectModel.kamarModel.insertData(Kamar);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1 : AllObjectModel.kamarModel.updateNamaKamar(data, id);
                break;
            case 2 : AllObjectModel.kamarModel.updateUkuranKamar(data, id);
                break;
            case 3 : AllObjectModel.kamarModel.updateKetKamar(data, id);
                break;
        }
    }
    
    public ArrayList<KamarEntity> getKamar(){
        return AllObjectModel.kamarModel.getKamar();
    }

    public ArrayList<KamarEntity> getIDK(){
        return AllObjectModel.kamarModel.getIDK();
    }
    
    public ArrayList<KamarEntity> getIdKamar(int cek){
        return AllObjectModel.kamarModel.getIdKamar(cek);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.kamarModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarKamar(){
    DefaultTableModel dataDaftarKamar = new DefaultTableModel();
    Object[] kolom = {"ID","NAMA KAMAR","UKURAN KAMAR","KET KAMAR"};
    dataDaftarKamar.setColumnIdentifiers(kolom);
    int size=getKamar().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.kamarModel.getKamar().get(i).getId();   
        data[1]=AllObjectModel.kamarModel.getKamar().get(i).getNama_kamar();
        data[2]=AllObjectModel.kamarModel.getKamar().get(i).getUkuran();
        data[3]=AllObjectModel.kamarModel.getKamar().get(i).getKet_kamar();
        data[4]=AllObjectModel.kamarModel.getKamar().get(i).getStatus();
        dataDaftarKamar.addRow(data);
    }
    return dataDaftarKamar;
  }
    
    public DefaultTableModel daftarIDK(){
    DefaultTableModel dataIDK= new DefaultTableModel();
    Object[] kolom = {"ID","NAMA KAMAR"};
    dataIDK.setColumnIdentifiers(kolom);
    int size=getKamar().size();
    for(int i = 0; i< size ;i++){
        Object []data=new Object[7];
        data[0]=AllObjectModel.kamarModel.getKamar().get(i).getId();   
        data[1]=AllObjectModel.kamarModel.getKamar().get(i).getNama_kamar();
        dataIDK.addRow(data);
    }
    return dataIDK;
  }
}

package Entity;

public class KamarEntity {
    private String nama_kamar, ukuran, fasilitas_kamar;
    private int id, status;
    
    public KamarEntity(){};
    
    public KamarEntity(int id, String nama_kamar, String ukuran, String fasilitas_kamar, int status){
        this.nama_kamar = nama_kamar;
        this.ukuran = ukuran;
        this.fasilitas_kamar = fasilitas_kamar;
        this.status = status;
    }

    public String getNama_kamar() {
        return nama_kamar;
    }

    public void setNama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getKet_kamar() {
        return fasilitas_kamar;
    }

    public void setKet_kamar(String fasilitas_kamar) {
        this.fasilitas_kamar = fasilitas_kamar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
//    public int getStatus() {
//        return status;
//    }

////    public void setStatus(int status) {
////        this.status = status;
//    }
//    
    
}

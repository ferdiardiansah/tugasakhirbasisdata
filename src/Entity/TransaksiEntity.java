    package Entity;

public class TransaksiEntity {
    private int id_transaksi;
    private String id_pemilik, id_kamar, id_user;
    private String lama_sewa, harga_sewa, total_harga;
    private String tgl_transaksi;
    
    public TransaksiEntity(){};
    
    public TransaksiEntity(int id_transaksi, String id_pemilik, String id_kamar, String id_user, String tgl_transaksi, String lama_sewa, String harga_sewa, String total_harga){
        this.id_transaksi = id_transaksi;
        this.id_pemilik = id_pemilik;
        this.id_kamar = id_kamar;
        this.id_user = id_user;
        this.tgl_transaksi = tgl_transaksi;
        this.lama_sewa = lama_sewa;
        this.harga_sewa = harga_sewa;
        this.total_harga = total_harga;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(String id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getLama_sewa() {
        return lama_sewa;
    }

    public void setLama_sewa(String lama_sewa) {
        this.lama_sewa = lama_sewa;
    }

    public String getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(String harga_sewa) {
        this.harga_sewa = harga_sewa;
    }

    public String getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    
}

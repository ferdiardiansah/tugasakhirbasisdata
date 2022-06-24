package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javafx.scene.image.Image;
public class ComponentGui extends JFrame{
    protected JButton btnregister = new JButton ("REGISTRASI");
    protected JButton btnnotreg = new JButton ("BUAT AKUN ?");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btnback = new JButton("<<LOG OUT");
    protected JButton btnkembali = new JButton("<<BACK");
    protected JButton btnhome = new JButton("^^HOME^^");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnverif = new JButton("VERIF");
    protected JButton btnunverif = new JButton("UNVERIF");
    protected JButton btnubahdata = new JButton("UBAH DATA");
    
    protected JButton btnhitung = new JButton("TOTAL HARGA");
    
    protected JButton btnpesan = new JButton("PESAN KAMAR");
    protected JButton btnkamar = new JButton("TAMBAH KAMAR");
    protected JLabel labelnama_kamar = new JLabel("NAMA KAMAR");
    protected JLabel labelukuran_kamar = new JLabel("UKUR KAMAR");
    protected JLabel labelket_kamar = new JLabel("KET KAMAR");
    protected JTextField fieldnama_kamar  = new JTextField();
    protected JTextField fieldukuran_kamar  = new JTextField();
    protected JTextField fieldket_kamar  = new JTextField();
    protected JButton btnubahnama_kamar = new JButton("ubah");
    protected JButton btnubahukuran_kamar = new JButton("ubah");
    protected JButton btnubahket_kamar = new JButton("ubah");
    
    protected JButton btntambahtransaksi = new JButton("TAMBAH TRANSAKSI");
    protected JButton btntransaksi = new JButton("LIHAT TRANSAKSI");
    protected JLabel labelid_pemilik = new JLabel("ID PEMILIK");
    protected JLabel labelid_kamar = new JLabel("ID KAMAR");
    protected JLabel labelid_user = new JLabel("ID USER");
    protected JLabel labeltgl_transaksi = new JLabel("TGL TRANSAKSI");
    protected JLabel labellama_sewa = new JLabel("LAMA SEWA");
    protected JLabel labelharga_sewa = new JLabel("HARGA SEWA");
    protected JLabel labeltotal_harga = new JLabel("TOTAL HARGA");
    protected JTextField fieldid_pemilik  = new JTextField();
    protected JTextField fieldid_kamar  = new JTextField();
    protected JTextField fieldid_user  = new JTextField();
    protected JTextField fieldtgl_transaksi  = new JTextField();
    protected JTextField fieldlama_sewa  = new JTextField();
    protected JTextField fieldharga_sewa  = new JTextField();
    protected JTextField fieldtotal_harga  = new JTextField();
    protected JButton btnubahid_pemilik = new JButton("ubah");
    protected JButton btnubahid_kamar = new JButton("ubah");
    protected JButton btnubahid_user = new JButton("ubah");
    protected JButton btnubahtgl_transaksi = new JButton("ubah");
    protected JButton btnubahlama_sewa = new JButton("ubah");
    protected JButton btnubahharga_sewa = new JButton("ubah");
    protected JButton btnubahtotal_harga = new JButton("ubah");
    

    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JLabel labelalamat = new JLabel("ALAMAT");
    protected JLabel labeljenis_kelamin = new JLabel("JENIS KELAMIN");

    protected JLabel bingkaigambar = new JLabel();
    protected JTextField fieldnama  = new JTextField();
    protected JPasswordField fieldpassword  = new JPasswordField();
    protected JTextField fieldnotelp  = new JTextField();
    protected JTextField fieldalamat  = new JTextField();
    protected JTextField fieldjenis_kelamin  = new JTextField();

    protected JButton btnubahnama = new JButton("ubah");
    protected JButton btnubahpassword = new JButton("ubah");
    protected JButton btnubahnotelp = new JButton("ubah");
    protected JButton btnubahalamat = new JButton("ubah");
    protected JButton btnubahjenis_kelamin = new JButton("ubah");

    BufferedImage bufferedimage = null;
    java.awt.Image gambarresize;
    void kosong(){
        fieldnama.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
        fieldalamat.setText(null);
        fieldjenis_kelamin.setText(null);
        
        fieldnama_kamar.setText(null);
        fieldukuran_kamar.setText(null);
        fieldket_kamar.setText(null);
        
        fieldid_pemilik.setText(null);
        fieldid_kamar.setText(null);
        fieldid_user.setText(null);
        fieldtgl_transaksi.setText(null);
        fieldlama_sewa.setText(null);
        fieldharga_sewa.setText(null);
        fieldtotal_harga.setText(null);
    }
}

package Gui;

import Entity.TransaksiEntity;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files; 
import java.nio.file.StandardCopyOption; 
import java.util.logging.Level; 
import java.util.logging.Logger;
public class TransakiUDGuI extends ComponentGui{
    int id; 
    String id_pemilik, id_kamar, id_user, tgl_transaksi, lama_sewa,harga_sewa, total_harga;
    
    public TransakiUDGuI(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek) {
        for (TransaksiEntity transaksi : AllObjectController.transaksi.getIdTransaksi(cek)) {
            this.id = transaksi.getId_transaksi();
            this.id_pemilik = transaksi.getId_pemilik();
            this.id_kamar = transaksi.getId_kamar();
            this.id_user = transaksi.getId_user();
            this.tgl_transaksi = transaksi.getTgl_transaksi();
            this.lama_sewa = transaksi.getLama_sewa();
            this.harga_sewa = transaksi.getHarga_sewa();
            this.total_harga = transaksi.getTotal_harga();
        }
        setTitle("MENU TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); 
        setVisible(true);
        
        labelregister.setText("MENU TRANSAKSI");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        btnkembali.setBounds(15,15,80,25);
        btnkembali.setBackground (Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);

        labelid_pemilik.setBounds (20,100,70,25);
        add(labelid_pemilik);
        fieldid_pemilik.setBounds (85,100,50,25);
        fieldid_pemilik.setText(id_pemilik);
        fieldid_pemilik.setEditable(false);
        add(fieldid_pemilik);

        labelid_kamar.setBounds(235,100,70,25);
        add(labelid_kamar);
        fieldid_kamar.setBounds (295,100,50,25);
        fieldid_kamar.setText(id_kamar);
        fieldid_kamar.setEditable(false);
        add(fieldid_kamar);

        labelid_user.setBounds (30,150,80,25);
        add(labelid_user);
        fieldid_user.setBounds(140, 150, 200,25);
        fieldid_user.setText(id_user);
        fieldid_user.setEditable(false);
        add(fieldid_user);
        
        labeltgl_transaksi.setBounds (30,200,100,25);
        add(labeltgl_transaksi);
        fieldtgl_transaksi.setBounds(140, 200, 200,25);
        fieldtgl_transaksi.setText(tgl_transaksi);
        fieldtgl_transaksi.setEditable(false);
        add(fieldtgl_transaksi);
        
        labellama_sewa.setBounds(30,250,100,25);
        add(labellama_sewa);
        fieldlama_sewa.setBounds(140,250,200,25);
        fieldlama_sewa.setText(lama_sewa);
        fieldlama_sewa.setEditable(false);
        add(fieldlama_sewa);
        
        labelharga_sewa.setBounds(30,300,100,25);
        add(labelharga_sewa);
        fieldharga_sewa.setBounds(140,300,200,25);
        fieldharga_sewa.setText(harga_sewa);
        fieldharga_sewa.setEditable(false);
        add(fieldharga_sewa);
        
        labeltotal_harga.setBounds(30,350,100,25);
        add(labeltotal_harga);
        fieldtotal_harga.setBounds(140,350,200,25);
        fieldtotal_harga.setText(total_harga);
        fieldtotal_harga.setEditable(false);
        add(fieldtotal_harga);

        bingkaigambar.setBounds(50,225,150,200);
        add(bingkaigambar);

        btnubahid_pemilik.setBounds(145, 100, 80, 25);
        btnubahid_kamar.setBounds(355,100,80,25);
        btnubahid_user.setBounds(355,150,80,25);
        btnubahtgl_transaksi.setBounds(355,200,80,25);
        btnubahlama_sewa.setBounds(355,250,80,25);
        btnubahharga_sewa.setBounds(355,300,80,25);
        btnubahtotal_harga.setBounds(355,350,80,25);
        add(btnubahid_pemilik);
        add(btnubahid_kamar);
        add(btnubahid_user);
        add(btnubahtgl_transaksi);
        add(btnubahlama_sewa);
        add(btnubahharga_sewa);
        add(btnubahtotal_harga);
        
        btnkembali.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnkembali.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnkembali.setForeground(Color.black);
            }
        });
        btnkembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MenuPemilikTransaksiGui MPTransaksi = new MenuPemilikTransaksiGui(cek);
                MPTransaksi.setVisible(true);
                dispose();
            }
        });
        btnubahid_pemilik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputidp = JOptionPane.showInputDialog("Masukkan ID Pemilik Baru");
                    if(inputidp.length() >0){
                        AllObjectController.transaksi. updateData(1, inputidp,cek);
                        fieldid_pemilik.setText(inputidp);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
        
        btnubahid_kamar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                try {
                    String inputidk = JOptionPane.showInputDialog("Masukkan ID Kamar Baru");
                    if (inputidk.length() > 0){
                        AllObjectController.transaksi.updateData(2, inputidk, cek);
                        fieldid_kamar.setText(inputidk); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahid_user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputidu = JOptionPane. showInputDialog("Masukkan ID User Baru");
                    if(inputidu.length()>0){
                        AllObjectController.transaksi.updateData(3,inputidu, cek);
                        fieldid_user.setText(inputidu);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahtgl_transaksi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputtgl = JOptionPane. showInputDialog("Masukkan TglTransaksi Baru");
                    if(inputtgl.length()>0){
                        AllObjectController.transaksi.updateData(4,inputtgl, cek);
                        fieldtgl_transaksi.setText(inputtgl);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahlama_sewa. addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputlsewa = JOptionPane.showInputDialog("Masukkan Lama Sewa Baru");
                    if (inputlsewa.length() >  0){
                        AllObjectController.transaksi.updateData(5, inputlsewa, cek);
                        fieldlama_sewa.setText(inputlsewa);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahharga_sewa. addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputhsewa = JOptionPane.showInputDialog("Masukkan Harga Sewa Baru");
                    if (inputhsewa.length() >  0){
                        AllObjectController.transaksi.updateData(6, inputhsewa, cek);
                        fieldharga_sewa.setText(inputhsewa);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahtotal_harga. addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputtharga = JOptionPane.showInputDialog("Masukkan Total Harga Baru");
                    if (inputtharga.length() >  0){
                        AllObjectController.transaksi.updateData(7, inputtharga, cek);
                        fieldtotal_harga.setText(inputtharga);
                    }else {
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
     }
}

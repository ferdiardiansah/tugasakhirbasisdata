package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File; 
import java.io.IOException; 
import java.util.logging. Level;
import java.util.logging. Logger;
public class TransaksiGui extends ComponentGui{
    int kode;
    String lama_sewa, harga_sewa,total_harga;
    
    public TransaksiGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENAMBAH TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("MENAMBAH TRANSAKSI");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        labelid_pemilik.setBounds(35, 100, 70, 25);
        add(labelid_pemilik);
        fieldid_pemilik.setBounds(105, 100, 50, 25);
        add(fieldid_pemilik);
        
        labelid_kamar.setBounds(320, 100, 70, 25);
        add(labelid_kamar);
        fieldid_kamar.setBounds(380, 100, 50, 25);
        add(fieldid_kamar);
        
        labelid_user.setBounds(180, 100, 70, 25);
        add(labelid_user);
        fieldid_user.setBounds(240, 100, 50, 25);
        add(fieldid_user);
        
        labeltgl_transaksi.setBounds(35, 150, 100, 25);
        add(labeltgl_transaksi);
        fieldtgl_transaksi.setBounds(140, 150, 290, 25);
        add(fieldtgl_transaksi);
        
        labellama_sewa.setBounds(35, 200, 80, 25);
        add(labellama_sewa);
        fieldlama_sewa.setBounds(140, 200, 290, 25);
        add(fieldlama_sewa);
        
        labelharga_sewa.setBounds(35, 250, 80, 25);
        add(labelharga_sewa);
        fieldharga_sewa.setBounds(140, 250, 290, 25);
        add(fieldharga_sewa);
        
        labeltotal_harga.setBounds(35, 300, 100, 25);
        add(labeltotal_harga);
        fieldtotal_harga.setBounds(140, 300, 290, 25);
        add(fieldtotal_harga);
        
        btnkembali.setBounds(15, 15, 80, 15);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        /*btnhitung.setBounds(60, 380, 100, 25);
        btnhitung.setBorder(null);
        btnhitung.setBackground(Color.black);
        btnhitung.setForeground(Color.white);
        btnhitung.setFocusPainted(false);
        add(btnhitung);*/
        
        btntambahtransaksi.setBounds(160, 380, 140, 25);
        btntambahtransaksi.setBorder(null);
        btntambahtransaksi.setBackground(Color.black);
        btntambahtransaksi.setForeground(Color.white);
        btntambahtransaksi.setFocusPainted(false);
        add(btntambahtransaksi);
        
        btnkembali.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnkembali.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnkembali.setForeground(Color.black);
            }
        });
        
        btnkembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuPemilikTransaksiGui ptransaksi = new MenuPemilikTransaksiGui(kode);
                ptransaksi.setVisible(true);
                dispose();
            }
        });
        
        btnkamar.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnkamar.setForeground(Color.black);
                btnkamar.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnkamar.setForeground(Color.white);
                btnkamar.setBackground(Color.black);
            }
        });
        
        btntambahtransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String id_pemilik = fieldid_pemilik.getText();
                String id_kamar = fieldid_kamar.getText();
                String id_user = fieldid_user.getText();
                String tgl_transaksi = fieldtgl_transaksi.getText();
                 lama_sewa = fieldlama_sewa.getText();
                 harga_sewa = fieldharga_sewa.getText();
                 total_harga = fieldtotal_harga.getText();
                
                int a = Integer.parseInt(lama_sewa);
                int b = Integer.parseInt(harga_sewa);
                int c = Integer.parseInt(total_harga);
                c = a*b;
                
                
                if(id_pemilik.length() != 0 && id_kamar.length() != 0 && id_user.length() != 0 && tgl_transaksi.length() != 0 && lama_sewa.length() != 0 && harga_sewa.length() != 0 && total_harga.length() != 0){
                    AllObjectController.transaksi.insertData(id_pemilik, id_kamar, id_user, tgl_transaksi, lama_sewa, harga_sewa, total_harga);
                    JOptionPane.showMessageDialog(null, " Berhasil Menambahkan Transaksi Baru [Total Harga] = " +total_harga);
                    dispose();
                    new MenuPemilikTransaksiGui(kode).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
        
        /*btnhitung.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Total Harga = " +total_harga);
                TransaksiGui transaksi = new TransaksiGui();
                transaksi.setVisible(true);
                dispose();
            }
        });*/
    }
}

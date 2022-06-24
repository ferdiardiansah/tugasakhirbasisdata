package Gui;

import javax.imageio.ImageIO;
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
public class MenuPemilikPilGui extends ComponentGui{
    JButton btninfokamar = new JButton("INFO KAMAR [TAMBAH, EDIT, HAPUS]");
    JButton btninfotransaksi = new JButton("INFO PELANGGAN [TAMBAH, EDIT, HAPUS TRANSAKSI]");
    JButton btninfoakun = new JButton("INFO AKUN [UBAH DATA]");
    int kode;
    
    public MenuPemilikPilGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("MENU UTAMA PEMILIK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); 
        setVisible(true);
        
        labelregister.setText("MENU UTAMA PEMILIK");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        btnback.setBounds(15, 15, 80, 15);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btninfokamar.setBounds (35,100,395,80);
        btninfokamar.setBackground (Color.CYAN);
        btninfokamar. setForeground (Color.black);
        btninfokamar.setBorder(null); 
        add(btninfokamar);
        
        btninfotransaksi.setBounds (35,200,395,80);
        btninfotransaksi.setBackground (Color.GRAY);
        btninfotransaksi. setForeground (Color.white);
        btninfotransaksi.setBorder(null); 
        add(btninfotransaksi);
        
        btninfoakun.setBounds (35,300,395,80);
        btninfoakun.setBackground (Color.ORANGE);
        btninfoakun. setForeground (Color.black);
        btninfoakun.setBorder(null); 
        add(btninfoakun);
        
        btnback.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LoginPemilikGui loginPemilikGui = new LoginPemilikGui();
                loginPemilikGui.setVisible(true);
                dispose();
            }
        });
        
        btninfokamar.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
            btninfokamar.setForeground(Color.black);
            btninfokamar.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e) {
            btninfokamar. setForeground(Color.black); 
            btninfokamar. setBackground (Color.CYAN); 
            }
        } );
        btninfokamar.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                MenuPemilikKamarGui MKamarGui = new MenuPemilikKamarGui(cek);
                MKamarGui.setVisible(true);
                dispose();
            }
        });
        
        btninfotransaksi.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
            btninfotransaksi.setForeground(Color.black);
            btninfotransaksi.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e) {
            btninfotransaksi. setForeground(Color.black); 
            btninfotransaksi. setBackground (Color.GRAY); 
            }
        } );
        btninfotransaksi.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                MenuPemilikTransaksiGui transaksi = new MenuPemilikTransaksiGui(cek);                        
                transaksi.setVisible(true);
                dispose();
            }
        });
        
        btninfoakun.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
            btninfoakun.setForeground(Color.black);
            btninfoakun.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e) {
            btninfoakun. setForeground(Color.black); 
            btninfoakun. setBackground (Color.ORANGE); 
            }
        } );
        btninfoakun.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) { 
                dispose();
                PemilikUDGui UDpemilikGui = new PemilikUDGui(cek);
                UDpemilikGui.setVisible(true);  
            }
        });
    }
}

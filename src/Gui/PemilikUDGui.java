package Gui;

import Entity.PemilikEntity;
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
public class PemilikUDGui extends ComponentGui{
    int id; 
    String nama, password, notelp, alamat;
    public PemilikUDGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek) {
        for (PemilikEntity Pemilik : AllObjectController.pemilik.getById(cek)) {
            this.id = Pemilik.getId();
            this.nama = Pemilik.getNama();
            this.password = Pemilik.getPassword();
            this.notelp = Pemilik.getNoTelp();
            this.alamat = Pemilik.getAlamat();
        }
        setTitle("BIODATA PEMILIK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); setVisible(true);
        
        labelregister.setText("BIODATA PEMILIK");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        btnkembali.setBounds(15,15,80,15);
        btnkembali.setBackground (Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);

        labelnama.setBounds (35,100,80,25);
        add(labelnama);
        fieldnama.setBounds (140,100,200,25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);

        labelpassword.setBounds(35,150,80,25);
        add(labelpassword);
        fieldpassword.setBounds (140,150,200,25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);

        labelnotelp.setBounds (35,200,80,25);
        add(labelnotelp);
        fieldnotelp.setBounds(140, 200, 200,25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        labelalamat.setBounds (35,250,80,25);
        add(labelalamat);
        fieldalamat.setBounds(140, 250, 200,25);
        fieldalamat.setText(alamat);
        fieldalamat.setEditable(false);
        add(fieldalamat);

        bingkaigambar.setBounds(50,225,150,200);
        add(bingkaigambar);

        btnubahnama.setBounds(350,100, 80, 25);
        btnubahpassword.setBounds(350,150,80,25);
        btnubahnotelp.setBounds(350,200,80,25);
        btnubahalamat.setBounds(350,250,80,25);
        add(btnubahnama);
        add(btnubahpassword);
        add(btnubahnotelp);
        add(btnubahalamat);
        
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
                MenuPemilikPilGui MPPil = new MenuPemilikPilGui(cek);
                MPPil.setVisible(true);
                dispose();
            }
        });
        btnubahnama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukkan Nama Baru");
                    if(inputnama.length() >0){
                        AllObjectController.pemilik. updateData(1, inputnama,cek);
                        fieldnama.setText(inputnama);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
            });
        
        btnubahpassword.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                try {
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if (inputpass.length() > 0){
                        AllObjectController.pemilik.updateData(2, inputpass, cek);
                        fieldpassword.setText(inputpass); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahnotelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane. showInputDialog("Masukkan Nomor Telepon Baru");
                    if(inputNoTelp.length()>0){
                        AllObjectController.pemilik.updateData(3,inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahalamat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputAlamat = JOptionPane. showInputDialog("Masukkan Alamat Baru");
                    if(inputAlamat.length()>0){
                        AllObjectController.pemilik.updateData(4,inputAlamat, cek);
                        fieldalamat.setText(inputAlamat);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
     }
}

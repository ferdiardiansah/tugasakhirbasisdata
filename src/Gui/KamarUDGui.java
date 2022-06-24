package Gui;

import Entity.KamarEntity;
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
public class KamarUDGui extends ComponentGui{
    int id; 
    String nama_kamar, ukuran_kamar, ket_kamar;
    public KamarUDGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek) {
        for (KamarEntity kamar : AllObjectController.kamar.getIdKamar(cek)) {
            this.id = kamar.getId();
            this.nama_kamar = kamar.getNama_kamar();
            this.ukuran_kamar = kamar.getUkuran();
            this.ket_kamar = kamar.getKet_kamar();
        }
        setTitle("BIODATA KAMAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); setVisible(true);
        
        labelregister.setText("BIODATA KAMAR");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        btnkembali.setBounds(15,15,80,15);
        btnkembali.setBackground (Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);

        labelnama_kamar.setBounds (35,100,80,25);
        add(labelnama_kamar);
        fieldnama_kamar.setBounds (140,100,200,25);
        fieldnama_kamar.setText(nama_kamar);
        fieldnama_kamar.setEditable(false);
        add(fieldnama_kamar);

        labelukuran_kamar.setBounds(35,150,80,25);
        add(labelukuran_kamar);
        fieldukuran_kamar.setBounds (140,150,200,25);
        fieldukuran_kamar.setText(ukuran_kamar);
        fieldukuran_kamar.setEditable(false);
        add(fieldukuran_kamar);

        labelket_kamar.setBounds (35,200,80,25);
        add(labelket_kamar);
        fieldket_kamar.setBounds(140, 200, 200,25);
        fieldket_kamar.setText(ket_kamar);
        fieldket_kamar.setEditable(false);
        add(fieldket_kamar);

        bingkaigambar.setBounds(50,225,150,200);
        add(bingkaigambar);

        btnubahnama_kamar.setBounds(350,100, 80, 25);
        btnubahukuran_kamar.setBounds(350,150,80,25);
        btnubahket_kamar.setBounds(350,200,80,25);
        add(btnubahnama_kamar);
        add(btnubahukuran_kamar);
        add(btnubahket_kamar);
        
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
                MenuPemilikKamarGui MPemilik = new MenuPemilikKamarGui(cek);
                MPemilik.setVisible(true);
                dispose();
            }
        });
        btnubahnama_kamar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String inputnama = JOptionPane.showInputDialog("Masukkan Nama Kamar Baru");
                    if(inputnama.length() >0){
                        AllObjectController.kamar. updateData(1, inputnama,cek);
                        fieldnama.setText(inputnama);
                    }else{
                        JOptionPane.showMessageDialog(null,"Data Kosong");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahukuran_kamar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                try {
                    String inputukuran = JOptionPane.showInputDialog("Masukkan Ukuran Kamar Baru");
                    if (inputukuran.length() > 0){
                        AllObjectController.kamar.updateData(2, inputukuran, cek);
                        fieldpassword.setText(inputukuran); 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnubahket_kamar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String inputket = JOptionPane. showInputDialog("Masukkan Ket Kamar Baru");
                    if(inputket.length()>0){
                        AllObjectController.kamar.updateData(3,inputket, cek);
                        fieldnotelp.setText(inputket);
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

package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class KamarGui extends ComponentGui {
    int kode;
    
    public KamarGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENAMBAH KAMAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("MENAMBAH KAMAR");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        labelnama_kamar.setBounds(35, 100, 80, 25);
        add(labelnama_kamar);
        fieldnama_kamar.setBounds(140, 100, 290, 25);
        add(fieldnama_kamar);
        
        labelukuran_kamar.setBounds(35, 150, 80, 25);
        add(labelukuran_kamar);
        fieldukuran_kamar.setBounds(140, 150, 290, 25);
        add(fieldukuran_kamar);
        
        labelket_kamar.setBounds(35, 200, 80, 25);
        add(labelket_kamar);
        fieldket_kamar.setBounds(140, 200, 290, 25);
        add(fieldket_kamar);
        
        btnkembali.setBounds(15, 15, 80, 15);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        btnkamar.setBounds(160, 380, 140, 25);
        btnkamar.setBorder(null);
        btnkamar.setBackground(Color.black);
        btnkamar.setForeground(Color.white);
        btnkamar.setFocusPainted(false);
        add(btnkamar);
        
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
                MenuPemilikKamarGui Kamar = new MenuPemilikKamarGui(kode);
                Kamar.setVisible(true);
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
        
        btnkamar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama_kamar = fieldnama_kamar.getText();
                String ukuran_kamar = fieldukuran_kamar.getText();
                String fasilitas_kamar = fieldket_kamar.getText();
                if(nama_kamar.length() != 0 && ukuran_kamar.length() != 0 && fasilitas_kamar.length() != 0){
                    AllObjectController.kamar.insertData(nama_kamar, ukuran_kamar, fasilitas_kamar);
                    JOptionPane.showMessageDialog(null, nama_kamar + " Adalah Kamar Baru");
                    dispose();
                    new MenuPemilikKamarGui(kode).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}

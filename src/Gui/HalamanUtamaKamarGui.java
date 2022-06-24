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
public class HalamanUtamaKamarGui extends ComponentGui{
    JTable tabelkamar = new JTable();
    JScrollPane spkamar = new JScrollPane(tabelkamar);
    JTable tabelpemilik = new JTable();
    JScrollPane sppemilik = new JScrollPane(tabelpemilik);
    JTextField textpilih = new JTextField();
    JButton btndetailkamar = new JButton("DETAIL KAMAR");
    int kode;
    public HalamanUtamaKamarGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("MENU KAMAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("INFORMASI KAMAR");
        labelregister.setBounds(480, 50, 150, 25);
        add(labelregister);
        
        spkamar.setBounds(20, 100, 870, 220);
        tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
        add(spkamar);
        
        sppemilik.setBounds(20, 350, 870, 300);
        tabelpemilik.setModel(AllObjectController.pemilik.daftarPemilik());
        add(sppemilik);
        
        
        btnhome.setBounds(15, 15, 80, 25);
        btnhome.setBackground(Color.white);
        btnhome.setFocusPainted(false);
        btnhome.setBorder(null);
        add(btnhome);
        
        tabelkamar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelkamar.getSelectedRow();
                textpilih.setText(AllObjectController.kamar.daftarKamar().getValueAt(i, 0).toString());
            }
        });
        
        
        btnhome.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnhome.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e){
                btnhome.setForeground(Color.black);
            }
        });
        
        btnhome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HalamanUtamaGui home = new HalamanUtamaGui();
                home.setVisible(true);
                dispose();
            }
        });
        
        
    } 
}

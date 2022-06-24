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
public class MenuUserKamarGui extends ComponentGui{
    JTable tabelkamar = new JTable();
    JScrollPane spkamar = new JScrollPane(tabelkamar);
    JTable tabelpemilik = new JTable();
    JScrollPane sppemilik = new JScrollPane(tabelpemilik);
    JTextField textpilih = new JTextField();
    JButton btndetailkamar = new JButton("DETAIL KAMAR");
    int kode;
    public MenuUserKamarGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
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
        
        
        /*

        btnpesan.setBounds(920, 150, 110, 25);
        btnpesan.setFocusPainted(false);
        btnpesan.setBorder(null);
        btnpesan.setBackground(Color.black);
        btnpesan.setForeground(Color.white);
        add(btnpesan);
        
        btndetailkamar.setBounds(920, 190, 110, 25);
        btndetailkamar.setFocusPainted(false);
        btndetailkamar.setBorder(null);
        btndetailkamar.setBackground(Color.black);
        btndetailkamar.setForeground(Color.white);
        add(btndetailkamar);
        */

        
        btnkembali.setBounds(15, 15, 80, 25);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        tabelkamar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelkamar.getSelectedRow();
                textpilih.setText(AllObjectController.kamar.daftarKamar().getValueAt(i, 0).toString());
            }
        });
        
        /*
        btnpesan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /*kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.verifKamar(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Kamar TERSEWA");
                tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
            }
        }); 
        btnpesan.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnpesan.setForeground(Color.black);
                btnpesan.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnpesan.setForeground(Color.white);
                btnpesan.setBackground(Color.black);
            }
        });
        */
        
        /*btndetailkamar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuUserDKamar MUserDK = new MenuUserDKamar(kode);
                MUserDK.setVisible(true);
                dispose();
            }
        });
        btndetailkamar.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btndetailkamar.setForeground(Color.black);
                btndetailkamar.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btndetailkamar.setForeground(Color.white);
                btndetailkamar.setBackground(Color.black);
            }
        });
        */
        
        
        btnkembali.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnkembali.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e){
                btnkembali.setForeground(Color.black);
            }
        });
        
        btnkembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuUserPilGui loginUserGui = new MenuUserPilGui(kode);
                loginUserGui.setVisible(true);
                dispose();
            }
        });
        
        
    } 
}

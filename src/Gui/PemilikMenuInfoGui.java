package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PemilikMenuInfoGui extends ComponentGui{
    JTable tabelpengajar = new JTable();
    JScrollPane sppengajar = new JScrollPane(tabelpengajar);
    JTextField textpilih = new JTextField();
    int kode;
    public PemilikMenuInfoGui(int cek){
        initComponent(cek);
    }
    void initComponent(final int cek){
        setTitle("MENU INFORMASI PENGAJAR LES ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppengajar.setBounds(20, 50, 500, 350);
        tabelpengajar.setModel(AllObjectController.pemilik.daftarPemilik());
        add(sppengajar);
        
        btnubahdata.setBounds(540, 50, 110, 25);
        btnubahdata.setFocusPainted(false);
        btnubahdata.setBorder(null);
        btnubahdata.setBackground(Color.black);
        btnubahdata.setForeground(Color.white);
        add(btnubahdata);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnkembali.setBounds(25, 20, 80, 25);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        tabelpengajar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelpengajar.getSelectedRow();
                textpilih.setText(AllObjectController.pemilik.daftarPemilik().getValueAt(i, 0).toString());
            }
        });
        
        btnubahdata.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PemilikUDGui pengajarMenuUDGui = new PemilikUDGui(cek);
                pengajarMenuUDGui.setVisible(true);
                dispose();
            }
        });
        
        //btndelete.addActionListener(new ActionListener(){
        //    public void actionPerformed(ActionEvent e){
        //        kode = Integer.parseInt(textpilih.getText());
        //        AllObjectController.pemilik.deleteDataPengajar(kode);
        //        tabelpengajar.setModel(AllObjectController.pengajar.daftarPengajar());
        //        JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA PENGAJAR");
        //    }
        //});
        
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
                PemilikGui pengajarGui = new PemilikGui(cek);
                pengajarGui.setVisible(true);
                dispose();
            }
        });
    } 
}

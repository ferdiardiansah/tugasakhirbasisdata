package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PemilikGui extends ComponentGui{
    JTable tabeluser = new JTable();
    JScrollPane sppeserta = new JScrollPane(tabeluser);
    JTextField textpilih = new JTextField();
    JButton btnmenupengajar = new JButton("INFORMASI");
    int kode;
    public PemilikGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("MENU PENGAJAR LES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppeserta.setBounds(20, 50, 500, 350);
        tabeluser.setModel(AllObjectController.user.daftarUser());
        add(sppeserta);
        
        btnverif.setBounds(540, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnmenupengajar.setBounds(540, 145, 110, 25);
        btnmenupengajar.setFocusPainted(false);
        btnmenupengajar.setBorder(null);
        btnmenupengajar.setBackground(Color.black);
        btnmenupengajar.setForeground(Color.white);
        add(btnmenupengajar);
        
        btnunverif.setBounds(540, 185, 110, 25);
        btnunverif.setFocusPainted(false);
        btnunverif.setBorder(null);
        btnunverif.setBackground(Color.black);
        btnunverif.setForeground(Color.white);
        add(btnunverif);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabeluser.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabeluser.getSelectedRow();
                textpilih.setText(AllObjectController.user.daftarUser().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.verifUser(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi(PELANGGAN AKTIF)");
                tabeluser.setModel(AllObjectController.user.daftarUser());
            }
        });
        btnunverif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.unverifUser(kode);
                JOptionPane.showMessageDialog(null, "Berhasil UnVerifikasi(PELANGGAN TIDAK AKTIF)");
                tabeluser.setModel(AllObjectController.user.daftarUser());
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.DeleteDataUser(kode);
                tabeluser.setModel(AllObjectController.user.daftarUser());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA PELANGGAN");
            }
        });
        
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
                LoginPemilikGui loginAdminGui = new LoginPemilikGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnmenupengajar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PemilikMenuInfoGui pengajarMenuGui = new PemilikMenuInfoGui(cek);
                pengajarMenuGui.setVisible(true);
                dispose();
            }
        });
    } 
}

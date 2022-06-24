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
public class MenuPemilikTransaksiGui extends ComponentGui{
    JTable tabeltransaksi = new JTable();
    JScrollPane sptransaksi = new JScrollPane(tabeltransaksi);
    JTable tabelidp = new JTable();
    JScrollPane spidp = new JScrollPane(tabelidp);
    JTable tabelidu = new JTable();
    JScrollPane spidu = new JScrollPane(tabelidu);
    JTable tabelidk = new JTable();
    JScrollPane spidk = new JScrollPane(tabelidk);
    
    JTextField textpilih = new JTextField();
    JButton btntambahtransaksi = new JButton("TAMBAH TRANSAKSI");
    JButton btnubahtransaksi = new JButton("UBAH TRANSAKSI");
    int kode;
    public MenuPemilikTransaksiGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("MENU TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("INFORMASI TRANSAKSI");
        labelregister.setBounds(480, 50, 150, 25);
        add(labelregister);
        
        sptransaksi.setBounds(20, 350, 870, 300);
        tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());
        add(sptransaksi);
        
        spidp.setBounds(20, 100, 180, 220);
        tabelidp.setModel(AllObjectController.pemilik.daftarIDP());
        add(spidp);
        
        spidu.setBounds(200, 100, 240, 220);
        tabelidu.setModel(AllObjectController.user.daftarIDU());
        add(spidu);
        
        spidk.setBounds(440, 100, 200, 220);
        tabelidk.setModel(AllObjectController.kamar.daftarIDK());
        add(spidk);
        
        btnverif.setText("[USER] TERBAYAR = 1");
        btnverif.setBounds(650, 100, 150, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btnunverif.setText("[USER]BELUM BAYAR = 0");
        btnunverif.setBounds(650, 140, 150, 25);
        btnunverif.setFocusPainted(false);
        btnunverif.setBorder(null);
        btnunverif.setBackground(Color.black);
        btnunverif.setForeground(Color.white);
        add(btnunverif);
        
        btntambahtransaksi.setBounds(910, 350, 120, 25);
        btntambahtransaksi.setFocusPainted(false);
        btntambahtransaksi.setBorder(null);
        btntambahtransaksi.setBackground(Color.black);
        btntambahtransaksi.setForeground(Color.white);
        add(btntambahtransaksi);
        
        btnubahtransaksi.setBounds(910, 400, 120, 25);
        btnubahtransaksi.setFocusPainted(false);
        btnubahtransaksi.setBorder(null);
        btnubahtransaksi.setBackground(Color.black);
        btnubahtransaksi.setForeground(Color.white);
        add(btnubahtransaksi);
        
        btndelete.setBounds(910, 450, 120, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnkembali.setBounds(15, 15, 80, 25);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        tabeltransaksi.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabeltransaksi.getSelectedRow();
                textpilih.setText(AllObjectController.transaksi.daftarTransaksi().getValueAt(i, 0).toString());
            }
        });
        
        tabelidu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelidu.getSelectedRow();
                textpilih.setText(AllObjectController.user.daftarIDU().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.verifUser(kode);
                JOptionPane.showMessageDialog(null, "Berhasil User Telah Membayar Sewa");
                tabelidu.setModel(AllObjectController.user.daftarIDU());
                tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());  
            }
        });
        btnverif.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnverif.setForeground(Color.black);
                btnverif.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnverif.setForeground(Color.white);
                btnverif.setBackground(Color.black);
            }
        });
        
        btnunverif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.unverifUser(kode);
                JOptionPane.showMessageDialog(null, "Berhasil User Belum Membayar Sewa");
                tabelidu.setModel(AllObjectController.user.daftarIDU());
                tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());
                
            }
        });
        btnunverif.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnunverif.setForeground(Color.black);
                btnunverif.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnunverif.setForeground(Color.white);
                btnunverif.setBackground(Color.black);
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.DeleteTransaksi(kode);
                tabeltransaksi.setModel(AllObjectController.transaksi.daftarTransaksi());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS TRANSAKSI");
            }
        });
        btndelete.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btndelete.setForeground(Color.black);
                btndelete.setBackground(Color.RED);
            }

            public void mouseExited(MouseEvent e){
                btndelete.setForeground(Color.white);
                btndelete.setBackground(Color.black);
            }
        });
        
        
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
                MenuPemilikPilGui loginAdminGui = new MenuPemilikPilGui(kode);
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btntambahtransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TransaksiGui transaksi = new TransaksiGui();
                transaksi.setVisible(true);
                dispose();
            }
        });
        btntambahtransaksi.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btntambahtransaksi.setForeground(Color.black);
                btntambahtransaksi.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btntambahtransaksi.setForeground(Color.white);
                btntambahtransaksi.setBackground(Color.black);
            }
        });
        
        btnubahtransaksi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                TransakiUDGuI udtransaksi = new TransakiUDGuI(kode);
                udtransaksi.setVisible(true);
                dispose();
            }
        });
        btnubahtransaksi.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnubahtransaksi.setForeground(Color.black);
                btnubahtransaksi.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btnubahtransaksi.setForeground(Color.white);
                btnubahtransaksi.setBackground(Color.black);
            }
        });
    } 
}

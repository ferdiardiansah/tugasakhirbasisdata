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
public class MenuPemilikKamarGui extends ComponentGui{
    JTable tabelkamar = new JTable();
    JScrollPane spkamar = new JScrollPane(tabelkamar);
    JTextField textpilih = new JTextField();
    JButton btntambahkamar = new JButton("TAMBAH KAMAR");
    JButton btnubahkamar = new JButton("UBAH KAMAR");
    int kode;
    public MenuPemilikKamarGui(int cek){
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
        
        spkamar.setBounds(20, 100, 870, 520);
        tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
        add(spkamar);
        
        btnverif.setText("TELAH DISEWA");
        btnverif.setBounds(920, 150, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btnunverif.setText("BELUM DISEWA");
        btnunverif.setBounds(920, 190, 110, 25);
        btnunverif.setFocusPainted(false);
        btnunverif.setBorder(null);
        btnunverif.setBackground(Color.black);
        btnunverif.setForeground(Color.white);
        add(btnunverif);
        
        btntambahkamar.setBounds(920, 230, 110, 25);
        btntambahkamar.setFocusPainted(false);
        btntambahkamar.setBorder(null);
        btntambahkamar.setBackground(Color.black);
        btntambahkamar.setForeground(Color.white);
        add(btntambahkamar);
        
        btnubahkamar.setBounds(920, 270, 110, 25);
        btnubahkamar.setFocusPainted(false);
        btnubahkamar.setBorder(null);
        btnubahkamar.setBackground(Color.black);
        btnubahkamar.setForeground(Color.white);
        add(btnubahkamar);
        
        btndelete.setBounds(920, 310, 110, 25);
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
        
        tabelkamar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i = tabelkamar.getSelectedRow();
                textpilih.setText(AllObjectController.kamar.daftarKamar().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.pemilik.verifKamar(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Kamar TERSEWA");
                tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
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
                AllObjectController.pemilik.unverifKamar(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Kamar BELUM TERSEWA");
                tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
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
                AllObjectController.pemilik.DeleteDataKamar(kode);
                tabelkamar.setModel(AllObjectController.kamar.daftarKamar());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS KAMAR");
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
        
        btntambahkamar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                KamarGui Kamar = new KamarGui();
                Kamar.setVisible(true);
                dispose();
            }
        });
        btntambahkamar.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btntambahkamar.setForeground(Color.black);
                btntambahkamar.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btntambahkamar.setForeground(Color.white);
                btntambahkamar.setBackground(Color.black);
            }
        });
        
        btnubahkamar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                KamarUDGui udKamar = new KamarUDGui(kode);
                udKamar.setVisible(true);
                dispose();
            }
        });
        btnubahkamar.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnubahkamar.setForeground(Color.black);
                btnubahkamar.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e){
                btnubahkamar.setForeground(Color.white);
                btnubahkamar.setBackground(Color.black);
            }
        });
    } 
}

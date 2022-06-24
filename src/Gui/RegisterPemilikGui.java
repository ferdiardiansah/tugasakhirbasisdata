package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegisterPemilikGui extends ComponentGui{
    public RegisterPemilikGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Pemilik");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER PEMILIK");
        labelregister.setBounds(180, 50, 150, 25);
        add(labelregister);
        
        labelnama.setBounds(35, 100, 80, 25);
        add(labelnama);
        fieldnama.setBounds(140, 100, 290, 25);
        add(fieldnama);
        
        labelpassword.setBounds(35, 150, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(140, 150, 290, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(35, 200, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(140, 200, 290, 25);
        add(fieldnotelp);
        
        labelalamat.setBounds(35, 250, 80, 25);
        add(labelalamat);
        fieldalamat.setBounds(140, 250, 290, 25);
        add(fieldalamat);
        
        btnkembali.setBounds(15, 15, 80, 15);
        btnkembali.setBackground(Color.white);
        btnkembali.setFocusPainted(false);
        btnkembali.setBorder(null);
        add(btnkembali);
        
        btnregister.setBounds(160, 380, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
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
                LoginPemilikGui loginAdminGui = new LoginPemilikGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnregister.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }

            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama = fieldnama.getText();
                String password = fieldpassword.getText();
                String alamat = fieldalamat.getText();
                String notelp = fieldnotelp.getText();
                if(nama.length() != 0 && password.length() != 0 && notelp.length() != 0 && alamat.length() != 0){
                    AllObjectController.pemilik.insertData(nama, password, alamat, notelp);
                    JOptionPane.showMessageDialog(null, nama + " Adalah Pemilik Baru");
                    dispose();
                    new LoginPemilikGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}

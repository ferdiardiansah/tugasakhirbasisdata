package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegisterGui extends ComponentGui{
    public RegisterGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Akun Pelanggan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER PELANGGAN");
        labelregister.setBounds(160, 50, 150, 25);
        add(labelregister);
        
        labelnama.setBounds(35, 100, 40, 25);
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
        
        labeljenis_kelamin.setBounds(35, 300, 90, 25);
        add(labeljenis_kelamin);
        fieldjenis_kelamin.setBounds(140, 300, 290, 25);
        add(fieldjenis_kelamin);
        
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
                LoginUserGui loginGui = new LoginUserGui();
                loginGui.setVisible(true);
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
                String nama_user = fieldnama.getText();
                String password = fieldpassword.getText();
                String no_telp = fieldnotelp.getText();
                String alamat = fieldalamat.getText();
                String Jenis_kelamin = fieldjenis_kelamin.getText();
                if(nama_user.length() != 0 && password.length() != 0 && no_telp.length() != 0 && alamat.length() != 0 && Jenis_kelamin.length() != 0){
                    AllObjectController.user.insertData(nama_user, password, no_telp, alamat, Jenis_kelamin);
                    JOptionPane.showMessageDialog(null, nama_user + " Adalah Pelanggan Baru");
                    dispose();
                    new LoginUserGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}

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
public class LoginPemilikGui extends ComponentGui{
    JButton btnregispemilik = new JButton("REGIS PEMILIK");
    String gambar;
    public LoginPemilikGui(){
        initComponent();
    }
    
    void initComponent() {
        setTitle("Login Pemilik");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480); 
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.white);
        setLayout(null); 
        setVisible(true);

        btnhome.setBounds(15, 15, 80, 15);
        btnhome.setBackground(Color.white);
        btnhome.setFocusPainted(false);
        btnhome.setBorder(null);
        add(btnhome);
        
        labelnama.setBounds (85,250,70,25); 
        add(labelnama); 
        fieldnama.setBounds(180,250,185,25);
        add(fieldnama);

        labelpassword.setBounds (85, 290,80, 25);
        add(labelpassword); 
        fieldpassword.setBounds (180, 290, 185,25); 
        add(fieldpassword);
        
        btnlogin.setBounds (180,350,100,25);
        btnlogin.setBackground (Color.black);
        btnlogin. setForeground (Color.white);
        btnlogin.setBorder(null); 
        add(btnlogin);
        
        btnregispemilik.setBounds(140, 400, 180, 25);
        btnregispemilik.setBorder(null);
        btnregispemilik.setBackground(Color.WHITE);
        add(btnregispemilik);


        bingkaigambar.setBounds (150,70,150, 150);
        add(bingkaigambar);
        gambar = "./src/Images/Pemilik.png";
        try {
            bufferedimage = ImageIO.read(new File(gambar));
        }catch (IOException ex) {
            Logger.getLogger(LoginUserGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize = bufferedimage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnhome.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnhome.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e){
                btnhome.setForeground(Color.RED);
            }
        });
        
        btnhome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HalamanUtamaGui home = new HalamanUtamaGui();
                home.setVisible(true);
                dispose();
            }
        });
        
        btnregispemilik.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnregispemilik.setForeground(Color.BLUE);
        }
        public void mouseExited(MouseEvent e) {
            btnregispemilik.setForeground(Color.black);
        }
        });
        btnregispemilik.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new RegisterPemilikGui().setVisible(true);
        }
        });
        
        
        btnlogin.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground (Color.black);
                btnlogin.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white); 
                btnlogin.setBackground(Color.black);
            }
        });
        btnlogin.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String nama = fieldnama.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.pemilik.login(nama, password); 
                if (cek>0){
                    dispose();
                    MenuPemilikPilGui menupGui = new MenuPemilikPilGui(cek); 
                    menupGui.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}

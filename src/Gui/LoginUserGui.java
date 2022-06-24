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
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoginUserGui extends ComponentGui{
    String gambar;
    public LoginUserGui(){
        initComponent();
    }
    
    void initComponent() {
        setTitle("Login User");
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
        labelnama.setBounds (85,250,130,25);
        add(labelnama); 
        fieldnama.setBounds (180,250,185,25); 
        add(fieldnama);
        labelpassword.setBounds (85,290,80,25);
        add(labelpassword); 
        fieldpassword.setBounds(180, 290,185,25); 
        add(fieldpassword);    
        btnlogin.setBounds(180,350,100,25); 
        btnlogin.setBackground (Color.black);
        btnlogin. setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        btnnotreg.setBounds (140,400,180,25);
        btnnotreg.setBorder(null); 
        btnnotreg.setBackground(Color.white);
        add(btnnotreg);

        bingkaigambar.setBounds (150,70, 150, 150); 
        add (bingkaigambar);
        gambar = "./src/Images/User.png";
        try {
            bufferedimage = ImageIO.read(new File(gambar));
        }catch (IOException ex) {
            Logger.getLogger(LoginUserGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize=bufferedimage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
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
        
        btnnotreg.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnnotreg. setForeground(Color.blue);
        }
        public void mouseExited(MouseEvent e) {
            btnnotreg.setForeground(Color.black);
        }
        });

        btnnotreg.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new RegisterGui().setVisible(true);
        }
        });
        btnlogin.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
            btnlogin.setForeground(Color.black);
            btnlogin.setBackground(Color.green);
            }
            public void mouseExited(MouseEvent e) {
            btnlogin. setForeground(Color.white); 
            btnlogin. setBackground (Color.black); 
            }
        } );
        btnlogin.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) { 
                String nama = fieldnama.getText();
                String password = fieldpassword.getText(); 
                int cek = AllObjectController.user.login(nama, password);
                if (cek>0){ 
                    dispose();
                    MenuUserPilGui userpilGui = new MenuUserPilGui(cek);
                    userpilGui.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}

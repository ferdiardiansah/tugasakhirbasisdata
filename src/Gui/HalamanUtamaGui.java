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
public class HalamanUtamaGui extends ComponentGui{
    JRadioButton btnloginpemilik = new JRadioButton("LOGIN / BUAT AKUN [PEMILIK]");
    JRadioButton btnloginuser = new JRadioButton("LOGIN / BUAT AKUN [USER/PELANGGAN]");
    JRadioButton btninfokamar = new JRadioButton("LIHAT INFORMASI KAMAR");
    String gambar;
    int kode;
    public HalamanUtamaGui(){
        initComponent();
    }
    
    void initComponent() {
        setTitle("HALAMAN SEWA KOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null); 
        setVisible(true);
        setVisible(true);
        
        labelregister.setText("SEWA KOS");
        labelregister.setBounds(170, 30, 150, 25);
        add(labelregister);

        /*
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
        */
        btnloginpemilik.setBounds(130,270,250,20);
        btnloginpemilik.setBorder(null);
        btnloginpemilik.setBackground (Color.white);
        add (btnloginpemilik);
        btnloginuser.setBounds(100,320,250,20);
        btnloginuser.setBorder(null);
        btnloginuser.setBackground (Color.white);
        add (btnloginuser);
        
        btninfokamar.setBounds(140,370,250,20);
        btninfokamar.setBorder(null);
        btninfokamar.setBackground (Color.white);
        add (btninfokamar);
        bingkaigambar.setBounds (150,70, 150, 150); 
        add (bingkaigambar);
        gambar = "./src/Images/Utama.jpg";
        try {
            bufferedimage = ImageIO.read(new File(gambar));
        }catch (IOException ex) {
            Logger.getLogger(LoginUserGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize=bufferedimage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        btnloginpemilik.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnloginpemilik.setForeground(Color.RED);
        }
        public void mouseExited(MouseEvent e) {
            btnloginpemilik.setForeground(Color.black);
        }
        });
        btnloginpemilik.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            dispose();
            LoginPemilikGui LoginAdminGui = new LoginPemilikGui();
            LoginAdminGui.setVisible(true);
        }
        });
        btnloginuser.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btnloginuser.setForeground(Color.BLUE);
        }
        public void mouseExited(MouseEvent e) {
            btnloginuser.setForeground(Color.black);
        }
        });
        btnloginuser.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            dispose();
            LoginUserGui loginGui = new LoginUserGui();
            loginGui.setVisible(true);
        }
        });
        
        btninfokamar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            btninfokamar.setForeground(Color.GREEN);
        }
        public void mouseExited(MouseEvent e) {
            btninfokamar.setForeground(Color.black);
        }
        });
        btninfokamar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            dispose();
            HalamanUtamaKamarGui kamar = new HalamanUtamaKamarGui();
            kamar.setVisible(true);
        }
        });
        
        /*
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
        */
    }
}

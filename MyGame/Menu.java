import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;

public class Menu extends JFrame implements ActionListener{
    private JFrame f;
    private JButton btnStart;
    private JButton btnExit;
    private JButton btnCredit;
    //private JLabel Logo;
    private JLabel background;
    private ImageIcon bg;
    public Clip clip;

    //constructor
    public Menu(){
        //Frame
        f = new JFrame("Monopoly!");
        f.setSize(1200,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        Components();
        background();
        Music();

        f.setLayout(null);  
        f.setVisible(true);
    }
    private void background(){
        bg = new ImageIcon("image/2.png");
        background = new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        f.add(background);
    }
    private void Components(){
        //button
        btnStart = new JButton("Start Game");
        btnExit = new JButton("Exit");
        btnCredit = new JButton("Credits");

        //setขนาด เเละตำเเหน่งปุ่ม
        btnStart.setBounds(450,350,300,100);  
        btnExit.setBounds(450,470,300,100); 
        btnCredit.setBounds(1050,700,130,50); 
        
        //Start Game
        btnStart.setFont(new Font("2005_iannnnnAMD",Font.BOLD,85));
        btnStart.setForeground(Color.WHITE);
        btnStart.setBackground(Color.BLACK);
        btnStart.setFocusable(false); //ปิดกรอบรอบตัวอักษร

        //Exit
        btnExit.setFont(new Font("2005_iannnnnAMD",Font.BOLD,85));
        btnExit.setForeground(Color.BLACK);
        btnExit.setBackground(Color.white);
        btnExit.setFocusable(false); //ปิดกรอบรอบตัวอักษร

        //Credits
        btnCredit.setFont(new Font("2005_iannnnnAMD",Font.BOLD,50));
        btnCredit.setForeground(Color.WHITE);
        btnCredit.setBackground(Color.BLACK);
        btnCredit.setFocusable(false); //ปิดกรอบรอบตัวอักษร

        f.add(btnStart);
        f.add(btnExit);
        f.add(btnCredit);

        //ปุ่มกดมี Action
        btnStart.addActionListener(this);
        btnExit.addActionListener(this);
        btnCredit.addActionListener(this);
    }
    public void Music(){
        try{
            File file = new File("music/MonopolyPLUS-OST-MainMenu.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void musicStop(){
        clip.stop();
        clip.close();
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnStart){
            f.dispose();
            new PlayerName();
        }
        else if(e.getSource() == btnExit){
            System.exit(0);
        }
        else if(e.getSource() == btnCredit){
            f.dispose();
            new Credit();
        }
    }
}

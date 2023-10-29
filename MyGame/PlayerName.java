import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PlayerName extends JFrame implements ActionListener{
    private JFrame f;
    private JButton btnGo;
    private JLabel logo;
    private JLabel NameP1;
    private JLabel NameP2;
    private JTextField tfNameP1;
    private JTextField tfNameP2;
    private JLabel background;
    private ImageIcon bg;
    final private Font mainFont = new Font("2005_iannnnnAMD",Font.BOLD,60);

    public PlayerName(){
        f = new JFrame("Monopoly!");
        f.setSize(1200,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); //หน้า frame อยู่กลางจอ
        
        NameForm();
        buttonGo();
        background();

        f.setLayout(null);
        f.setVisible(true);
    }
    private void background(){
        bg = new ImageIcon("image/player.png");
        background = new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        f.add(background);
    }
    private void NameForm(){
        logo = new JLabel("Please enter your player name.");
        logo.setBounds(240,210,1000,200);
        logo.setFont(new Font("2005_iannnnnAMD",Font.BOLD,90));
        logo.setForeground(Color.black);

        //Player1
        NameP1 = new JLabel("Player 1 Name :");
        NameP1.setFont(mainFont);
        NameP1.setForeground(Color.red);
        NameP1.setBounds(325,320,400,100);
        tfNameP1 = new JTextField();
        tfNameP1.setFont(new Font("2005_iannnnnAMD", Font.PLAIN, 40));
        tfNameP1.setBounds(575,355,300,40);

        //Player2
        NameP2 = new JLabel("Player 2 Name :");
        NameP2.setFont(mainFont);
        NameP2.setForeground(Color.blue);
        NameP2.setBounds(320,375,400,100);
        tfNameP2 = new JTextField();
        tfNameP2.setFont(new Font("2005_iannnnnAMD", Font.PLAIN, 40));
        tfNameP2.setBounds(575,410,300,40);

        f.add(logo);
        f.add(NameP1);
        f.add(tfNameP1);
        f.add(NameP2);
        f.add(tfNameP2);
    }
    private void buttonGo(){
        btnGo = new JButton("Go Go!");
        btnGo.setBounds(500,500,200,80);
        btnGo.setFont(new Font("2005_iannnnnAMD",Font.BOLD,90));
        btnGo.setFocusable(false);
        btnGo.setForeground(Color.WHITE);
        btnGo.setBackground(Color.BLACK);

        f.add(btnGo);

        btnGo.addActionListener(this);
    }
    
    //button action
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnGo){
            String NamePlayer1 = tfNameP1.getText();
            String NamePlayer2 = tfNameP2.getText();
            if(NamePlayer1.isEmpty() || NamePlayer2.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter your player name. NOW!!");
            }
            else {
                new Board(new Player(NamePlayer1), new Player(NamePlayer2));
                f.dispose();
            }
        }
    }
}

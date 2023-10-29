import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credit extends JFrame implements ActionListener{
    private JFrame f;
    private JButton btnGoBack;
    private JLabel Logo;
    private JLabel lun;
    private JLabel tong;
    private JLabel aom;
    private JLabel background;
    private ImageIcon bg;
    final private Font mainFont = new Font("2005_iannnnnAMD",Font.PLAIN,80);

    public Credit(){
        f = new JFrame("Monopoly!");
        f.setSize(1200,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        buttonBack();
        Components();
        background();

        f.setLayout(null);  
        f.setVisible(true);
    }
    private void background(){
        bg = new ImageIcon("image/monopoly.png");
        background = new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        f.add(background);
    }
    private void Components(){
        Logo = new JLabel("CREDITS");
        //setขนาด เเละตำเเหน่ง logo
        Logo.setBounds(480,100,1200,400);
        Logo.setForeground(Color.black);
        Logo.setFont(new Font("2005_iannnnnAMD",Font.BOLD,110)); 

        //Lun
        lun = new JLabel("65050022 Kornkamol Saengsawang");
        lun.setBounds(275,210,800,300);
        lun.setForeground(Color.black);
        lun.setFont(mainFont); 
        
        //Tong
        tong = new JLabel("65050042 Kawisara Taweesak");
        tong.setBounds(275,260,800,300);
        tong.setForeground(Color.black);
        tong.setFont(mainFont); 

        //Aom
        aom = new JLabel("65050328 Dararat Wirotwetchaphan");
        aom.setBounds(275,310,800,300);
        aom.setForeground(Color.black);
        aom.setFont(mainFont); 

        f.add(lun);
        f.add(tong);
        f.add(aom);
        f.add(Logo);
    }
    private void buttonBack(){
        btnGoBack = new JButton("Back");
        btnGoBack.setBounds(500,520,200,80);
        btnGoBack.setFont(new Font("2005_iannnnnAMD",Font.BOLD,100));
        btnGoBack.setFocusable(false);
        btnGoBack.setForeground(Color.WHITE);
        btnGoBack.setBackground(Color.BLACK);

        f.add(btnGoBack);

        btnGoBack.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnGoBack){
            f.dispose();
            new Menu();
        }
    }
}

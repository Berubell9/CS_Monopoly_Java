import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JFrame implements ActionListener {
    private JFrame f, fEvent, fEvent2;
    private JLabel board, message, d1Face, d2Face, lbRoundPlay, lbMoneyPlayerRed, lbMoneyPlayerBlue, lbPropertyRed, lbPropertyBlue;
    private JButton btnRollDice, btnYes, btnNo, btnOK, btnOKV2, btnOKV3;
    private ImageIcon imageBoard, player1Mark, player2Mark;
    private ImageIcon[] diceImage;
    private JLabel[] chessPondPlayer1, chessPondPlayer2;
    private int dice1, dice2;
    private Area[] area;
    private MysteryEvent[] mysteryEvents;
    private Player playerRed, playerBlue;
    private ArrayList<String> queue;
    private String lastPlay = "";
    private boolean isClicked = true, isDice = true;

    // constructor
    public Board(Player playerRed, Player playerBlue) {
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;

        // Frame
        f = new JFrame("Monopoly!");
        f.setSize(1200, 835);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); // หน้า frame อยู่กลางจอ

        initiationImage();
        initiationComponent();

        f.setLayout(null);
        f.setVisible(true);
    }

    public void initiationImage(){
        try {
            diceImage = new ImageIcon[6];
            player1Mark = new ImageIcon(new ImageIcon("image/red.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            player2Mark = new ImageIcon(new ImageIcon("image/blue.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            diceImage[0] = new ImageIcon(new ImageIcon("image/de1.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            diceImage[1] = new ImageIcon(new ImageIcon("image/de2.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            diceImage[2] = new ImageIcon(new ImageIcon("image/de3.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            diceImage[3] = new ImageIcon(new ImageIcon("image/de4.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            diceImage[4] = new ImageIcon(new ImageIcon("image/de5.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            diceImage[5] = new ImageIcon(new ImageIcon("image/de6.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void initiationComponent() {
        queue = new ArrayList<String>();
        queue.add("playerRed");
        chessPondPlayer1 = new JLabel[24];
        chessPondPlayer2 = new JLabel[24];

        area = new Area[24];
        initiationArea(area);

        mysteryEvents = new MysteryEvent[7];
        initiationMysteryEvent(mysteryEvents);

        // Load botton roll
        btnRollDice = new JButton("Roll Dice!");
        btnRollDice.setBounds(800, 700, 390, 100);
        btnRollDice.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 80));
        btnRollDice.setFocusable(false);
        btnRollDice.setForeground(Color.WHITE);
        btnRollDice.setBackground(Color.BLACK);
        btnRollDice.addActionListener(this);
        f.add(btnRollDice);

        //create a dice
        d1Face = new JLabel(diceImage[5]);
        d1Face.setBounds(920, 600, 70, 70);
        f.add(d1Face);

        d2Face = new JLabel(diceImage[5]);
        d2Face.setBounds(1000, 600, 70, 70);
        f.add(d2Face);

        // Load dashboard
        lbRoundPlay = new JLabel("Round : " + playerRed.getName(),SwingConstants.CENTER);
        lbRoundPlay.setForeground(Color.RED);
        lbRoundPlay.setBounds(830, 30, 350, 40);
        lbRoundPlay.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 70));
        f.add(lbRoundPlay);

        lbMoneyPlayerRed = new JLabel(playerRed.getName() + " money : "+playerRed.getMoney());
        lbMoneyPlayerRed.setForeground(Color.red);
        lbMoneyPlayerRed.setBounds(830, 100, 350, 30);
        lbMoneyPlayerRed.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 45));
        f.add(lbMoneyPlayerRed);

        lbPropertyRed = new JLabel("Property : ");
        lbPropertyRed.setBounds(830, 100, 500, 200);
        lbPropertyRed.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 30));
        f.add(lbPropertyRed);

        lbMoneyPlayerBlue = new JLabel(playerBlue.getName() + " money : "+playerBlue.getMoney());
        lbMoneyPlayerBlue.setForeground(Color.blue);
        lbMoneyPlayerBlue.setBounds(830, 300, 350, 30);
        lbMoneyPlayerBlue.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 45));
        f.add(lbMoneyPlayerBlue);

        lbPropertyBlue = new JLabel("Property : ");
        lbPropertyBlue.setBounds(830, 300, 500, 200);
        lbPropertyBlue.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 30));
        f.add(lbPropertyBlue);
        
        //load Mark
        addPlayer1Component();
        addPlayer2Component();

        // Load board
        imageBoard = new ImageIcon("image/board.png");
        board = new JLabel("", imageBoard, JLabel.LEFT);
        board.setBounds(0, 0, 800, 800);
        f.add(board);
    }

    public void addPlayer1Component(){

        chessPondPlayer1[0] = new JLabel(player1Mark);
        chessPondPlayer1[0].setBounds(715, 710, 30, 30);
        chessPondPlayer1[0].setVisible(true);

        chessPondPlayer1[1] = new JLabel(player1Mark);
        chessPondPlayer1[1].setBounds(590, 710, 30, 30);
        chessPondPlayer1[1].setVisible(false);
        
        chessPondPlayer1[2] = new JLabel(player1Mark);
        chessPondPlayer1[2].setBounds(490, 710, 30, 30);
        chessPondPlayer1[2].setVisible(false);

        chessPondPlayer1[3] = new JLabel(player1Mark);
        chessPondPlayer1[3].setBounds(385, 710, 30, 30);
        chessPondPlayer1[3].setVisible(false);

        chessPondPlayer1[4] = new JLabel(player1Mark);
        chessPondPlayer1[4].setBounds(285, 710, 30, 30);
        chessPondPlayer1[4].setVisible(false);

        chessPondPlayer1[5] = new JLabel(player1Mark);
        chessPondPlayer1[5].setBounds(180, 710, 30, 30);
        chessPondPlayer1[5].setVisible(false);

        chessPondPlayer1[6] = new JLabel(player1Mark);
        chessPondPlayer1[6].setBounds(60, 710, 30, 30);
        chessPondPlayer1[6].setVisible(false);

        chessPondPlayer1[7] = new JLabel(player1Mark);
        chessPondPlayer1[7].setBounds(20, 590, 30, 30);
        chessPondPlayer1[7].setVisible(false);

        chessPondPlayer1[8] = new JLabel(player1Mark);
        chessPondPlayer1[8].setBounds(20, 490, 30, 30);
        chessPondPlayer1[8].setVisible(false);
        
        chessPondPlayer1[9] = new JLabel(player1Mark);
        chessPondPlayer1[9].setBounds(20, 390, 30, 30);
        chessPondPlayer1[9].setVisible(false);

        chessPondPlayer1[10] = new JLabel(player1Mark);
        chessPondPlayer1[10].setBounds(20, 280, 30, 30);
        chessPondPlayer1[10].setVisible(false);

        chessPondPlayer1[11] = new JLabel(player1Mark);
        chessPondPlayer1[11].setBounds(20, 180, 30, 30);
        chessPondPlayer1[11].setVisible(false);

        chessPondPlayer1[12] = new JLabel(player1Mark);
        chessPondPlayer1[12].setBounds(55, 20, 30, 30);
        chessPondPlayer1[12].setVisible(false);

        chessPondPlayer1[13] = new JLabel(player1Mark);
        chessPondPlayer1[13].setBounds(180, 20, 30, 30);
        chessPondPlayer1[13].setVisible(false);

        chessPondPlayer1[14] = new JLabel(player1Mark);
        chessPondPlayer1[14].setBounds(285, 20, 30, 30);
        chessPondPlayer1[14].setVisible(false);

        chessPondPlayer1[15] = new JLabel(player1Mark);
        chessPondPlayer1[15].setBounds(385, 20, 30, 30);
        chessPondPlayer1[15].setVisible(false);

        chessPondPlayer1[16] = new JLabel(player1Mark);
        chessPondPlayer1[16].setBounds(490, 20, 30, 30);
        chessPondPlayer1[16].setVisible(false);

        chessPondPlayer1[17] = new JLabel(player1Mark);
        chessPondPlayer1[17].setBounds(595, 20, 30, 30);
        chessPondPlayer1[17].setVisible(false);

        chessPondPlayer1[18] = new JLabel(player1Mark);
        chessPondPlayer1[18].setBounds(720, 20, 30, 30);
        chessPondPlayer1[18].setVisible(false);
        
        chessPondPlayer1[19] = new JLabel(player1Mark);
        chessPondPlayer1[19].setBounds(720, 180, 30, 30);
        chessPondPlayer1[19].setVisible(false);

        chessPondPlayer1[20] = new JLabel(player1Mark);
        chessPondPlayer1[20].setBounds(720, 285, 30, 30);
        chessPondPlayer1[20].setVisible(false);

        chessPondPlayer1[21] = new JLabel(player1Mark);
        chessPondPlayer1[21].setBounds(720, 385, 30, 30);
        chessPondPlayer1[21].setVisible(false);

        chessPondPlayer1[22] = new JLabel(player1Mark);
        chessPondPlayer1[22].setBounds(720, 485, 30, 30);
        chessPondPlayer1[22].setVisible(false);

        chessPondPlayer1[23] = new JLabel(player1Mark);
        chessPondPlayer1[23].setBounds(720, 590, 30, 30);
        chessPondPlayer1[23].setVisible(false);

        for(int i=0;i<chessPondPlayer1.length;i++) {
            f.add(chessPondPlayer1[i]);
        }
    }

    public void addPlayer2Component(){

        chessPondPlayer2[0] = new JLabel(player2Mark);
        chessPondPlayer2[0].setBounds(715, 750, 30, 30);
        chessPondPlayer2[0].setVisible(true);

        chessPondPlayer2[1] = new JLabel(player2Mark);
        chessPondPlayer2[1].setBounds(590, 750, 30, 30);
        chessPondPlayer2[1].setVisible(false);
        
        chessPondPlayer2[2] = new JLabel(player2Mark);
        chessPondPlayer2[2].setBounds(490, 750, 30, 30);
        chessPondPlayer2[2].setVisible(false);

        chessPondPlayer2[3] = new JLabel(player2Mark);
        chessPondPlayer2[3].setBounds(385, 750, 30, 30);
        chessPondPlayer2[3].setVisible(false);

        chessPondPlayer2[4] = new JLabel(player2Mark);
        chessPondPlayer2[4].setBounds(285, 750, 30, 30);
        chessPondPlayer2[4].setVisible(false);

        chessPondPlayer2[5] = new JLabel(player2Mark);
        chessPondPlayer2[5].setBounds(180, 750, 30, 30);
        chessPondPlayer2[5].setVisible(false);

        chessPondPlayer2[6] = new JLabel(player2Mark);
        chessPondPlayer2[6].setBounds(60, 750, 30, 30);
        chessPondPlayer2[6].setVisible(false);

        chessPondPlayer2[7] = new JLabel(player2Mark);
        chessPondPlayer2[7].setBounds(55, 590, 30, 30);
        chessPondPlayer2[7].setVisible(false);

        chessPondPlayer2[8] = new JLabel(player2Mark);
        chessPondPlayer2[8].setBounds(55, 490, 30, 30);
        chessPondPlayer2[8].setVisible(false);
        
        chessPondPlayer2[9] = new JLabel(player2Mark);
        chessPondPlayer2[9].setBounds(55, 390, 30, 30);
        chessPondPlayer2[9].setVisible(false);

        chessPondPlayer2[10] = new JLabel(player2Mark);
        chessPondPlayer2[10].setBounds(55, 280, 30, 30);
        chessPondPlayer2[10].setVisible(false);

        chessPondPlayer2[11] = new JLabel(player2Mark);
        chessPondPlayer2[11].setBounds(55, 180, 30, 30);
        chessPondPlayer2[11].setVisible(false);

        chessPondPlayer2[12] = new JLabel(player2Mark);
        chessPondPlayer2[12].setBounds(55, 55, 30, 30);
        chessPondPlayer2[12].setVisible(false);

        chessPondPlayer2[13] = new JLabel(player2Mark);
        chessPondPlayer2[13].setBounds(180, 55, 30, 30);
        chessPondPlayer2[13].setVisible(false);

        chessPondPlayer2[14] = new JLabel(player2Mark);
        chessPondPlayer2[14].setBounds(285, 55, 30, 30);
        chessPondPlayer2[14].setVisible(false);

        chessPondPlayer2[15] = new JLabel(player2Mark);
        chessPondPlayer2[15].setBounds(385, 55, 30, 30);
        chessPondPlayer2[15].setVisible(false);

        chessPondPlayer2[16] = new JLabel(player2Mark);
        chessPondPlayer2[16].setBounds(490, 55, 30, 30);
        chessPondPlayer2[16].setVisible(false);

        chessPondPlayer2[17] = new JLabel(player2Mark);
        chessPondPlayer2[17].setBounds(595, 55, 30, 30);
        chessPondPlayer2[17].setVisible(false);

        chessPondPlayer2[18] = new JLabel(player2Mark);
        chessPondPlayer2[18].setBounds(720, 55, 30, 30);
        chessPondPlayer2[18].setVisible(false);
        
        chessPondPlayer2[19] = new JLabel(player2Mark);
        chessPondPlayer2[19].setBounds(755, 180, 30, 30);
        chessPondPlayer2[19].setVisible(false);

        chessPondPlayer2[20] = new JLabel(player2Mark);
        chessPondPlayer2[20].setBounds(755, 285, 30, 30);
        chessPondPlayer2[20].setVisible(false);

        chessPondPlayer2[21] = new JLabel(player2Mark);
        chessPondPlayer2[21].setBounds(755, 385, 30, 30);
        chessPondPlayer2[21].setVisible(false);

        chessPondPlayer2[22] = new JLabel(player2Mark);
        chessPondPlayer2[22].setBounds(755, 485, 30, 30);
        chessPondPlayer2[22].setVisible(false);

        chessPondPlayer2[23] = new JLabel(player2Mark);
        chessPondPlayer2[23].setBounds(755, 590, 30, 30);
        chessPondPlayer2[23].setVisible(false);

        for(int i=0;i<chessPondPlayer2.length;i++) {
            f.add(chessPondPlayer2[i]);
        }
    }

    public void initiationArea(Area[] area){
        area[0] = new Area("GO", "Event", 0);
        area[1] = new Area("Science", "Land", 350);
        area[2] = new Area("Economics", "Land", 120);
        area[3] = new Area("Chance", "Event", 0);
        area[4] = new Area("Agricultural", "Land", 230);
        area[5] = new Area("Business", "Land", 230);
        area[6] = new Area("In jail", "Event", 0);
        area[7] = new Area("Pharmaceutics", "Land", 180);
        area[8] = new Area("Medical", "Land", 200);
        area[9] = new Area("Chance", "Event", 0);
        area[10] = new Area("Dentistry", "Land", 220);
        area[11] = new Area("Psychology", "Land", 280);
        area[12] = new Area("Free Parking", "Event", 0);
        area[13] = new Area("Architecture", "Land", 160);
        area[14] = new Area("Communication Arts", "Land", 100);
        area[15] = new Area("Chance", "Event", 0);
        area[16] = new Area("Humanities", "Land", 240);
        area[17] = new Area("Liberal Arts", "Land", 300);
        area[18] = new Area("Go to jail", "Event", 0);
        area[19] = new Area("Engineering", "Land", 280);
        area[20] = new Area("Industry", "Land", 120);
        area[21] = new Area("Chance", "Event", 0);
        area[22] = new Area("Education", "Land", 300);
        area[23] = new Area("Law", "Land", 150);
    }

    public void initiationMysteryEvent(MysteryEvent[] me){
        me[0] = new MysteryEvent("YOU INHERIT COLLECT 500฿", "Increase", 500);
        me[1] = new MysteryEvent("YOU HAVE WON SECOND PRIZE IN A BEAUTY CONTEST. COLLECT 200฿", "Increase", 200);
        me[2] = new MysteryEvent("Health insurance pay 150฿", "Decrease", 150);
        me[3] = new MysteryEvent("HOLIDAY FUN MATURES. COLLECT 300฿", "Increase", 300);
        me[4] = new MysteryEvent("CONSULTANCY FEE. PAY 200฿", "Decrease", 200);
        me[5] = new MysteryEvent("SPEEDING FINE. PAY 150฿", "Decrease", 150);
        me[6] = new MysteryEvent("YOUR BUILDING LOAN MATURES. COLLECT 150.", "Increase", 150);
        //me[7] = new MysteryEvent("HOSPITAL FEES. PAY  100฿", "Decrease", 100);
    }

    public void walkPlayer(String playerNow, int dice){//parameter เต๋า2อัน
        //เเยก player
        //เลขช่อง = เต๋า2อัน%24
        // int totalDice = dice % 24;
        //เเยกหมาก
        if(playerNow.equals("playerRed")){
            chessPondPlayer1[playerRed.getLocation()].setVisible(false);
            playerRed.setLocation((playerRed.getLocation() + dice) % 24);
            lastPlay = "playerRed";
            runConditionArea(area[playerRed.getLocation()], playerRed, playerBlue);
            chessPondPlayer1[playerRed.getLocation()].setVisible(true);
            queue.remove(0);
            if(queue.isEmpty()){
                queue.add("playerBlue");
                lbRoundPlay.setText("Round : "+playerBlue.getName());
                lbRoundPlay.setForeground(Color.BLUE);
            }
        }
        else if(playerNow.equals("playerBlue")) { 
            chessPondPlayer2[playerBlue.getLocation()].setVisible(false);;
            playerBlue.setLocation((playerBlue.getLocation() + dice) % 24);
            lastPlay = "playerBlue";
            runConditionArea(area[playerBlue.getLocation()], playerBlue, playerRed);
            chessPondPlayer2[playerBlue.getLocation()].setVisible(true);
            queue.remove(0);
            if(queue.isEmpty()){
                queue.add("playerRed");
                lbRoundPlay.setText("Round : "+playerRed.getName());
                lbRoundPlay.setForeground(Color.RED);
            }
        }
        checkLose();
    }

    public void checkLose(){
        if(playerRed.getMoney() < 0){
            lbMoneyPlayerBlue.setText("Win!!!!!!!");
            winPage(playerBlue);
        }
        else if(playerBlue.getMoney() < 0){
            lbMoneyPlayerRed.setText("Win!!!!!!!");
            winPage(playerRed);
        }
    }

    public void runConditionArea(Area a, Player thisPlayer, Player enemyPlayer){
        String type = a.getType();
        if(type.equals("Land")){
            // System.out.println("Land");
            if(a.getOwner()){
                paidRent(a, thisPlayer, enemyPlayer);
            }
            else {
                buyArea(a);
            }
        }
        else if(type.equals("Event")){
            String name = a.getName();
            if(name.equals("Chance")){
                // System.out.println("Mystery Event");
                showMysteryEvent(thisPlayer);
            }
            else if(name.equals("GO")){
                getSalary(thisPlayer);
                isDice = true;
            }
            else if(name.equals("In jail")){
                if(lastPlay.equals("playerRed")){
                    queue.add("playerBlue");
                    queue.add("playerBlue");
                    lbRoundPlay.setText("Round : " + playerBlue.getName());
                    lbRoundPlay.setForeground(Color.BLUE);
                }
                else {
                    queue.add("playerRed");
                    queue.add("playerRed");
                    lbRoundPlay.setText("Round : " + playerRed.getName());
                    lbRoundPlay.setForeground(Color.RED);
                }
                isDice = true;
            }
            else if(name.equals("Free Parking")){
                isDice = true;
            }
            else if(name.equals("Go to jail")){
                if(lastPlay.equals("playerRed")){
                    chessPondPlayer1[thisPlayer.getLocation()].setVisible(false);
                    thisPlayer.setLocation(6);
                    chessPondPlayer1[6].setVisible(true);
                    queue.add("playerBlue");
                    queue.add("playerBlue");
                    lbRoundPlay.setText("Round : " + playerBlue.getName());
                    lbRoundPlay.setForeground(Color.BLUE);
                }
                else {
                    chessPondPlayer2[thisPlayer.getLocation()].setVisible(false);
                    thisPlayer.setLocation(6);
                    chessPondPlayer2[6].setVisible(true);
                    queue.add("playerRed");
                    queue.add("playerRed");
                    lbRoundPlay.setText("Round : " + playerRed.getName());
                    lbRoundPlay.setForeground(Color.red);
                }
                isDice = true;
            }
        }
    }

    public void buyArea(Area a){
        fEvent = new JFrame("Buy area event");
        fEvent.setSize(400,120);
        fEvent.setLocationRelativeTo(null);

        message = new JLabel("Do you want to buy "+a.getName()+" for "+a.getValue()+" Baht?",SwingConstants.CENTER);
        message.setBounds(10, 10, 380, 20);
        fEvent.add(message);

        btnYes = new JButton("Yes");
        btnYes.setBounds(120, 50, 70, 20);
        btnYes.addActionListener(this);
        fEvent.add(btnYes);

        btnNo = new JButton("No");
        btnNo.setBounds(210, 50, 70, 20);
        btnNo.addActionListener(this);
        fEvent.add(btnNo);

        fEvent.setLayout(null);  
        fEvent.setVisible(true);
    }

    public void paidRent(Area a, Player playerRent, Player playerOwner){
        fEvent = new JFrame("Paid rent event");
        fEvent.setSize(500,120);
        fEvent.setLocationRelativeTo(null);

        message = new JLabel("You have to pay the rent of area "+a.getName()+" amount "+a.getValue()+" baht.",SwingConstants.CENTER);
        message.setBounds(10, 10, 480, 20);
        fEvent.add(message);

        btnOK = new JButton("OK");
        btnOK.setBounds(215, 50, 70, 20);
        btnOK.addActionListener(this);
        fEvent.add(btnOK);

        playerRent.decreaseMoney(a.getValue());
        playerOwner.increaseMoney(a.getValue());

        fEvent.setLayout(null);  
        fEvent.setVisible(true);
    }

    public void showMysteryEvent(Player player){
        fEvent = new JFrame("Paid rent event");
        fEvent.setSize(600,120);
        fEvent.setLocationRelativeTo(null);

        Random rd = new Random();
        int indexEvent = rd.nextInt(7);
        if(mysteryEvents[indexEvent].getType().equals("Increase")){
            player.increaseMoney(mysteryEvents[indexEvent].getValue());
        }
        else {
            player.decreaseMoney(mysteryEvents[indexEvent].getValue());
        }

        message = new JLabel(mysteryEvents[indexEvent].getName(),SwingConstants.CENTER);
        message.setBounds(10, 10, 580, 20);
        fEvent.add(message);

        btnOK = new JButton("OK");
        btnOK.setBounds(265, 50, 70, 20);
        btnOK.addActionListener(this);
        fEvent.add(btnOK);

        fEvent.setLayout(null);  
        fEvent.setVisible(true);
    }

    public void getSalary(Player player){
        fEvent = new JFrame("Get salary event");
        fEvent.setSize(400,120);
        fEvent.setLocationRelativeTo(null);
        
        player.increaseMoney(500);

        message = new JLabel("You get a salary of 500 baht.",SwingConstants.CENTER);
        message.setBounds(10, 10, 380, 20);
        fEvent.add(message);

        btnOK = new JButton("OK");
        btnOK.setBounds(165, 50, 70, 20);
        btnOK.addActionListener(this);
        fEvent.add(btnOK);

        fEvent.setLayout(null);  
        fEvent.setVisible(true);
    }

    public void cannotBuy(){
        fEvent2 = new JFrame("Can't buy page");
        fEvent2.setSize(400,120);
        fEvent2.setLocationRelativeTo(null);

        message = new JLabel("You can't buy this place.",SwingConstants.CENTER);
        message.setBounds(10, 10, 380, 20);
        fEvent2.add(message);

        btnOKV2 = new JButton("OK");
        btnOKV2.setBounds(165, 50, 70, 20);
        btnOKV2.addActionListener(this);
        fEvent2.add(btnOKV2);

        fEvent2.setLayout(null);  
        fEvent2.setVisible(true);
    }

    public void winPage(Player player){
        fEvent2 = new JFrame("Win Page");
        fEvent2.setSize(400,120);
        fEvent2.setLocationRelativeTo(null);
        
        player.increaseMoney(500);

        message = new JLabel(player.getName()+" Win!!!",SwingConstants.CENTER);
        message.setFont(new Font("Kanit", Font.BOLD, 20));
        message.setBounds(10, 10, 380, 30);
        fEvent2.add(message);

        btnOKV3 = new JButton("OK");
        btnOKV3.setBounds(165, 50, 70, 20);
        btnOKV3.addActionListener(this);
        fEvent2.add(btnOKV3);

        fEvent2.setLayout(null);  
        fEvent2.setVisible(true);
    }

    public void updateProperty(){
        String strPropertyRed = "<html>Property : ";
        ArrayList<Area> propertyRed = playerRed.getProperty();
        for (int i = 0; i < propertyRed.size(); i++) {
            if(i == propertyRed.size()-1){
                // System.out.print(propertyRed.get(i).getName());
                strPropertyRed += propertyRed.get(i).getName();
                continue;
            }
            // System.out.print(propertyRed.get(i).getName()+", ");
            strPropertyRed += propertyRed.get(i).getName() + ", ";
            if(i%2 == 1){
                strPropertyRed += "<br/>";
            }
        }
        strPropertyRed += "</html>";
        lbPropertyRed.setText(strPropertyRed);

        String strPropertyBlue = "<html>Property : ";
        ArrayList<Area> propertyBlue = playerBlue.getProperty();
        for (int i = 0; i < propertyBlue.size(); i++) {
            if(i == propertyBlue.size()-1){
                strPropertyBlue += propertyBlue.get(i).getName();
                continue;
            }
            strPropertyBlue += propertyBlue.get(i).getName() + ", ";
            if(i%2 == 1){
                strPropertyBlue += "<br/>";
            }
        }
        strPropertyBlue +="</html>";
        lbPropertyBlue.setText(strPropertyBlue);
    }
    
    public void changeFaceDice(int d1, int d2){
        d1Face.setIcon(diceImage[d1-1]);
        d2Face.setIcon(diceImage[d2-1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRollDice && isDice) {
            isDice = false;
            isClicked = true;
            // roll dice
            Random rd = new Random();
            dice1 = rd.nextInt(6)+1;
            dice2 = rd.nextInt(6)+1;
            changeFaceDice(dice1, dice2);
            walkPlayer(queue.get(0), dice1 + dice2);
            // System.out.println("Dice: " + (dice1+dice2));
            lbMoneyPlayerRed.setText(playerRed.getName() + " money : "+playerRed.getMoney());
            lbMoneyPlayerBlue.setText(playerBlue.getName() + " money : "+playerBlue.getMoney());
            // System.out.println("Player red money : "+playerRed.getMoney());
            // System.out.println("Player blue money : "+playerBlue.getMoney());
            
        }
        else if(e.getSource() == btnYes && isClicked) {
            isClicked = false;
            if(lastPlay.equals("playerRed")){
                if(playerRed.checkMoneyTobuy(area[playerRed.getLocation()].getValue())){
                    playerRed.buy(area[playerRed.getLocation()]);
                    lbMoneyPlayerRed.setText(playerRed.getName() + " money : "+playerRed.getMoney());
                    // System.out.println("Player red money after buy: "+playerRed.getMoney());
                    area[playerRed.getLocation()].setOwner(true);
                    btnYes.setEnabled(false);
                }
                else {
                    cannotBuy();
                }
            }
            else {
                if(playerBlue.checkMoneyTobuy(area[playerBlue.getLocation()].getValue())){
                    playerBlue.buy(area[playerBlue.getLocation()]);
                    lbMoneyPlayerBlue.setText(playerBlue.getName() + " money : "+playerBlue.getMoney());
                    // System.out.println("Player blue money after buy: "+playerBlue.getMoney());
                    area[playerBlue.getLocation()].setOwner(true);
                    btnYes.setEnabled(false);
                }
                else {
                    cannotBuy();
                }
            }
            updateProperty();
            isDice = true;
            checkLose();
            fEvent.dispose();
        }
        else if(e.getSource() == btnNo || e.getSource() == btnOK) {
            isDice = true;
            fEvent.dispose();
        }
        else if(e.getSource() == btnOKV2){
            isDice = true;
            fEvent2.dispose();
        }
        else if(e.getSource() == btnOKV3){
            fEvent2.dispose();
            fEvent.dispose();
            f.dispose();
        }
    }
}
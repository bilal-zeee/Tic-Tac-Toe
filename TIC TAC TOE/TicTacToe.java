import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

Random random = new Random();
JFrame frame = new JFrame();
JPanel title = new JPanel();
JPanel body = new JPanel();
JLabel textfield = new JLabel();
JButton[] slots = new JButton[9];
boolean player1_turn;
int count = 1;
boolean flag = false;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("Arial",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,800);
        title.setBackground(Color.BLACK);

        body.setLayout(new GridLayout(3,3));
        body.setBackground(Color.BLACK);

        for (int i= 0; i<9;i++){
            slots[i] = new JButton();
            body.add(slots[i]);
            slots[i].setFont(new Font("Arial",Font.BOLD,120));
            slots[i].setForeground(Color.WHITE);
            slots[i].setBackground(Color.BLACK);
            slots[i].setFocusable(false);
            slots[i].addActionListener(this);
        }

        title.add(textfield);
        frame.add(title,BorderLayout.NORTH);
        frame.add(body);

        first_turn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i=0; i<9; i++){
            if (e.getSource()==slots[i]){
                if (player1_turn){
                    if(slots[i].getText() == ""){
                        slots[i].setText("O");
                        player1_turn = false;
                        textfield.setText("X's Turn");
                        this.count += 1;
                        check();
                    } 
                }
                else{
                    if(slots[i].getText() == "")
                        slots[i].setText("X");
                        player1_turn = true;
                        textfield.setText("O's Turn");
                        this.count += 1;
                        check();
                }
            }
        }

    }

    public void first_turn() {

        try {
            for(int i=0;i<9;i++){
                slots[i].setEnabled(false);
            }
            Thread.sleep(800);
            for(int i=0;i<9;i++){
                slots[i].setEnabled(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("O's Turn");
        }
        else{
            player1_turn = false;
            textfield.setText("X's Turn");
        }
    }

    public void check() {

        if( (slots[0].getText()=="X") &&
            (slots[1].getText()=="X") && 
            (slots[2].getText()=="X")
            ){
            x_wins(0, 1, 2);
        }

        if( (slots[3].getText()=="X") &&
            (slots[4].getText()=="X") && 
            (slots[5].getText()=="X")
            ){
            x_wins(3, 4, 5);
        }

        if( (slots[6].getText()=="X") &&
            (slots[7].getText()=="X") && 
            (slots[8].getText()=="X")
            ){
            x_wins(6, 7, 8);
        }

        if( (slots[0].getText()=="X") &&
            (slots[3].getText()=="X") && 
            (slots[6].getText()=="X")
            ){
            x_wins(0, 3, 6);
        }

        if( (slots[1].getText()=="X") &&
            (slots[4].getText()=="X") && 
            (slots[7].getText()=="X")
            ){
            x_wins(1, 4, 7);
        }

        if( (slots[2].getText()=="X") &&
            (slots[5].getText()=="X") && 
            (slots[8].getText()=="X")
            ){
            x_wins(2, 5, 8);
        }

        if( (slots[0].getText()=="X") &&
            (slots[4].getText()=="X") && 
            (slots[8].getText()=="X")
            ){
            x_wins(0, 4, 8);
        }

        if( (slots[2].getText()=="X") &&
            (slots[4].getText()=="X") && 
            (slots[6].getText()=="X")
            ){
            x_wins(2, 4, 6);
        }

        if( (slots[0].getText()=="O") &&
        (slots[1].getText()=="O") && 
        (slots[2].getText()=="O")
        ){
        o_wins(0, 1, 2);
    }

    if( (slots[3].getText()=="O") &&
        (slots[4].getText()=="O") && 
        (slots[5].getText()=="O")
        ){
        o_wins(3, 4, 5);
    }

    if( (slots[6].getText()=="O") &&
        (slots[7].getText()=="O") && 
        (slots[8].getText()=="O")
        ){
        o_wins(6, 7, 8);
    }

    if( (slots[0].getText()=="O") &&
        (slots[3].getText()=="O") && 
        (slots[6].getText()=="O")
        ){
        o_wins(0, 3, 6);
    }

    if( (slots[1].getText()=="O") &&
        (slots[4].getText()=="O") && 
        (slots[7].getText()=="O")
        ){
        o_wins(1, 4, 7);
    }

    if( (slots[2].getText()=="O") &&
        (slots[5].getText()=="O") && 
        (slots[8].getText()=="O")
        ){
        o_wins(2, 5, 8);
    }

    if( (slots[0].getText()=="O") &&
        (slots[4].getText()=="O") && 
        (slots[8].getText()=="O")
        ){
        o_wins(0, 4, 8);
    }

    if( (slots[2].getText()=="O") &&
        (slots[4].getText()=="O") && 
        (slots[6].getText()=="O")
        ){
        o_wins(2, 4, 6);
    }

    if ((this.count > 9) && (flag == false)){
        draw();
    }


    }

    public void x_wins(int a, int b, int c) {

        slots[a].setBackground(Color.GREEN);
        slots[b].setBackground(Color.GREEN);
        slots[c].setBackground(Color.GREEN);
        textfield.setText("X Wins!");
        this.flag = true;

        for(int i=0;i<9;i++){
            slots[i].setEnabled(false);
        }
    
    }

    public void o_wins(int a, int b, int c) {

        slots[a].setBackground(Color.GREEN);
        slots[b].setBackground(Color.GREEN);
        slots[c].setBackground(Color.GREEN);
        textfield.setText("O Wins!");
        this.flag = true;

        for(int i=0;i<9;i++){
            slots[i].setEnabled(false);
        }
    }

    public void draw(){
        textfield.setText("Draw!");
        for(int i=0;i<9;i++){
            slots[i].setBackground(Color.RED);
        }
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class tiktaktoe extends JFrame implements ActionListener
{

    JPanel player,game,result,select,deck,player2,result1,result2,result3,result12;
    JLabel player1l,player2l,resultl,name1,name2,score1l,score2l,colon1,colon2;
    JTextField player1t,player2t;
    int score1,score2,mark=1,count,undo=0,win=0;
    int d[]=new int[9];
    JButton newb,nameb,startb,undob;
    JButton box[]=new JButton[9];
    CardLayout card;
    Border buttonborder = new LineBorder(Color.black, 1);
    public tiktaktoe()
    {
        deck=new JPanel();
        player=new JPanel();
        player.setBackground(Color.darkGray);
        select=new JPanel();
        select.setLayout(new FlowLayout());
        select.setBackground(Color.black);
        player.setLayout(new FlowLayout());
        player1l=new JLabel("Player 1 : O");
        player1l.setForeground(Color.green);
        player1l.setFont(new Font("Arial", Font.PLAIN, 30));
        player1t=new JTextField(18);
        player1t.setFont(new Font("Arial", Font.PLAIN, 30));
        player2l=new JLabel("Player 2 : X");
        player2l.setForeground(Color.red);
        player2l.setFont(new Font("Arial", Font.PLAIN, 30));
        player2t=new JTextField(18);
        player2t.setFont(new Font("Arial", Font.PLAIN, 30));
        startb=new JButton("Start");
        startb.setBackground(Color.white);
        undob=new JButton("Undo");
        undob.setBackground(Color.white);
        player.add(player1l);player.add(player1t);
        player.add(player2l);player.add(player2t);
        select.add(startb);
        
        add(select,BorderLayout.SOUTH);
        startb.addActionListener(this);
        //player2 panel
        
        player2=new JPanel();
        player2.setLayout(new GridLayout(2,1));
        result=new JPanel();
        result1=new JPanel();
        result2=new JPanel();
        result3=new JPanel();
        result12=new JPanel();
        result.setBackground(Color.black);
        result.setLayout(new GridLayout(3,1));
        game=new JPanel();
        game.setLayout(new GridLayout(3,3));
        
        player2.add(result);
        player2.add(game);
        newb=new JButton("New");
        nameb=new JButton("Back");
        newb.setBackground(Color.white);
        nameb.setBackground(Color.white);
        name1=new JLabel("");
        colon1=new JLabel(":");
        score1l=new JLabel(String.valueOf(score1));
        resultl=new JLabel("");
        name2=new JLabel("");
        colon2=new JLabel(":");
        score2l=new JLabel(String.valueOf(score2));
        name1.setFont(new Font("Arial", Font.PLAIN,30));
        colon1.setFont(new Font("Arial", Font.PLAIN,30));
        score1l.setFont(new Font("Arial", Font.PLAIN,30));
        name1.setForeground(Color.green);
        colon1.setForeground(Color.green);
        score1l.setForeground(Color.green);
        
        name2.setFont(new Font("Arial", Font.PLAIN,30));
        colon2.setFont(new Font("Arial", Font.PLAIN,30));
        score2l.setFont(new Font("Arial", Font.PLAIN,30));
        name2.setForeground(Color.red);
        colon2.setForeground(Color.red);
        score2l.setForeground(Color.red);
        result1.setLayout(new FlowLayout());
        result2.setLayout(new FlowLayout());
        result3.setLayout(new FlowLayout());
        result12.setLayout(new GridLayout());
        result12.add(result1);
        result12.add(result2);
        result.add(result12);
        result.add(result3);
        
        result1.setBackground(Color.black);
        result2.setBackground(Color.black);
        result3.setBackground(Color.black);
        resultl.setFont(new Font("Arial", Font.PLAIN,40));
        result1.add(name1);result1.add(colon1);result1.add(score1l);
        result3.add(resultl);
        result2.add(name2);result2.add(colon2);result2.add(score2l);
        
        
        select.add(newb);
        select.add(undob);
        select.add(nameb);
        newb.setVisible(false);
        nameb.setVisible(false);
        undob.setVisible(false);
        for(int i=0;i<box.length;i++)
        {
            box[i]=new JButton(" ");
            box[i].setFont(new Font("Arial", Font.PLAIN, 40));
            game.add(box[i]);
            box[i].setBackground(Color.white);
            box[i].setFocusable(false);
            box[i].setBorder(buttonborder);
            box[i].addActionListener(this);
        }
        newb.addActionListener(this);
        nameb.addActionListener(this);
        undob.addActionListener(this);
        
        card=new CardLayout();
        deck.setLayout(card);
        deck.add(player,"player");
        deck.add(player2,"player2");
        add(deck);
        
        setSize(500,500);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(startb==e.getSource())
        {
            card.show(deck,"player2");
            name1.setText(player1t.getText());
            name2.setText(player2t.getText());
            startb.setVisible(false);
            newb.setVisible(true);
            nameb.setVisible(true);
            undob.setVisible(true);
        }
        if(nameb==e.getSource())
        {
            card.show(deck,"player");
            startb.setVisible(true);
            newb.setVisible(false);
            nameb.setVisible(false);
            undob.setVisible(false);
            score1=0;score2=0;
            score1l.setText(String.valueOf(score1));
            score2l.setText(String.valueOf(score2));
            resultl.setText(" ");
            count=0;mark=1;
            undo=0;win=0;
            for(int i=0;i<box.length;i++)
            {
                d[i]=0;
                box[i].setText(" ");
            }
        }
        if(box[0]==e.getSource())
        {
            undo=1;
            if(d[0]==0)
            {
                setmark(0);
                d[0]=1;
            }
            
        }
        if(box[1]==e.getSource())
        {
            undo=2;
            if(d[1]==0)
            {
                setmark(1);
                d[1]=1;
            }
        }
        if(box[2]==e.getSource())
        {
            undo=3;
            if(d[2]==0)
            {
                setmark(2);
                d[2]=1;
            }
        }
        if(box[3]==e.getSource())
        {
            undo=4;
            if(d[3]==0)
            {
                setmark(3);
                d[3]=1;
            }
        }
        if(box[4]==e.getSource())
        {
            undo=5;
            if(d[4]==0)
            {
                setmark(4);
                d[4]=1;
            }
        }
        if(box[5]==e.getSource())
        {
            undo=6;
            if(d[5]==0)
            {
                setmark(5);
                d[5]=1;
            }
        }
        if(box[6]==e.getSource())
        {
            undo=7;
            if(d[6]==0)
            {
                setmark(6);
                d[6]=1;
            }
        }
        if(box[7]==e.getSource())
        {
            undo=8;
            if(d[7]==0)
            {
                setmark(7);
                d[7]=1;
            }
        }
        if(box[8]==e.getSource())
        {
            undo=9;
            if(d[8]==0)
            {
                setmark(8);
                d[8]=1;
            }
        }
        if(newb==e.getSource())
        {
            for(int i=0;i<box.length;i++)
            {
                box[i].setText(" ");
                d[i]=0;
                resultl.setText(" ");
                count=0;
                undo=0;
                win=0;
            }
            
        }
        if(undob==e.getSource())
        {
            undofunc(undo);
            
        }
    }
    public void undofunc(int undo)
    {
        if(undo>=1 && undo<=9)
        {
            if(win==0)
            {
                if(box[undo-1].getText().compareTo("O")==0 || box[undo-1].getText().compareTo("X")==0)
                {
                    box[undo-1].setText(" ");
                    d[undo-1]=0;
                    if(mark==1)
                    {
                        mark=2;
                    }
                    else if(mark==2)
                    {
                        mark=1;
                    }
                    count--;
                }
            }
            
            
        }
    }
    public void setmark(int a)
    {
        count++;
        if(mark==1)
       {
            box[a].setText("O");
            box[a].setForeground(Color.green);
            mark=2;
       }
       else if(mark==2)
       {
            box[a].setText("X");
            box[a].setForeground(Color.red);
            mark=1;
       }
        wincheck();
    }
    public void winresult()
    {
        if(mark==2)
        {
            resultl.setText("Player 1 Wins");
            score1++;
            score1l.setText(String.valueOf(score1));
            resultl.setForeground(Color.green);
        }
        else if(mark==1)
        {
            resultl.setText("Player 2 Wins");
            score2++;
            score2l.setText(String.valueOf(score2));
            resultl.setForeground(Color.red);
        }
    }
    public void setend()
    {
        for(int i=0;i<d.length;i++)
        {
            d[i]=1;
        }
        win=1;
    }
    public void wincheck()
    {
        if(((box[0].getText()).compareTo("O")==0 && (box[1].getText()).compareTo("O")==0 && (box[2].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[1].getText()).compareTo("X")==0 && (box[2].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[3].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[5].getText()).compareTo("O")==0) || ((box[3].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[5].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else if(((box[6].getText()).compareTo("O")==0 && (box[7].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[6].getText()).compareTo("X")==0 && (box[7].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[0].getText()).compareTo("O")==0 && (box[3].getText()).compareTo("O")==0 && (box[6].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[3].getText()).compareTo("X")==0 && (box[6].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[1].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[7].getText()).compareTo("O")==0) || ((box[1].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[7].getText()).compareTo("X")==0))
        {
            winresult();
            setend();
        }
        else if(((box[2].getText()).compareTo("O")==0 && (box[5].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[2].getText()).compareTo("X")==0 && (box[5].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[0].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else if(((box[2].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[6].getText()).compareTo("O")==0) || ((box[2].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[6].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else
        {
            if (count==9)
            {
                resultl.setText("Draw");
                win=1;                                                          
                resultl.setForeground(Color.white);                             
            }
            
        }
    }
    public static void main(String...x)
    {
        new tiktaktoe();
    }
}

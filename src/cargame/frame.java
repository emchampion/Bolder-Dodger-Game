package cargame;

import java.awt.Canvas;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class frame extends JFrame implements ActionListener 
{//frame

    JFrame f = new JFrame ("Mountain Racer");
    Canvas canvas = new Canvas();
    JButton btnPlay = new JButton("Play");
    JButton btnQuit = new JButton("Quit");
    JTextArea instructions = new JTextArea(content);
    Track track;
    Insets i;

    public frame()
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.setVisible(true);
        f.add(btnPlay);
        f.add(btnQuit);
        f.add(instructions);
        f.add(canvas);

        
        btnPlay.setBounds(175,300,100,40);
        btnQuit.setBounds(325,300,100,40);
        instructions.setBounds(50,360,500,190);
        
        btnPlay.addActionListener(this);
        btnQuit.addActionListener(this);

    }
    
    static String content = "Mountain Racer!\n"
    						+"Dodge the Boulders as long as you can!\n"
    						+"Controls are your Arrow Keys\n";
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnPlay){
            btnPlay.setVisible(false);
            btnQuit.setVisible(false);
            canvas.setVisible(false);
            if(track != null)
                f.remove(track);
            track = null;
            track = new Track(this);
            f.add(track);    
        }
        if(e.getSource() == btnQuit){
            System.exit(0);
        }
    }
        

}
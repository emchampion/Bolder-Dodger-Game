package cargame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

public class Track extends JPanel implements ActionListener{
    Car Racer;
    Timer time;
    Timer spawn;
    int score = 0;
    frame s;
    AL al;
    
    public Track(frame f){   //track obj  
        s = f;
        Insets i = s.f.getInsets();
        Racer = new Car();
        Racer.setRight(600 - i.left - i.right - 1);
        Racer.setBottom(600 - i.top - i.bottom - 1);
        al = new AL();
        addKeyListener(al);
        setFocusable(true);
        time = new Timer(5, this);
        time.start();
        spawn = new Timer(1000, this);
        spawn.start();
        requestFocusInWindow();
    }
    
    //Create Linked List for Boulders here.
    private LinkedList<Boulders> boulders = new LinkedList<Boulders>();
    //actions area
    public void actionPerformed(ActionEvent e)//actions from buttons, care, boulders
    {
        if(e.getSource()  == time)
        {
            score ++;
            Racer.move();
            requestFocusInWindow();
            ListIterator<Boulders> itr = boulders.listIterator();
            while(itr.hasNext())
            {
                Boulders bold = itr.next();
                bold.move();

                if (bold.crash(Racer)){
                    time.stop();
                    spawn.stop();
                    setFocusable(false);
                    s.btnPlay.setVisible(true);
                    s.btnQuit.setVisible(true);
                }
                    
                if(bold.getY() > 600)
                    itr.remove();
            }
            
            repaint();
        }
        if(e.getSource() == spawn)
        { 
            for(int count = 0; count < (score/1000)+1; count++)
                boulders.add(new Boulders());  
        }
    }
    public void paint(Graphics g)//graphics
    {
        super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            
            g.fillRect(Racer.getX(), Racer.getY(), 10, 20);
            
            for(Boulders bold : boulders)
                g.fillOval(bold.getX(), bold.getY(), bold.getR(), bold.getR());
            g.drawString("Score: " + score, 10,20);
    }
    private class AL extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            Racer.keyReleased(e);
        }
        public void keyPressed(KeyEvent e){
            Racer.keyPressed(e);
        }
    }
}
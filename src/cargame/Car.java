package cargame;

import java.awt.event.KeyEvent;

public class Car {
int x, dx, y, dy, right, bottom;

    public Car()//start location
    {
        x = 300;
        y = 550;
        
    }
    public int getWidth(){//width of car
        return 10;
    }
    public int getHeight(){//height of car
        return 20;
    }
    public void move(){//movement with borders
        x = x + dx;
        if (x < 0)
            x = 0;
        if (x + 10 > right)
            x = right -10;
        y = y + dy;
        if (y < 0)
            y = 0;
        if (y + 20 > bottom)
            y = bottom -20;
    
    }
    public int getCenterX(){//center of car
        return x + 5;
    }
    public int getCenterY(){//center of car
        return y + 10;
    }
    
    public int getX(){//location
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void keyPressed(KeyEvent e){//movement
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)
            dx = -1;
        
        if (key == KeyEvent.VK_RIGHT)
            dx = 1;
        
        if (key == KeyEvent.VK_UP)
            dy = -1;
        
        if (key == KeyEvent.VK_DOWN)
            dy = 1;
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)
            dx = 0;
        
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
        
        if (key == KeyEvent.VK_UP)
            dy = 0;
        
        if (key == KeyEvent.VK_DOWN)
            dy = 0;
    }
    public void setRight(int i){
        right = i;
    }
    public void setBottom(int i){
        bottom = i;
    }
}
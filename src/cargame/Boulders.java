package cargame;

public class Boulders {//boulders
    int x,
        y,
        r,
        dy;

    //Constructor
    public Boulders(){//boulder location and size
        x = (int) (Math.random()*601);
        y = (int) (Math.random()*50-200) ;
        r = (int) (Math.random()*50+50);
        dy = 1;
    }
    public void move(){//boulder movement
        y = y + dy;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getR(){
        return r;
    }
    
    public boolean crash(Car car)
    {//checks for collision
        //Calculate distances of circle center from rectangle center.
        float cX = Math.abs(x+r/2 - car.getCenterX());
        float cY = Math.abs(y+r/2 - car.getCenterY());
        
        //Calculate half width and height of rectangle.
        int rW = car.getWidth()/2;
        int rH = car.getHeight()/2;
      
        //Is the boulder too far away to even consider collision?
        if (cX > (rW + r/2)) { return false; }
        if (cY > (rH + r/2)) { return false; }

        //If so, is it colliding with an edge?
        if (cX <= rW) { return true; } 
        if (cY <= rH) { return true; }

        //If not, calculate distance from corner.
        double cornerDistance_sq = Math.pow((cX - rW/2),2) + Math.pow((cY - rH/2),2);

        //Is it too close to the corner?
        return (cornerDistance_sq <= Math.pow(r/2,2));
    }


}
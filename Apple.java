import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food
 * 
 * @author Tu
 * @version April 2025
 */
public class Apple extends Actor
{
    int speed = 1;
    
    public Apple(){
        setImage("images/apple.png");
    }
    
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        
        // Remove apple and draw game over when apple gets to the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}

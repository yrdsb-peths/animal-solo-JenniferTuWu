import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero
 * 
 * @author Tu
 * @version April 2025
 */
public class Elephant extends Actor
{    
    public Elephant(){
        setImage("images/elephant.png");
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        //remove apple if elephant eats it
        removeTouching(Apple.class);
    }
}

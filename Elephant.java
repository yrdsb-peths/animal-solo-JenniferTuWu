import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero
 * 
 * @author Tu
 * @version April 2025
 */
public class Elephant extends Actor
{    
    GreenfootSound eat = new GreenfootSound("eat.mp3");
    GreenfootImage idle[] = new GreenfootImage[8];
    
    public Elephant(){
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idle[i].scale(100,100);
        }
        setImage(idle[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    int animationCounter = 0;
    int animationSpeed = 15;
    public void animateElephant(){
        animationCounter++;
        if (animationCounter >= animationSpeed){
            animationCounter = 0;
            imageIndex = (imageIndex + 1) % idle.length;
            setImage(idle[imageIndex]);
        }
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
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    // eat the apple and spawn new apple if an apple is eaten
    public void eat(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            eat.play();
        }
    }
}

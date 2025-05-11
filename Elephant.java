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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    // Direction the elephant is facing
    String facing = "right";
    
    public Elephant(){
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        //Initial elephant image
        setImage(idleRight[0]);
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
            if(facing.equals("right")){
                imageIndex = (imageIndex + 1) % idleRight.length;
                setImage(idleRight[imageIndex]);
            }
            else{
                imageIndex = (imageIndex + 1) % idleLeft.length;
                setImage(idleLeft[imageIndex]);
            }
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
            facing = "right";
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

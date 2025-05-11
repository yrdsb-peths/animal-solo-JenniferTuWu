import greenfoot.*;

public class MyWorld extends World {
    public int score;
    Label scoreLabel;
    GreenfootSound elephantSound = new GreenfootSound("elephantSound.mp3");
    
    public MyWorld() {
        super(600, 400, 1, false);
        
        //creating the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //creat a label
        scoreLabel = new Label(0, 80);
        addObject (scoreLabel, 50, 50);
        
        createApple();
    }
    
    /*
     * End the game and draw "GameOver"
     */
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        elephantSound.play();
    }
    
    
    /**
     * Increase score
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    //random location for apples 
    public void createApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(500);
        int y = 0;
        addObject(apple, x, y);
    }
}

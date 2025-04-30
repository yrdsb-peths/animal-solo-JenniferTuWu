import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        //creating the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //creat a label
        Label scoreLabel = new Label(0, 80);
        addObject (scoreLabel, 50, 50);
        
        createApple();
    }
    
    //random location for apples 
    public void createApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(500);
        int y = 0;
        addObject(apple, x, y);
    }
}

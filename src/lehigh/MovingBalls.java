package lehigh;

import processing.core.PApplet;

import java.util.Arrays;

public class MovingBalls extends PApplet{
    int howManyBalls = 10;
    float x [] =new float[howManyBalls];
    float y [] =new float[howManyBalls];
    float speedX [] =new float[howManyBalls];
    float speedY [] =new float[howManyBalls];
    float color[][] =new float[howManyBalls][3];
    int radius   =30;

    public void settings(){
        size(250, 250);
        Arrays.fill(speedX, 1);
        Arrays.fill(speedY, 1);
        for (int i =0; i<howManyBalls; i++){
        x[i]=random(radius,width-radius);
        y[i]=random(radius,width-radius);
        color[i]= new float[]{random(255),random(255),random(255)};
        }
    }

    public void draw(){
        background(0);
        noStroke();
        fill(255,50,50);
        for(int i =0; i<howManyBalls; i++) {
            ellipse(x[i], y[i], radius = 10, radius = 10);

            if ((x[i] - radius) <= 0 || (x[i] + radius) >= width)
                speedX[i] = -speedX[i];
            if ((y[i] - radius) <= 0 || (y[i] + radius) >= width)
                speedY[i] = -speedY[i];

            x[i] += speedX[i];
            y[i] += speedY[i];
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}

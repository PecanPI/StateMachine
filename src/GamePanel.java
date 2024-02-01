import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private boolean isRunning = true;
    private final long desiredFPS = 60;
    private long desiredFrameTime = 1000000000/ desiredFPS;

    Image image;
    Graphics graphics;
    Thread gameThread;

    GamePanel(){

    }
    public void paint(Graphics g){
        image =  createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0,0, this);
    }

    public void update(double time){

    }
    public void draw(Graphics g){

    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long accumulatedTime = 0;
        while (isRunning) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            accumulatedTime += elapsedTime;
            while (accumulatedTime >= desiredFrameTime) {
                update(desiredFrameTime / 100000000.0); // Pass elapsed time in seconds
                accumulatedTime -= desiredFrameTime;
            }
            repaint();
        }
    }
}

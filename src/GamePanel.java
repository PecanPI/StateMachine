import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private boolean isRunning = true;
    private final long desiredFPS = 60;
    private long desiredFrameTime = 1000000000/ desiredFPS;


    public final int CELL_SIZE = 10;
    public final int X_CELLS = 120;
    public final int Y_CELLS = 100
    public final int SCREEN_WIDTH =  X_CELLS*CELL_SIZE;
    public final int SCREEN_HEIGHT = Y_CELLS*CELL_SIZE;
    public final int NUMBER_OF_ANTS = 50; //TODO: update this take user value

    Image image;
    Graphics graphics;
    Thread gameThread;

    Environment environment;

    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);
        start();
    }
    public void start(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void intializeEnviornment(){
        environment = new Environment(X_CELLS, Y_CELLS);
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

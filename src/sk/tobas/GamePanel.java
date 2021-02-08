package sk.tobas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    public static int width;
    public static int height;

    private BufferedImage img;
    private Graphics2D g;

    private Thread thread;
    private boolean running = false;

    public GamePanel(int width, int height) {
        GamePanel.width = width;
        GamePanel.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if(thread == null) {
            thread = new Thread(this, "Simple 2D Game");
            thread.start();
        }
    }

    @Override
    public void run() {
        init();

        final double GAME_HERTZ = 60;
        final double TBU = 1000000000 / GAME_HERTZ;      // time before update

        final int MUBR = 5;                             // most update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double FTBR = 1000000000 / TARGET_FPS;    // final time before update

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;

        while(running) {
            double now = System.nanoTime();
            int updateCount = 0;

            while ((now - lastUpdateTime) > TBU && (updateCount < MUBR)) {
                update();
                input();
                lastUpdateTime += TBU;
                updateCount++;
            }

            if(now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }

            input();
            render();
            draw();

            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if(thisSecond > lastSecondTime) {
                if(frameCount != oldFrameCount) {
                    System.out.println(thisSecond + " : " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < FTBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                now = System.nanoTime();
            }
        }
    }

    public void init() {
        this.running = true;

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
    }

    public void update() {

    }

    public void input() {

    }

    public void render() {
        if(g != null) {
            g.setColor(new Color(66,134,244));
            g.fillRect(0,0, width, height);
        }
    }

    public void draw() {
        Graphics g = this.getGraphics();
        g.drawImage(img, 0 , 0, width, height, null);
        g.dispose();
    }
}

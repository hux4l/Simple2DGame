package sk.tobas.game;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setTitle("Simple 2D Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(800,600));


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

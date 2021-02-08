package sk.tobas;

import javax.swing.*;
import java.awt.*;

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

package SnakeGame;

import javax.swing.*;

/**
 * Created by Ильяс on 22.04.2018.
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Snake Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocation(500,0);
        add(new GameProcess());
        setVisible(true);

    }

    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow();

    }
}


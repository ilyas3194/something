package SnakeGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ильяс on 22.04.2018.
 */
public class GameProcess extends JPanel {

        private final int SIZE = 400;
        private final int DOT_SIZE = 20;
        private final int All_DOTS = 400;
        private Image dot;
        private Image apple;
        private int AppleX ;
        private int AppleY ;
        private int[] x = new int[All_DOTS];
        private int[] y = new int[All_DOTS];
        private int dots;
        private boolean left;
        private boolean right = true;
        private boolean up;
        private boolean down;
        private boolean ingame = true;
        private Timer timer;

        public GameProcess(){
            setBackground(Color.white);
            addImage();

        }
        public void addImage(){
            ImageIcon iid = new ImageIcon("SnakeGame/Snake.png");
            dot = iid.getImage();
            ImageIcon iia = new ImageIcon("SnakeGame/apple.png");
            apple = iia.getImage();
        }
}

package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by Ильяс on 22.04.2018.
 */
public class GameProcess extends JPanel implements ActionListener {

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
        private boolean left = false;
        private boolean right = true;
        private boolean up= false;
        private boolean down= false;
        private boolean ingame = true;
        private Timer timer;

        public GameProcess(){
            setBackground(Color.black);
            addImage();
            initGame();
            addKeyListener(new FieldKeyListener());
            setFocusable(true);

        }
        private void initGame() {
            dots = 3;
            for (int i = 0; i < dots; i++) {
                x[i] = 60 - i*DOT_SIZE;
                y[i] = 60;
            }
            timer = new Timer(250,this);
            timer.start();
            createApple();
        }

        
        private void createApple() {
            AppleX = new Random().nextInt(20)*DOT_SIZE;
            AppleY = new Random().nextInt(20)*DOT_SIZE;
        }

        public void addImage(){
            ImageIcon iid = new ImageIcon("Snake.png");
            dot = iid.getImage();
            ImageIcon iia = new ImageIcon("apple.png");
            apple = iia.getImage();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(ingame){
                g.drawImage(apple,AppleX,AppleY,this);
                for (int i = 0; i < dots; i++) {
                    g.drawImage(dot,x[i],y[i],this);
                }
            } else{
                String str = "Game Over";
                //Font f = new Font("Arial",14,Font.BOLD);
                g.setColor(Color.white);
                //g.setFont(f);
                g.drawString(str,125,SIZE/2);
            }
        }
        private void move() {
            for (int i = dots; i > 0; i--) {
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
            if(left){
                x[0] -= DOT_SIZE;
            }
            if(right){
                x[0] += DOT_SIZE;
            }
            if(up){
                y[0] -= DOT_SIZE;
            }
            if(down){
                y[0] += DOT_SIZE;
            }
        }
        private void checkApple() {
            if(x[0] == AppleX && y[0] == AppleY){
                dots++;
                createApple();
            }
        }



        private void checkCollisions() {
            for (int i = dots; i >0 ; i--) {
                if(i>4 && x[0] == x[i] && y[0] == y[i]){
                    ingame = false;
                }
            }

            if(x[0]>SIZE){
                ingame = false;
            }
            if(x[0]<0){
                ingame = false;
            }
            if(y[0]>SIZE){
                ingame = false;
            }
            if(y[0]<0){
                ingame = false;
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(ingame){
                checkApple();
                checkCollisions();
                move();

            }
            repaint();

        }

        class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }




}

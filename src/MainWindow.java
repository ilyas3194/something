import javax.swing.*;

/**
 * Created by Ильяс on 22.04.2018.
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Snake Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320,345);
        setLocation(400,400);
        add(new GameProcess());
        setVisible(true);

    }

    public static void main(String[] args) {
        System.out.println("Welcome guest");
        MainWindow mainWindow = new MainWindow();

    }
}


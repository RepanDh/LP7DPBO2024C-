import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Membuat JFrame baru untuk GUI Form
        JFrame startFrame = new JFrame("Start Game");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setSize(360, 640);
        startFrame.setLocationRelativeTo(null);
        startFrame.setResizable(false);

        // Membuat JButton baru untuk memulai game
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup startFrame dan membuka gameFrame saat tombol ditekan
                startFrame.dispose();

                JFrame gameFrame = new JFrame("Flappy Bird");
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setSize(360, 640);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setResizable(false);

                FlappyBird flappyBird = new FlappyBird();
                gameFrame.add(flappyBird);
                gameFrame.pack();
                gameFrame.addKeyListener(flappyBird);
                gameFrame.setVisible(true);
            }
        });

        startFrame.getContentPane().add(startButton);
        startFrame.setVisible(true);
    }
}

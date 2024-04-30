import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;


public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    JButton restartButton;
    JLabel scoreLabel;
    int frameWidht = 360;
    int frameHeight = 640;
    int playerStartPosX = frameWidht / 8;
    int playerStartPosY = frameHeight / 2;

    int playerWidht = 34;
    int playerHeight = 24;
    Player player;

    //images attributes
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    //game logic
    Timer gameloop;
    Timer pipesCooldown;

    int gravity = 1;


    //pipes
    int pipeStartPosX = frameWidht;
    int pipeStartPosY = 0;
    int pipeWidht = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    int score = 0;
    boolean gameOver = false;

    public FlappyBird(){
        setPreferredSize(new Dimension(frameWidht, frameHeight));
        setFocusable(true);
        addKeyListener(this);
//        setBackground(Color.blue);

//        restartButton = new JButton("Restart");
//        restartButton.setVisible(false);
//        restartButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                restartGame();
//            }
//        });
//        add(restartButton);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel);


        //load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bintang.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerStartPosX, playerStartPosY, playerWidht, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        pipesCooldown.start();
        gameloop = new Timer(1000/60, this);
        gameloop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidht, frameHeight, null);

        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidht(), player.getHeight(), null);


        for(int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidht(), pipe.getHeight(), null);
        }
        if (gameOver) {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (frameWidht - metr.stringWidth(msg)) / 2, frameHeight / 2);
        }

    }

    public void move(){
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            checkCollision();
            checkScore();
            repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver){
            player.setVelocityY(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_R && gameOver) {
            restartGame();
            resetScore();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void placePipes(){
        int randomPosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() * (pipeHeight/2));
        int openingSpace = frameHeight/4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidht, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidht, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public void checkCollision() {
        for (Pipe pipe : pipes) {
            if (player.getBounds().intersects(pipe.getBounds()) || player.getPosY() + player.getHeight() > getHeight()) {
                gameOver = true;
                gameloop.stop();
                pipesCooldown.stop();
//                restartButton.setVisible(true);
                repaint();
            }
        }
    }



    public void checkScore() {
        for (Pipe pipe : pipes) {
            if (!pipe.passed && pipe.getImage() == upperPipeImage && player.getPosX() > pipe.getPosX() + pipe.getWidht()) {
                score++;
                pipe.passed = true;
                scoreLabel.setText("Score: " + score);
            }
        }
    }



    public void restartGame() {
        player = new Player(playerStartPosX, playerStartPosY, playerWidht, playerHeight, birdImage);
        pipes.clear();
        score = 0;
        gameOver = false;
//        restartButton.setVisible(false);
        gameloop.start();
        pipesCooldown.start();
    }
    public void resetScore() {
        score = 0;
        scoreLabel.setText("Score: " + score);
    }




}

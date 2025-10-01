import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

public class cs1_Pong{
    public static void main(String[] args){
        JFrame frame = new JFrame("Pong");
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PongPanel panel = new PongPanel();

        frame.add(panel);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setAlwaysOnTop(false);
    }

    public static class PongPanel extends JPanel implements ActionListener, KeyListener{
        boolean wPressed = false;
        boolean sPressed = false;
        boolean upPressed = false;
        boolean downPressed = false;

        boolean onePressed = false;
        boolean twoPressed = false;

        boolean start = true;
        boolean vsCPU = false;

        int LpaddleY = 250;
        int LpaddleX = 25;
        int LpaddleW = 25;
        int LpaddleH = 250;

        int RpaddleY = 250;
        int RpaddleX = 950;
        int RpaddleW = 25;
        int RpaddleH = 250;

        int ballX = 480;
        int ballY = 380;
        int ballW = 20;
        int ballH = 20;
        int ballXspeed = 18;
        int ballYspeed = -10;

        int leftScore = 0;
        int rightScore = 0;

        Clip collisionClip;
        Clip scoreClip;

        Timer timer = new Timer(1000/60, this);

        public PongPanel(){
            setBackground(new Color(220, 200, 200));
            timer.start();
            setFocusable(true);
            addKeyListener(this);

            try{
                File collisionFile = new File("collision.wav");
                AudioInputStream collisionAudio = AudioSystem.getAudioInputStream(collisionFile);
                collisionClip = AudioSystem.getClip();
                collisionClip.open(collisionAudio);

                File scoreFile = new File("score.wav");
                AudioInputStream scoreAudio = AudioSystem.getAudioInputStream(scoreFile);
                scoreClip = AudioSystem.getClip();
                scoreClip.open(scoreAudio);
            }
            catch(Exception e){
                System.out.println("ERROR LOADING SOUND FILES!");
            }
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(start == true){
                g.setColor(new Color(240, 240, 240));
                g.setFont(new Font("Times New Roman", Font.BOLD, 100));
                g.drawString("PONG!", 334, 250);
                g.setFont(new Font("Times New Roman", Font.BOLD, 40));
                g.drawString("By: Jessica Abt", 360, 300);

                g.setFont(new Font("Times New Roman", Font.BOLD, 50));
                g.drawString("Press '1' to play vs HUMAN", 220, 450);
                g.drawString("Press '2' to play vs CPU", 220, 510);
            }
            else if(leftScore < 11 && rightScore < 11){//change color
                g.setColor(new Color(255, 255, 255));
                //draw left paddle
                g.fillRect(LpaddleX, LpaddleY, LpaddleW, LpaddleH);
                //draw right paddle
                g.fillRect(RpaddleX, RpaddleY, RpaddleW, RpaddleH);
                //draw ball
                g.fillRect(ballX, ballY, ballW, ballH);
                //set font
                g.setFont(new Font("Times New Roman", Font.BOLD, 96));
                //draw left score
                g.drawString("" + leftScore, 200, 100);
                //draw right score
                g.drawString("" + rightScore, 800, 100);
            }
            else if(leftScore >= 11){
                timer.stop();

                g.setFont(new Font("Times New Roman", Font.BOLD, 96));
                g.setColor(new Color(255, 255, 255));
                g.drawString("Left Player Wins!", 140, 300);
                g.setFont(new Font("Times New Roman", Font.BOLD, 45));
            }
            else if(rightScore >= 11){
                timer.stop();

                g.setFont(new Font("Times New Roman", Font.BOLD, 96));
                g.setColor(new Color(255, 255, 255));
                g.drawString("Right Player Wins!", 120, 300);
                g.setFont(new Font("Times New Roman", Font.BOLD, 45));
            }
        }

        public void actionPerformed(ActionEvent e){
            if(start == true){
                if(onePressed == true){
                    start = false;
                    vsCPU = false;
                }
                if(twoPressed == true){
                    start = false;
                    vsCPU = true;
                }
            }
            else{
                if(vsCPU == true && RpaddleY > ballY - RpaddleH/2 + ballH/2 && ballX > 250){
                    RpaddleY -= 12;
                }
                else if(vsCPU == true && RpaddleY < ballY - RpaddleH/2 + ballH/2 && ballX > 250){
                    RpaddleY += 12;
                }

                if(wPressed == true){
                    LpaddleY = LpaddleY - 10;
                }
                if(sPressed == true){
                    LpaddleY = LpaddleY + 10;
                }
                if(upPressed == true){
                    RpaddleY = RpaddleY - 10;
                }
                if(downPressed == true){
                    RpaddleY = RpaddleY + 10;
                }

                if(LpaddleY <= 0){
                    LpaddleY = 0;
                }
                if(LpaddleY >= 515){
                    LpaddleY = 515;
                }
                if(RpaddleY <= 0){
                    RpaddleY = 0;
                }
                if(RpaddleY >= 515){
                    RpaddleY = 515;
                }

                if(ballY <= 0){
                    ballYspeed = -ballYspeed;
                }
                if(ballY >= 740){
                    ballYspeed = -ballYspeed;
                }

                if(ballX <= 0){
                    ballX = 480;
                    ballY = 380;
                    ballXspeed = 18;
                    ballYspeed = -10;
                    rightScore++;
                    playSound("score.wav");
                    try{
                        Thread.sleep(500);
                    }
                    catch(Exception ex){

                    }
                }

                if(ballX >= 960){
                    ballX = 480;
                    ballY = 380;
                    ballXspeed = 18;
                    ballYspeed = -10;
                    leftScore++;
                    playSound("score.wav");
                    try{
                        Thread.sleep(500);
                    }
                    catch(Exception ex){

                    }
                }

                ballX = ballX + ballXspeed;
                ballY = ballY + ballYspeed;

                boolean touchingLeftPaddle = intersects(LpaddleX, LpaddleY, LpaddleW, LpaddleH);
                boolean touchingRightPaddle = intersects(RpaddleX, RpaddleY, RpaddleW, RpaddleH);
                if(touchingLeftPaddle == true){
                    ballXspeed = -ballXspeed;
                    if(ballXspeed > 0){
                        ballXspeed++;
                    }
                    if(ballYspeed > 0){
                        ballYspeed++;
                    }
                    if(ballX < LpaddleX + LpaddleW){
                        ballX = LpaddleX + LpaddleW;
                    }
                    playSound("collision.wav");
                }
                if(touchingRightPaddle == true){
                    ballXspeed = -ballXspeed;
                    if(ballXspeed > 0){
                        ballXspeed++;
                    }
                    if(ballYspeed > 0){
                        ballYspeed++;
                    }
                    if(ballX + ballW > RpaddleX){
                        ballX = RpaddleX - ballW;
                    }
                    playSound("collision.wav");
                }

                repaint();
            }
        }

        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W){
                wPressed = true;                
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                sPressed = true;                
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                upPressed = true;                
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                downPressed = true;                
            }
            if(e.getKeyCode() == KeyEvent.VK_1){
                onePressed = true;                
            }
            if(e.getKeyCode() == KeyEvent.VK_2){
                twoPressed = true;                
            }
        }

        public boolean intersects(int px1, int py1, int pw, int ph){
            int bx1 = ballX;
            int by1 = ballY;
            int bx2 = bx1 + 20;
            int by2 = by1 + 20;

            int px2 = px1 + 25;
            int py2 = py1 + 250;

            if(bx2 > px1 && bx1 < px2 && by2 > py1 && by1 < py2){
                return true;
            }
            else{
                return false;
            }
        }

        public void keyReleased(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W){
                wPressed = false;                
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                sPressed = false;                
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                upPressed = false;                
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                downPressed = false;  
            }
            if(e.getKeyCode() == KeyEvent.VK_1){
                onePressed = false;                
            }
            if(e.getKeyCode() == KeyEvent.VK_2){
                twoPressed = false;                
            }
        }

        public void keyTyped(KeyEvent e){

        }

        public void playSound(String s){
            try{
                if(s.equals("collision.wav")){
                    collisionClip.setMicrosecondPosition(0);
                    collisionClip.start();
                }
                if(s.equals("score.wav")){
                    scoreClip.setMicrosecondPosition(0);
                    scoreClip.start();
                }
            }
            catch(Exception e){
                System.out.println("Can't find file named: " + s);
            }
        }
    }
}

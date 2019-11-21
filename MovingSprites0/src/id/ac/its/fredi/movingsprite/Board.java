package id.ac.its.fredi.movingsprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private SpaceShip spaceShip;
    private final int DELAY = 10;
    private Asteroid a1,a2,a3;
    
    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        spaceShip = new SpaceShip();
        a1 = new Asteroid(100, 50);
        a2 = new Asteroid(300, 30);
        a3 = new Asteroid(200, 100);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), 
            spaceShip.getY(), this);
        g2d.drawImage(a1.getImage(), a1.getX(), 
                a1.getY(), this);
        g2d.drawImage(a2.getImage(), a2.getX(), 
                a2.getY(), this);
        g2d.drawImage(a3.getImage(), a3.getX(), 
                a3.getY(), this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        step();
    }
    
    private void step() {
        
        spaceShip.move();
        
        repaint(spaceShip.getX()-1, spaceShip.getY()-1, 
                spaceShip.getWidth()+2, spaceShip.getHeight()+2);     
    }    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }
}

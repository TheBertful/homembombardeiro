/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Hugo
 */
public class Jogador {

    private Image boneco;
    private String bonecoPath = "/Assets/jovem.png";
    private int x;
    private int y;
    private int limiteBombas = 3;
    private int bombasEmCampo = 0;
    private ArrayList<Bomb> bombas;
    private Rectangle hitbox;
 
    public Jogador() {
        inicializarJogador();
    }

    private void inicializarJogador() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bonecoPath));
        boneco = ii.getImage();
        x = 40;
        y = 30;
        bombas = new ArrayList<Bomb>(); 
        // a ideia aqui é fazer algum construtor que receba o numero do player, pra ter um sprite diferente
        // e s posição diferente pra cada um
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public Image getImage() {
        return boneco;
    }
    
    public ArrayList<Bomb> getBombas() {
        return bombas;
    }
    
    public int getBombasEmCampo() {
        return bombasEmCampo;
    }
    
    public void setBombasEmCampo(int bombasEmCampo) {
        this.bombasEmCampo = bombasEmCampo;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }
   
    public void setHitbox(int p1, int p2, int largura, int altura) {
        hitbox = new Rectangle(p1, p2, largura, altura);
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
           x = x-32;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = x+32;
        }

        if (key == KeyEvent.VK_UP) {
            y = y-32;
        }

        if (key == KeyEvent.VK_DOWN) {
            y = y+32;
        }
        
        if (key == KeyEvent.VK_SPACE) {
            if (bombasEmCampo < limiteBombas) {
                bombas.add(new Bomb(x, y));
                bombasEmCampo++;
            }
            
        }
        
    }
     
}

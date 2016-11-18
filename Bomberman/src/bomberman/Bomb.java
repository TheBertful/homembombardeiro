/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author hug
 */
public class Bomb {
 
    private Image bomb;
    private String bombPath = "/Assets/bomb1.png";
    private int x;
    private int y;
    private int pavio = 1000;
    private Rectangle hitbox;
    
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        inicializarBomba();
    }
    
    private void inicializarBomba() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bombPath));
        bomb = ii.getImage();
        hitbox = new Rectangle(x, y, ii.getIconWidth(), ii.getIconHeight());
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getPavio() {
        return pavio;
    }

    public void setPavio(int pavio) {
        this.pavio = pavio;
    }
    
    public Image getImage() {
        return bomb;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }
}

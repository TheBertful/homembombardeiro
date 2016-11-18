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
 * @author Administrador
 */
public class Explosion {
    
    private Image explosion;
    private String explosionPath = "/Assets/firecenter2.png";
    private int x;
    private int y;
    private int lifetime = 500;
    private Rectangle hitbox;
    
    public Explosion(int x, int y){
        this.x = x;
        this.y = y;
        inicializarExplosao();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
    private void inicializarExplosao() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(explosionPath));
        explosion = ii.getImage();
        hitbox = new Rectangle(x, y, ii.getIconWidth(), ii.getIconHeight());
    }
    
    public Image getImage() {
        return explosion;
    }
    
}

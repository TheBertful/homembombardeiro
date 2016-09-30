/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author hug
 */
public class Bomb {
 
    private Image bomb;
    private String bombPath = "/Assets/jovem.png";
    private int x;
    private int y;
    private int pavil;
    
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        inicializarBomba();
    }
    
    private void inicializarBomba() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bombPath));
        bomb = ii.getImage();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getPavil() {
        return pavil;
    }

    public void setPavil(int pavil) {
        this.pavil = pavil;
    }
    
    public Image getImage() {
        return bomb;
    }
}

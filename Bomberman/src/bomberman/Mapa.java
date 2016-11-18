/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Administrador
 */
public class Mapa extends javax.swing.JPanel implements ActionListener {

    private Image map;
    private String mapPath = "/Assets/map.png";
    private Jogador player1;
    private Timer timer;
    private final int DELAY = 1;
    
    public Mapa() {
        //initComponents();
        inicializarMapa();
    }
    
    private void inicializarMapa(){
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.requestFocus();
        
        carregarMapa();               
        int w = map.getWidth(this);
        int h = map.getHeight(this);
        setPreferredSize(new Dimension(w,h));
        
        player1 = new Jogador();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void carregarMapa(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(mapPath));
        map = ii.getImage();
      
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        g.drawImage(map, 0, 0, null);    
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }   

     private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);  
        player1.setHitbox(player1.getX(), player1.getY(), 19, 26);
        
        if(!player1.getBombas().isEmpty()) {
            for (int i = 0; i < player1.getBombas().size(); i++) {
                Bomb bomba;
                bomba = player1.getBombas().get(i);
                g2d.drawImage(bomba.getImage(), bomba.getX(), bomba.getY(), this);
                bomba.setPavio(bomba.getPavio() - 1);
                if (bomba.getPavio() < 0) {
                    player1.getBombas().remove(i);
                    for (int j = 0; j < player1.getRange(); j++) {
                        
                    }
                    player1.setBombasEmCampo(player1.getBombasEmCampo() - 1);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //player1.move();
        //System.out.println(player1.getX() + " " + player1.getY());
        this.requestFocus();
        repaint();  
    }

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

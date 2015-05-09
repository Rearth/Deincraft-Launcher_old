/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.JavaApplication1;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Florian
 */
public class StartWindow {
    public static JFrame fenster = new JFrame("Starten"); 
    public static void main(String[] Args) {
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(608, 80);
        fenster.setUndecorated(true);
        JPanel Panel = new javax.swing.JPanel();
        Label LeftProg = new Label("");
        Panel.add(LeftProg);
        Panel.setSize(120, 30);
        Panel.setLocation(10, 10);
        Panel.setBackground(Color.black);
        fenster.getContentPane().add(Panel);
        fenster.setVisible(true);
        LeftProg.setVisible(false);
        int leftS = 1;
        LeftProg.setSize(leftS,30);
        LeftProg.setLocation(10, 5);
        LeftProg.setVisible(true);
        fenster.setAlwaysOnTop(true);
        LeftProg.setText("Deincraft Launcher wird Gestartet. Bitte warten...");
        LeftProg.setForeground(Color.green);
        LeftProg.setFont(new java.awt.Font("MineCrafter 2.0", 1, 15));
        fenster.pack();
        fenster.setVisible(true);
        fenster.setLocationRelativeTo(null);
    }
}

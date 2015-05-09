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
import javax.swing.JFrame;
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
        JPanel Panel = new javax.swing.JPanel();
        Label LeftProg = new Label("");
        Panel.add(LeftProg);
        Panel.setSize(120, 30);
        Panel.setLocation(10, 10);
        fenster.getContentPane().add(Panel);
        fenster.setVisible(true);
        LeftProg.setVisible(false);
        int leftS = 1;
        LeftProg.setSize(leftS,30);
        LeftProg.setLocation(10, 5);
        LeftProg.setVisible(true);
        fenster.setAlwaysOnTop(true);
        LeftProg.setText("Launcher wird Gestarten. Bitte warten...");
        fenster.pack();
        fenster.setVisible(true);
        fenster.setLocationRelativeTo(null);
    }
}

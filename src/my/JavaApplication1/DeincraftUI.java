/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.JavaApplication1;

import deincraft.functions.setRAM;
import static deincraft.util.Path.DCpath;
import deincraft.util.Text;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DavidW
 */
public class DeincraftUI extends javax.swing.JFrame {
    public static String Username;
    public static String Password;
    public static boolean Startenabled = true;
    String RAM;
    boolean Optifineon;
    boolean DualhotBaron;
    boolean Shaderon;
    public static boolean OptionEnabled = true;

    /**
     * Creates new form DeincraftUI
     */
    public DeincraftUI() throws IOException, InterruptedException, Exception {
     /*   choice1.add("1024");
        choice1.add("1536");
        choice1.add("2048");
        choice1.add("2560");
        choice1.add("3072"); */
        //start hier
        StartWindow.main(null);
        StartWindow.fenster.setVisible(true);
        //StartWindow.fenster.pack();
        BufferedImage I;
        I = ImageIO.read(getClass().getResource("/Images/laucherhintergund.png"));
        setContentPane(new JLabel(new ImageIcon(I)));
        pack();
        initComponents();
        jLabel8.setText("Version: " + deincraft.functions.updateChecker.launcher.installedlauncherversion);
        //firsttime
        // deincraft.other.firsttimeinstall.main();
        //version abgleichen
        // deincraft.other.versionvergleich.main();
        //auf Updates prüfen
        deincraft.functions.UpdateChecker.main(null);
        //RAM setzen
        RAM = setRAM.main(null);
        jTextField2.setText(RAM);
        //namen setzen
        if (deincraft.auth.load.load() == true) {
            //logged in aussehen.
            jPanel1.setVisible(false);
            jLabel10.setVisible(true);
            deincraft.login.TCPautoLogin.main(Username, Password, true);
            jLabel2.setText(Username);
        } else {
            //aussehen wenn ausgeloggt.
            jLabel2.setText("");
            jLabel10.setLocation(1, 1);
            jLabel10.setSize(1, 1);
            jLabel10.setVisible(false);
            jPanel1.setLocation(221,272);
            jPanel1.setVisible(true);
            jPanel1.setLocation(221,272);
            jPanel1.setVisible(true);
        }
        //enter knopf beim usernamen
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deincraft.other.setname.main(jTextField1, jPasswordField1, jLabel2, jPanel1, jLabel10);
                } catch (IOException ex) {
                    Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPasswordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deincraft.other.setname.main(jTextField1, jPasswordField1, jLabel2, jPanel1, jLabel10);
                } catch (IOException ex) {
                    Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
      
        jLabel6.setText(deincraft.functions.Changelog.main());
        Image icon = Toolkit.getDefaultToolkit().getImage("./Images/ButtonExit.png");
        icon = new ImageIcon("ButtonExit.png").getImage();
        super.setIconImage(icon);
        //(new javax.swing.ImageIcon(getClass().getResource("/Images/play (1).png")))
        BufferedImage i;
        i = ImageIO.read(getClass().getResource("/Images/LOGO.png"));
        setIconImage(i);
        setTitle("Deincraft Launcher");
        //537 168
        
        //Dualhotbar
        File DualhotBar = new File(DCpath() + "modpacks/tekkitmain/mods/dualhotbar-1.7.10-1.6.jar");
        if(DualhotBar.exists() == true) {
            DualhotBaron = true;
            System.out.println("True");
            jButton5.setBackground(Color.green);
        } else {
            DualhotBaron = false;
            System.out.println("False");
            jButton5.setBackground(Color.red);
        }
        File Optifine = new File(DCpath() + "modpacks/tekkitmain/mods/OptiFine_1.7.10_HD_B7.jar");
        if(Optifine.exists() == true) {
            Optifineon = true;
            System.out.println("True");
            jButton4.setBackground(Color.green);
        } else {
            Optifineon = false;
            System.out.println("False");
            jButton4.setBackground(Color.red);
        }
        File Shader = new File(DCpath() + "modpacks/tekkitmain/mods/ShadersModCore-v2.3.28-mc1.7.10-f.jar");
        if(Shader.exists() == true) {
            Shaderon = true;
            System.out.println("True");
            jButton7.setBackground(Color.green);
        } else {
            Shaderon = false;
            System.out.println("False");
            jButton7.setBackground(Color.red);
        }         
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame1.setUndecorated(true);
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setLocation((dim.width / 2), 300);
         StartWindow.fenster.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Settings");

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setText("Optifine");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 255, 51));
        jButton5.setText("DualhotBar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setText("Shader");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Deincraft Launcher");
        setBackground(new java.awt.Color(51, 255, 0));
        setForeground(java.awt.Color.green);
        setMaximumSize(new java.awt.Dimension(691, 390));
        setMinimumSize(new java.awt.Dimension(691, 390));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 51));
        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(349, 136));

        jLabel3.setFont(new java.awt.Font("MineCrafter 2.0", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 255, 3));
        jLabel3.setText("Username:");

        jButton1.setFont(new java.awt.Font("MineCrafter 2.0", 0, 11)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("MineCrafter 2.0", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 255, 3));
        jLabel5.setText("Passwort:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 0));
        jLabel7.setText("Noch nicht Registriert? Hier Klicken zum Registrieren.");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/facebook-symbol_1.png"))); // NOI18N
        jButton8.setAlignmentY(0.0F);
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton8MouseMoved(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/domain (2)_1.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton6.setFont(jButton6.getFont());
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teamspeak-icon-lg.png"))); // NOI18N
        jButton6.setAlignmentY(0.0F);
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6MouseMoved(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("MineCrafter 2.0", 0, 9)); // NOI18N
        jButton2.setText("Ausloggen");
        jButton2.setBorder(null);
        jButton2.setDefaultCapable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("MineCrafter 2.0", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 255, 3));
        jLabel2.setText("Username");

        jLabel6.setFont(new java.awt.Font("MineCrafter 2.0", 3, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 255, 3));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 255, 3));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/START.png"))); // NOI18N
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel10MouseMoved(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(2, 255, 3));
        jLabel4.setText("Ram in MB:");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("Version:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/JavaApplication1/489749-Gear-512.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel9MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel9))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2))
                                .addGap(70, 151, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jLabel2.setText("");
        jLabel10.setVisible(false);
        JOptionPane.showMessageDialog(null, "Ausgeloggt.", "Logout", JOptionPane.OK_CANCEL_OPTION);
        jPanel1.setVisible(true);
        System.out.println("Gesetzt");
            String namentxtfw = (DCpath() + "launcher/username.txt");
            String PWtxtfw = (DCpath() + "launcher/password.txt");
        try {
            Text.write(namentxtfw, "");
            Text.write(PWtxtfw, "");
            Username = "";
            Password = "";
            jPasswordField1.setText("");
            jTextField1.setText("");
            deincraft.login.TCPautoLogin.main(null, null, false);   //schalte auto login aus. 
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            if (deincraft.other.setname.main(jTextField1, jPasswordField1, jLabel2, jPanel1, jLabel10) == true) {
                Username = jTextField1.getText();
                Password = jPasswordField1.getText();
                deincraft.login.TCPautoLogin.main(Username, Password, true);  
            }

        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here
        try {

            Desktop.getDesktop().browse(new URI("ts3server://ts.deincraft-tekkit.tk"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        try {

            Desktop.getDesktop().browse(new URI("https://www.facebook.com/DeinCraft.Minecraft.Server"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseMoved
        jButton6.setSize(43, 43);
    }//GEN-LAST:event_jButton6MouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        jButton6.setSize(41, 41);
        jLabel1.setSize(41, 41);
        jButton8.setSize(41, 41);
        jLabel10.setSize(295,111);
        jLabel9.setSize(41, 41);
    }//GEN-LAST:event_formMouseMoved

    private void jButton8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseMoved
        // TODO add your handling code here:
        jButton8.setSize(43, 43);
    }//GEN-LAST:event_jButton8MouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            Desktop.getDesktop().browse(new URI("http://www.deincraft-tekkit.tk/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        // TODO add your handling code here:
        jLabel1.setSize(43, 43);
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        jFrame1.setVisible(false);
        if (Startenabled == false) {
            return;
        }
        long memorySize = ((com.sun.management.OperatingSystemMXBean) 
        ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        long RAMinMB = memorySize / 1024 /1024;
        int ramfield = Integer.parseInt(jTextField2.getText());
        if ((ramfield >= RAMinMB)) {
            //wenn auserhalb des bereiches.
            JOptionPane.showMessageDialog(null, "Der eingestellte RAM ist größer, als der RAM, \n\rder dieser Computer verfügt.", "RAM fehler", JOptionPane.OK_CANCEL_OPTION);
            jTextField2.setText(RAM);
        } else if (ramfield <= 1024) {
            JOptionPane.showMessageDialog(null, "Der eingestellte RAM ist zu klein für Minecraft", "RAM fehler", JOptionPane.OK_CANCEL_OPTION);
            jTextField2.setText(RAM);
        } else {
            
            if (ramfield <= 1535) {
                    JOptionPane.showMessageDialog(null, "Wenn der eingestellte RAM unter 1536 liegt, \n\rkönnte es im Spiel ziemlich laggen.", "RAM Warnung", JOptionPane.OK_CANCEL_OPTION);
                }
            RAM = jTextField2.getText();
            try {
                Text.write(DCpath() + "launcher/RAM.txt", RAM);
                
                System.out.println("Starten....");
                OptionEnabled = false;
                jFrame1.setVisible(false);
                Username = jLabel2.getText();
                deincraft.login.TCPautoLogin.main(jLabel2.getText(), Password, true); 
                deincraft.start.Start.main(new String[]{Username, RAM});
                
            } catch (IOException ex) {
                Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                OptionEnabled = false;
                jFrame1.setVisible(false);
                System.out.println("Starten....");
                Username = jLabel2.getText();
                deincraft.start.Start.main(new String[]{Username, RAM});
            }
        }
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseMoved
        // TODO add your handling code here:
        jLabel10.setSize(320,135);
        
    }//GEN-LAST:event_jLabel10MouseMoved

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/START_PRESSED.png")));
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        // TODO add your handling code here:
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/START.png")));
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            Desktop.getDesktop().browse(new URI("http://www.deincraft-tekkit.tk/registrieren/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      // TODO add your handling code here:
        Closing.close();
    }//GEN-LAST:event_formWindowClosing

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        if(OptionEnabled == true){
            jFrame1.setVisible(true);
            jFrame1.pack();
        } else {
            JOptionPane.showMessageDialog(null, "Minecraft muss zum ändern der einstellungen Geschlossen sein");
        } 
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseMoved
        // TODO add your handling code here:
        jLabel9.setSize(43, 43);
    }//GEN-LAST:event_jLabel9MouseMoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        File Optifinean = new File(DCpath() + "modpacks/tekkitmain/mods/OptiFine_1.7.10_HD_B7.jar");
        File Optifineaus = new File (DCpath() + "modpacks/tekkitmain/mods/OptiFine_1.7.10_HD_B7.jar");
        try {
        if (Optifineon == true) {
            Optifinean.renameTo(Optifineaus);
            Optifineon = false;
            jButton4.setBackground(Color.red);
        } else {
            Optifineaus.renameTo(Optifinean);
            Optifineon = true;
            jButton4.setBackground(Color.green);
        }
        } catch (Exception e)
            {e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        File DualhotBaran = new File(DCpath() + "modpacks/tekkitmain/mods/dualhotbar-1.7.10-1.6.jar");
        File DualhotBaraus = new File(DCpath() + "modpacks/tekkitmain/mods/dualhotbar-1.7.10-1.6.jar.off");
        try {
        if (DualhotBaron == true) {
            DualhotBaran.renameTo(DualhotBaraus);
            DualhotBaron = false;
            jButton5.setBackground(Color.red);
        } else {
            DualhotBaraus.renameTo(DualhotBaran);
            DualhotBaron = true;
            jButton5.setBackground(Color.green);
        }
        } catch (Exception e)
            {e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        File Shaderan = new File(DCpath() + "modpacks/tekkitmain/mods/ShadersModCore-v2.3.28-mc1.7.10-f.jar");
        File Shaderaus = new File(DCpath() + "modpacks/tekkitmain/mods/ShadersModCore-v2.3.28-mc1.7.10-f.jar.off");
        try {
        if (Shaderon == true) {
            Shaderan.renameTo(Shaderaus);
            Shaderon = false;
            jButton7.setBackground(Color.red);
        } else {
            Shaderaus.renameTo(Shaderan);
            Shaderon = true;
            jButton7.setBackground(Color.green);
        }
        } catch (Exception e)
            {e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    //int i = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeincraftUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeincraftUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeincraftUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeincraftUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new DeincraftUI().setVisible(true);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DeincraftUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

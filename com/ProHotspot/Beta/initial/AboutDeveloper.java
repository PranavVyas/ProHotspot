package com.ProHotspot.Beta.initial;

import com.ProHotspot.MaterialUI.MaterialButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutDeveloper extends JFrame {
   private JPanel contentPane;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AboutDeveloper frame = new AboutDeveloper();
               frame.setVisible(true);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
   }

   public AboutDeveloper() {
      this.setBackground(Color.LIGHT_GRAY);
      this.setIconImage((new ImageIcon(this.getClass().getResource("/logo.png"))).getImage());
      this.setTitle("About Developer");
      this.setDefaultCloseOperation(2);
      this.setBounds(100, 100, 500, 300);
      this.contentPane = new JPanel();
      this.contentPane.setBackground(Color.WHITE);
      this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.setContentPane(this.contentPane);
      this.contentPane.setLayout((LayoutManager)null);
      JLabel lblAboutDeveloper = new JLabel("About Developer");
      lblAboutDeveloper.setHorizontalAlignment(0);
      lblAboutDeveloper.setFont(new Font("Trebuchet MS", 1, 24));
      lblAboutDeveloper.setBounds(150, 10, 200, 50);
      this.contentPane.add(lblAboutDeveloper);
      JLabel label = new JLabel("");
      Image ppicture = (new ImageIcon(this.getClass().getResource("/profile.jpg"))).getImage();
      label.setIcon(new ImageIcon(ppicture));
      label.setBounds(20, 75, 112, 150);
      this.contentPane.add(label);
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(150, 71, 330, 164);
      this.contentPane.add(panel);
      panel.setLayout((LayoutManager)null);
      JLabel lblName = new JLabel("Name :");
      lblName.setFont(new Font("Segoe UI Emoji", 0, 13));
      lblName.setBounds(10, 10, 50, 15);
      panel.add(lblName);
      JLabel label_1 = new JLabel("Email :");
      label_1.setFont(new Font("Segoe UI Emoji", 0, 13));
      label_1.setBounds(10, 35, 50, 15);
      panel.add(label_1);
      JLabel label_2 = new JLabel("Blog  :");
      label_2.setFont(new Font("Segoe UI Emoji", 0, 13));
      label_2.setBounds(10, 60, 50, 15);
      panel.add(label_2);
      JLabel lblPranavJVyas = new JLabel("Pranav J Vyas");
      lblPranavJVyas.setFont(new Font("Segoe UI Emoji", 0, 13));
      lblPranavJVyas.setBounds(70, 10, 170, 15);
      panel.add(lblPranavJVyas);
      JLabel label_3 = new JLabel("pranavvyas4399@gmail.com");
      label_3.setFont(new Font("Segoe UI Emoji", 0, 13));
      label_3.setBounds(70, 35, 170, 15);
      panel.add(label_3);
      JLabel label_5 = new JLabel("Follow me on :");
      label_5.setFont(new Font("Segoe UI Emoji", 0, 13));
      label_5.setBounds(10, 85, 100, 15);
      panel.add(label_5);
      JButton fbBtn = new MaterialButton("Facebook");
      Image fbsmall = (new ImageIcon(this.getClass().getResource("/fbsmall.png"))).getImage();
      fbBtn.setIcon(new ImageIcon(fbsmall));
      fbBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("https://www.facebook.com/pranav.vyas.330"));
            } catch (IOException var3) {
               var3.printStackTrace();
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }

         }
      });
      fbBtn.setBounds(120, 85, 200, 20);
      panel.add(fbBtn);
      JButton ghBtn = new MaterialButton("GitHub");
      ghBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("https://github.com/PranavVyas"));
            } catch (IOException var3) {
               var3.printStackTrace();
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }

         }
      });
      Image ghsmall = (new ImageIcon(this.getClass().getResource("/ghsmall.png"))).getImage();
      ghBtn.setIcon(new ImageIcon(ghsmall));
      ghBtn.setBounds(120, 110, 200, 20);
      panel.add(ghBtn);
      JButton heBtn = new MaterialButton("HackerEarth");
      heBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("http://www.hackerearth.com/@pranavvyas4399"));
            } catch (IOException var3) {
               var3.printStackTrace();
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }

         }
      });
      Image hesmall = (new ImageIcon(this.getClass().getResource("/hesmall.png"))).getImage();
      heBtn.setIcon(new ImageIcon(hesmall));
      heBtn.setBounds(120, 135, 200, 20);
      panel.add(heBtn);
      JButton bpBtn = new MaterialButton("Go to my Website");
      bpBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("https://programmingandtech.000webhostapp.com/prohotspot"));
            } catch (IOException var3) {
               var3.printStackTrace();
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }

         }
      });
      bpBtn.setBounds(70, 56, 250, 20);
      panel.add(bpBtn);
   }
}

package com.ProHotspot.Beta.initial;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutApp {
   private JFrame frmAboutProhotspot;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AboutApp window = new AboutApp();
               window.frmAboutProhotspot.setVisible(true);
               window.frmAboutProhotspot.setResizable(false);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
   }

   public AboutApp() {
      this.initialize();
   }

   private void initialize() {
      this.frmAboutProhotspot = new JFrame();
      this.frmAboutProhotspot.getContentPane().setBackground(Color.WHITE);
      this.frmAboutProhotspot.getContentPane().setFont(new Font("Segoe UI Emoji", 0, 12));
      this.frmAboutProhotspot.setIconImage((new ImageIcon(this.getClass().getResource("/logo.png"))).getImage());
      this.frmAboutProhotspot.setTitle("About ProHotspot");
      this.frmAboutProhotspot.setBounds(100, 100, 500, 300);
      this.frmAboutProhotspot.setDefaultCloseOperation(2);
      this.frmAboutProhotspot.getContentPane().setLayout((LayoutManager)null);
      JLabel lblNewLabel = new JLabel("ProHotspot");
      lblNewLabel.setFont(new Font("Segoe UI Emoji", 0, 12));
      lblNewLabel.setBounds(249, 27, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(lblNewLabel);
      JLabel lblAppilactionName = new JLabel("Appilaction Name :");
      lblAppilactionName.setFont(new Font("Segoe UI Emoji", 0, 12));
      lblAppilactionName.setBounds(109, 27, 120, 14);
      this.frmAboutProhotspot.getContentPane().add(lblAppilactionName);
      JLabel label = new JLabel("Appilaction Version :");
      label.setFont(new Font("Segoe UI Emoji", 0, 12));
      label.setBounds(109, 52, 120, 14);
      this.frmAboutProhotspot.getContentPane().add(label);
      JLabel label_1 = new JLabel("2.4.3");
      label_1.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_1.setBounds(249, 52, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(label_1);
      JLabel label_2 = new JLabel("Appilaction Copyright :");
      label_2.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_2.setBounds(109, 102, 130, 14);
      this.frmAboutProhotspot.getContentPane().add(label_2);
      JLabel label_3 = new JLabel("Pranav Vyas");
      label_3.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_3.setBounds(249, 102, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(label_3);
      JLabel label_4 = new JLabel("");
      label_4.setBounds(10, 27, 90, 90);
      Image icsmall = (new ImageIcon(this.getClass().getResource("/logosmall.jpeg"))).getImage();
      label_4.setIcon(new ImageIcon(icsmall));
      this.frmAboutProhotspot.getContentPane().add(label_4);
      JLabel License = new JLabel("Licensed");
      License.setFont(new Font("Segoe UI Emoji", 0, 12));
      License.setBounds(109, 127, 120, 14);
      this.frmAboutProhotspot.getContentPane().add(License);
      JLabel LicLabel = new JLabel("NO");
      LicLabel.setFont(new Font("Segoe UI Emoji", 0, 12));
      LicLabel.setBounds(249, 127, 235, 14);

      try {
         if (Function2.checkLicAvailable()) {
            LicLabel.setText("Yes");
         } else {
            LicLabel.setText("No");
         }
      } catch (IOException var17) {
         var17.printStackTrace();
      }

      this.frmAboutProhotspot.getContentPane().add(LicLabel);
      JLabel lblCredites = new JLabel("Credites:");
      lblCredites.setFont(new Font("Segoe UI Emoji", 0, 12));
      lblCredites.setBounds(109, 152, 120, 14);
      this.frmAboutProhotspot.getContentPane().add(lblCredites);
      JLabel label_5 = new JLabel("Created and developed by : Pranav Vyas");
      label_5.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_5.setBounds(249, 152, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(label_5);
      JLabel label_6 = new JLabel("Based on AES Encryption 16 bit");
      label_6.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_6.setBounds(249, 168, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(label_6);
      JLabel label_7 = new JLabel("Encryption Algorithm by:www.codejava.net");
      label_7.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_7.setBounds(249, 184, 235, 14);
      this.frmAboutProhotspot.getContentPane().add(label_7);
      JLabel label_8 = new JLabel("Last Update Date :");
      label_8.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_8.setBounds(109, 77, 120, 14);
      this.frmAboutProhotspot.getContentPane().add(label_8);
      JLabel label_9 = new JLabel("October 4,2017");
      label_9.setFont(new Font("Segoe UI Emoji", 0, 12));
      label_9.setBounds(249, 77, 225, 14);
      this.frmAboutProhotspot.getContentPane().add(label_9);
   }
}

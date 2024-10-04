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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class LicenseWindow extends JFrame {
   protected static final String LicenceWindow = null;
   private JPanel contentPane;
   private JTextField name;
   private JTextField key;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               LicenseWindow frame = new LicenseWindow();
               frame.setVisible(true);
               int qq = Function.exeRun("net user > userInfo");
               frame.setResizable(false);
            } catch (Exception var3) {
               var3.printStackTrace();
            }

         }
      });
   }

   public LicenseWindow() {
      this.setIconImage((new ImageIcon(this.getClass().getResource("/logo.png"))).getImage());
      this.setTitle("Activation");
      File lic = new File("Licence.file");
      if (!lic.exists()) {
         try {
            PrintWriter out = new PrintWriter("Licence.file");
            out.close();
         } catch (FileNotFoundException var10) {
            var10.printStackTrace();
         }
      }

      this.setDefaultCloseOperation(2);
      this.setBounds(100, 100, 500, 300);
      this.contentPane = new JPanel();
      this.contentPane.setBackground(Color.WHITE);
      this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      this.setContentPane(this.contentPane);
      this.contentPane.setLayout((LayoutManager)null);
      JLabel lblRegistration = new JLabel("Registration");
      lblRegistration.setHorizontalAlignment(0);
      lblRegistration.setFont(new Font("Trebuchet MS", 0, 18));
      lblRegistration.setBounds(185, 10, 100, 30);
      this.contentPane.add(lblRegistration);
      JLabel lblName = new JLabel("Name           :");
      lblName.setFont(new Font("Sylfaen", 0, 15));
      lblName.setBounds(149, 51, 100, 20);
      this.contentPane.add(lblName);
      JLabel label = new JLabel("Product Key :");
      label.setFont(new Font("Sylfaen", 0, 15));
      label.setBounds(149, 80, 100, 20);
      this.contentPane.add(label);
      this.name = new JTextField();
      this.name.setBounds(274, 51, 200, 20);
      this.contentPane.add(this.name);
      this.name.setColumns(10);
      this.key = new JTextField();
      this.key.setColumns(10);
      this.key.setBounds(274, 80, 200, 20);
      this.contentPane.add(this.key);
      JButton btnRegister = new MaterialButton("Register");
      btnRegister.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (LicenseWindow.this.name.getText().length() != 0) {
               boolean res = Function2.checkLic(LicenseWindow.this.name, LicenseWindow.this.key);
               if (res) {
                  new MaterilaDialog("Result", "<html>Registered Successfully<br>Please Restart for take effect</html>", "NORMAL");

                  try {
                     Function2.generateInfo(LicenseWindow.this.name);
                  } catch (Exception var5) {
                     var5.printStackTrace();
                  }
               } else {
                  new MaterilaDialog("Result", "<html>Wrong KEY or NAME !!!<br>Not Registered Successfully</html>", "CANCEL");
               }
            } else {
               new MaterilaDialog("Result", "Username must not be Empty", "WARNING");
            }

         }
      });
      btnRegister.setBounds(200, 130, 100, 30);
      this.contentPane.add(btnRegister);
      JButton button = new MaterialButton("Get New For FREE NOW");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("https://programmingandtech.000webhostapp.com/how-to-register-free-for-prohotspot"));
            } catch (IOException var3) {
               var3.printStackTrace();
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }

         }
      });
      button.setBounds(149, 171, 200, 30);
      this.contentPane.add(button);
      JLabel label_1 = new JLabel("");
      label_1.setBounds(30, 51, 85, 85);
      Image img = (new ImageIcon(this.getClass().getResource("/reg.png"))).getImage();
      label_1.setIcon(new ImageIcon(img));
      this.contentPane.add(label_1);
   }

   public static void close() {
      close();
   }
}

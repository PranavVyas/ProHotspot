package com.ProHotspot.Beta.initial;

import com.ProHotspot.MaterialUI.MaterialButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaterilaDialog extends JDialog {
   private final JPanel contentPanel = new JPanel();
   private JButton cancelButton;
   private JButton okButton;

   public MaterilaDialog(String title, String msg, String type) {
      String[] args = new String[]{title, msg, type};
      main(args);
   }

   public MaterilaDialog(String title, String msg, String type, String oktype) {
      String[] args = new String[]{title, msg, type, oktype};
      main(args);
   }

   public MaterilaDialog(String title, String msg) {
      String[] args = new String[]{title, msg, "NORMAL"};
      main(args);
   }

   public static void main(String[] args) {
      try {
         MaterilaDialog dialog = new MaterilaDialog(args);
         dialog.setDefaultCloseOperation(2);
         dialog.setVisible(true);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public MaterilaDialog(final String[] args) {
      this.getContentPane().setBackground(Color.WHITE);
      this.setBounds(100, 100, 450, 249);
      this.setTitle(args[0]);
      this.getContentPane().setLayout((LayoutManager)null);
      JPanel buttonPane = new JPanel();
      buttonPane.setBackground(Color.WHITE);
      buttonPane.setBounds(0, 172, 434, 34);
      this.getContentPane().add(buttonPane);
      this.okButton = new MaterialButton("OK");
      this.okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (args.length == 4) {
               try {
                  Desktop.getDesktop().browse(new URI("https://programmingandtech.000webhostapp.com/download-prohotspot"));
               } catch (IOException var4) {
                  new MaterilaDialog("", "<html>Could not connect to internet<br>Check connection and try again</html>", "CANCEL");
                  var4.printStackTrace();
               } catch (URISyntaxException var5) {
                  new MaterilaDialog("", "<html>Server is down<br>Try after some time</html>", "CANCEL");
                  var5.printStackTrace();
               }
            } else {
               MaterilaDialog.this.dispose();
            }

         }
      });
      this.cancelButton = new MaterialButton("Cancel");
      this.cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            MaterilaDialog.this.dispose();
         }
      });
      FlowLayout fl_buttonPane = new FlowLayout(1, 5, 5);
      buttonPane.setLayout(fl_buttonPane);
      buttonPane.add(this.okButton);
      buttonPane.add(this.cancelButton);
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(171, 11, 250, 150);
      this.getContentPane().add(panel);
      panel.setLayout((LayoutManager)null);
      JLabel img = new JLabel("");
      img.setBackground(Color.WHITE);
      img.setBounds(10, 11, 150, 150);
      this.getContentPane().add(img);
      Image i1;
      if (args[2] == "NORMAL") {
         i1 = (new ImageIcon(this.getClass().getResource("/ok.png"))).getImage();
         img.setIcon(new ImageIcon(i1));
      } else if (args[2] == "CANCEL") {
         i1 = (new ImageIcon(this.getClass().getResource("/cancel.png"))).getImage();
         img.setIcon(new ImageIcon(i1));
      } else {
         i1 = (new ImageIcon(this.getClass().getResource("/warning.png"))).getImage();
         img.setIcon(new ImageIcon(i1));
      }

      JLabel lblLabel = new JLabel(args[1]);
      lblLabel.setFont(new Font("Segoe UI Emoji", 1, 15));
      lblLabel.setHorizontalAlignment(0);
      lblLabel.setBounds(10, 11, 230, 128);
      panel.add(lblLabel);
      JLabel mMsg = new JLabel(args[1]);
      mMsg.setBounds(10, 11, 414, 206);
      if (args.length == 4) {
         this.okButton.setText("Download Now");
      }

      this.setResizable(false);
   }
}

package com.ProHotspot.Instruction;

import com.ProHotspot.Beta.initial.Function;
import com.ProHotspot.Beta.initial.MaterilaDialog;
import com.ProHotspot.MaterialUI.MaterialButton;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions {
   private JFrame frmInstructions;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               File f = new File("GenInfo");
               if (!f.exists()) {
                  f.createNewFile();
                  PrintWriter out = new PrintWriter("GenInfo");
                  out.println("Firsttime tip : true");
                  out.close();
               }
            } catch (IOException var4) {
               var4.printStackTrace();
            }

            try {
               if (Function.searchInFile("GenInfo", "Firsttime tip : false") == "-1") {
                  new MaterilaDialog("Alert", "<html>Now You will be redirected to Instruction page...<br>*If you know already check Don't show this again to prevent opening in future...<br>*If You have already Checked Do not Show this again Kindly Ignore this dialog and press OK</html>", "WARNING");
                  Instructions window = new Instructions();
                  window.frmInstructions.setVisible(true);
               }
            } catch (Exception var3) {
               var3.printStackTrace();
            }

         }
      });
   }

   public static void startForce(boolean res) {
      if (!res) {
         EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                  File f = new File("GenInfo");
                  if (!f.exists()) {
                     f.createNewFile();
                     PrintWriter out = new PrintWriter("GenInfo");
                     out.println("Firsttime tip : true");
                     out.close();
                  }
               } catch (IOException var4) {
                  var4.printStackTrace();
               }

               try {
                  if (Function.searchInFile("GenInfo", "Firsttime tip : false") == "-1") {
                     Instructions window = new Instructions();
                     window.frmInstructions.setVisible(true);
                  }
               } catch (Exception var3) {
                  var3.printStackTrace();
               }

            }
         });
      } else {
         EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                  File f = new File("GenInfo");
                  if (!f.exists()) {
                     f.createNewFile();
                     PrintWriter out = new PrintWriter("GenInfo");
                     out.println("Firsttime tip : true");
                     out.close();
                  }
               } catch (IOException var4) {
                  var4.printStackTrace();
               }

               try {
                  Instructions window = new Instructions();
                  window.frmInstructions.setVisible(true);
               } catch (Exception var3) {
                  var3.printStackTrace();
               }

            }
         });
      }

   }

   public Instructions() {
      this.initialize();
   }

   private void initialize() {
      int HIGHT = 540;
      int WIDTH = 960;
      this.frmInstructions = new JFrame();
      this.frmInstructions.setIconImage((new ImageIcon(this.getClass().getResource("/logo.png"))).getImage());
      this.frmInstructions.setTitle("Instructions");
      this.frmInstructions.setBounds(100, 100, WIDTH + 100, HIGHT + 130);
      this.frmInstructions.setDefaultCloseOperation(2);
      this.frmInstructions.setResizable(false);
      this.frmInstructions.getContentPane().setLayout((LayoutManager)null);
      final JLabel l1 = new JLabel("");
      Image i1 = (new ImageIcon(this.getClass().getResource("/ins1.png"))).getImage();
      l1.setIcon(new ImageIcon(i1));
      l1.setBounds(50, 10, WIDTH, HIGHT);
      this.frmInstructions.getContentPane().add(l1);
      final JLabel lblStep = new JLabel("Step 1");
      lblStep.setFont(new Font("Trebuchet MS", 0, 16));
      lblStep.setHorizontalAlignment(0);
      lblStep.setBounds(WIDTH / 2 - 50, HIGHT + 10, 100, 30);
      this.frmInstructions.getContentPane().add(lblStep);
      JButton nxtbtn = new MaterialButton("Next");
      nxtbtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            this.changeImg(l1, lblStep);
         }

         private void changeImg(JLabel lb, JLabel lb2) {
            int no = Integer.valueOf(lb2.getText().substring(5));
            if (no == 1) {
               Function.exeRun("ncpa.cpl");
            }

            if (no < 8) {
               ++no;
               String str = "/ins" + no + ".png";
               Image i1 = (new ImageIcon(this.getClass().getResource(str))).getImage();
               lb.setIcon(new ImageIcon(i1));
               lb2.setText("Step " + no);
            } else {
               ++no;
            }

            if (no > 8) {
               Instructions.this.frmInstructions.setVisible(false);
               Instructions.this.frmInstructions.dispose();
            }

         }
      });
      nxtbtn.setBounds(WIDTH / 2 - 50, HIGHT + 50, 100, 30);
      this.frmInstructions.getContentPane().add(nxtbtn);
      final JCheckBox chckbxDontShowThis = new JCheckBox("Don't Show this next time");
      chckbxDontShowThis.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent arg0) {
            if (chckbxDontShowThis.isSelected()) {
               Function3.Checkbox(true);
            } else {
               Function3.Checkbox(false);
            }

         }
      });
      chckbxDontShowThis.setBounds(50, 590, 231, 27);
      this.frmInstructions.getContentPane().add(chckbxDontShowThis);
      JButton btnSeeItLive = new MaterialButton("See It LIVE !");
      btnSeeItLive.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Desktop.getDesktop().browse(new URI("https://youtu.be/na2B6SzoSJ4"));
            } catch (URISyntaxException | IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      btnSeeItLive.setBounds(812, 590, 198, 30);
      this.frmInstructions.getContentPane().add(btnSeeItLive);
   }
}

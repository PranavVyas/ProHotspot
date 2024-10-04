package com.ProHotspot.Beta.initial;

import com.ProHotspot.Beta.update.FunctionUpdate;
import com.ProHotspot.Instruction.Instructions;
import com.ProHotspot.MaterialUI.MaterialButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Window {
   private static JFrame frmProHotspotV;
   private JTextField name;
   private JPasswordField passwordField;
   private JTextField textField;

   public static void main(String[] args) throws Exception {
      File f = new File("Profiles.mp3");
      if (!f.exists()) {
         f.createNewFile();
      }

      File f2 = new File("userInfo");
      if (!f2.exists()) {
         f2.createNewFile();
      }

      File f3 = new File("userInfo2");
      if (!f3.exists()) {
         f3.createNewFile();
      }

      int qw = Function.exeRun("net user > userInfo2");
      int qr = Function.exeRun("net user > userInfo");
      int qt = Function.exeRun("netsh wlan show hostednetwork > WiFi.file");
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               new Window();
               Window.frmProHotspotV.setVisible(true);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
   }

   public Window() throws IOException {
      this.initialize();
   }

   private void initialize() throws IOException {
      frmProHotspotV = new JFrame();
      frmProHotspotV.getContentPane().setBackground(Color.WHITE);
      frmProHotspotV.setTitle("ProHotspot v2");
      frmProHotspotV.setBackground(new Color(153, 255, 255));
      frmProHotspotV.setBounds(100, 100, 750, 500);
      frmProHotspotV.setIconImage((new ImageIcon(this.getClass().getResource("/logo.png"))).getImage());
      frmProHotspotV.setDefaultCloseOperation(3);
      frmProHotspotV.getContentPane().setLayout((LayoutManager)null);
      int fHight = frmProHotspotV.getHeight();
      int fWidth = frmProHotspotV.getWidth();
      frmProHotspotV.setResizable(false);
      JButton[] saveSaveP = new JButton[3];
      final JButton[] openActiP = new JButton[3];
      JPanel[] Panel = new JPanel[6];
      final JLabel[] saveNameP = new JLabel[3];
      final JLabel[] openNameP = new JLabel[3];
      JLabel lblHotspotName = new JLabel("Hotspot Password");
      lblHotspotName.setFont(new Font("Segoe UI Emoji", 0, 13));
      lblHotspotName.setBounds(50, 140, 150, 30);
      frmProHotspotV.getContentPane().add(lblHotspotName);
      JLabel label = new JLabel("Hotspot Name");
      label.setFont(new Font("Segoe UI Emoji", 0, 13));
      label.setBounds(50, 100, 150, 30);
      frmProHotspotV.getContentPane().add(label);
      this.textField = new JTextField();
      this.textField.setEnabled(false);
      this.textField.setVisible(false);
      this.textField.setBounds(200, 140, 200, 30);
      frmProHotspotV.getContentPane().add(this.textField);
      this.textField.setColumns(10);
      this.passwordField = new JPasswordField();
      this.passwordField.setBackground(Color.WHITE);
      this.passwordField.setBounds(200, 140, 200, 30);
      frmProHotspotV.getContentPane().add(this.passwordField);
      this.name = new JTextField();
      this.name.setBackground(Color.WHITE);
      this.name.setBounds(200, 100, 200, 30);
      frmProHotspotV.getContentPane().add(this.name);
      this.name.setColumns(10);
      JButton btnStartHotspot = new MaterialButton("Start Hotspot");
      btnStartHotspot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String hName = Window.this.name.getText().toString();
            new String();
            String hPass;
            if (Window.this.passwordField.isVisible()) {
               hPass = Window.this.passwordField.getText().toString();
            } else {
               hPass = Window.this.textField.getText().toString();
            }

            if (Function.check(hPass, hName) == 1) {
               new MaterilaDialog("Warning", "<html>*Password must be 8 - 63 characters<br>*Username must not Empty</html>", "CANCEL");
            } else {
               try {
                  Function.setHotspot(hName, hPass);
                  if (Function.checkStart() == 0) {
                     new MaterilaDialog("Successful", "<html>Hotspot Started Sucessfully...<br>Enjoy Wifi Hotspot</html>", "NORMAL");
                     Instructions.main((String[])null);
                  } else {
                     new MaterilaDialog("Error", "<html>Hotspot didn't Started<br>*Try Restarting Hotspot<br>*WiFi might be turned off<br>*If Problem occurs contact Support</html>", "CANCEL");
                  }
               } catch (IOException var5) {
                  var5.printStackTrace();
               }
            }

         }
      });
      btnStartHotspot.setBounds(50, 243, 150, 30);
      frmProHotspotV.getContentPane().add(btnStartHotspot);
      JButton btnStopHotspot = new MaterialButton("Stop Hotspot");
      btnStopHotspot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try {
               Function.stopHotspot();
               if (Function.checkStop() == 0) {
                  new MaterilaDialog("Stopped", "<html>Hotspot Stopped Sucessfully...<br>Thank you for using Wifi Hotspot</html>", "NORMAL");
               } else {
                  new MaterilaDialog("Error", "<html>Hotspot didn't stopped<br>*Try Restarting Hotspot<br>*Hotspot was not Started<br>*If Problem occurs contact Support </html>", "CANCEL");
               }
            } catch (IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      btnStopHotspot.setBounds(250, 243, 150, 30);
      frmProHotspotV.getContentPane().add(btnStopHotspot);
      JLabel lblNewLabel = new JLabel("ProHotspot");
      lblNewLabel.setHorizontalAlignment(0);
      lblNewLabel.setBounds(109, 11, 241, 42);
      lblNewLabel.setFont(new Font("Trebuchet MS", 1, 35));
      frmProHotspotV.getContentPane().add(lblNewLabel);
      JLabel lblMadeWithLove = new JLabel("No limits to Sharing");
      lblMadeWithLove.setBounds(226, 52, 207, 20);
      lblMadeWithLove.setFont(new Font("Segoe Script", 1, 15));
      frmProHotspotV.getContentPane().add(lblMadeWithLove);
      JTabbedPane tabbedPane = new JTabbedPane(1);
      tabbedPane.setBounds(475, 0, 269, 450);
      frmProHotspotV.getContentPane().add(tabbedPane);
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      tabbedPane.addTab("Save", (Icon)null, panel, (String)null);
      panel.setLayout((LayoutManager)null);
      Panel[3] = new JPanel();
      Panel[3].setBounds(10, 233, 244, 100);
      panel.add(Panel[3]);
      Panel[3].setLayout((LayoutManager)null);
      saveNameP[2] = new JLabel("Username");
      saveNameP[2].setBounds(10, 36, 224, 14);
      Panel[3].add(saveNameP[2]);
      JLabel label_11 = new JLabel("Profile 3");
      label_11.setFont(new Font("Segoe UI Emoji", 0, 15));
      label_11.setBounds(10, 11, 224, 14);
      Panel[3].add(label_11);
      boolean flaggg = true;
      final JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
      chckbxShowPassword.setFont(new Font("Segoe UI Emoji", 0, 13));
      chckbxShowPassword.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (chckbxShowPassword.isSelected()) {
               boolean flaggg = false;
               String rrr = Window.this.passwordField.getText();
               Window.this.textField.setEnabled(true);
               Window.this.textField.setVisible(true);
               Window.this.passwordField.setVisible(false);
               Window.this.passwordField.setEnabled(false);
               Window.this.textField.setText(rrr);
            } else {
               String rrrx = Window.this.textField.getText();
               Window.this.textField.setEnabled(false);
               Window.this.textField.setVisible(false);
               Window.this.passwordField.setVisible(true);
               Window.this.passwordField.setEnabled(true);
               Window.this.passwordField.setText(rrrx);
            }

         }
      });
      chckbxShowPassword.setBackground(Color.WHITE);
      chckbxShowPassword.setBounds(200, 170, 123, 23);
      frmProHotspotV.getContentPane().add(chckbxShowPassword);
      saveSaveP[2] = new MaterialButton("Save");
      saveSaveP[2].setEnabled(true);
      saveSaveP[2].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               if (chckbxShowPassword.isSelected()) {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 3, 0, Window.this.textField);
               } else {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 3, 1, Window.this.textField);
               }
            } catch (IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      saveSaveP[2].setBounds(10, 61, 224, 23);
      Panel[3].add(saveSaveP[2]);
      Panel[4] = new JPanel();
      Panel[4].setBounds(10, 122, 244, 100);
      panel.add(Panel[4]);
      Panel[4].setLayout((LayoutManager)null);
      saveNameP[1] = new JLabel("Username");
      saveNameP[1].setBounds(10, 36, 224, 14);
      Panel[4].add(saveNameP[1]);
      JLabel label_9 = new JLabel("Profile 2");
      label_9.setFont(new Font("Segoe UI Emoji", 0, 15));
      label_9.setBounds(10, 11, 224, 14);
      Panel[4].add(label_9);
      saveSaveP[1] = new MaterialButton("Save");
      saveSaveP[1].setEnabled(true);
      saveSaveP[1].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               if (chckbxShowPassword.isSelected()) {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 2, 0, Window.this.textField);
               } else {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 2, 1, Window.this.textField);
               }
            } catch (IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      saveSaveP[1].setBounds(10, 61, 224, 23);
      Panel[4].add(saveSaveP[1]);
      Panel[5] = new JPanel();
      Panel[5].setBounds(10, 11, 244, 100);
      panel.add(Panel[5]);
      JButton saveRefreshAll = new MaterialButton("Refresh All");
      saveRefreshAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Function.refreshAll(openNameP, saveNameP, openActiP);
         }
      });
      saveRefreshAll.setBounds(10, 392, 244, 30);
      panel.add(saveRefreshAll);
      Panel[5].setLayout((LayoutManager)null);
      saveNameP[0] = new JLabel("Username");
      saveNameP[0].setBounds(10, 36, 224, 14);
      Panel[5].add(saveNameP[0]);
      JLabel label_7 = new JLabel("Profile 1");
      label_7.setFont(new Font("Segoe UI Emoji", 0, 15));
      label_7.setBounds(10, 11, 224, 14);
      Panel[5].add(label_7);
      saveSaveP[0] = new MaterialButton("Save");
      saveSaveP[0].setEnabled(true);
      saveSaveP[0].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               if (chckbxShowPassword.isSelected()) {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 1, 0, Window.this.textField);
               } else {
                  Function.saveProfile(Window.this.name, Window.this.passwordField, "Profiles.mp3", 1, 1, Window.this.textField);
               }
            } catch (IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      saveSaveP[0].setBounds(10, 61, 224, 23);
      Panel[5].add(saveSaveP[0]);
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(Color.WHITE);
      tabbedPane.addTab("Open", (Icon)null, panel_1, (String)null);
      panel_1.setLayout((LayoutManager)null);
      Panel[0] = new JPanel();
      Panel[0].setBounds(10, 11, 244, 100);
      panel_1.add(Panel[0]);
      Panel[0].setLayout((LayoutManager)null);
      JLabel lblProfile = new JLabel("Profile 1");
      lblProfile.setFont(new Font("Segoe UI Emoji", 0, 15));
      lblProfile.setBounds(10, 11, 224, 14);
      Panel[0].add(lblProfile);
      openNameP[0] = new JLabel("Username");
      openNameP[0].setBounds(10, 36, 224, 14);
      Panel[0].add(openNameP[0]);
      openActiP[0] = new MaterialButton("Activate");
      openActiP[0].setEnabled(true);
      openActiP[0].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Function.activateProfile("Profiles.mp3", Window.this.name, Window.this.passwordField, 1, Window.this.textField);
         }
      });
      openActiP[0].setBounds(10, 61, 224, 23);
      Panel[0].add(openActiP[0]);
      Panel[1] = new JPanel();
      Panel[1].setBounds(10, 122, 244, 100);
      panel_1.add(Panel[1]);
      Panel[1].setLayout((LayoutManager)null);
      openNameP[1] = new JLabel("Username");
      openNameP[1].setBounds(10, 36, 224, 14);
      Panel[1].add(openNameP[1]);
      JLabel label_3 = new JLabel("Profile 2");
      label_3.setFont(new Font("Segoe UI Emoji", 0, 15));
      label_3.setBounds(10, 11, 224, 14);
      Panel[1].add(label_3);
      openActiP[1] = new MaterialButton("Activate");
      openActiP[1].setEnabled(true);
      openActiP[1].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Function.activateProfile("Profiles.mp3", Window.this.name, Window.this.passwordField, 2, Window.this.textField);
         }
      });
      openActiP[1].setBounds(10, 61, 224, 23);
      Panel[1].add(openActiP[1]);
      Panel[2] = new JPanel();
      Panel[2].setBounds(10, 233, 244, 100);
      panel_1.add(Panel[2]);
      Panel[2].setLayout((LayoutManager)null);
      JButton openRefreshAll = new MaterialButton("Refresh All");
      openRefreshAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Function.refreshAll(openNameP, saveNameP, openActiP);
         }
      });
      openRefreshAll.setBounds(10, 392, 244, 30);
      panel_1.add(openRefreshAll);
      final JPanel panel_2 = new JPanel();
      panel_2.setBackground(Color.WHITE);
      tabbedPane.addTab("Additional", (Icon)null, panel_2, (String)null);
      panel_2.setLayout((LayoutManager)null);
      JLabel lblConnectedUsers = new JLabel("Connected Users :");
      lblConnectedUsers.setFont(new Font("Segoe UI Emoji", 0, 13));
      lblConnectedUsers.setBounds(10, 11, 117, 25);
      panel_2.add(lblConnectedUsers);
      final JLabel noUses = new JLabel("");
      noUses.setBounds(137, 11, 117, 25);
      panel_2.add(noUses);
      Panel[2].setLayout((LayoutManager)null);
      final JPanel p = new JPanel();
      p.setBackground(new Color(255, 255, 255));
      p.setLayout(new GridLayout(100, 1, 100, 0));
      JScrollPane scrollPane = new JScrollPane(p);
      scrollPane.setBounds(10, 47, 244, 339);
      panel_2.add(scrollPane);
      JButton btnNewButton = new MaterialButton("Refresh Users");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Function.exeRun("netsh wlan show hostednetwork > users");
            Function.refreshUser(noUses, panel_2);
            Function.usersInfo(p, noUses, panel_2);
         }
      });
      btnNewButton.setBounds(10, 392, 244, 30);
      panel_2.add(btnNewButton);
      new JLabel("ddd");
      new JLabel("ddd");
      new JLabel("ddd");
      new JLabel("ddd");
      openNameP[2] = new JLabel("Username");
      openNameP[2].setBounds(10, 36, 224, 14);
      Panel[2].add(openNameP[2]);
      JLabel label_5 = new JLabel("Profile 3");
      label_5.setFont(new Font("Segoe UI Emoji", 0, 15));
      label_5.setBounds(10, 11, 224, 14);
      Panel[2].add(label_5);
      openActiP[2] = new MaterialButton("Activate");
      openActiP[2].setEnabled(true);
      openActiP[2].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Function.activateProfile("Profiles.mp3", Window.this.name, Window.this.passwordField, 3, Window.this.textField);
         }
      });
      openActiP[2].setBounds(10, 61, 224, 23);
      Panel[2].add(openActiP[2]);
      JButton btnTestWifi = new MaterialButton("Test Wi-Fi");
      btnTestWifi.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               Function.checkWiFi();
               if (Function.checkWiFi() == 0) {
                  new MaterilaDialog("Sucessfull", "<html>Wi-Fi Test Sucessfull<br>Your Device Supports Wi-Fi Hotspot Service !!!</html>", "NORMAL");
               } else {
                  new MaterilaDialog("Result", "<html>Sorry ! Your Device does not Support Wi-Fi Hotspot Function</html>", "CANCEL");
               }
            } catch (IOException var3) {
               var3.printStackTrace();
            }

         }
      });
      btnTestWifi.setBounds(167, 200, 123, 30);
      frmProHotspotV.getContentPane().add(btnTestWifi);
      JLabel lblWarning = new JLabel("Warning : To Enable all the feature please activate product!!!\r\n");
      lblWarning.setFont(new Font("Trebuchet MS", 0, 14));
      lblWarning.setHorizontalAlignment(0);
      lblWarning.setBounds(10, 314, 455, 16);
      frmProHotspotV.getContentPane().add(lblWarning);
      JLabel lblWarning2 = new JLabel("You cannot use Profiles if not Activated");
      lblWarning2.setHorizontalAlignment(0);
      lblWarning2.setFont(new Font("Trebuchet MS", 0, 14));
      lblWarning2.setBounds(10, 330, 455, 16);
      frmProHotspotV.getContentPane().add(lblWarning2);
      JMenuBar menuBar_1 = new JMenuBar();
      frmProHotspotV.setJMenuBar(menuBar_1);
      JMenu mnAbout = new JMenu("About");
      menuBar_1.add(mnAbout);
      JMenuItem mntmAboutThisApplication = new JMenuItem("About This Application");
      mntmAboutThisApplication.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            AboutApp.main((String[])null);
         }
      });
      mnAbout.add(mntmAboutThisApplication);
      JMenuItem mntmAboutDeveloper = new JMenuItem("About Developer");
      mntmAboutDeveloper.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            AboutDeveloper.main((String[])null);
         }
      });
      mnAbout.add(mntmAboutDeveloper);
      JMenu mnLicense = new JMenu("Activate");
      menuBar_1.add(mnLicense);
      JMenuItem mntmRegister = new JMenuItem("Activate");
      mntmRegister.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            LicenseWindow.main((String[])null);
         }
      });
      mnLicense.add(mntmRegister);
      JMenu mnHelp = new JMenu("Help");
      menuBar_1.add(mnHelp);
      JMenuItem mntmTopics = new JMenuItem("How to Enable Sharing");
      mntmTopics.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Instructions.startForce(true);
         }
      });
      mnHelp.add(mntmTopics);
      JMenuItem mntmConnectedButNo = new JMenuItem("Connected But no Internet Connection Problem");
      mntmConnectedButNo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Instructions.startForce(true);
         }
      });
      mnHelp.add(mntmConnectedButNo);
      JMenuItem mntmFaq = new JMenuItem("FAQ");
      mntmFaq.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            int q = Function.exeRun("ProHotspotFAQ.mht");
         }
      });
      mnHelp.add(mntmFaq);
      JMenuItem mntmCheckForUpdates = new JMenuItem("Check For Updates");
      mntmCheckForUpdates.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String CURR = "2.4.3";
            System.out.println("Checking for Update");
            String Latest = FunctionUpdate.latver();
            System.out.println("Latest Version is " + Latest);
            if (Latest != "-2" && Latest != "-3" && Latest != "-1") {
               if (Latest.compareTo(CURR) == 0) {
                  new MaterilaDialog("Message", "<html>There is no Update available now</html>", "NORMAL");
               } else {
                  new MaterilaDialog("Message", "<html>Latest Update available<br>Latest Version is " + Latest + "<br>Your Version is " + CURR + "</html>", "NORMAL", "Update");
               }
            } else {
               new MaterilaDialog("Message", "<html>Could not connect to internet<br>*Please connect to internet and try again</html>", "WARNING");
            }

         }
      });
      mnHelp.add(mntmCheckForUpdates);
      Function.refreshAll(openNameP, saveNameP, openActiP);

      int i;
      for(i = 0; i < 3; ++i) {
         saveNameP[i].setFont(new Font("Segoe UI Emoji", 0, 13));
         openNameP[i].setFont(new Font("Segoe UI Emoji", 0, 13));
      }

      for(i = 0; i < 6; ++i) {
         Panel[i].setForeground(Color.WHITE);
         Panel[i].setBackground(Color.WHITE);
      }

      if (!Function2.checkLicAvailable()) {
         for(i = 0; i < 6; ++i) {
            Panel[i].setEnabled(false);
         }

         for(i = 0; i < 3; ++i) {
            saveSaveP[i].setEnabled(false);
            openActiP[i].setEnabled(false);
            saveNameP[i].setEnabled(false);
            openNameP[i].setEnabled(false);
         }

         lblWarning.setEnabled(true);
         lblWarning.setVisible(true);
         lblWarning2.setEnabled(true);
         lblWarning2.setVisible(true);
      } else {
         for(i = 0; i < 6; ++i) {
            Panel[i].setEnabled(true);
         }

         for(i = 0; i < 3; ++i) {
            saveSaveP[i].setEnabled(true);
            openActiP[i].setEnabled(true);
            saveNameP[i].setEnabled(true);
            openNameP[i].setEnabled(true);
         }

         lblWarning.setEnabled(false);
         lblWarning.setVisible(false);
         lblWarning2.setEnabled(false);
         lblWarning2.setVisible(false);
      }

      Function.refreshUser(noUses, panel_2);
      Function.refreshAll(openNameP, saveNameP, openActiP);
   }

   public static void usersInfo(JPanel p) {
   }
}

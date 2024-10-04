package com.ProHotspot.Beta.initial;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Function {
   public static void stopHotspot() throws IOException {
      String command = "netsh wlan stop hostednetwork > resStop";
      exeRun(command);
   }

   public static int checkStop() {
      try {
         return searchInFile("resStop", "The hosted network stopped") != "-1" ? 0 : 1;
      } catch (IOException var1) {
         var1.printStackTrace();
         return 1;
      }
   }

   public static void setHotspot(String name, String password) throws IOException {
      String command = "netsh wlan set hostednetwork mode=allow ssid=\"" + name + "\" key=\"" + password + "\"";
      exeRun(command);
      command = "netsh wlan start hostednetwork  > setRes.File";
      exeRun(command);
      exeRun("exit");
   }

   public static int checkStart() {
      try {
         if (searchInFile("setRes.File", "The hosted network started.") != "-1") {
            System.out.println("checkStart : Returning 0");
            return 0;
         } else {
            System.out.println("checkStart : Returning -1");
            return 1;
         }
      } catch (IOException var1) {
         var1.printStackTrace();
         return 1;
      }
   }

   public static int check(String Pass, String Name) {
      return Pass.length() >= 8 && Pass.length() <= 63 && !Name.isEmpty() ? 0 : 1;
   }

   public static void WriteInFile(int pno, String str, String fname) {
      try {
         FileWriter fw = new FileWriter(fname, true);
         BufferedWriter bf = new BufferedWriter(fw);
         bf.write(str + "\n");
         bf.close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   public static String readFromFile(String fname, String search) {
      try {
         FileReader fr = new FileReader(fname);
         BufferedReader br = new BufferedReader(fr);
         String string = "Init";

         while(string.length() != 0) {
            string = br.readLine();
            if (string.contains(search)) {
               break;
            }
         }

         br.close();
         return string;
      } catch (IOException var5) {
         var5.printStackTrace();
         return "Failed";
      }
   }

   public static int checkWiFi() throws IOException {
      FileReader fr = new FileReader("WiFi.file");
      BufferedReader br = new BufferedReader(fr);
      String string = "Init";
      string = br.readLine();
      string = br.readLine();

      boolean flag;
      for(flag = false; string.length() != 0; string = br.readLine()) {
         if (string.contains("Mode                   : Allowed")) {
            flag = true;
            break;
         }
      }

      br.close();
      return flag ? 0 : 1;
   }

   public static String searchInFile(String fname, String search) throws IOException {
      File file = new File(fname);
      if (!file.exists()) {
         file.createNewFile();
      }

      FileReader fr = new FileReader(fname);
      BufferedReader br = new BufferedReader(fr);
      new String();
      boolean flag = false;
      String result = new String();

      String string;
      while((string = br.readLine()) != null) {
         System.out.println("read : " + string);
         if (string.length() > 0) {
            if (string.contains(search)) {
               flag = true;
               result = string;
               break;
            }

            flag = false;
         } else {
            flag = false;
         }
      }

      return !flag ? "-1".toString() : result;
   }

   public static void replaceWordInFiles(String fname, String original, String replace) {
      List<String> lines = new ArrayList();
      System.out.println("Got Original string as : " + original);
      System.out.println("Got Replace string as : " + replace);
      String line = null;

      try {
         File f1 = new File(fname);
         FileReader fr = new FileReader(f1);

         BufferedReader br;
         for(br = new BufferedReader(fr); (line = br.readLine()) != null; lines.add(line)) {
            if (line.indexOf(original) != -1) {
               line = line.replace(original, replace);
            }
         }

         fr.close();
         br.close();
         FileWriter fw = new FileWriter(f1);
         BufferedWriter out = new BufferedWriter(fw);
         Iterator var11 = lines.iterator();

         while(var11.hasNext()) {
            String s = (String)var11.next();
            out.write(s + "\n");
            System.out.println("Writing " + s + "To file.");
         }

         out.flush();
         out.close();
      } catch (Exception var12) {
         var12.printStackTrace();
      }

   }

   public static void refreshLabelsSave(JLabel lbl, int no) {
      try {
         String uname = searchInFile("Profiles.mp3", "P_Name_" + no + " : ");
         if (uname.matches("-1")) {
            uname = "Not Set Yet";
         }

         lbl.setText(uname.replaceAll("P_Name_" + no + " : ", ""));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public static void refreshLabelsOpen(JLabel lbl, int no, JButton btn) {
      try {
         String uname = searchInFile("Profiles.mp3", "P_Name_" + no + " : ");
         if (uname.matches("-1")) {
            uname = "Not Set Yet";
            btn.setEnabled(false);
         } else {
            btn.setEnabled(true);
         }

         lbl.setText(uname.replaceAll("P_Name_" + no + " : ", ""));
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public static void saveProfile(JTextField name, JPasswordField passwordField, String fname, int no, int choise, JTextField tf) throws IOException {
      checkFile("Profiles.mp3");
      String hName = name.getText().toString();
      new String();
      String hPass;
      if (choise == 0) {
         hPass = tf.getText().toString();
      } else {
         hPass = passwordField.getText().toString();
      }

      if (!hName.isEmpty() && hPass.length() >= 8 && hPass.length() <= 64) {
         if (searchInFile("Profiles.mp3", "Profile " + no) != "-1") {
            System.out.println("Enetred when foundede");
            System.out.println("Relpacing with P_Name_" + no + " : " + hName + " and " + "P_Pass_" + no + " : " + hPass);
            replaceWordInFiles("Profiles.mp3", searchInFile("Profiles.mp3", "P_Name_" + no + " : "), "P_Name_" + no + " : " + hName);
            replaceWordInFiles("Profiles.mp3", searchInFile("Profiles.mp3", "P_Pass_" + no + " : "), "P_Pass_" + no + " : " + hPass);
         } else {
            WriteInFile(3, "Profile " + no, fname);
            WriteInFile(3, "P_Name_" + no + " : " + hName, fname);
            WriteInFile(3, "P_Pass_" + no + " : " + hPass, fname);
         }
      } else {
         new MaterilaDialog("Information", "<html>Didn't Saved It ,<br>Reasons might be : <br>*Username was Empty<br>*Password was not valid</html>", "CANAEL");
      }

   }

   public static void activateProfile(String fname, JTextField name, JPasswordField passwordField, int no, JTextField textField) {
      new String();
      new String();
      String hName = readFromFile(fname, "P_Name_" + no + " : ").replaceAll("P_Name_" + no + " : ", "");
      String hPass = readFromFile(fname, "P_Pass_" + no + " : ").replaceAll("P_Pass_" + no + " : ", "");
      System.out.println(" change : " + hName);
      System.out.println(" change : " + hPass);
      name.setText(hName);
      passwordField.setText(hPass);
      textField.setText(hPass);
   }

   public static int exeRun(String command) {
      try {
         Runtime rt = Runtime.getRuntime();
         Process pr = rt.exec("cmd /c " + command);
         BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
         String line = null;

         while((line = input.readLine()) != null) {
            System.out.println(line);
         }

         int exitVal = pr.waitFor();
         System.out.println("Exited with error code " + exitVal);
         return exitVal;
      } catch (Exception var6) {
         System.out.println(var6.toString());
         var6.printStackTrace();
         return -1;
      }
   }

   public static int checkStatus(String file) {
      exeRun("netsh wlan show hostednetwork > " + file);

      try {
         return searchInFile(file, "Status                 : Started") != "-1" ? 0 : 1;
      } catch (IOException var2) {
         var2.printStackTrace();
         return 1;
      }
   }

   public static void refreshAll(JLabel[] openNameP, JLabel[] saveNameP, JButton[] openActiP) {
      for(int i = 0; i < 3; ++i) {
         refreshLabelsOpen(openNameP[i], i + 1, openActiP[i]);
         refreshLabelsSave(saveNameP[i], i + 1);
      }

   }

   public static void checkFile(String file) throws IOException {
      File f = new File(file);
      if (!f.exists()) {
         f.createNewFile();
      }

   }

   public static void refreshUser(JLabel lbl, JPanel pnl) {
      File f = new File("users");

      try {
         checkFile("users");
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      try {
         int no = 0;
         int noo2 = 29;
         if (searchInFile("users", "Number of clients      :") != "-1") {
            no = Integer.valueOf(searchInFile("users", "Number of clients      :").substring(noo2));
         }

         lbl.setText("" + no);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      f.deleteOnExit();
   }

   public static void usersInfo(JPanel p, JLabel lbl, JPanel pnl) {
      try {
         int no = false;
         int noo2 = 29;
         p.removeAll();
         p.transferFocusBackward();
         String[] str = new String[100];
         if (searchInFile("users", "Number of clients      :") != "-1") {
            int no = Integer.valueOf(searchInFile("users", "Number of clients      :").substring(noo2));
            str = searchInFileSpecial("users", "Number of clients      :", no);
         }

         for(int i = 0; i < str.length - 1; ++i) {
            if (str[i] != null) {
               JLabel lblp = new JLabel("User " + i + " : " + str[i].replaceAll("       Authenticated", ""));
               lblp.setFont(new Font("Segoe UI Emoji", 0, 15));
               lblp.setBounds(0, 0, 224, 14);
               p.add(lblp, (Object)null);
            }
         }
      } catch (IOException var8) {
         var8.printStackTrace();
      }

   }

   public static String[] searchInFileSpecial(String fname, String search, int no) throws IOException {
      File file = new File(fname);
      if (!file.exists()) {
         file.createNewFile();
      }

      String[] rrr = new String[no + 1];
      FileReader fr = new FileReader(fname);
      BufferedReader br = new BufferedReader(fr);
      new String();
      boolean flag = false;
      new String();

      String string;
      while((string = br.readLine()) != null) {
         System.out.println("read : " + string);
         if (string.length() > 0) {
            if (string.contains(search)) {
               flag = true;
               break;
            }

            flag = false;
         } else {
            flag = false;
         }
      }

      for(int index = 0; (string = br.readLine()) != null; ++index) {
         rrr[index] = string;
      }

      return rrr;
   }
}

package com.ProHotspot.Beta.initial;

import com.ProHotspot.encryption.CryptoUtilsTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextField;

public class Function2 {
   public static String generateLictxt(String text) {
      return proenc(text);
   }

   public static String generateUPLictxt(String text) {
      return text;
   }

   public static String proenc(String str) {
      int temp2 = 0;
      int MAX = 90;
      int MIN = 65;
      String strret = "";

      for(int i = 0; i < str.length(); ++i) {
         int temp = str.charAt(i);

         int temp;
         for(temp = (temp + (int)Math.sqrt((double)(temp * (i + 1)))) * (temp + temp % (i + 7)) + i; temp > MAX || temp < MIN; temp = temp % MAX + MIN) {
         }

         temp2 += temp;
         strret = strret + (char)temp;
      }

      strret = strret + temp2;
      return strret;
   }

   public static boolean checkLic(JTextField name, JTextField key) {
      String LICORG = generateLictxt(name.getText());
      String LICUP = generateUPLictxt(key.getText());
      return LICORG.matches(LICUP);
   }

   public static void generateInfo(JTextField name) throws Exception {
      int qq = Function.exeRun("ipconfig");
      String ORGN = name.getText();
      String LICORG = generateLictxt(name.getText());
      PrintWriter out = new PrintWriter("InfoLicense");
      out.write("Regestration Result : Sucessfull....");
      out.write("Regestration Name : " + ORGN);
      FileReader fr = new FileReader("userInfo");
      BufferedReader br = new BufferedReader(fr);
      String usr = br.readLine();
      usr = br.readLine();
      out.write(usr);
      out.close();
      CryptoUtilsTest.encFile("InfoLicense", "PRANAV678vyASiGD");
   }

   public static boolean checkLicAvailable() throws IOException {
      File f = new File("InfoLicense.encrypted");
      if (f.exists()) {
         FileReader fr2 = new FileReader("userInfo2");
         BufferedReader br2 = new BufferedReader(fr2);
         String usr = br2.readLine();
         usr = br2.readLine();
         CryptoUtilsTest.decFile("InfoLicense", "PRANAV678vyASiGD");
         FileReader fr = new FileReader("InfoLicense.decrypted");
         BufferedReader br = new BufferedReader(fr);
         String str = br.readLine();
         br.close();
         if (str.contains("Regestration Result : Sucessfull....")) {
            return str.contains(usr);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}

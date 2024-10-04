package com.ProHotspot.Beta.update;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

public class FunctionUpdate {
   public static String latver() {
      try {
         URL url = new URL("http://programandtech.blogspot.in/p/latestversion2.html");
         JOptionPane.showMessageDialog((Component)null, "Checking for Update...\nPress OK and Wait for some time", "Conformation", 1);
         URLConnection con = url.openConnection();
         InputStream is = con.getInputStream();
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String line = null;

         while((line = br.readLine()) != null) {
            if (line.contains("LatestVersion")) {
               System.out.println(line.substring(13, 18));
               String str = line.substring(13, 18);
               return str;
            }
         }

         return "-1";
      } catch (MalformedURLException var6) {
         var6.printStackTrace();
         return "-2";
      } catch (IOException var7) {
         var7.printStackTrace();
         return "-3";
      }
   }
}
